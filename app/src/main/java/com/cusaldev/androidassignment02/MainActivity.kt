package com.cusaldev.androidassignment02

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {

    lateinit var btnHome : ImageButton
    lateinit var btnVideo : ImageButton
    lateinit var btnChat : ImageButton
    lateinit var btnSettings : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnHome = findViewById(R.id.imageButton2)
        btnVideo = findViewById(R.id.imageButton3)
        btnChat = findViewById(R.id.imageButton4)
        btnSettings = findViewById(R.id.imageButton5)

        var homeFragment = HomeFragment()
        var videoFragment = VideoFragment()
        var chatFragment = ChatFragment()
        var settingsFragment = SettingsFragment()

        btnHome.setOnClickListener {
            supportFragmentManager.beginTransaction()

                .replace(R.id.fragmentContainerView2, homeFragment)
                .commit()
        }

        btnVideo.setOnClickListener {
            supportFragmentManager.beginTransaction()

                .replace(R.id.fragmentContainerView2, videoFragment)
                .commit()
        }

        btnChat.setOnClickListener {
            supportFragmentManager.beginTransaction()

                .replace(R.id.fragmentContainerView2, chatFragment)
                .commit()
        }

        btnSettings.setOnClickListener {
            supportFragmentManager.beginTransaction()

                .replace(R.id.fragmentContainerView2, settingsFragment)
                .commit()
        }
    }
}