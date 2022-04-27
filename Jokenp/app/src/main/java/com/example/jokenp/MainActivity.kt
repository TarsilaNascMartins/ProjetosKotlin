package com.example.jokenp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.example.jokenp.databinding.ActivityMainBinding


var valorPlacarPC = 0
var valorPlacarUser = 0

private lateinit var  binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bpedra.setOnClickListener {
            opcaoSelecionada(1)
            Log.d("Jogo user", "pedra")
        }

        binding.bpapel.setOnClickListener {
            opcaoSelecionada(2)
            Log.d("Jogo user", "papel")
        }

        binding.btesoura.setOnClickListener {
            opcaoSelecionada(3)
            Log.d("Jogo user", "tesoura")
        }

    }

    fun pontoPC (): Int{
           valorPlacarPC++
        return valorPlacarPC

    }

    fun pontoUser (): Int{
        valorPlacarUser++
        return valorPlacarUser

    }

    @SuppressLint("SetTextI18n")
    fun opcaoSelecionada(opUser:Int) {

        val opPC = (1..3).random()
        Log.d("Jogo comp", opUser.toString())

        when(opPC){
            1 -> binding.bresultado.setImageResource(R.drawable.pedra)
            2 -> binding.bresultado.setImageResource(R.drawable.papel)
            else -> binding.bresultado.setImageResource(R.drawable.tesoura)
        }

        if(opPC == opUser) {
             binding.textResultado.text = "Empatou!"
        } else if ((opPC == 2 && opUser == 1) || (opPC == 1 && opUser == 3)|| (opPC == 3 && opUser == 2)){
            binding.textResultado.text = "Você perdeu! :("

            binding.scorePC.text =  "Score App: ${pontoPC().toString()}"


        } else {
            binding.textResultado.text = "Você ganhou!!! "
            binding.scoreUser.text =  "Score Usuário: ${pontoUser().toString()}"

        }






    }





}