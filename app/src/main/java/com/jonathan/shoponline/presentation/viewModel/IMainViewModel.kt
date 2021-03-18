package com.jonathan.shoponline.presentation.viewModel

import com.jonathan.shoponline.data.enums.CardType
import com.jonathan.shoponline.domain.ITransactionUseCase
import com.jonathan.shoponline.domain.callback.IResponseCallback
import com.jonathan.shoponline.model.Product
import com.jonathan.shoponline.model.Transaction
import com.jonathan.shoponline.model.cards.ICard

interface IMainViewModel {
    fun setRepository(repository: ITransactionUseCase?)
    fun startTransaction(transaction: Transaction?)
    fun cleanTransaction()
    fun addProduct(products: MutableList<Product>?, product: Product)
    fun callTransactionRequest(callback: IResponseCallback)
    fun callSelectTypeCard(selectedCard: ICard)
}