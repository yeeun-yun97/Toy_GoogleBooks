package com.github.yeeun_yun97.clone.googlebook.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.databinding.ItemBookBinding
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
        Glide.with(itemView).clear(binding.bookImageView)
        if (bookData.imageUrl != "") {
            Glide.with(itemView)
                .load(bookData.imageUrl)
                .error(R.drawable.ic_baseline_menu_book_24)
                .into(binding.bookImageView)
        } else {
            val drawable = ResourcesCompat.getDrawable(
                itemView.context.resources,
                R.drawable.ic_baseline_menu_book_24,
                itemView.context.theme
            )
            binding.bookImageView.setImageDrawable(drawable)
        }
    }

}