package com.allen.kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.allen.kotlin.LoadingDialog
import com.allen.kotlin.LoadingDialog.showLoading
import com.allen.kotlin.R
import com.allen.kotlin.showToast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), View.OnClickListener {
    private lateinit var mBtnLogin: Button
    private lateinit var mEdtUserName: EditText
    private lateinit var mEdtPwd: EditText
    private var handler = MyHandler()
    private var activity = this

    inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message?) {
            if (msg!!.what == 1) {
                LoadingDialog.dismissLoading()
                startActivity(Intent(activity, MainActivity::class.java))
            } else if (msg!!.what == 0) {
                LoadingDialog.dismissLoading()
                showToast(getString(R.string.user_name_or_pwd_error))
                mEdtUserName.text.clear()
                mEdtPwd.text.clear()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        initListener()
    }

    private fun initView() {
        mBtnLogin = findViewById(R.id.btn_login)
        mEdtUserName = findViewById(R.id.edt_user_name)
        mEdtPwd = findViewById(R.id.edt_pwd)
    }

    private fun initListener() {
        mBtnLogin.setOnClickListener(this)
        txt_forgot_pwd.setOnClickListener(this)
    }

    private fun doLogin() {
        val userName = mEdtUserName.text.toString()
        val pwd = mEdtPwd.text.toString()
        if (userName.isEmpty()) {//验证用户是否为空
            this.showToast(getString(R.string.user_name_is_null_or_empty))
            return
        }
        if (pwd.isEmpty()) {//验证密码是否为空
            this.showToast(getString(R.string.pwd_is_null_or_empty))
            return
        }
        showLoading(this)
        Thread {
            Thread.sleep(2000)
            if (userName == "admin" && pwd == "123456") {
                handler.sendEmptyMessage(1)
            } else {
                handler.sendEmptyMessage(0)
            }
        }.start()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_login -> doLogin()
            txt_forgot_pwd.id -> showToast(getString(R.string.no_such_function))
            else -> showToast(getString(R.string.click_event_not_processed))
        }
    }
}
