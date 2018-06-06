package com.allen.kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

abstract class BaseFragment : Fragment() {
    private var isViewCreated = false
    private var isUIVisible = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        isViewCreated = true
        lazyLoad()
    }

    abstract fun lazyLoad()

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {
            isUIVisible = true
            lazyLoad()
        } else {
            isUIVisible = false
        }
    }
}