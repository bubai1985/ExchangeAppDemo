package com.example.exchangeappdemo.modal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exchangeappdemo.dataparser.CurrencyDataApi
import com.example.exchangeappdemo.dataparser.CurrencyDataParser
import com.example.exchangeappdemo.model.Currency
import com.example.exchangeappdemo.util.BubbleSort
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

/**
 * This is data holder class. This ViewModel class class holds the data until and unless the
 * activity is destroyed.
 */
class MainActivityViewModel : ViewModel() {
    private var currencyDataList = LinkedList<Currency>()
    val currencyList: MutableLiveData<LinkedList<Currency>> = MutableLiveData<LinkedList<Currency>>()

    /**
     * This method starts Coroutine to fetch the data from web server
     */
    fun getAllCurrencies() {
        CoroutineScope(Dispatchers.IO).launch {
            val jasonData = CurrencyDataApi().getAllUserData()
            currencyDataList = CurrencyDataParser().parseUserData(jasonData)
            BubbleSort.sortData(currencyDataList)
            withContext(Dispatchers.Main) {
                currencyList.value = currencyDataList
            }
        }
    }
}