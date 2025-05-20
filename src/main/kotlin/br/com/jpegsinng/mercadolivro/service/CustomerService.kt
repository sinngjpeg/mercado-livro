package br.com.jpegsinng.mercadolivro.service

import br.com.jpegsinng.mercadolivro.enums.CustomerStatus
import br.com.jpegsinng.mercadolivro.enums.Errors
import br.com.jpegsinng.mercadolivro.exception.NotFoundException
import br.com.jpegsinng.mercadolivro.model.CustomerModel
import br.com.jpegsinng.mercadolivro.repository.CustomerRepository
import br.com.jpegsinng.mercadolivro.validation.EmailAvailableValidator
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code) }
    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INATIVO

        customerRepository.save(customer)
    }

    fun emailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }

}