package com.sdl.coolweather.ui.area

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.sdl.coolweather.R
import com.sdl.coolweather.databinding.SimpleItemBinding

/**
 * create by songdongliang on 2019/8/6
 */
class ChooseAreaAdapter(context: Context, private val resId: Int, private val dataList: List<String>): ArrayAdapter<String>(context, resId, dataList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val bind: SimpleItemBinding?
        val view = if (convertView == null) {
            bind = DataBindingUtil.inflate(LayoutInflater.from(parent.context), resId, parent, false)
            bind.root.tag = bind
            bind.root
        } else {
            bind = convertView.tag as SimpleItemBinding
            convertView
        }
        bind?.data = dataList[position]
        return view
    }
}