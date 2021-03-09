package com.jonathan.shoponline

import com.jonathan.shoponline.data.api.CreditCardRequest
import com.jonathan.shoponline.data.api.DebitCallRequest
import com.jonathan.shoponline.data.enums.ResponseType
import org.junit.Assert
import org.junit.Test

class CallRequestTest {
    private var debitCardRequest: DebitCallRequest? = null
    private var creditCardRequest: CreditCardRequest? = null

    @Test
    fun givenDebitCallRequestWhenSuccessResponseAndGetResponseCodeIsCalledThenShouldReturn200() {
        //prepare
        debitCardRequest = DebitCallRequest(ResponseType.SUCCESS)

        //action
        val responseCode: Int = debitCardRequest!!.responseCode

        //assert
        Assert.assertEquals(200, responseCode.toLong())
    }

    @Test
    fun givenDebitCallRequestWhenCardNotValidResponseAndGetResponseCodeIsCalledThenShouldReturn502() {
        //prepare
        debitCardRequest = DebitCallRequest(ResponseType.CARD_NOT_VALID)

        //action
        val responseCode: Int = debitCardRequest!!.responseCode

        //assert
        Assert.assertEquals(502, responseCode.toLong())
    }

    @Test
    fun givenDebitCallRequestWhenInsufficientFundsResponseAndGetResponseCodeIsCalledThenShouldReturn503() {
        //prepare
        debitCardRequest = DebitCallRequest(ResponseType.INSUFFICIENT_FUNDS)

        //action
        val responseCode: Int = debitCardRequest!!.responseCode

        //assert
        Assert.assertEquals(503, responseCode.toLong())
    }

    @Test
    fun givenDebitCallRequestWhenCardNotValidResponseAndGetErrorMessageIsCalledThenShouldReturnCorrectMessage() {
        //prepare
        debitCardRequest = DebitCallRequest(ResponseType.CARD_NOT_VALID)
        debitCardRequest!!.responseCode

        //action
        val errorMessage: String? = debitCardRequest!!.errorMessage

        //assert
        Assert.assertEquals("Debit Card not valid", errorMessage)
    }

    @Test
    fun givenDebitCallRequestWhenInsufficientFundsResponseAndGetErrorMessageIsCalledThenShouldReturnCorrectMessage() {
        //prepare
        debitCardRequest = DebitCallRequest(ResponseType.INSUFFICIENT_FUNDS)
        debitCardRequest!!.responseCode

        //action
        val errorMessage: String? = debitCardRequest!!.errorMessage

        //assert
        Assert.assertEquals("Insufficient funds in your debit card", errorMessage)
    }

    @Test
    fun givenCreditCallRequestWhenSuccessResponseAndGetResponseCodeIsCalledThenShouldReturn200() {
        //prepare
        creditCardRequest = CreditCardRequest(ResponseType.SUCCESS)

        //action
        val responseCode: Int = creditCardRequest!!.responseCode

        //assert
        Assert.assertEquals(200, responseCode.toLong())
    }

    @Test
    fun givenCreditCallRequestWhenCardNotValidResponseAndGetResponseCodeIsCalledThenShouldReturn502() {
        //prepare
        creditCardRequest = CreditCardRequest(ResponseType.CARD_NOT_VALID)

        //action
        val responseCode: Int = creditCardRequest!!.responseCode

        //assert
        Assert.assertEquals(502, responseCode.toLong())
    }

    @Test
    fun givenCreditCallRequestWhenInsufficientFundsResponseAndGetResponseCodeIsCalledThenShouldReturn503() {
        //prepare
        creditCardRequest = CreditCardRequest(ResponseType.INSUFFICIENT_FUNDS)

        //action
        val responseCode: Int = creditCardRequest!!.responseCode

        //assert
        Assert.assertEquals(503, responseCode.toLong())
    }

    @Test
    fun givenCreditCallRequestWhenCardNotValidResponseAndGetErrorMessageIsCalledThenShouldReturnCorrectMessage() {
        //prepare
        creditCardRequest = CreditCardRequest(ResponseType.CARD_NOT_VALID)
        creditCardRequest!!.responseCode

        //action
        val errorMessage: String? = creditCardRequest!!.errorMessage

        //assert
        Assert.assertEquals("Credit Card not valid", errorMessage)
    }

    @Test
    fun givenCreditCallRequestWhenInsufficientFundsResponseAndGetErrorMessageIsCalledThenShouldReturnCorrectMessage() {
        //prepare
        creditCardRequest = CreditCardRequest(ResponseType.INSUFFICIENT_FUNDS)
        creditCardRequest!!.responseCode

        //action
        val errorMessage: String? = creditCardRequest!!.errorMessage

        //assert
        Assert.assertEquals("Insufficient funds in your credit card", errorMessage)
    }
}