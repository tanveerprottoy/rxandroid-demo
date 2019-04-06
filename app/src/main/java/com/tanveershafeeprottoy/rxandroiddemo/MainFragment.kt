package com.tanveershafeeprottoy.rxandroiddemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tanveershafeeprottoy.rxandroiddemo.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentMainBinding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        fragmentMainBinding.mainFragment = this
        return fragmentMainBinding.root
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.activityMainBtn0 -> ActivityUtils.replaceFragmentOnActivity(
                activity?.supportFragmentManager,
                SingleFragment.newInstance(),
                R.id.activityMainFrame,
                "SingleFragment"
            )
            R.id.activityMainBtn1 -> ActivityUtils.replaceFragmentOnActivity(
                activity?.supportFragmentManager,
                MapFragment.newInstance(),
                R.id.activityMainFrame,
                "MapFragment"
            )
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
