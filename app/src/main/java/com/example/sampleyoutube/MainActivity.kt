package com.example.sampleyoutube

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleyoutube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager : FragmentManager
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.searchIcon.setOnClickListener {
            val intent = Intent(this, SearchBar::class.java)
            startActivity(intent)
        }

        binding.btmNav.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.navHome -> openFragment(HomeFragment())
                R.id.navShorts -> openFragment(ShortsFragment())
                R.id.navAdd -> openFragment(AddFragment())
                R.id.navSubscriptions -> openFragment(SubscriptionsFragment())
                R.id.navProfile -> openFragment(ProfileFragment())
            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())
    }

    fun openFragment(fragment : Fragment) {
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentConatiner, fragment)
        fragmentTransaction.commit()
    }
}