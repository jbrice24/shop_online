package com.jonathan.shoponline.data.api

import com.jonathan.shoponline.domain.callback.IResponseCallback

class CreditCallImpl(private val request: CreditCardRequest) : IApiService {

    override fun call(callback: IResponseCallback?) {
        val response: Int = request.responseCode

        if (response == 200)
            callback?.onSuccess()
        else
            callback?.onError(request.errorMessage)
    }

}
