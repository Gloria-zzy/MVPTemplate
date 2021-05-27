package com.example.mvptemplate.model

import com.example.mvptemplate.MVPContract

class MyModel: MVPContract.Model{

    private var DEFAULT_DATA = "default data"
    private var mData = ""

    override fun loadData(callback: MVPContract.ResultCallback<String>) {
        if (mData == "") {
            callback.onSuccess(DEFAULT_DATA)
        } else {
            callback.onSuccess(mData)
        }
    }

    override fun saveData(data: String, callback: MVPContract.ResultCallback<String>) {
        mData = data
        callback.onSuccess("save data success")
    }

}