package com.productos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.productos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Se establece el enlace con la vista xml mediante el objeto binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Se inicializa Firebase y se asigna el objeto para autenticacion
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        //Se define el metodo para el login
        binding.btRegister.setOnClickListener{ hacerRegistro() }

        //Se define el metodo para el register
        binding.btLogin.setOnClickListener{ hacerLogin() }
    }

    private fun hacerLogin() {
        var email = binding.etCorreo.text.toString()
        var clave = binding.etClave.text.toString()

        //Se usa la funcion para crear un usuario por medio de correo y contraseña
        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if(task.isSuccessful) {
                    val user=auth.currentUser
                    actualiza(user)
                }else {
                    Toast.makeText(baseContext,getString(R.string.msg_fallo_login),
                        Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }

    private fun hacerRegistro() {
        var email = binding.etCorreo.text.toString()
        var clave = binding.etClave.text.toString()

        //Se usa la funcion para crear un usuario por medio de correo y contraseña
        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if(task.isSuccessful) {
                    val user=auth.currentUser
                    actualiza(user)
                }else {
                    Toast.makeText(baseContext,getString(R.string.msg_fallo_registro),
                        Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }

    private fun actualiza(user: FirebaseUser?) {
        if (user != null){
            // paso a la pantalla principal
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }

    public override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        actualiza(user)
    }
}