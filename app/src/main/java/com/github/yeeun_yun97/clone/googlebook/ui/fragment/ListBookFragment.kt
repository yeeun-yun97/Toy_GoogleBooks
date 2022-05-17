package com.github.yeeun_yun97.clone.googlebook.ui.fragment

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.databinding.FragmentListBookBinding
import com.github.yeeun_yun97.clone.googlebook.ui.adapter.BookAdapter
import com.github.yeeun_yun97.clone.googlebook.viewModel.BookViewModel
import com.github.yeeun_yun97.clone.googlebook.viewModel.SingleBookViewModel

class ListBookFragment : BasicFragment<FragmentListBookBinding>() {
    private val viewModel: BookViewModel by activityViewModels()
    private val singleBookViewModel: SingleBookViewModel by activityViewModels()

    override fun layoutId(): Int = R.layout.fragment_list_book

    override fun onCreateView() {
        val recyclerView = binding.recyclerView
        binding.include.toolbarTitle = "책 목록 - '프로그래밍'"

        val adapter = BookAdapter(::moveToViewBookFragment)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        viewModel.bookList.observe(
            viewLifecycleOwner, {
                adapter.setList(it)
            }
        )
        viewModel.loadBooks()
    }

    private fun moveToViewBookFragment(book: BookData) {
        singleBookViewModel.book.postValue(book)
        moveToOtherFragment(ViewBookDataFragment())
    }


}