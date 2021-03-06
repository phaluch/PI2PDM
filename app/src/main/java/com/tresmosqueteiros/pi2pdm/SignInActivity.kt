package com.tresmosqueteiros.pi2pdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        tvMainEsqueceuSenha.setOnClickListener {
            val intencaoDeChamada = Intent(this, ForgotActivity::class.java)
            startActivity(intencaoDeChamada)
        }

        txCriarCadastro.setOnClickListener {
            val intencaoDeChamada = Intent(this, SignUpActivity::class.java)
            startActivity(intencaoDeChamada)
        }

        btLogin.setOnClickListener {
            val email = txEmailLogin.text.toString()
            val password = txEmailSenha.text.toString()

            val auth = FirebaseAuth.getInstance()
            val taskDeLogin = auth.signInWithEmailAndPassword(email, password)

            taskDeLogin.addOnCompleteListener {resultado ->
                if(resultado.isSuccessful){
                    val intencaoDeChamada = Intent(this, HomeActivity::class.java)
                    startActivity(intencaoDeChamada)
                }else {
                    Toast.makeText(this, "Deu erro no Login", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}