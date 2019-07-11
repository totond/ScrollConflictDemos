package com.yanzhikai.scrollconflictdemos

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

class TestViewGroup : FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    var i : Int = 0

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("jkyTestViewGroup", "dispatchTouchEvent: " + ev?.action)
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            i = 0
        }
        return super.dispatchTouchEvent(ev)
    }

//    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
//        Log.i("jkySubViewPager", "onInterceptTouchEvent: " + ev?.action)
//        return super.onInterceptTouchEvent(ev)
//    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("jkyTestViewGroup", "onTouchEvent：" + i++)
        return true
    }
}