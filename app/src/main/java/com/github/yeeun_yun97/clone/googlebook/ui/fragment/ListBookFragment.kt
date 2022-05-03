package com.github.yeeun_yun97.clone.googlebook.ui.fragment

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.databinding.FragmentListBookBinding
import com.github.yeeun_yun97.clone.googlebook.ui.BookAdapter
import com.github.yeeun_yun97.clone.googlebook.viewModel.ListBookViewModel

class ListBookFragment : BasicFragment<FragmentListBookBinding>() {
    private val viewModel: ListBookViewModel by activityViewModels()

    override fun layoutId(): Int = R.layout.fragment_list_book

    override fun onCreateView() {
        val recyclerView = binding.recyclerView

        val adapter = BookAdapter(viewModel.bookList.value!!, ::open)
        recyclerView.layoutManager = LinearLayoutManager(context)
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