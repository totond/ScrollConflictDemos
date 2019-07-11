package com.yanzhikai.scrollconflictdemos

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

class MySubViewPager : ViewPager {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    var lastX:Float = 0f
    var lastY:Float = 0f

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("jkySubViewPager", "dispatchTouchEvent: " + ev?.action)
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("jkySubViewPager", "onInterceptTouchEvent: " + ev?.action)

        when (ev?.action) {
            MotionEvent.ACTION_DOWN->{
                lastX = ev.x
                lastY = ev.y
            }
            MotionEvent.ACTION_MOVE->{

                if (ev.x - lastX > 10) {
                    Log.i("jkySubViewPager", "onInterceptTouchEvent: 1" )
                    return true
                }else if (ev.x - lastX > 200) {
                    Log.i("jkySubViewPager", "onInterceptTouchEvent: 2" )
                    return false
                }
            }
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("jkySubViewPager", "onTouchEvent：" + ev?.action)
        return super.onTouchEvent(ev)
    }
}