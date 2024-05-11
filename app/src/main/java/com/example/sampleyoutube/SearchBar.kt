package com.example.sampleyoutube

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.sampleyoutube.databinding.ActivityMainBinding
import com.example.sampleyoutube.databinding.ActivitySearchBarBinding

class SearchBar : AppCompatActivity() {

    private lateinit var fragmentManager : FragmentManager
    private lateinit var binding : ActivitySearchBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarSearch)

        var text  = binding.searchText.text

        binding.search.setOnClickListener {
                if(text?.isNotEmpty()!!) {
                    fragmentManager = supportFragmentManager
                    val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.frame, HomeFragment())
                    fragmentTransaction.commit()
                }
        }

        binding.back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }
}

