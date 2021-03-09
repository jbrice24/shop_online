package com.jonathan.shoponline.data.api

import com.jonathan.shoponline.data.enums.ResponseType

class CreditCardRequest(private val responseType: ResponseType?) {

    var errorMessage: String? = null

    val responseCode: Int
        get() {
            return when (responseType) {
                ResponseType.SUCCESS -> 200
                ResponseType.CARD_NOT_VALID -> {
                    errorMessage = "Credit Card not valid"
                    502
                }

                ResponseType.INSUFFICIENT_FUNDS -> {
                    errorMessage = "Insufficient funds in your credit card"
                    503
                }
                else -> return 0
            }
        }
}
