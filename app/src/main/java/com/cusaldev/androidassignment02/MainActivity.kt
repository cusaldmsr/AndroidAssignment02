package com.cusaldev.androidassignment02

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btnHome: ImageButton
    lateinit var btnVideo: ImageButton
    lateinit var btnChat: ImageButton
    lateinit var btnSettings: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize buttons
        btnHome = findViewById(R.id.imageButton2)
        btnVideo = findViewById(R.id.imageButton3)
        btnChat = findViewById(R.id.imageButton4)
        btnSettings = findViewById(R.id.imageButton5)

        // Create fragment instances
        val homeFragment = HomeFragment()
        val videoFragment = VideoFragment()
        val chatFragment = ChatFragment()
        val settingsFragment = SettingsFragment()

        // Load HomeFragment initially if no saved state
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2, homeFragment)
                .commit()
        }

        // Set up button listeners with transitions
        btnHome.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.fragment_slide_in_right,  // Enter animation
                    R.anim.fragment_slide_out_left,  // Exit animation
                    R.anim.fragment_slide_in_left,   // Pop enter (back)
                    R.anim.fragment_slide_out_right  // Pop exit (back)
                )
                .replace(R.id.fragmentContainerView2, homeFragment)
                .addToBackStack(null) // Optional: allows back navigation
                .commit()
        }

        btnVideo.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.fragment_slide_in_right,
                    R.anim.fragment_slide_out_left,
                    R.anim.fragment_slide_in_left,
                    R.anim.fragment_slide_out_right
                )
                .replace(R.id.fragmentContainerView2, videoFragment)
                .addToBackStack(null)
                .commit()
        }

        btnChat.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.fragment_slide_in_right,
                    R.anim.fragment_slide_out_left,
                    R.anim.fragment_slide_in_left,
                    R.anim.fragment_slide_out_right
                )
                .replace(R.id.fragmentContainerView2, chatFragment)
                .addToBackStack(null)
                .commit()
        }

        btnSettings.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.fragment_slide_in_right,
                    R.anim.fragment_slide_out_left,
                    R.anim.fragment_slide_in_left,
                    R.anim.fragment_slide_out_right
                )
                .replace(R.id.fragmentContainerView2, settingsFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}