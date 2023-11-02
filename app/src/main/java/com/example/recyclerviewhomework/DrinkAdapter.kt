package com.example.recyclerviewhomework

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.databinding.DrinkItemBinding

class DrinkAdapter() : RecyclerView.Adapter<DrinkAdapter.DrinkHolder>(), Parcelable {

    val drinkList = ArrayList<Drink>()
    constructor(parcel: Parcel) : this() {
    }

    class DrinkHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = DrinkItemBinding.bind(item)
        fun bind(drink: Drink) = with(binding){
            im.setImageResource(drink.imageId)
            tvTitle.text = drink.title
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DrinkAdapter> {
        override fun createFromParcel(parcel: Parcel): DrinkAdapter {
            return DrinkAdapter(parcel)
        }

        override fun newArray(size: Int): Array<DrinkAdapter?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drink_item, parent, false)
        return DrinkHolder(view)
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

    override fun onBindViewHolder(holder: DrinkHolder, position: Int) {
        holder.bind(drinkList[position])
    }

    fun addDrink(drink: Drink) {
        drinkList.add(drink)
        notifyDataSetChanged()
    }
}