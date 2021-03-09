package com.jonathan.shoponline

import com.jonathan.shoponline.data.enums.ResponseType
import com.jonathan.shoponline.domain.ITransactionUseCase
import com.jonathan.shoponline.domain.TransactionUseCaseImpl
import com.jonathan.shoponline.domain.callback.IResponseCallback
import com.jonathan.shoponline.model.Product
import com.jonathan.shoponline.model.Transaction
import com.jonathan.shoponline.model.cards.CreditCardImpl
import com.jonathan.shoponline.model.cards.DebitCardImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.collections.ArrayList

class TransactionRepositoryTest {
    private var responseMessage: String? = null
    private var transaction: Transaction? = null
    private var products: ArrayList<Product> = ArrayList()
    private var repository: ITransactionUseCase? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        transaction = Transaction()

        products.addAll(listOf(
            Product("001", 1000.0),
            Product("002", 2000.0),
            Product("003", 3000.0)))

        transaction?.products = products

        repository = TransactionUseCaseImpl()
    }

    @Test
    fun givenDebitCardTransactionRequestWhenSuccessResponseThenOnSuccessIsCalled() {
        //prepare
        transaction?.setSelectedCard(DebitCardImpl())
        transaction?.responseType = ResponseType.SUCCESS

        //action
        repository?.callTransactionRequest(
            transaction,
            ResponseCallbackStub()
        )

        //assert
        Assert.assertEquals("success", responseMessage)
    }

    @Test
    fun givenCreditCardTransactionRequestWhenSuccessResponseThenOnSuccessIsCalled() {
        //prepare
        transaction?.setSelectedCard(CreditCardImpl())
        transaction?.responseType = ResponseType.SUCCESS

        //action
        repository?.callTransactionRequest(
            transaction,
            ResponseCallbackStub()
        )

        //assert
        Assert.assertEquals("success", responseMessage)
    }

    @Test
    fun givenDebitCardTransactionRequestWhenCardNotValidResponseThenOnErrorIsCalled() {
        //prepare
        transaction?.setSelectedCard(DebitCardImpl())
        transaction?.responseType = ResponseType.CARD_NOT_VALID

        //action
        repository?.callTransactionRequest(
            transaction,
            ResponseCallbackStub()
        )

        //assert
        Assert.assertEquals("Debit Card not valid", responseMessage)
    }

    @Test
    fun givenCreditCardTransactionRequestWhenCardNotValidResponseThenOnErrorIsCalled() {
        //prepare
        transaction?.setSelectedCard(CreditCardImpl())
        transaction?.responseType = ResponseType.CARD_NOT_VALID

        //action
        repository?.callTransactionRequest(
            transaction,
            ResponseCallbackStub()
        )

        //assert
        Assert.assertEquals("Credit Card not valid", responseMessage)
    }

    @Test
    fun givenDebitCardTransactionRequestWhenInsufficientFundsResponseThenOnErrorIsCalled() {
        //prepare
        transaction?.setSelectedCard(DebitCardImpl())
        transaction?.responseType = ResponseType.INSUFFICIENT_FUNDS

        //action
        repository?.callTransactionRequest(
            transaction,
            ResponseCallbackStub()
        )

        //assert
        Assert.assertEquals("Insufficient funds in your debit card", responseMessage)
    }

    @Test
    fun givenCreditCardTransactionRequestWhenInsufficientFundsResponseThenOnErrorIsCalled() {
        //prepare
        transaction?.setSelectedCard(CreditCardImpl())
        transaction?.responseType = ResponseType.INSUFFICIENT_FUNDS

        //action
        repository?.callTransactionRequest(
            transaction,
            ResponseCallbackStub()
        )

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
