package br.comalura.forum.mapper

import br.comalura.forum.dto.NovoUsuarioForm
import br.comalura.forum.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioFormMapper: Mapper<NovoUsuarioForm, Usuario> {

    override fun map(t: NovoUsuarioForm): Usuario {
        return Usuario(
            nome = t.nome,
            email = t.email
        )
    }
}