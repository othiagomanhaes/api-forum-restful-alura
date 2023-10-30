package br.comalura.forum.mapper

import br.comalura.forum.dto.NovoCursoForm
import br.comalura.forum.model.Curso
import org.springframework.stereotype.Component

@Component
class CursoFormMapper(): Mapper<NovoCursoForm, Curso> {

    override fun map(t: NovoCursoForm): Curso {
        return Curso(
            nome = t.nome,
            categoria = t.categoria
        )
    }
}