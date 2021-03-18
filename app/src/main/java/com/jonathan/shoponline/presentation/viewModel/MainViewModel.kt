package com.jonathan.shoponline.presentation.viewModel

import com.jonathan.shoponline.domain.ITransactionUseCase
import com.jonathan.shoponline.domain.callback.IResponseCallback
import com.jonathan.shoponline.model.Product
import com.jonathan.shoponline.model.Transaction
import com.jonathan.shoponline.model.cards.ICard
import java.lang.Exception

class MainViewModel : IMainViewModel {
    private var transaction: Transaction? = null
    private var repository: ITransactionUseCase? = null
    var message : String? = null

    override fun setRepository(repository: ITransactionUseCase?) {
        this.repository = repository
    }

    override fun addProduct(products: MutableList<Product>?, product: Product) {

        if(products?.size!! <= 100)
            products.add(product)
        else
            throw Exception("Limit reached, a maximum of 100 products can be added")
    }

    override fun callSelectTypeCard(selectedCard: ICard) {
        transaction?.setSelectedCard(selectedCard)
    }

    override fun callTransactionRequest(callback: IResponseCallback) {

        if(isValidTransaction(transaction))
            repository?.callTransactionRequest(transaction, callback)
        //else
            //Show dialog with error message
    }

    override fun startTransaction(transaction: Transaction?) {
        this.transaction = transaction
    }

    override fun cleanTransaction() {
        transaction = null
    }

    fun isValidTransaction(transaction: Transaction?) : Boolean{

        if(transaction?.products == null)
            transaction?.products = ArrayList()

        if(transaction?.products?.size == 0) {
            message = "You must add at least one product"
            return false
        } else if(transaction?.card == null) {
            message = "You must choose a payment method"
            return false
        }

        return true
    }
}