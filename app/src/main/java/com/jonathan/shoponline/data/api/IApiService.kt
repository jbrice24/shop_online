package com.jonathan.shoponline.data.api

import com.jonathan.shoponline.domain.callback.IResponseCallback

interface IApiService {
    fun call(callback: IResponseCallback?)
}