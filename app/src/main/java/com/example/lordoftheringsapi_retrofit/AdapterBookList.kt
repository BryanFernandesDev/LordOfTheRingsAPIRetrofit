package com.example.lordoftheringsapi_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lordoftheringsapi_retrofit.databinding.ItemListBookNameBinding

class AdapterBookList(private val listBook: List<Doc>, private val inflater: LayoutInflater) :
    RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(ItemListBookNameBinding.inflate(inflater,parent,false).root)

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(listBook[position].name)
    }

    override fun getItemCount() = listBook.size


}

//xml do item
class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemListBookNameBinding.bind(itemView)

    fun bind(book_name: String) {
        binding.listBookNameItem.text = book_name
    }

}