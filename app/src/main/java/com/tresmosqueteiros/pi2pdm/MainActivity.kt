package com.tresmosqueteiros.pi2pdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txEmailLogin.setOnClickListener(savedInstanceState: Bundle?) {
            val intencaoDeChamada = Intent(this, SignUpActivity::class.java)
            startActivity(intencaoDeChamada)
        }


    }
}