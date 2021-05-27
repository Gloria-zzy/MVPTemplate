package com.example.mvptemplate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mvptemplate.MVPContract
import com.example.mvptemplate.R
import com.example.mvptemplate.model.MyModel
import com.example.mvptemplate.presenter.MyPresenter

class MainActivity : AppCompatActivity(), MVPContract.View {

    private val mEtInput: EditText by lazy {
        findViewById<EditText>(R.id.et_input)
    }

    private val mTvContent: TextView by lazy {
        findViewById<TextView>(R.id.tv_content)
    }

    private val mBtSave: Button by lazy {
        findViewById<Button>(R.id.bt_save)
    }

    private val mPresenter = MyPresenter(MyModel(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.loadData()
        mBtSave.setOnClickListener { mPresenter.saveData(mEtInput.text.toString()) }
    }

    override fun loadDataReady(data: String) {
        mTvContent.text = data
    }

    override fun saveDataReady() {
        mPresenter.loadData()
    }
}