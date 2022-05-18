package com.github.yeeun_yun97.clone.googlebook.ui.fragment

import androidx.fragment.app.activityViewModels
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.databinding.FragmentViewBookDataBinding
import com.github.yeeun_yun97.clone.googlebook.ui.component.SjImageViewUtil
import com.github.yeeun_yun97.clone.googlebook.ui.component.SjNotification
import com.github.yeeun_yun97.clone.googlebook.viewModel.SingleBookViewModel

class ViewBookDataFragment : BasicFragment<FragmentViewBookDataBinding>() {
    private val viewModel: SingleBookViewModel by activityViewModels()

    override fun layoutId(): Int = R.layout.fragment_view_book_data

    override fun onCreateView() {
        binding.viewModel = viewModel
        viewModel.book.observe(viewLifecycleOwner,
            { book ->
                binding.favoriteImageView.setOnClickListener {
                    setFavorite(book)
                }
                binding.openWebButton.setOnClickListener {
                    open(book.linkUrl)
                }
                SjImageViewUtil.setImageResource(
                    binding.imageView,
                    book.imageUrl,
                    R.drawable.ic_baseline_menu_book_24
                )
                if (book.saved) {
                    binding.favoriteImageView.setImageResource(R.drawable.ic_baseline_star_24)
                } else {
                    binding.favoriteImageView.setImageResource(R.drawable.ic_baseline_star_outline_24)
                }
            }
        )


    }

    private fun setFavoriteImageViewImage(isSaved: Boolean) {
        if (isSaved) {
            binding.favoriteImageView.setImageResource(R.drawable.ic_baseline_star_outline_24)
        } else {
            binding.favoriteImageView.setImageResource(R.drawable.ic_baseline_star_24)
        }
    }

    private fun setFavorite(fav: BookData) {
        viewModel.saveFav(fav)
        setFavoriteImageViewImage(fav.saved)
        notifyNotification(title = fav.title, isAdd = !fav.saved)
    }

    private fun notifyNotification(title: String, isAdd: Boolean) {
        val textData: Pair<String, String> = if (isAdd) {
            Pair("즐겨찾기 추가", "즐겨찾기에 ${title}(이)가 추가되었습니다.")
        } else {
            Pair("즐겨찾기 제거", "즐겨찾기에서 ${title}(을)를 제거하였습니다.")
        }
        SjNotification.notifyNotification(requireContext(), textData.first, textData.second)
    }

    private fun open(url: String) {
        if (url.isNotEmpty()) {
            moveToOtherFragment(ViewWebFragment.newInstance(url))
        }
    }
}