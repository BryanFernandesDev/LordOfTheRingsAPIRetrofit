package com.example.lordoftheringsapi_retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lordoftheringsapi_retrofit.databinding.BookListActivityDesignBinding
import retrofit2.Response

class BookListActivity : AppCompatActivity() {

    private lateinit var binding: BookListActivityDesignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BookListActivityDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getData()

    }

    fun getData() {

        val retrofitClient = NetworkUtil.getRetrofitInstance("https://the-one-api.dev/v2/")

        val endpoint = retrofitClient.create(Endpoint::class.java)

        val callback = endpoint.getPosts()

        callback.enqueue(object : retrofit2.Callback<Posts> {
            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            open override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                val booksList = response.body()?.docs ?: listOf()

                val adapterBook = AdapterBookList(booksList,layoutInflater)
                val  managerLayout = LinearLayoutManager(this@BookListActivity, LinearLayoutManager.VERTICAL,false)

                binding.listBookNameRv.apply {
                    adapter = adapterBook
                    layoutManager = managerLayout
                }


            }


        })


    }

}

