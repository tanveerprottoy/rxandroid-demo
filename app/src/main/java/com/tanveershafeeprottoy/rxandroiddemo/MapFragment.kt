package com.tanveershafeeprottoy.rxandroiddemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tanveershafeeprottoy.rxandroiddemo.databinding.FragmentMapBinding

class MapFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var fragmentMapBinding: FragmentMapBinding
    private lateinit var baseListAdapter: BaseListAdapter<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(activity!!).get(UserViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMapBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_map,
            container,
            false
        )
        fragmentMapBinding.userViewModel = userViewModel
        baseListAdapter = BaseListAdapter(
            R.layout.row_user_list,
            BR.rowUserListObj
        )
        fragmentMapBinding.fragmentMapRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = baseListAdapter
        }
        return fragmentMapBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userViewModel.userListMapMutableLiveData.observe(
            viewLifecycleOwner,
            Observer {
                baseListAdapter.setData(it)
            }
        )
        userViewModel.throwableSingleLiveEvent.observe(
            viewLifecycleOwner,
            Observer {
                Toast.makeText(
                    activity,
                    "Error occurred",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
    }

    companion object {

        @JvmStatic
        fun newInstance() = MapFragment()
    }
}
