package com.github.af2905.musicland.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.af2905.musicland.R
import com.github.af2905.musicland.databinding.ActivityMainBinding
import com.github.af2905.musicland.presentation.feature.CategoriesFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CategoriesFragment())
            .addToBackStack(CategoriesFragment.TAG)
            .commit()
    }
}