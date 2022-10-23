package com.example.lordoftheringsapi_retrofit

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainMenu : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

       val mainItems = mutableListOf<MainItem>()
        mainItems.add(

            MainItem(
                id = 1,
                drawbleId = R.drawable.one_ring_menu_item,
                textStringId = R.string.book_list_menu_string,
                color = Color.BLACK
            )
        )
        mainItems.add(

            MainItem(
                id = 2,
                drawbleId = R.drawable.one_ring_menu_item,
                textStringId = R.string.characters_list_menu_string,
                        color = Color.BLACK
            )
        )
        mainItems.add(

            MainItem(
                id = 3,
                drawbleId = R.drawable.one_ring_menu_item,
                textStringId = R.string.chapters_list_menu_string,
                        color = Color.BLACK
            )
        )

        val adapter = MainAdapter(mainItems) { id ->

            when(id){
                1 ->{
                    val intent = Intent(this@MainMenu,BookListActivity::class.java)
                    Toast.makeText(this, "Clicado", Toast.LENGTH_LONG).show()
                }

        }
          }


        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = GridLayoutManager(this, 3)


    }


        private inner class MainAdapter(

            private val mainItems: List<MainItem>,
            private val onItemClickListener: (Int) -> Unit): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

                //xml que será inserido na RV
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder{
                    val view = layoutInflater.inflate(R.layout.item_menu_layout, parent, false)
                    return MainViewHolder(view)
                }

            //metodo de rolagem na tela
            override fun onBindViewHolder(holder: MainViewHolder, position: Int){

                val itemCurrent = mainItems[position]
                holder.bind(itemCurrent)

            }

            override fun getItemCount(): Int{
                return mainItems.size
            }

            private inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
                lateinit var item: MainItem
                fun bind(item: MainItem){
                    this.item = item
                    val img: ImageView = itemView.findViewById(R.id.item_img_icon)
                    val name: TextView = itemView.findViewById(R.id.item_txt_name)
                    val container: LinearLayout = itemView.findViewById(R.id.item_container)

                    img.setImageResource(item.drawbleId)
                    name.setText(item.textStringId)
                    container.setBackgroundColor(item.color)

                }

                override fun onClick(p0: View?) {
                    onItemClickListener(item.id)
                }
            }



            }




}