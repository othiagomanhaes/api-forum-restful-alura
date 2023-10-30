package br.comalura.forum.controller

import br.comalura.forum.dto.NovoUsuarioForm
import br.comalura.forum.dto.UsuarioView
import br.comalura.forum.model.Usuario
import br.comalura.forum.repository.UsuarioRepository
import br.comalura.forum.service.UsuarioService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/usuario")
class UsuarioController(private val service: UsuarioService) {

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid form: NovoUsuarioForm,
        uriBuilder: UriComponentsBuilder
        ): ResponseEntity<UsuarioView> {
        val usuarioView = service.cadastrar(form)
        val uri = uriBuilder.path("/usuario${usuarioView.id}").build().toUri()
        return ResponseEntity.created(uri).body(usuarioView)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Usuario {
        return service.buscarPorId(id)
    }
}