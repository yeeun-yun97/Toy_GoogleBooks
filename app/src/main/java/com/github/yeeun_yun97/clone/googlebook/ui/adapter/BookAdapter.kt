package com.github.yeeun_yun97.clone.googlebook.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.databinding.ItemBookBinding
import com.github.yeeun_yun97.clone.googlebook.ui.component.SjImageViewUtil
import com.github.yeeun_yun97.clone.ynmodule.ui.adapter.RecyclerBasicAdapter
import com.github.yeeun_yun97.clone.ynmodule.ui.adapter.RecyclerBasicViewHolder

class BookAdapter(
    private val viewOperation: (BookData) -> Unit
) : RecyclerBasicAdapter<BookData, BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding);
    }

    override fun onBindViewHolder(holder: BookViewHolder, item: BookData) {
        holder.setItem(item, viewOperation)
    }
}

class BookViewHolder(binding: ItemBookBinding) :
    RecyclerBasicViewHolder<ItemBookBinding>(binding) {
    fun setItem(
        bookData: BookData,
        viewOperation: (BookData) -> Unit
    ) {
        binding.bookData = bookData
        binding.root.setOnClickListener { viewOperation(bookData) }
        SjImageViewUtil.setImageResource(
            binding.bookImageView,
            bookData.imageUrl,
            R.drawable.ic_baseline_menu_book_24
        )
    }

}