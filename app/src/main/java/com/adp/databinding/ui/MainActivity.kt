package com.adp.databinding.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.adp.databinding.R
import com.adp.databinding.databinding.ActivityMainBinding

//import com.adp.databinding.databinding.ActivityMainBinding

/**
 * Shows a menu.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The layout for this activity is a Data Binding layout so it needs to be inflated using DataBindingUtil.
        val binding: com.adp.databinding.databinding.ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // The returned binding has references to all the Views with an ID.
        binding.observableFieldsActivityButton.setOnClickListener {
            startActivity(Intent(this, ObservableFieldActivity::class.java))
        }
        binding.viewmodelActivityButton.setOnClickListener {
            startActivity(Intent(this, ViewModelActivity::class.java))
        }
    }
}
