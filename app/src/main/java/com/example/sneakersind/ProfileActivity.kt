package com.example.sneakersind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar!!.title="Profile"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
