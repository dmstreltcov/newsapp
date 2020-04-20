package com.streltsov.newsapp.ui.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.streltsov.newsapp.App
import com.streltsov.newsapp.R
import com.streltsov.newsapp.model.news.Article
import com.streltsov.newsapp.model.news.formatDate
import kotlinx.android.synthetic.main.layout_news_item.view.*
import javax.inject.Inject

class NewsAdapter() : RecyclerView.Adapter<NewsItem>() {

    private var list: List<Article> = ArrayList()
    private var width: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItem {

        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_news_item, parent, false)
//        val height: Float = parent.measuredWidth / 2f
//        val params: RecyclerView.LayoutParams =
//            view.layoutParams as RecyclerView.LayoutParams
//        params.height = height.roundToInt()
//        width = parent.measuredWidth
//        view.layoutParams = params
        return NewsItem(view)
    }

    fun setList(list: List<Article>) {
        this.list = list
    }


    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: NewsItem, position: Int) {
        holder.bind(list[position], width)
    }
}

class NewsItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        App.appComponent().inject(this)
    }

    @Inject
    lateinit var context: Context

    fun bind(article: Article, width: Int) {
        Glide.with(itemView)
            .load(article.urlToImage)
            .placeholder(R.drawable.progress_animation)
            .error(R.drawable.shape_empty)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(itemView.img_news)
        itemView.title_news.text = article.title
        if (!article.publishedAt.isNullOrEmpty()) {
            itemView.title_published.text = context.getString(
                R.string.title_publishedAt,
                article.formatDate(article.publishedAt)
            )
        }
    }
}
