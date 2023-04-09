package com.example.tztcell.presentation.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tztcell.R
import com.google.android.material.appbar.MaterialToolbar

fun Fragment.hideActionBar() = (requireActivity() as AppCompatActivity).supportActionBar?.hide()
fun Fragment.showActionBar() = (requireActivity() as AppCompatActivity).supportActionBar?.show()

fun Fragment.hideArrowTool()  {
    (requireActivity() as AppCompatActivity).findViewById<MaterialToolbar>(R.id.toolbar).navigationIcon = null
}


