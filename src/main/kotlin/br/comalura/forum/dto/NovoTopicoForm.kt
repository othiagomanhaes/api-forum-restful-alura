package br.comalura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NovoTopicoForm (
    @field:Size(min = 5, max = 50, message = "Titulo deve ter entre 5 e 50 caracteres.")
    @field:NotEmpty(message = "Titulo não pode sem em branco.")
    val titulo: String,

    @field:NotEmpty(message = "Menssagem não pode sem em branco.")
    val mensagem: String,

    @field:NotNull
    val idCurso: Long,

    @field:NotNull
    val idAutor: Long
)