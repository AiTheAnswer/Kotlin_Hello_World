package com.allen.kotlin.fragment

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allen.kotlin.R
import com.allen.kotlin.adapter.RankingAdapter
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack
import com.ximalaya.ting.android.opensdk.model.ranks.RankList
import kotlinx.android.synthetic.main.fragment_recommend.view.*

class RecommendFragment : BaseFragment() {
    private var recyclerView: RecyclerView? = null
    private var mRankingAdapter: RankingAdapter? = null
    private var mActivity: Activity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mActivity = activity
        val view = inflater.inflate(R.layout.fragment_recommend, null)
        recyclerView = view.recycle_views
        return view
    }

    override fun lazyLoad() {
        val params = HashMap<String, String>()
        params[DTransferConstants.RANK_TYPE] = "1"

        CommonRequest.getRankList(params, object : IDataCallBack<RankList> {
            override fun onSuccess(rankList: RankList) {
                mRankingAdapter = RankingAdapter(activity, rankList)
                recyclerView?.adapter = mRankingAdapter

            }

            override fun onError(p0: Int, p1: String?) {
            }
        })
    }
}