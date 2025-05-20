package br.com.jpegsinng.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class PostBookRequest (
    @field:NotEmpty(message = "Nome do livro deve ser informado")
    var name: String,
    @field:NotNull(message = "Valor do livro deve ser informado")
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId: Int
)