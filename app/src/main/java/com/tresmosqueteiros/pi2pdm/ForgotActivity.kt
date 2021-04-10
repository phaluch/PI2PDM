package com.tresmosqueteiros.pi2pdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot.*

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        btCadastro2.setOnClickListener {
            val email = emForgotEmail.text.toString()
            val auth = FirebaseAuth.getInstance()
            auth.sendPasswordResetEmail(email)
            Toast.makeText(this, "Se o email estiver cadastrado receberá link para recadastro!", Toast.LENGTH_LONG).show()
            finish()
        }

        ivForgotVoltar.setOnClickListener {
            finish()
        }
    }
}