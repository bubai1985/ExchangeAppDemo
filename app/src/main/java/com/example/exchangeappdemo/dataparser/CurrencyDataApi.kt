package com.example.exchangeappdemo.dataparser

import java.net.URL
import javax.net.ssl.HttpsURLConnection

/**
 * This class fetch the data from from server
 */
class CurrencyDataApi {
    val BASE_URL = "https://cdn.jsdelivr.net/gh/fawazahmed0/"
    val CURRENCY_API = "currency-api@1/latest/currencies/aud.json"
    val CURRENCY_DATA_URL = BASE_URL + CURRENCY_API

    /**
     * This method fetch the data from server
     * @return as String
     */
    fun getAllUserData() : String {
        var jsonData = java.lang.StringBuilder()
        try {
            val url = URL(CURRENCY_DATA_URL)
            with(url.openConnection() as HttpsURLConnection) {
                requestMethod = "GET"  // optional default is GET
                println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        jsonData.append(line)
                    }
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return jsonData.toString()
    }
}