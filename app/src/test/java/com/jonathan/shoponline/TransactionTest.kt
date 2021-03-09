package com.jonathan.shoponline

import com.jonathan.shoponline.model.Product
import com.jonathan.shoponline.model.Transaction
import com.jonathan.shoponline.model.cards.CreditCardImpl
import com.jonathan.shoponline.model.cards.DebitCardImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.collections.ArrayList

class TransactionTest {
    private var transaction = Transaction()
    private val products: ArrayList<Product> = ArrayList()

    @Before
    fun setUp() {
        products.addAll(listOf(
            Product("001", 1000.0),
            Product("002", 2000.0)))
    }

    @Test
    fun givenTransactionWhenGetSubTotalAmountIsCalledThenShouldReturnCorrectAmount() {
        //prepare
        transaction = Transaction()
        transaction.products = products

        //action
        val subTotal = transaction.subTotalAmount()

        //assert
        Assert.assertEquals(3000.0, subTotal, 0.0)
    }

    @Test
    fun givenDebitCardTransactionWhenGetTaxIsCalledThenShouldReturnCorrectTax() {
        //prepare
        transaction = Transaction()
        transaction.products = products
        transaction.setSelectedCard(DebitCardImpl())

        //action
        val tax = transaction.taxAmount()

        //assert
        Assert.assertEquals(45.0, tax, 0.0)
    }

    @Test
    fun givenCreditCardTransactionWhenGetTaxIsCalledThenShouldReturnCorrectTax() {
        //prepare
        transaction = Transaction()
        transaction.products = products
        transaction.setSelectedCard(CreditCardImpl())

        //action
        val tax = transaction.taxAmount()

        //assert
        Assert.assertEquals(90.0, tax, 0.0)
    }

    @Test
    fun givenDebitCardTransactionWhenGetTotalTransactionIsCalledThenShouldReturnCorrectAmount() {
        //prepare
        transaction = Transaction()
        transaction.products = products
        transaction.setSelectedCard(DebitCardImpl())

        //action
        val totalTransaction = transaction.totalTransaction()

        //assert
        Assert.assertEquals(3045.0, totalTransaction, 0.0)
    }

    @Test
    fun givenCreditCardTransactionWhenGetTotalTransactionIsCalledThenShouldReturnCorrectAmount() {
        //prepare
        transaction = Transaction()
        transaction.products = products
        transaction.setSelectedCard(CreditCardImpl())

        //action
        val totalTransaction = transaction.totalTransaction()

        //assert
        Assert.assertEquals(3090.0, totalTransaction, 0.0)
    }
}