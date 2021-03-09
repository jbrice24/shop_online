package com.jonathan.shoponline.model.cards

import com.jonathan.shoponline.data.enums.CardType

interface ICard {
    fun type() : CardType
    fun tax() : Double
}