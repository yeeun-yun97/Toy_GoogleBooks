package com.github.yeeun_yun97.clone.googlebook.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.databinding.ItemBookBinding

class BookAdapter(
    var itemList: List<BookData>,
    val openOperation: (String) -> Unit
) : RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BookViewHolder(binding);
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.setItem(itemList[position], openOperation)
    }

    override fun getItemCount(): Int = itemList.size
}

class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setItem(
        bookData: BookData,
        openOperation: (String) -> Unit
    ) {
        binding.bookData = bookData
        if (bookData.imageUrl != "") {
            Glide.with(itemView)
                .load(bookData.imageUrl)
                .error(R.drawable.ic_baseline_menu_book_24)
                .into(binding.bookImageView)
        }
        binding.openLinkImageView.setOnClickListener {
            openOperation(bookData.linkUrl)
        }
    }

    fun openLink(url: String) {
        Log.d("tag", url)
    }

}