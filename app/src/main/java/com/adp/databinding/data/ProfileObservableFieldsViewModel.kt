package com.adp.databinding.data

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.databinding.ObservableInt

class ProfileObservableFieldsViewModel : ViewModel() {
    val name = ObservableField("Ada")
    val lastName = ObservableField("Lovelace")
    val likes =  ObservableInt(0)

    // popularity is exposed as an ObservableField instead of a @Bindable property.
    val popularity = ObservableField<Popularity>(Popularity.NORMAL)

    fun onLike() {
        likes.set(likes.get() + 1)

        popularity.set(likes.get().let {
            if (it > 9) Popularity.STAR
            if (it > 4) Popularity.POPULAR
            Popularity.NORMAL
        })
    }
}