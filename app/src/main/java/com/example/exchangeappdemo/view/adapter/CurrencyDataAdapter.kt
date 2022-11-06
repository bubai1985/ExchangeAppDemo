package com.example.exchangeappdemo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangeappdemo.R
import com.example.exchangeappdemo.model.Currency
import java.math.BigDecimal
import java.util.*

/**
 * This adapter class of RecyclerView
 * It populates the data into RecyclerView
 */

class CurrencyDataAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private var currencyDataList = LinkedList<Currency>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.currency_data_sub,parent,false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currency = currencyDataList.get(position)
        holder.bind(currency)
    }

    override fun getItemCount(): Int {
        return currencyDataList.size
    }

    fun setAllCurencies(userList: LinkedList<Currency>) {
        this.currencyDataList = userList
    }
}

/**
 * This is view holder class. It holds the view
 * @param [input] as View
 */
class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(currency: Currency) {
        val tvName = view.findViewById<TextView>(R.id.userName)
        val tvCurrency = view.findViewById<TextView>(R.id.currency)
        tvName.text = currency?.currencyCode
        tvCurrency.text = BigDecimal(currency?.exchangeRate.toString()).toString()
    }
}