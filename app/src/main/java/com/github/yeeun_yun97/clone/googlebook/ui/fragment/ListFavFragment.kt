package com.github.yeeun_yun97.clone.googlebook.ui.fragment

import android.content.Context
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.databinding.FragmentListFavBinding
import com.github.yeeun_yun97.clone.googlebook.ui.adapter.FavoriteAdapter
import com.github.yeeun_yun97.clone.googlebook.ui.component.SjNotification
import com.github.yeeun_yun97.clone.googlebook.viewModel.BookViewModel
import com.github.yeeun_yun97.clone.googlebook.viewModel.SingleBookViewModel

class ListFavFragment : BasicFragment<FragmentListFavBinding>() {
    private val viewModel: BookViewModel by activityViewModels()
    private val singleBookViewModel: SingleBookViewModel by activityViewModels()

    override fun layoutId(): Int = R.layout.fragment_list_fav

    override fun onCreateView() {
        val adapter = FavoriteAdapter(::open, ::saveFav, ::moveToViewBookFragment)

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
            moveToOtherFragment(ViewWebFragment.newInstance(url))
        }
    }

    private fun moveToViewBookFragment(book: BookData) {
        singleBookViewModel.book.postValue(book)
        moveToOtherFragment(ViewBookDataFragment())
    }

    private fun saveFav(fav: BookData, isAdd: Boolean) {
        viewModel.saveFav(fav, isAdd)
        notifyNotification(fav.title,isAdd)
    }

    private fun notifyNotification(title: String, isAdd: Boolean) {
        val textData: Pair<String, String> = if (isAdd) {
            Pair("즐겨찾기 추가", "즐겨찾기에 ${title}(이)가 추가되었습니다.")
        } else {
            Pair("즐겨찾기 제거", "즐겨찾기에서 ${title}(을)를 제거하였습니다.")
        }
        SjNotification.notifyNotification(requireContext(), textData.first, textData.second)
    }


}