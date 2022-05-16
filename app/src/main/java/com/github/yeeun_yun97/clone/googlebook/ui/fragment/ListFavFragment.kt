package com.github.yeeun_yun97.clone.googlebook.ui.fragment

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.databinding.FragmentListFavBinding
import com.github.yeeun_yun97.clone.googlebook.ui.adapter.BookAdapter
import com.github.yeeun_yun97.clone.googlebook.viewModel.BookViewModel
import com.github.yeeun_yun97.clone.googlebook.viewModel.SingleBookViewModel

class ListFavFragment : BasicFragment<FragmentListFavBinding>() {
    private val viewModel: BookViewModel by activityViewModels()
    private val singleBookViewModel: SingleBookViewModel by activityViewModels()

    override fun layoutId(): Int = R.layout.fragment_list_fav

    override fun onCreateView() {
        val adapter = BookAdapter(::open, ::saveFav, ::moveToViewBookFragment)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        viewModel.favList.observe(
            viewLifecycleOwner,
            {
                adapter.setList(it)
            }
        )
    }

    private fun open(url: String) {
        if (url.isNotEmpty()) {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//            startActivity(intent)
            moveToOtherFragment(ViewWebFragment.newInstance(url))
        }
    }

    private fun moveToViewBookFragment(book: BookData) {
        singleBookViewModel.book.postValue(book)
        moveToOtherFragment(ViewBookDataFragment())
    }

    private fun saveFav(fav: BookData, isAdd: Boolean) {
        viewModel.saveFav(fav, isAdd)
    }
}