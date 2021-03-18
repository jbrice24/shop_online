package com.jonathan.shoponline.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jonathan.shoponline.R
import com.jonathan.shoponline.data.enums.ResponseType
import com.jonathan.shoponline.domain.TransactionUseCaseImpl
import com.jonathan.shoponline.domain.callback.IResponseCallback
import com.jonathan.shoponline.model.Product
import com.jonathan.shoponline.model.Transaction
import com.jonathan.shoponline.model.cards.DebitCardImpl
import com.jonathan.shoponline.presentation.viewModel.IMainViewModel
import com.jonathan.shoponline.presentation.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}