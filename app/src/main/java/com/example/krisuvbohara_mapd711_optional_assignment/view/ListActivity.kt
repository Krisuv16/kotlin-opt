package com.example.krisuvbohara_mapd711_optional_assignment.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.krisuvbohara_mapd711_optional_assignment.R
import com.example.krisuvbohara_mapd711_optional_assignment.models.ProductModel
import com.example.krisuvbohara_mapd711_optional_assignment.view.adapter.ProductAdapter
import com.example.krisuvbohara_mapd711_optional_assignment.viewmodel.ProductViewModel

class ListActivity : AppCompatActivity() {
    private lateinit var productViewModel : ProductViewModel
    private var recyclerView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)
        recyclerView = findViewById<View>(R.id.productListView) as RecyclerView
        callingViewModel()
        title = "Laptops"
    }
    private fun callingViewModel(){
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        productViewModel.fetchProducts()
        productViewModel.product.observe(this, Observer {
            initAdapter(it)
        })
    }

    private fun initAdapter(data: ProductModel ){
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val adapter = ProductAdapter(data)
        recyclerView!!.adapter = adapter
    }
}