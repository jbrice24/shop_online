package com.jonathan.shoponline

import com.jonathan.shoponline.data.api.*
import com.jonathan.shoponline.data.enums.ResponseType
import com.jonathan.shoponline.domain.callback.IResponseCallback
import org.junit.Assert
import org.junit.Test

class CardCallTest {
    private var responseMessage: String? = null
    private var debitCardCall: IApiService? = null
    private var creditCardCall: IApiService? = null

    @Test
    fun givenDebitCallApiWhenIsSuccessResponseThenShouldOnSuccessIsCalled() {
        //prepare
        debitCardCall = DebitCallImpl(DebitCallRequest(ResponseType.SUCCESS))

        //action
        debitCardCall!!.call(ResponseCallbackStub())

        //assert
        Assert.assertEquals("success", responseMessage)
    }

    @Test
    fun givenDebitCallApiWhenIsCardNotValidResponseThenShouldOnErrorWithCorrectMessageIsCalled() {
        //prepare
        debitCardCall = DebitCallImpl(DebitCallRequest(ResponseType.CARD_NOT_VALID))

        //action
        debitCardCall!!.call(ResponseCallbackStub())

        //assert
        Assert.assertEquals("Debit Card not valid", responseMessage)
    }

    @Test
    fun givenDebitCallApiWhenIsInsufficientFundsResponseThenShouldOnErrorWithCorrectMessageIsCalled() {
        //prepare
        debitCardCall = DebitCallImpl(DebitCallRequest(ResponseType.INSUFFICIENT_FUNDS))

        //action
        debitCardCall!!.call(ResponseCallbackStub())

        //assert
        Assert.assertEquals("Insufficient funds in your debit card", responseMessage)
    }

    @Test
    fun givenCreditCallApiWhenIsSuccessResponseThenShouldOnSuccessIsCalled() {
        //prepare
        creditCardCall = CreditCallImpl(CreditCardRequest(ResponseType.SUCCESS))

        //action
        creditCardCall!!.call(ResponseCallbackStub())

        //assert
        Assert.assertEquals("success", responseMessage)
    }

    @Test
    fun givenCreditCallApiWhenIsCardNotValidResponseThenShouldOnErrorWithCorrectMessageIsCalled() {
        //prepare
        creditCardCall = CreditCallImpl(CreditCardRequest(ResponseType.CARD_NOT_VALID))

        //action
        creditCardCall!!.call(ResponseCallbackStub())

        //assert
        Assert.assertEquals("Credit Card not valid", responseMessage)
    }

    @Test
    fun givenCreditCallApiWhenIsInsufficientFundsResponseThenShouldOnErrorWithCorrectMessageIsCalled() {
        //prepare
        creditCardCall = CreditCallImpl(CreditCardRequest(ResponseType.INSUFFICIENT_FUNDS))

        //action
        creditCardCall!!.call(ResponseCallbackStub())

        //assert
        Assert.assertEquals("Insufficient funds in your credit card", responseMessage)
    }


    private inner class ResponseCallbackStub : IResponseCallback {

        override fun onSuccess() {
            responseMessage = "success"
        }

        override fun onError(errorMessage: String?) {
            responseMessage = errorMessage
        }
    }
}