package com.jonathan.shoponline.domain.callback

interface IResponseCallback {
    fun onSuccess()
    fun onError(errorMessage: String?)
}
