package com.example.krisuvbohara_mapd711_optional_assignment.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.krisuvbohara_mapd711_optional_assignment.R
import com.example.krisuvbohara_mapd711_optional_assignment.models.ProductModel
import com.example.krisuvbohara_mapd711_optional_assignment.view.DetailsActivity
import com.squareup.picasso.Picasso


class ProductAdapter (private val product: ProductModel) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var context: Context? = null

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.productTitle)
        val rating : TextView = itemView.findViewById(R.id.productRating)
        val brand : TextView = itemView.findViewById(R.id.productBrand)
        val description : TextView = itemView.findViewById(R.id.productDescription)
        val imageView : ImageView = itemView.findViewById(R.id.productImage)
        val button : AppCompatButton = itemView.findViewById(R.id.itemButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val productView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_card, parent, false)
        context = parent.context
        return  ViewHolder(productView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = product.products[position].title
        holder.rating.text = product.products[position].rating.toString() + " ★"
        holder.brand.text = product.products[position].brand
        holder.description.text = product.products[position].description
        Picasso.get().load(product.products[position].images[0]).into(holder.imageView);
        holder.button.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("title",product.products[position].title)
            intent.putExtra("id",product.products[position].id)
//            intent.putExtra("brand",product.products[position].brand)
//            intent.putExtra("rating",product.products[position].rating)
//            intent.putExtra("desc",product.products[position].description)
//            intent.putExtra("image",product.products[position].images[0])
            context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return product.products.size
    }
}