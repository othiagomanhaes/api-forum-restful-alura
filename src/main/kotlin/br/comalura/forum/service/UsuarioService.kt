package br.comalura.forum.service

import br.comalura.forum.dto.NovoUsuarioForm
import br.comalura.forum.dto.UsuarioView
import br.comalura.forum.exception.NotFoundException
import br.comalura.forum.mapper.UsuarioFormMapper
import br.comalura.forum.mapper.UsuarioViewMapper
import br.comalura.forum.model.Curso
import br.comalura.forum.model.Usuario
import br.comalura.forum.repository.UsuarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (
    private val repository: UsuarioRepository,
    private val usuarioViewMapper: UsuarioViewMapper,
    private val usuarioFormMapper: UsuarioFormMapper,
    private val notFoundUsuario: String = "Usuário não encontrado"
    ) {

    fun buscarPorId(id: Long): Usuario {
        return repository.findById(id)
            .orElseThrow{ NotFoundException(notFoundUsuario) }
    }

    fun cadastrar(form: NovoUsuarioForm): UsuarioView {
        val usuario = usuarioFormMapper.map(form)
        repository.save(usuario)
        return usuarioViewMapper.map(usuario)
    }
}