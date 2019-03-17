package com.adp.databinding.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.adp.databinding.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observable_fields_activity_button.setOnClickListener {startActivity(Intent(this, ObservableFieldActivity::class.java))}
        viewmodel_activity_button.setOnClickListener {startActivity(Intent(this, ViewModelActivity::class.java))}
    }
}
