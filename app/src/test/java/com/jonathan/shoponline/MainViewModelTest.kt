package com.jonathan.shoponline

import com.jonathan.shoponline.data.api.DebitCallRequest
import com.jonathan.shoponline.data.enums.ResponseType
import com.jonathan.shoponline.domain.ITransactionUseCase
import com.jonathan.shoponline.domain.TransactionUseCaseImpl
import com.jonathan.shoponline.domain.callback.IResponseCallback
import com.jonathan.shoponline.model.Product
import com.jonathan.shoponline.model.Transaction
import com.jonathan.shoponline.model.cards.DebitCardImpl
import com.jonathan.shoponline.presentation.viewModel.MainViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.lang.AssertionError


class MainViewModelTest {

    private var responseMessage: String? = null
    private lateinit var transaction: Transaction
    private var products: ArrayList<Product> = ArrayList()
    private lateinit var  viewModel: MainViewModel
    private var repository: ITransactionUseCase? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

        //Prepare
        transaction = Transaction()

        products.addAll(listOf(
            Product("001", 1000.0),
            Product("002", 2000.0),
            Product("003", 3000.0)
        ))

        viewModel = MainViewModel()
    }

    @Test
    fun giveProductListWhenSizeIsLowerThan100ThenCanBeAddNewProduct() {

        transaction.products = products

        transaction.products?.add(Product("004", 1000.0))

        Assert.assertEquals(transaction.products?.size, 4)

    }

    @Test
    fun giveProductListWhenSizeIs100ThenCanBeAddNewProduct() {

        transaction.products = products

        transaction.products?.apply {
            repeat(100) {
                this.add(Product("004", 1000.0)) }
            }

        try{
            viewModel.addProduct(transaction.products, Product("100", 1000.0))
        } catch (exception:java.lang.Exception){
            Assert.assertEquals(exception.message, "Limit reached, a maximum of 100 products can be added")
        }

    }

    @Test
    fun giveViewModelWhenTransactionIsValidThenCallOnSuccess() {

        repository = TransactionUseCaseImpl()
        viewModel.setRepository(repository)
        transaction.products = products
        transaction.setSelectedCard(DebitCardImpl())
        transaction.responseType = ResponseType.SUCCESS
        viewModel.startTransaction(transaction)

        viewModel.callTransactionRequest(ResponseCallbackStub())

        Assert.assertEquals("success", responseMessage)

    }

    @Test
    fun giveViewModelWhenTransactionIsValidThenReturnTrue() {

        transaction.products = products
        transaction.setSelectedCard(DebitCardImpl())

        val result = viewModel.isValidTransaction(transaction)

        Assert.assertEquals(true, result)

    }

    @Test
    fun giveViewModelWhenNotSelectCardThenTransactionIsWrong() {

        transaction.products = products

        val result = viewModel.isValidTransaction(transaction)

        Assert.assertEquals(false, result)

    }

    @Test
    fun giveViewModelWhenNotSelectProductThenTransactionIsWrong() {

        transaction = Transaction()
        transaction.setSelectedCard(DebitCardImpl())

        val result = viewModel.isValidTransaction(transaction)

        Assert.assertEquals(false, result)

    }

    @Test
    fun giveViewModelWhenNotSelectCardThenShowErrorMessage() {

        transaction.products = products

        viewModel.isValidTransaction(transaction)

        Assert.assertEquals(viewModel.message, "You must choose a payment method")

    }

    @Test
    fun giveViewModelWhenNotSelectProductThenShowErrorMessage() {

        transaction = Transaction()
        transaction.setSelectedCard(DebitCardImpl())

        viewModel.isValidTransaction(transaction)

        Assert.assertEquals(viewModel.message, "You must add at least one product")

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