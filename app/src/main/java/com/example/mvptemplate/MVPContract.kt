package com.example.mvptemplate

import android.content.Context

interface MVPContract {

    interface View {

        fun loadDataReady(data: String)
        fun saveDataReady()

    }

    interface Model {

        fun loadData(callback: ResultCallback<String>)
        fun saveData(data: String, callback: ResultCallback<String>)

    }

    abstract class Presenter<M, V>(private val model: Model, private val view: View) {

        fun getModel(): Model {
            return model
        }

        fun getView(): View {
            return view
        }

        abstract fun loadData()
        abstract fun saveData(data: String)

    }

    interface ResultCallback<T>{

        fun onSuccess(result: T)
        fun onFail()

    }

}