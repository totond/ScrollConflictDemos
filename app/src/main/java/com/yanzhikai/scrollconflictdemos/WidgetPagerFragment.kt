package com.yanzhikai.scrollconflictdemos

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_widget_pager.*

class WidgetPagerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_widget_pager, container, false)
        val adapter = MyAdapter(context!!)
        val vp_widget = root.findViewById<MySubViewPager>(R.id.vp_widget)
        vp_widget.adapter = adapter
        return root
    }

    class MyAdapter(val context: Context) : PagerAdapter() {
        val views = ArrayList<View>()
        init {
            val range = 0..3
            for (i in range){
                val widget = LayoutInflater.from(context).inflate(R.layout.view_widget_1, null)
                when (i) {
                    0 -> widget.setBackgroundColor(Color.GREEN)
                    1 -> widget.setBackgroundColor(Color.BLUE)
                    2 -> widget.setBackgroundColor(Color.YELLOW)
                }
                views.add(widget)
            }
        }

        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0 == p1
        }

        override fun getCount(): Int {
            return 3
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            container.addView(views[position])
            return views[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(views[position])
        }
    }
}