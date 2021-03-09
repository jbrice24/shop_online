package com.jonathan.shoponline.domain

import com.jonathan.shoponline.domain.callback.IResponseCallback
import com.jonathan.shoponline.model.Transaction

interface ITransactionUseCase {

    fun callTransactionRequest(
        transaction: Transaction?,
        callback: IResponseCallback?
    )
}