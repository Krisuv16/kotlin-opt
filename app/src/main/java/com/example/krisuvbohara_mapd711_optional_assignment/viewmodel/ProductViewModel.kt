package com.example.krisuvbohara_mapd711_optional_assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krisuvbohara_mapd711_optional_assignment.models.Product
import com.example.krisuvbohara_mapd711_optional_assignment.models.ProductModel
import com.example.krisuvbohara_mapd711_optional_assignment.network.ApiInterface
import com.example.krisuvbohara_mapd711_optional_assignment.network.Config
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {
    val product = MutableLiveData<ProductModel>()
    val productDetail = MutableLiveData<Product>()

    fun fetchProducts(){
        val config = Config.getRetroFitInstance().create(ApiInterface:: class.java)
        config.fetchProducts().enqueue(object : Callback<ProductModel>{
            override fun onResponse(call: Call<ProductModel>, response: Response<ProductModel>) {
                product.value =  response.body()
            }
            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                println(t)
            }
        })
    }

    fun fetchSingleProduct(id : Int){
        val config = Config.getRetroFitInstance().create(ApiInterface:: class.java)
        config.fetchSingleProduct(id).enqueue(object : Callback<Product>{
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                productDetail.value = response.body()
            }
            override fun onFailure(call: Call<Product>, t: Throwable) {
                println(t)
            }

        })
    }
}