package com.allen.kotlin

import android.content.Context
import android.os.Handler
import android.os.Message
import android.support.v7.app.AlertDialog
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.getScreenWidth(): Int {
    val wm: WindowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val outMetrics = DisplayMetrics()
    wm.defaultDisplay.getMetrics(outMetrics)
    return outMetrics.widthPixels
}

fun Context.getScreenHeight(): Int {
    val wm: WindowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val outMetrics = DisplayMetrics()
    wm.defaultDisplay.getMetrics(outMetrics)
    return outMetrics.heightPixels
}

fun ImageView.loadUrl(url:String){

}

object LoadingDialog {
    var loading: AlertDialog? = null
    fun showLoading(context: Context) {
        if (null != loading) {
            if (loading!!.isShowing) {
                loading!!.dismiss()
            }
        } else {
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.loading_view, null)
            val builder = AlertDialog.Builder(context).setView(view)
            loading = builder.create()
        }
        loading!!.setCanceledOnTouchOutside(false)
        loading!!.show()
        //设置Dialog的宽高要在show()方法之后
        val screenWidth = context.getScreenWidth()
        val params = loading!!.window.attributes
        params.width = (screenWidth * 0.5f).toInt()
        params.height = (screenWidth * 0.4f).toInt()
        loading!!.window.attributes = params
    }


    fun dismissLoading() {
        if (null != loading && loading!!.isShowing) {
            loading!!.dismiss()
        }
    }
}
