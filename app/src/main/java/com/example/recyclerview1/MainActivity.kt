package com.example.recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		val data: MutableList<Memo> = loadData()
		var adapter = CustomAdapter()
		adapter.listData = data
		binding.recyclerView.adapter = adapter

		binding.recyclerView.layoutManager = LinearLayoutManager(this)

	}
	fun loadData(): MutableList<Memo>{
		val data: MutableList<Memo> = mutableListOf()

		for(no in 1.. 100){
			val content = "대화내용${no}번 입니다."
			val date = System.currentTimeMillis()

			var memo = Memo(no, content, date)
			data.add(memo)
		}
		return data;
	}
}