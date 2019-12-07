package com.example.exercise1_car_loan_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnReset: Button = findViewById(R.id.buttonReset)
        btnReset.setOnClickListener { reset() }

        val btnCalculate: Button = findViewById(R.id.buttonCalculate)
        btnCalculate.setOnClickListener { calculate() }
    }

    private fun calculate(){
        val price: EditText = findViewById(R.id.editTextCarPrice)
        val payment: EditText = findViewById(R.id.editTextDownPayment)
        val period: EditText = findViewById(R.id.editTextLoanPeriod)
        val interestt: EditText = findViewById(R.id.editTextInterestRate)

        val viewLoan = price.text.toString().toDouble() - payment.text.toString().toDouble()
        val viewInterest = viewLoan * interestt.text.toString().toDouble() * period.text.toString().toDouble()
        val viewPayment = (viewLoan + viewInterest) / period.text.toString().toDouble() / 12

        textViewLoan.text = viewLoan.toString()
        textViewInterest.text = viewInterest.toString()
        textViewMonthlyRepayment.text = viewPayment.toString()
    }

    private fun reset(){
        val price: EditText = findViewById(R.id.editTextCarPrice)
        val payment: EditText = findViewById(R.id.editTextDownPayment)
        val period: EditText = findViewById(R.id.editTextLoanPeriod)
        val interestt: EditText = findViewById(R.id.editTextInterestRate)

        val viewLoan: TextView = findViewById(R.id.textViewLoan)
        val viewInterest: TextView = findViewById(R.id.textViewInterest)
        val viewRepayment: TextView = findViewById(R.id.textViewMonthlyRepayment)

        price.text = null
        payment.text = null
        period.text = null
        interestt.text = null

        viewLoan.text = null
        viewInterest.text = null
        viewRepayment.text = null
    }
}
