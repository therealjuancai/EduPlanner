package com.softcg.eduplanner.ui.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.softcg.eduplanner.R
import com.softcg.eduplanner.databinding.ActivityMainBinding
import com.softcg.eduplanner.ui.register.RegisterActivity

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val miViewModel : MiViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init(){
        initlisteners()
        initObservers()
    }

    private fun initlisteners(){
        with(binding){
            textoregistrar.setOnClickListener{miViewModel.onRegisterSelected()}
        }
    }

    private fun initObservers(){
        miViewModel.navigateToRegister.observe(this, Observer{
            it.getContentIfNotHandled()?.let {
                goToRegister()
            }
        })
    }

    private fun goToRegister(){
        startActivity(RegisterActivity.create(this))
    }

}