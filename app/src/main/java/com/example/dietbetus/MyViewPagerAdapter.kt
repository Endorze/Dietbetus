package com.example.dietbetus

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ActionsFragment()
            1 -> return MainMenuFragment()
            2 -> return InsulinRapportering()

            else -> return MainMenuFragment()
        }
    }
}