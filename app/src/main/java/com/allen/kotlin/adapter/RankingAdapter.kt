package com.allen.kotlin.adapter

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.allen.kotlin.R
import com.allen.kotlin.adapter.RankingAdapter.MyViewHolder
import com.allen.kotlin.loadUrl
import com.ximalaya.ting.android.opensdk.model.ranks.RankList

class RankingAdapter(val context: Context?, private val ranks: RankList) : RecyclerView.Adapter<MyViewHolder>() {
    private var mListener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recommend_recyclerview_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ranks.rankList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rank = ranks.rankList[position]
        holder.imgIcon.loadUrl(rank.coverUrl)
        //为每个item设置点击事件；
        holder.itemView.setOnClickListener({
            mListener!!.onItemClick(it, position)
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public val imgIcon: ImageView = itemView.findViewById(R.id.recommend_item_icon)
        val imgPauseIcon: ImageView = itemView.findViewById(R.id.recommend_pause_icon)
        val txtTitle: ImageView = itemView.findViewById(R.id.recommend_item_title)
        val txtAlbumName: ImageView = itemView.findViewById(R.id.recommend_album_name)
        val txtLabel: ImageView = itemView.findViewById(R.id.recommend_label)
        val txtLength: ImageView = itemView.findViewById(R.id.recommend_length)
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    public fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }
}