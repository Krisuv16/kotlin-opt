package com.example.krisuvbohara_mapd711_optional_assignment.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.krisuvbohara_mapd711_optional_assignment.R
import com.example.krisuvbohara_mapd711_optional_assignment.viewmodel.ProductViewModel
import com.squareup.picasso.Picasso


class DetailsActivity : AppCompatActivity() {
    private lateinit var productViewModel : ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val intent = intent
        val id=intent.getIntExtra("id", 0)
        val titleText=intent.getStringExtra("title")
//        val brandText=intent.getStringExtra("brand")
//        val ratingText=intent.getDoubleExtra("rating", 0.0)
//        val descText=intent.getStringExtra("desc")
//        val firstImage=intent.getStringExtra("image")

        val image = findViewById<View>(R.id.detailImage) as ImageView
        val title = findViewById<View>(R.id.detailTitle) as TextView
        val brand = findViewById<View>(R.id.detailBrand) as TextView
        val rating = findViewById<View>(R.id.detailRating) as TextView
        val desc = findViewById<View>(R.id.detailDesc) as TextView

//        title.text = titleText
//        brand.text = brandText
//        rating.text = ratingText.toString() + " ★"
//        desc.text = descText
//        Picasso.get().load(firstImage).into(image);

        callingViewModel(id,title,brand,rating,desc,image)
        setTitle(titleText)
    }

    private fun callingViewModel(id: Int, title : TextView,  brand : TextView,  rating : TextView,  desc : TextView, image : ImageView ){
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        productViewModel.fetchSingleProduct(id)
        productViewModel.productDetail.observe(this, Observer {
            title.text = it.title
            brand.text = "Brand:   " + it.brand
            rating.text = it.rating.toString() + " ★"
            desc.text = "Description:\n" +it.description
            Picasso.get().load(it.images[0]).into(image);
        })
    }
}