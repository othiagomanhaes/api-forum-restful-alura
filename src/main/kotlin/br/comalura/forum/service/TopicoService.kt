package br.comalura.forum.service

import br.comalura.forum.dto.AtualizacaoTopicoForm
import br.comalura.forum.dto.NovoTopicoForm
import br.comalura.forum.dto.TopicoView
import br.comalura.forum.exception.NotFoundException
import br.comalura.forum.mapper.TopicoFormMapper
import br.comalura.forum.mapper.TopicoViewMapper
import br.comalura.forum.model.Topico
import br.comalura.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado"

    ) {

    fun listar(nomeCurso: String?): List<TopicoView> {
        return repository.findAll().stream().map {
            t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{ NotFoundException(notFoundMessage) }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
       val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id)
            .orElseThrow{ NotFoundException(notFoundMessage) }

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}