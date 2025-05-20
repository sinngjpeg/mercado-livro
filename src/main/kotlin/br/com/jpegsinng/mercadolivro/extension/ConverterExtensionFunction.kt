package br.com.jpegsinng.mercadolivro.extension

import br.com.jpegsinng.mercadolivro.controller.request.PostBookRequest
import br.com.jpegsinng.mercadolivro.controller.request.PostCustomerRequest
import br.com.jpegsinng.mercadolivro.controller.request.PutBookRequest
import br.com.jpegsinng.mercadolivro.controller.request.PutCustomerRequest
import br.com.jpegsinng.mercadolivro.enums.BookStatus
import br.com.jpegsinng.mercadolivro.enums.CustomerStatus
import br.com.jpegsinng.mercadolivro.model.BookModel
import br.com.jpegsinng.mercadolivro.model.CustomerModel
import java.awt.print.Book

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name, email = this.email, status = previousValue.status)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}