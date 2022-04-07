package com.leonamleite.marvelapi.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.leonamleite.marvelapi.R
import com.leonamleite.marvelapi.databinding.ActivityMainBinding
import com.leonamleite.marvelapi.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity","onCreate")
        setContentView(binding.root)

        viewModel.characteres.observe(this) {
            when (it) {
                MainViewModel.State.Loading -> Log.i(TAG, "CARREGANDO...")
                is MainViewModel.State.Error -> Log.e(TAG, it.error.message.toString())
                is MainViewModel.State.Success -> Log.i(TAG, it.list.toString())
            }
        }
        viewModel.getCharacterList(9)
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

    companion object {
        private const val TAG = "TAG"
    }
}
