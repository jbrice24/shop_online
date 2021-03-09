package com.jonathan.shoponline.model.cards

import com.jonathan.shoponline.data.enums.CardType

class CreditCardImpl : ICreditCard {

    override fun type(): CardType {
        return CardType.CREDIT
    }

    override fun tax(): Double {
        return 3.0
    }
}