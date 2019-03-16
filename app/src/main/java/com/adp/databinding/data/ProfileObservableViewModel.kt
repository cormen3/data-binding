package com.adp.databinding.data

import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.adp.databinding.BR
import com.adp.databinding.util.ObservableViewModel

class ProfileObservableViewModel : ObservableViewModel() {
    val name = ObservableField("Ada")
    val lastName = ObservableField("Lovelace")
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

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}

private fun ObservableInt.increment() {
    set(get() + 1)
}
