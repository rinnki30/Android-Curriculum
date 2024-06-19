package com.example.androidcurriculum.ui.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.androidcurriculum.Adapter.ImageSliderAdapter
import com.example.androidcurriculum.R
import java.util.Random


class ViewPagerFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ImageSliderAdapter
    private val handler = Handler(Looper.getMainLooper())
    private val random = Random()
    private val imageResIds = listOf(
        R.drawable.view_pager1,
        R.drawable.view_pager2,
        R.drawable.view_pager3,
        R.drawable.view_pager4,
        R.drawable.view_pager5,
        R.drawable.view_pager6,
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)
        adapter = ImageSliderAdapter(imageResIds)
        viewPager.adapter = adapter

        handler.postDelayed(runnable, 3000) // 3 seconds interval
    }

    private val runnable = object : Runnable {
        override fun run() {
            val nextItem = random.nextInt(adapter.itemCount)
            viewPager.setCurrentItem(nextItem, true)
            handler.postDelayed(this, 3000) // 3 seconds interval
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(runnable)
    }
}
