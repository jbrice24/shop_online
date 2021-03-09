package com.jonathan.shoponline.presentation.viewModel

import com.jonathan.shoponline.domain.ITransactionUseCase
import com.jonathan.shoponline.domain.callback.IResponseCallback
import com.jonathan.shoponline.model.Product
import com.jonathan.shoponline.model.Transaction
import com.jonathan.shoponline.model.cards.ICard

class MainViewModel : IMainViewModel, IResponseCallback {
    private var transaction: Transaction? = null
    private var repository: ITransactionUseCase? = null

    override fun setRepository(repository: ITransactionUseCase?) {
        this.repository = repository
    }

    override fun addProduct(product: Product) {
        if (transaction == null) startTransaction()
        transaction?.products?.add(product)
    }

    override fun callSelectTypeCard(selectedCard: ICard) {
        transaction?.setSelectedCard(selectedCard)
    }

    override fun callTransactionRequest() {
        repository?.callTransactionRequest(transaction, this)
    }

    override fun startTransaction() {
        transaction = Transaction()
    }

    override fun cleanTransaction() {
        transaction = null
    }

    override fun onSuccess() {}
    override fun onError(errorMessage: String?) {}
}