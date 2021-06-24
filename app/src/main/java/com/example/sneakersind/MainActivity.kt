package com.example.sneakersind

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sneakersind.`class`.Shoes
import com.example.sneakersind.`object`.ShoesData
import com.example.sneakersind.adapter.ShoesListAdapter

class MainActivity : AppCompatActivity()  {

    private  lateinit var rvShoes : RecyclerView
    private val listShoes : ArrayList<Shoes> = arrayListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvShoes = findViewById(R.id.rv_shoes)
        rvShoes.setHasFixedSize(true)

        listShoes.addAll(ShoesData.listData)
        showShoesRecyclerList()

      //        Profile ///

        val btnProfile : Button = findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener{
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }

    }






    private fun showShoesRecyclerList() {
        rvShoes.layoutManager= LinearLayoutManager(this)
        val listShoesAdapter = ShoesListAdapter(listShoes)
        rvShoes.adapter = listShoesAdapter

        listShoesAdapter.setOnClickCallBack(object : ShoesListAdapter.OnItemClickCallBack {
            override fun onItemCliked(data: Shoes) {
                showSelectedItem(data)
            }
        })
    }


    private fun showSelectedItem(shoesdata : Shoes)
    {
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_NAME , shoesdata.name )
        intent.putExtra(DetailActivity.EXTRA_PRICE , shoesdata.price )
        intent.putExtra(DetailActivity.EXTRA_DETAIL , shoesdata.detail )
        intent.putExtra(DetailActivity.EXTRA_IMAGE,shoesdata.image)
        intent.putExtra(DetailActivity.EXTRA_COLOR ,shoesdata.color)
        startActivity(intent)
    }




}