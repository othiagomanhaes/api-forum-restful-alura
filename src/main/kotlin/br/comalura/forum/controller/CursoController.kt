package br.comalura.forum.controller

import br.comalura.forum.dto.CursoView
import br.comalura.forum.dto.NovoCursoForm
import br.comalura.forum.mapper.CursoFormMapper
import br.comalura.forum.mapper.CursoViewMapper
import br.comalura.forum.model.Curso
import br.comalura.forum.repository.CursoRepository
import br.comalura.forum.service.CursoService
import jakarta.persistence.Id
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
@RequestMapping("/curso")
class CursoController(
    private val cursoService: CursoService,
    private val cursoViewMapper: CursoViewMapper
) {

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid form: NovoCursoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CursoView> {
        val cursoView = cursoService.cadastrar(form)
        val uri = uriBuilder.path("/curso${cursoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(cursoView)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Curso {
        return cursoService.buscarPorId(id)
    }
}