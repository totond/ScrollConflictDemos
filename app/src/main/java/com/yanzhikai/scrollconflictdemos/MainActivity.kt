package com.yanzhikai.scrollconflictdemos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_test1.setOnClickListener { gotoFragment(SBFragment()) }

    }

    fun gotoFragment(fragment: Fragment) {
        ly_root.visibility = View.VISIBLE
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.ly_root, fragment)
        ft.commit()
    }
}
