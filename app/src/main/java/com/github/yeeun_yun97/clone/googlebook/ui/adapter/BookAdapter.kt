package com.github.yeeun_yun97.clone.googlebook.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.databinding.ItemBookBinding
import com.github.yeeun_yun97.clone.ynmodule.ui.adapter.RecyclerBasicAdapter
import com.github.yeeun_yun97.clone.ynmodule.ui.adapter.RecyclerBasicViewHolder

class BookAdapter(
    private val openOperation: (String) -> Unit,
    private val favOperation: (BookData, Boolean) -> Unit,
    private val viewOperation: (BookData) -> Unit
) : RecyclerBasicAdapter<BookData, BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding);
    }

    override fun onBindViewHolder(holder: BookViewHolder, item: BookData) {
        holder.setItem(item, openOperation, favOperation, viewOperation)
    }
}

class BookViewHolder(binding: ItemBookBinding) :
    RecyclerBasicViewHolder<ItemBookBinding>(binding) {
    fun setItem(
        bookData: BookData,
        openOperation: (String) -> Unit,
        favOperation: (BookData, Boolean) -> Unit,
        viewOperation: (BookData) -> Unit
    ) {
        binding.bookData = bookData
        binding.root.setOnClickListener {
            viewOperation(bookData)
        }
        if (bookData.imageUrl != "") {
            Glide.with(itemView)
                .load(bookData.imageUrl)
                .error(R.drawable.ic_baseline_menu_book_24)
                .into(binding.bookImageView)
        }
        binding.openLinkImageView.setOnClickListener {
            openOperation(bookData.linkUrl)
        }
        if (bookData.saved)
            binding.favoriteImageView.setImageResource(R.drawable.ic_baseline_star_24)
        else
            binding.favoriteImageView.setImageResource(R.drawable.ic_baseline_star_outline_24)
        binding.favoriteImageView.setOnClickListener {
            val imageView = it as ImageView
            if (bookData.saved)
                imageView.setImageResource(R.drawable.ic_baseline_star_outline_24)
            else
                imageView.setImageResource(R.drawable.ic_baseline_star_24)
            favOperation(bookData, !bookData.saved)
        }
    }

}