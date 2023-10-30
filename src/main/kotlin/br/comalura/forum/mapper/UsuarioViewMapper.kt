package br.comalura.forum.mapper

import br.comalura.forum.dto.UsuarioView
import br.comalura.forum.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioViewMapper: Mapper<Usuario, UsuarioView> {

    override fun map(t: Usuario): UsuarioView {
        return UsuarioView(
            id = t.id,
            nome = t.nome,
            email = t.email
        )
    }
}