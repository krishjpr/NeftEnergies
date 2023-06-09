package com.neftenergies.binding

import com.neftenergies.utils.Utility
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amnix.xtension.extensions.isNotNullOrEmpty
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.neftenergies.R
import kotlin.math.roundToInt


@BindingAdapter("product_image")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) {
        view.setImageResource(R.drawable.app_logo)
    } else {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.ic_logo_trips)
            .error(R.drawable.ic_logo_trips)
            .into(view)
    }
}

@BindingAdapter(value = ["article_image", "video_thumbnail"], requireAll = true)
fun bindArticleImageFromUrl(view: ImageView, articleImage: String?, videoThumnailImage: String?) {
    when {
        videoThumnailImage.isNotNullOrEmpty() -> {
            Glide.with(view.context)
                .load(videoThumnailImage)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
        }
        articleImage.isNotNullOrEmpty() -> {
            Glide.with(view.context)
                .load(articleImage)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
        }
    }
}

@BindingAdapter("product_image_farm")
fun bindImage(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) {
        view.setImageResource(R.drawable.ic_logo_trips)
    } else {
        Glide.with(view.context)
            .load(imageUrl)
            .apply(RequestOptions().override(600, 300))
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.ic_logo_trips)
            .error(R.drawable.ic_logo_trips)
            .into(view)
    }
}


@BindingAdapter("state_image")
fun bindStateImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("profile_image")
fun bindProfileImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .apply(
                RequestOptions()
                    .error(R.drawable.ic_logo_trips)
                    .centerCrop()
            )
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("login_banner")
fun bindLoginBannerImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .apply(
                RequestOptions()
                    .error(R.drawable.ic_logo_trips)
                    .centerCrop()
            )
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)

    }
}

@BindingAdapter(value = ["product_image", "error"], requireAll = false)
fun loadImage(view: ImageView, profileImage: String, error: Int) {
    if (profileImage.isNullOrEmpty() || TextUtils.isEmpty(profileImage)) {
        view.setImageResource(R.drawable.ic_logo_trips)
    } else {
        Glide.with(view.context)
            .load(profileImage)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>,
                    isFirstResource: Boolean,
                ): Boolean {
                    view.setImageResource(error)
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>,
                    dataSource: DataSource?,
                    isFirstResource: Boolean,
                ): Boolean {
                    view.setImageDrawable(resource)
                    return true
                }

            })
            .into(view)
    }
}

@BindingAdapter("android:src")
fun setImageUri(view: ImageView, imageUri: String?) {
    if (imageUri == null) {
        view.setImageURI(null)
    } else {
        view.setImageURI(Uri.parse(imageUri))
    }
}

@BindingAdapter("android:src")
fun setImageUri(view: ImageView, imageUri: Uri?) {
    view.setImageURI(imageUri)
}

@BindingAdapter("android:src")
fun setImageDrawable(view: ImageView, drawable: Drawable?) {
    view.setImageDrawable(drawable)
}

@BindingAdapter("userRatingFormat")
fun bindRating(view: TextView, rating: Double?) {
    rating?.let {
        view.text = rating.toString()
    }
}

@BindingAdapter("htmlText")
fun setHtmlTextValue(textView: TextView, htmlText: String?) {
    if (htmlText.isNullOrEmpty()) return
    val result: Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(htmlText)
    }
    textView.text = result
}

@BindingAdapter(value = ["selectedTab", "recentSize", "pastSize"], requireAll = true)
fun orderEmptyViewHandling(
    emptyView: View, selectedTab: Int, recentSize: Int, pastSize: Int,
) {
    when (selectedTab) {
        0 -> {
            if (recentSize > 0) {
                emptyView.visibility = View.GONE
            } else {
                emptyView.visibility = View.VISIBLE
            }
        }
        1 -> {
            if (pastSize > 0) {
                emptyView.visibility = View.GONE
            } else {
                emptyView.visibility = View.VISIBLE
            }
        }
    }
}

@BindingAdapter(value = ["selectedTab", "recentSize", "placedSize", "pastSize"], requireAll = true)
fun orderEmptyViewHandling(
    emptyView: View, selectedTab: Int, recentSize: Int, placedSize: Int, pastSize: Int,
) {
    when (selectedTab) {
        0 -> {
            if (recentSize == 0 && placedSize == 0) {
                emptyView.visibility = View.VISIBLE
            } else {
                emptyView.visibility = View.GONE
            }
        }
        1 -> {
            if (pastSize > 0) {
                emptyView.visibility = View.GONE
            } else {
                emptyView.visibility = View.VISIBLE
            }
        }
    }
}

@BindingAdapter(value = ["selectedTab", "placeSize"], requireAll = true)
fun placedOrderRecyclerHandling(
    view: View, selectedTab: Int, placedSize: Int,
) {
    if (selectedTab == 0 && placedSize > 0) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["selectedTab", "recentSize"], requireAll = true)
fun recentOrderRecyclerHandling(
    view: View, selectedTab: Int, recentSize: Int,
) {
    if (selectedTab == 0 && recentSize > 0) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["selectedTab", "pastSize"], requireAll = true)
fun pastOrderRecyclerHandling(
    recyclerView: RecyclerView, selectedTab: Int, pastSize: Int,
) {
    if (selectedTab == 1 && pastSize > 0) {
        recyclerView.visibility = View.VISIBLE
    } else {
        recyclerView.visibility = View.GONE
    }
}

@BindingAdapter(value = ["orderDate", "quantity", "items", "isDateAlreadyFormatted", "isEnglish"],
    requireAll = true)
fun setDateAndItemCount(
    textView: TextView,
    orderDate: String,
    quantity: String,
    items: String,
    isDateAlreadyFormatted: Boolean,
    isEnglish: Boolean,
) {
    try {
        if (orderDate.isNotNullOrEmpty()) {
            if (isDateAlreadyFormatted) {
                textView.text = orderDate + " / " + quantity + items
            } else {
                if (isEnglish) {
                    textView.text = Utility.getEnglishFormattedDate(orderDate,
                        Utility.DATE_MONTH_YEAR_FORMAT,
                        Utility.MONTH_DATE_YEAR_FORMAT) + " / " + quantity + items
                } else {
                    textView.text = Utility.getFormattedDate(orderDate,
                        Utility.DATE_MONTH_YEAR_FORMAT,
                        Utility.MONTH_DATE_YEAR_FORMAT) + " / " + quantity + items
                }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

@BindingAdapter(value = ["validity_date"], requireAll = true)
fun setDateAndVisibility(
    textView: TextView, validity_date: String? = null,
) {
    try {
        if (validity_date.isNullOrEmpty()) {
            textView.visibility = View.GONE
        } else {
            textView.visibility = View.VISIBLE
            textView.text = "Valid till " + Utility.getFormattedDate(
                validity_date,
                Utility.MONTH_DATE_YEAR_FORMAT,
                Utility.YEAR_MONTH_DATA_TIME_FORMAT
            )
        }
    } catch (e: Exception) {
        textView.visibility = View.GONE
    }
}

@BindingAdapter(value = ["reformat_date"], requireAll = true)
fun reformatDate(
    textView: TextView, reformat_date: String? = null,
) {
    try {
        if (reformat_date.isNullOrEmpty()) {
            textView.visibility = View.GONE
        } else {
            textView.visibility = View.VISIBLE
            var date = reformat_date
            if (date.contains(":00")) {
                date = date.replace(":00", " ")
            }
            if (date.contains("pm")) {
                date = date.replace("pm", "PM")
            } else if (date.contains("am")) {
                date = date.replace("am", "AM")
            }
            textView.text = date
        }
    } catch (e: Exception) {
        textView.visibility = View.GONE
    }
}

@BindingAdapter("product_quantity")
fun setQuantity(textView: TextView, quantity: String) {
    val productQuantity: Int
    try {
        productQuantity = quantity.toInt()
        if (productQuantity < 10) {
            textView.text = "0".plus(productQuantity)
        } else {
            textView.text = productQuantity.toString()
        }
    } catch (e: Exception) {
        textView.text = quantity
    }
}

@BindingAdapter("reformatFloatPriceToInt")
fun setReformattedIntPrice(textView: TextView, price: Float) {
    try {
        if (price.isNaN() || price.isInfinite() || price.toString() == "0" || price.toString() == "0.0") {
            textView.visibility = View.INVISIBLE
        } else {
            if (price.toString().endsWith(".0") || price.toString().contains(".00"))
                textView.text =
                    textView.context.getString(R.string.rupee_symbol_with_space) + price.roundToInt()
                        .toString()
            else textView.text =
                textView.context.getString(R.string.rupee_symbol_with_space) + price.toString()
        }
    } catch (e: Exception) {
        textView.text = textView.context.getString(R.string.rupee_0)
    }
}

@BindingAdapter("reformatPromotionalDiscountInt")
fun setReformatPromotionalDiscountInt(textView: TextView, price: Float) {
    try {
        if (price.isNaN() || price.isInfinite()) {
            textView.text = textView.context.getString(R.string.rupee_0)
        } else {
            if (price.toString().endsWith(".0") || price.toString().contains(".00"))
                textView.text =
                    textView.context.getString(R.string.minus_rupee_symbol) + price.roundToInt()
                        .toString()
            else textView.text =
                textView.context.getString(R.string.minus_rupee_symbol) + price.toString()
        }
    } catch (e: Exception) {
        textView.text = textView.context.getString(R.string.rupee_0)
    }
}

@BindingAdapter(value = ["mrp_price", "sales_price"], requireAll = true)
fun calculateDiscount(
    textView: TextView, mrp_price: Float, sales_price: Float,
) {
    try {
        if (mrp_price.isNaN() || sales_price.isNaN()) {
            textView.visibility = View.INVISIBLE
        } else {
            val discount = ((mrp_price - sales_price) / mrp_price) * 100
            if (discount.isNaN() || discount.isInfinite()) {
                textView.visibility = View.INVISIBLE
            } else {
                if (discount.roundToInt() == 0) {
                    textView.visibility = View.GONE
                } else {
                    textView.visibility = View.VISIBLE
                    textView.text = discount.roundToInt()
                        .toString() + textView.context.getString(R.string.percent_off)
                }
            }
        }
    } catch (e: Exception) {
        textView.visibility = View.INVISIBLE
    }
}

@BindingAdapter(value = ["mrp_price", "sales_price", "contact_for_price"], requireAll = true)
fun contactForPrice(
    textView: TextView, mrp_price: Float, sales_price: Float, contact_for_price: Boolean,
) {
    try {
        if ((sales_price.toString() == "0" || sales_price.toString() == "0.0") && (mrp_price.toString() == "0" || mrp_price.toString() == "0.0")) {
            textView.text = textView.context.getString(R.string.contactforprice)
        }
    } catch (e: Exception) {
        textView.visibility = View.INVISIBLE
    }
}

@BindingAdapter(value = ["mrp_price_equal", "to_sales_price"], requireAll = true)
fun mrpPriceVisibility(
    textView: TextView, mrp_price: Float, sales_price: Float,
) {
    try {
        if (mrp_price == 0f) {
            textView.visibility = View.GONE
        } else if (mrp_price <= sales_price) {
            textView.visibility = View.GONE
        } else {
            textView.visibility = View.VISIBLE
            if (mrp_price.toString().endsWith(".0") || mrp_price.toString().contains(".00"))
                textView.text =
                    textView.context.getString(R.string.rupee_symbol_with_space) + mrp_price.roundToInt()
                        .toString()
            else textView.text =
                textView.context.getString(R.string.rupee_symbol_with_space) + mrp_price.toString()
        }
    } catch (e: Exception) {
        textView.visibility = View.GONE
    }
}

@BindingAdapter(value = ["sku_mrp_price", "sku_sales_price"], requireAll = true)
fun setPriceAndVisibility(
    textView: TextView, mrp_price: Double, sales_price: String? = null,
) {
    try {
        if (sales_price.isNullOrEmpty() && mrp_price == 0.0) {
            textView.visibility = View.INVISIBLE
        } else if (!sales_price.isNullOrEmpty() && sales_price.toFloat() > 0) {
            if (sales_price.toString().endsWith(".0") || sales_price.toString().contains(".00"))
                textView.text =
                    textView.context.getString(R.string.rupee_symbol_with_space) + sales_price.toFloat()
                        .roundToInt().toString()
            else textView.text =
                textView.context.getString(R.string.rupee_symbol_with_space) + sales_price.toString()
            textView.visibility = View.VISIBLE
        } else {
            if (mrp_price.toString().endsWith(".0") || mrp_price.toString().contains(".00"))
                textView.text =
                    textView.context.getString(R.string.rupee_symbol_with_space) + mrp_price.roundToInt()
                        .toString()
            else textView.text =
                textView.context.getString(R.string.rupee_symbol_with_space) + mrp_price.toString()
            textView.visibility = View.VISIBLE
        }
    } catch (e: Exception) {
        textView.visibility = View.INVISIBLE
    }


}


@BindingAdapter(value = ["salesPrice", "qtySelected"], requireAll = true)
fun calculateSalesPrice(
    textView: AppCompatTextView, salesprice: String?, qty: Int,
) {
    try {
        if (salesprice != null) {
            val floatPrice = salesprice.toFloat() * qty

            if (floatPrice.toString().endsWith(".0") || floatPrice.toString().contains(".00"))
                textView.text =
                    textView.context.getString(R.string.rupee_symbol_with_space) + floatPrice.roundToInt()
                        .toString()
            else textView.text =
                textView.context.getString(R.string.rupee_symbol_with_space) + floatPrice.toString()
        }
    } catch (e: Exception) {
        // do nothing
    }
}


@BindingAdapter(value = ["mrpPrice", "qtySelected"], requireAll = true)
fun calculateMRPPrice(
    textView: AppCompatTextView, mrpPrice: String?, qty: Int,
) {
    if (mrpPrice != null) {
        textView.visibility = View.VISIBLE

        val floatPrice = mrpPrice.toFloat() * qty
        if (floatPrice.toString().endsWith(".0") || floatPrice.toString().contains(".00"))
            textView.text =
                textView.context.getString(R.string.rupee_symbol_with_space) + floatPrice.roundToInt()
                    .toString()
        else textView.text =
            textView.context.getString(R.string.rupee_symbol_with_space) + floatPrice.toString()
    } else {
        textView.visibility = View.GONE
    }

}


@BindingAdapter("readTime")
fun setArticleReadTime(textView: TextView, readTime: String) {
    try {
        if (readTime.isNullOrEmpty()) {
            textView.text = ""
        } else {
            var formattedTime = readTime
            if (formattedTime.startsWith("0 minutes,")) formattedTime =
                formattedTime.replace("0 minutes,", "")
            formattedTime = formattedTime.replace("minutes", "Min")
            formattedTime = formattedTime.replace("seconds", "Sec")
            textView.text = formattedTime + textView.context.getString(R.string.article_read)
        }
    } catch (e: Exception) {
        textView.text = textView.context.getString(R.string.rupee_0)
    }
}

@BindingAdapter("bg_color")
fun setBackgroundColor(
    view: View, isCartViewShowing: Boolean,
) {
    if (isCartViewShowing) {
        view.setBackgroundColor(ContextCompat.getColor(view.context,
            android.R.color.transparent))
    } else {
        view.setBackgroundColor(ContextCompat.getColor(view.context,
            android.R.color.white))
    }
}

@BindingAdapter("farmDate")
fun farmDate(view: TextView, str: String?) {
    str?.let {
        val sb = SpannableStringBuilder(str)
        sb.setSpan(
            ForegroundColorSpan(Color.BLACK),
            str.indexOf(":") + 1,
            str.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        );
        sb.setSpan(
            StyleSpan(Typeface.BOLD),
            str.indexOf(":") + 1,
            str.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        );
        view.text = sb
    }
}



