package com.example.krisuvbohara_mapd711_optional_assignment.network

import com.example.krisuvbohara_mapd711_optional_assignment.models.Product
import com.example.krisuvbohara_mapd711_optional_assignment.models.ProductModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("products/category/laptops")
    fun fetchProducts() : Call<ProductModel>

    @GET("products/{id}")
    fun fetchSingleProduct(@Path(value = "id", encoded = false) key: Int ) : Call<Product>
}