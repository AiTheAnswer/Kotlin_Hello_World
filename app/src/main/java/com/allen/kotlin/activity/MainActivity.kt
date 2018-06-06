package com.allen.kotlin.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.allen.kotlin.R

class MainActivity : BaseActivity() {
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager
    private lateinit var mTitles: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initData() {
        mTitles = arrayOf(getString(R.string.recommended), getString(R.string.category), getString(R.string.ranking), getString(R.string.anchor))
    }

    private fun initView() {
        mTabLayout = findViewById(R.id.tab_layout)
        mViewPager = findViewById(R.id.view_pager)
    }
}
