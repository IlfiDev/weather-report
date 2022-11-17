package ru.ilfidev.weatherreport.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.ilfidev.weatherreport.R

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 100

    override fun createFragment(position: Int): Fragment {
        val fragment = test2()
        fragment.arguments = Bundle().apply {
            putInt("A", position + 1)
        }
        return fragment
    }


}