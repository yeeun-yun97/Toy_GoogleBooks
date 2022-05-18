package com.github.yeeun_yun97.clone.googlebook.ui.component

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.github.yeeun_yun97.clone.googlebook.R

class SjImageViewUtil {

    companion object {
        fun setImageResource(
            imageView: ImageView,
            imageUrl: String,
            @DrawableRes defaultImage: Int = -1
        ) {
            val context = imageView.context
            //clear image
            Glide.with(context).clear(imageView)

            //set image from url
            if (imageUrl != "") {
                Glide.with(context)
                    .load(imageUrl)
                    .error(R.drawable.ic_baseline_menu_book_24)
                    .into(imageView)

                //set default image
            } else if (defaultImage != -1) {
                val drawable = ResourcesCompat.getDrawable(
                    context.resources,
                    defaultImage,
                    context.theme
                )
                imageView.setImageDrawable(drawable)
            }
        }
    }
}