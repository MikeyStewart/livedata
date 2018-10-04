package com.example.mstewart.livedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var mutableLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        mutableLiveData.observe(this, Observer { newString ->
            textView.text = newString
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpButton()
    }

    private fun setUpButton() {
        button.setOnClickListener {
            mutableLiveData.value = "Random int: ${Random().nextInt()}"
        }
    }

}
