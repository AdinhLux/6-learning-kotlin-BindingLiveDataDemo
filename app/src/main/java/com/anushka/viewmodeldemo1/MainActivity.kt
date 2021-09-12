package com.anushka.viewmodeldemo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        /*
         * LiveData is always associated with the lifecycle of an activity or service
         * So we have to provide the actual lifecycle owner to the viewModel : we set the current activity as the lifecycle owner of the binding object
         *
         * LiveData is always observed inside a UI Lifecycle owner, which can be an Activity or a Fragment.
         *
         * https://www.raywenderlich.com/10391019-livedata-tutorial-for-android-deep-dive
         */
        binding.lifecycleOwner = this
        binding.myViewModel = viewModel
    }
}
