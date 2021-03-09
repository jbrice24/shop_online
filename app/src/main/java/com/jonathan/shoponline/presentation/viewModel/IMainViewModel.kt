package com.jonathan.shoponline.presentation.viewModel

import com.jonathan.shoponline.data.enums.CardType
import com.jonathan.shoponline.domain.ITransactionUseCase
import com.jonathan.shoponline.model.Product
import com.jonathan.shoponline.model.cards.ICard

interface IMainViewModel {
    fun setRepository(repository: ITransactionUseCase?)
    fun startTransaction()
    fun cleanTransaction()
    fun addProduct(product: Product)
    fun callTransactionRequest()
    fun callSelectTypeCard(selectedCard: ICard)
}