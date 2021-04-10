package com.tresmosqueteiros.pi2pdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btCadastro.setOnClickListener {

        }
    }

    private fun cadastrar() {
        val email = inputEmailCadastro.text.toString()
        val password = inputPasswordCadastro.text.toString()
        val retype = inputRepeatPasswordCadastro.text.toString()

        if (password != retype) {
            Toast.makeText(this, "Digite a senha igual nos dois campos!", Toast.LENGTH_LONG).show()
            return
        }

        val auth = FirebaseAuth.getInstance()
        val taskDeLogin = auth.createUserWithEmailAndPassword(email, password)

        taskDeLogin.addOnCompleteListener { resultado ->
            if (resultado.isSuccessful) {
                finish()
            } else {
                Toast.makeText(this, "Algo deu errado no cadastro", Toast.LENGTH_LONG).show()
            }
        }
    }
}