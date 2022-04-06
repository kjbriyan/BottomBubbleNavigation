package com.kjbriyan.smoothbottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gauravk.bubblenavigation.BubbleNavigationLinearView
import com.gauravk.bubblenavigation.BubbleToggleView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bubbleNavigationLinearView =
            findViewById<BubbleNavigationLinearView>(R.id.bottom_navigation_view_linear)

        bubbleNavigationLinearView.setBadgeValue(0, "40")
        bubbleNavigationLinearView.setBadgeValue(1, null) //invisible badge
        bubbleNavigationLinearView.setBadgeValue(2, "7")
        bubbleNavigationLinearView.setBadgeValue(3, null)
        bubbleNavigationLinearView.setBadgeValue(4, "") //empty badge

        setFragment(HomeFragment.newIntance())

        bubbleNavigationLinearView.setNavigationChangeListener { view, position ->
            when(position){
                0 -> setFragment(HomeFragment.newIntance())
                1 -> setFragment(SearchFragment.newInstance())
                2 -> setFragment(LikeFragment.newIntance())
                3 -> setFragment(NotifyFragment.newInstace())
                4 -> setFragment(ProfileFragment.newInstance())

            }
        }

    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout, fragment, "HomeActivity")
            .commit()
    }

}