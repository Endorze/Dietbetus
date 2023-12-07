package com.example.dietbetus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.dietbetus.databinding.FragmentMainMenuBinding
import com.example.dietbetus.databinding.FragmentThreeChoicesBinding
import com.google.android.material.tabs.TabLayout

class ThreeChoicesFragment : Fragment() {
    private lateinit var binding: FragmentThreeChoicesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeChoicesBinding.inflate(layoutInflater)


        var tabLayout : TabLayout
        var viewPager2 : ViewPager2
        var myViewPagerAdaper : MyViewPagerAdapter

        tabLayout = binding.tabLayout
        viewPager2 = binding.viewPager

        myViewPagerAdaper = MyViewPagerAdapter(activity as FragmentActivity)
        viewPager2.setAdapter(myViewPagerAdaper)
        viewPager2.setCurrentItem(1)

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.setCurrentItem(tab.getPosition())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.getTabAt(position)?.select()
            }
        })
        tabLayout.selectTab(tabLayout.getTabAt(1))

        return binding.root
    }
}