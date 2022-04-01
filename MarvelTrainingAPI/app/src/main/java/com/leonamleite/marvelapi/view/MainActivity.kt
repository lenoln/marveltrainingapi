package com.leonamleite.marvelapi.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.leonamleite.marvelapi.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity","onCreate")
        setContentView(R.layout.activity_main)

    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        Log.i("MainActivity","onCreateView")
        return super.onCreateView(name, context, attrs)
    }

    override fun onStart() {
        Log.i("MainActivity","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("MainActivity","onResume")
        super.onResume()
    }

    override fun onRestart() {
        Log.i("MainActivity","onRestart")
        super.onRestart()
    }

    override fun onPause() {
        Log.i("MainActivity","onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("MainActivity","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("MainActivity","onDestroy")
        super.onDestroy()
    }
}
