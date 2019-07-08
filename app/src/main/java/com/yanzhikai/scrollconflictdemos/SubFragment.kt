package com.yanzhikai.scrollconflictdemos

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sub.*

class SubFragment : Fragment() {
    val fragmentList: ArrayList<Fragment> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var root = inflater.inflate(R.layout.fragment_sub, null, false)
        fragmentList.add(WidgetFragment())
        fragmentList.add(WidgetPagerFragment())
        fragmentList.add(WidgetFragment())
        val adapter = MyFragmentAdapter(fragmentList, childFragmentManager)
        val vp = root.findViewById<MyViewPager>(R.id.vp)
        vp.adapter = adapter
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    class MyFragmentAdapter(private val list:ArrayList<Fragment>, fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
        init {

        }
        override fun getItem(p0: Int): Fragment {
            return list[p0]
        }

        override fun getCount(): Int {
            return list.size
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            super.destroyItem(container, position, `object`)
        }
    }
}
