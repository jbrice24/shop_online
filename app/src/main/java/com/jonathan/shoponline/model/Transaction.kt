    package com.jonathan.shoponline.model

import com.jonathan.shoponline.data.enums.ResponseType
import com.jonathan.shoponline.model.cards.ICard

class Transaction {

    var products: MutableList<Product>? = null
    var card: ICard? = null
    var responseType: ResponseType? = null

    fun setSelectedCard (card : ICard) {
        this.card = card
    }

    fun subTotalAmount() : Double {
        var subTotal = 0.0

        products?.forEach { subTotal += it.price }

        return subTotal
    }

    fun taxAmount() : Double = subTotalAmount() * card?.tax()!! / 100

    fun totalTransaction() : Double {

        val subTotal = subTotalAmount()
        val tax = taxAmount()
        return subTotal + tax
    }

}