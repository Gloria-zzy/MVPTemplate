package com.example.mvptemplate.presenter

import com.example.mvptemplate.MVPContract
import com.example.mvptemplate.model.MyModel
import com.example.mvptemplate.view.MainActivity

class MyPresenter(model: MyModel, view: MainActivity) : MVPContract.Presenter<MVPContract.Model, MVPContract.View>(
    model, view
) {

    override fun loadData() {
        getModel().loadData(object : MVPContract.ResultCallback<String>{
            override fun onSuccess(result: String) {
                if (getView() != null) {
                    getView().loadDataReady(result)
                }
            }

            override fun onFail() {
                if (getView() != null) {
                    // TODO: 2021/5/27
                }
            }

        })
    }

    override fun saveData(data: String) {
        getModel().saveData(data, object : MVPContract.ResultCallback<String>{
            override fun onSuccess(result: String) {
                if (getView() != null) {
                    getView().saveDataReady()
                }
            }

            override fun onFail() {
                if (getView() != null) {
                    // TODO: 2021/5/27
                }
            }

        })
    }

}