package com.example.exchangeappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exchangeappdemo.view.adapter.CurrencyDataAdapter
import com.example.exchangeappdemo.databinding.ActivityMainBinding
import com.example.exchangeappdemo.modal.MainActivityViewModel

/**
 * This is launch Activity class
 * It is used to display all data to the user
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mCurrencyDataAdapter: CurrencyDataAdapter
    private lateinit var mMainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mMainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // Initialize view
        initView()

        // Get all currencies from we server
        mMainActivityViewModel.getAllCurrencies()

        // Observing on currency list
        mMainActivityViewModel.currencyList.observe(this, androidx.lifecycle.Observer {
            mCurrencyDataAdapter.setAllCurencies(it)
            mCurrencyDataAdapter.notifyDataSetChanged()
            binding.progressBar.visibility = View.GONE
        })
    }

    /**
     * This method is used for initialize view
     */
    private fun initView() {
        mCurrencyDataAdapter = CurrencyDataAdapter()
        binding.progressBar.visibility = View.VISIBLE
        binding.rvUserData.apply {
            setLayoutManager(LinearLayoutManager(this@MainActivity));
            adapter = mCurrencyDataAdapter
        }
        mCurrencyDataAdapter.notifyDataSetChanged()
    }
}