package br.comalura.forum.service

import br.comalura.forum.dto.CursoView
import br.comalura.forum.dto.NovoCursoForm
import br.comalura.forum.exception.NotFoundException
import br.comalura.forum.mapper.CursoFormMapper
import br.comalura.forum.mapper.CursoViewMapper
import br.comalura.forum.model.Curso
import br.comalura.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(
    private val repository: CursoRepository,
    private val cursoFormMapper: CursoFormMapper,
    private val cursoViewMapper: CursoViewMapper,
    private val cursoNotFound: String = "Curso não encontrado."
) {

    fun buscarPorId(id: Long): Curso {
        return repository.findById(id)
            .orElseThrow{ NotFoundException(cursoNotFound) }
    }

    fun cadastrar(form: NovoCursoForm): CursoView {
        val curso = cursoFormMapper.map(form)
        repository.save(curso)
        return cursoViewMapper.map(curso)
    }
}