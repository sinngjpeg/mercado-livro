package br.com.jpegsinng.mercadolivro.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,
    @field:Email(message = "Email deve ser valido")
    var email: String,
    @field:NotEmpty(message = "Senha deve ser informada")
    var password: String
)
