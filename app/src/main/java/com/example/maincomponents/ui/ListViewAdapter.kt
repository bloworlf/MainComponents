package com.example.maincomponents.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.maincomponents.R
import com.example.maincomponents.data.model.Contact

class ListViewAdapter(var context: Context, var list: List<Contact>) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Contact {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = convertView
        if (view == null) {
            view = LayoutInflater.from(context)
                .inflate(R.layout.model_contact, parent, false)
        }
        val currentItem = getItem(position)
        val textViewItemName = view
            ?.findViewById(R.id.name) as TextView
        val textViewItemDescription = view
            ?.findViewById(R.id.phone) as TextView
        textViewItemName.text = currentItem.name
        textViewItemDescription.text = currentItem.phoneNumber
        return view
    }
}