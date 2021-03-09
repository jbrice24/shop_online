package com.jonathan.shoponline.model.cards

import com.jonathan.shoponline.data.enums.CardType

class DebitCardImpl : IDebitCard {

    override fun type(): CardType {
        return CardType.DEBIT
    }

    override fun tax(): Double {
        return 1.5
    }


}