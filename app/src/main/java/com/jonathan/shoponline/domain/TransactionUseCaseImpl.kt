package com.jonathan.shoponline.domain

import com.jonathan.shoponline.data.api.IApiService
import com.jonathan.shoponline.data.factory.ApiFactory
import com.jonathan.shoponline.domain.callback.IResponseCallback
import com.jonathan.shoponline.model.Transaction

class TransactionUseCaseImpl : ITransactionUseCase {

    override fun callTransactionRequest(transaction: Transaction?, callback: IResponseCallback?) {
        val apiService: IApiService? = ApiFactory.getApi(transaction)
        apiService?.call(callback)
    }

}