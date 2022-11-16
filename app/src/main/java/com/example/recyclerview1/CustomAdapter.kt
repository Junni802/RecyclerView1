package com.example.recyclerview1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview1.databinding.ContentListBinding
import com.google.android.material.transition.Hold
import java.text.SimpleDateFormat

class CustomAdapter: RecyclerView.Adapter<Holder>() {
	var listData = mutableListOf<Memo>()
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
		val binding = ContentListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return Holder(binding)
	}

	override fun onBindViewHolder(holder: Holder, position: Int) {
		val memo = listData.get(position)
		holder.setMemo(memo)
	}

	override fun getItemCount(): Int {
		return listData.size
	}
}

class Holder(val binding: ContentListBinding): RecyclerView.ViewHolder(binding.root){
	fun setMemo(memo: Memo){
		binding.textNo.text = "${memo.no}"
		binding.txtContent.text = memo.content
		var sdf = SimpleDateFormat("yyyy/MM/dd");
		var formattedDate = sdf.format(memo.date)

		binding.txtDate.text = formattedDate
	}
}