package com.example.exchangeappdemo.util

import com.example.exchangeappdemo.model.Currency
import java.util.LinkedList

/**
 * This class is being used for shorting user data
 */
class BubbleSort {
    companion object {
        /**
         *The application must use a Bubble Sort to sort the currencies in descending order based
         * on the exchange rate.
         * @param [input] as LinkedList of Currency
         */
        fun sortData(currencyList: LinkedList<Currency>) {
            for (i in 0..currencyList.size) {
                for (j in 1..currencyList.size - i - 1) {
                   if (currencyList.get(j - 1).exchangeRate < currencyList.get(j).exchangeRate) {
                       swapData(currencyList, j)
                    } else if (currencyList.get(j - 1).exchangeRate == currencyList.get(j).exchangeRate) {
                        //if the exchange rates are the same then sort using the currency code
                        if (currencyList.get(j-1).currencyCode.compareTo(currencyList.get(j).currencyCode) > 0) {
                            swapData(currencyList, j)
                        }
                   }
                }
            }
        }

        /**
         * This function swaps two Currency objects.
         * @param [input] as LinkedList of Currency
         */

        private fun swapData(currencyList: LinkedList<Currency>, index: Int) {
            val temp = currencyList.get(index - 1)
            currencyList.set(index - 1, currencyList.get(index))
            currencyList.set(index, temp)
        }
    }
}