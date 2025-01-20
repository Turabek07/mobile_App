package com.example.assignments

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentA())
                .commit()
        }


        findViewById<View>(R.id.switchFragmentButton).setOnClickListener {

            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)


            val nextFragment: Fragment = if (currentFragment is FragmentA) {
                FragmentB()
            } else {
                FragmentA()
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, nextFragment)
                .commit()
        }
    }
}
