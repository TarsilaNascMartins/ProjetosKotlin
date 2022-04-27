package com.example.alcoolvsgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alcoolvsgasolina.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportActionBar != null) {
            supportActionBar?.hide()
        }

        binding.floatingActionButton2.setOnClickListener {

            launchAlertDialog()
        }


    }


    fun calcularPreco(view: View){
        val precoGasolina = binding.editPrecoGasolina.text.toString()
        val precoAlcool = binding.editPrecoAlcool.text.toString()

        if((precoAlcool.isNotEmpty()) && precoGasolina.isNotEmpty()) {

            var conta = precoAlcool.toDouble() / precoGasolina.toDouble()

            if (conta >= 0.7) {
                binding.textResultado.text = "Melhor utilizar Gasolina!"
            }  else {
                binding.textResultado.text = "Melhor utilizar Álcool!"
            }

        }else {
            binding.textResultado.text = "Preencha todos os campos!"
        }
    }
    private fun launchAlertDialog() {
        val builder = AlertDialog.Builder(this)
            .setTitle("Entenda o cálculo ")
            .setMessage("Dividimos o valor do litro do álcool pelo da gasolina.\n" +
                    "Quando o resultado é menor que 0,7, a recomendação é abastecer com álcool." +
                    "\nSe maior, a recomendação é escolher a gasolina.")
            .setPositiveButton("Ok") { dialogInterface, i ->

                Toast.makeText(this, "Faça sua escolha!", Toast.LENGTH_SHORT).show()

            }

        builder.show()
    }


}