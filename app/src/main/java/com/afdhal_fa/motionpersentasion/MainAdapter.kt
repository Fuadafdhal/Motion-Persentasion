package com.afdhal_fa.motionpersentasion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afdhal_fa.motionpersentasion.base.BaseRecyclerViewAdapter
import com.afdhal_fa.motionpersentasion.databinding.ItemTextBinding

class MainAdapter : BaseRecyclerViewAdapter<MainAdapter.VHolder, String>() {

    inner class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mBinding = ItemTextBinding.bind(itemView)

        init {
            mBinding.root.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }

        fun onBind(it: String) {
            mBinding.textView.text = it
        }
    }

    override fun onBindViewHolder(holder: VHolder, item: String, position: Int) {
        holder.onBind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))
}