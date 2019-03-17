package com.adp.databinding.ui

import android.databinding.Bindable
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.adp.databinding.BR
import com.adp.databinding.data.ObservableViewModel
import com.adp.databinding.model.Popularity
import com.adp.databinding.util.increment

class ProfileObservableViewModel : ObservableViewModel() {
    val name = ObservableField("hossein")
    val lastName = ObservableField("gheisary")
    val likes =  ObservableInt(0)

    fun onLike() {
        likes.increment()
        // You control when the @Bindable properties are updated using `notifyPropertyChanged()`.
        notifyPropertyChanged(BR.popularity)
    }

    @Bindable
    fun getPopularity(): Popularity {
        return likes.get().let {
            when {
                it > 9 -> Popularity.STAR
                it > 4 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        }
    }
}






