package com.adp.databinding.util

import android.databinding.ObservableInt

public fun ObservableInt.increment() {
    set(get() + 1)
}
