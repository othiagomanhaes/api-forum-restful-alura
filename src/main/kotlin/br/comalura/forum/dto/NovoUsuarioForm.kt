package br.comalura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import kotlin.math.min


data class NovoUsuarioForm(
    @field:Size(min = 3, max = 65, message = "Nome deve estar entre 3 e 65 caracteres de tamanho.")
    @field:NotEmpty(message = "Nome não pode estar vazio")
    val nome: String,

    @field:NotEmpty
    val email: String
)
