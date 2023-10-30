package br.comalura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class NovoCursoForm(
    @field:Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres.")
    @field:NotEmpty(message = "Nome não pode sem em branco.")
    val nome: String,

    @field:NotEmpty(message = "Categoria não pode ser em branco.")
    val categoria: String
)
