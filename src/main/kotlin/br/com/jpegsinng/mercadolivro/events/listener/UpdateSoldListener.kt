package br.com.jpegsinng.mercadolivro.events.listener

import br.com.jpegsinng.mercadolivro.events.PurchaseEvent
import br.com.jpegsinng.mercadolivro.service.BookService
import br.com.jpegsinng.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class UpdateSoldListener(
    private val bookService: BookService
) {
    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        println("Atualizando status dos livros")
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}