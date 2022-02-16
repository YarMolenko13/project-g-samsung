package com.techstroy.projectg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        applicationContext

        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = this.findNavController(R.id.nav_host_fragment)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.authorizationFragment -> hideBottomNav(navigation)
                R.id.recoverPasswordFragment -> hideBottomNav(navigation)
                R.id.registrationFragment -> hideBottomNav(navigation)
                else -> showBottomNav(navigation)
            }
        }
    }

    private fun hideBottomNav(view: View) {
        view.visibility = View.GONE
    }

    private fun showBottomNav(view: View) {
        view.visibility = View.VISIBLE
    }
}