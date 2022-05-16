package com.github.yeeun_yun97.clone.googlebook.ui.fragment

import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.databinding.FragmentViewBookDataBinding
import com.github.yeeun_yun97.clone.googlebook.viewModel.SingleBookViewModel

class ViewBookDataFragment : BasicFragment<FragmentViewBookDataBinding>() {
    private val viewModel: SingleBookViewModel by activityViewModels()

    override fun layoutId(): Int = R.layout.fragment_view_book_data

    override fun onCreateView() {
        binding.viewModel = viewModel
        viewModel.book.observe(viewLifecycleOwner,
            { book ->
                binding.favoriteImageView.setOnClickListener {
                    setFavorite(book.saved)
                }
                binding.openWebButton.setOnClickListener {
                    open(book.linkUrl)
                }
                Glide.with(requireContext()).load(book.imageUrl).into(binding.imageView)
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

    private fun setFavorite(isSaved: Boolean) {
        viewModel.saveFav()
        setFavoriteImageViewImage(isSaved)
    }

    private fun open(url: String) {
        if (url.isNotEmpty()) {
            moveToOtherFragment(ViewWebFragment.newInstance(url))
        }
    }
}