package com.tanveershafeeprottoy.rxandroiddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tanveershafeeprottoy.rxandroiddemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        if(savedInstanceState != null) {
            return
        }
        ActivityUtils.addFragmentOnActivity(
            supportFragmentManager,
            MainFragment.newInstance(),
            R.id.activityMainFrame
        )
    }
}
