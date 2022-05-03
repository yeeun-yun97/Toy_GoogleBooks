package com.github.yeeun_yun97.clone.googlebook.ui.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.ui.BookAdapter
import com.github.yeeun_yun97.clone.googlebook.viewModel.ListBookViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: ListBookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = BookAdapter(viewModel.bookList.value!!, ::open)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        viewModel.bookList.observe(
            this, {
                adapter.itemList = it
                adapter.notifyDataSetChanged()
            }
        )
        viewModel.loadBooks()
    }

    private fun open(url: String) {
        if (!url.isNullOrEmpty()) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }


}