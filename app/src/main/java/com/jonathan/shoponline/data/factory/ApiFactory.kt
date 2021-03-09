package com.jonathan.shoponline.data.factory

import com.jonathan.shoponline.data.api.*
import com.jonathan.shoponline.data.enums.CardType
import com.jonathan.shoponline.model.Transaction

class ApiFactory {

    companion object {

        fun getApi(transaction: Transaction?): IApiService? {
            when (transaction?.card?.type()) {
                CardType.DEBIT -> return DebitCallImpl(DebitCallRequest(transaction.responseType))
                CardType.CREDIT -> return CreditCallImpl(CreditCardRequest(transaction.responseType))
            }
            return null
        }
    }


}