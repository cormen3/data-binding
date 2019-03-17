package com.adp.databinding.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.adp.databinding.R
import com.adp.databinding.data.ProfileObservableViewModel
import com.adp.databinding.databinding.ViewmodelProfileBinding

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(ProfileObservableViewModel::class.java)

        val binding: ViewmodelProfileBinding = DataBindingUtil.setContentView(this, R.layout.viewmodel_profile)

        // Bind layout with ViewModel
        binding.viewmodel = viewModel
    }
}
