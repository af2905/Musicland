package com.github.af2905.musicland.helper

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <F : Fragment> F.putArgs(argsBuilder: Bundle.() -> Unit): F =
    this.apply { arguments = Bundle().apply(argsBuilder) }