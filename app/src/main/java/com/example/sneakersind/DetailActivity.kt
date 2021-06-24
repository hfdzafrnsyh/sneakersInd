package com.example.sneakersind

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.sneakersind.`class`.Shoes
import org.w3c.dom.Text


class DetailActivity : AppCompatActivity() , View.OnClickListener  {


    companion object {

        val EXTRA_NAME = "extra_name"
        val EXTRA_PRICE = "extra_price"
        val EXTRA_DETAIL = "extra_detail"
        val EXTRA_IMAGE = "extra_image"
        val EXTRA_COLOR = "extra_color"


    }


    lateinit var btnBuy : Button
    lateinit var btnShare: Button
    lateinit var tvName: TextView
    lateinit var tvPrice: TextView
    lateinit var tvDetail: TextView
    lateinit var tvColor : TextView
    lateinit var imgShoes: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.title = "Detail"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        /* parsing data */

        tvName = findViewById(R.id.tv_name)
        tvPrice = findViewById(R.id.tv_price)
        tvDetail = findViewById(R.id.tv_detail)
        imgShoes = findViewById(R.id.img_item_shoes)
        tvColor = findViewById(R.id.tv_warna)

        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)
        val price = intent.getDoubleExtra(EXTRA_PRICE, 0.0)
        val color = intent.getStringExtra(EXTRA_COLOR)

        tvPrice.setText(price.toString())
        tvDetail.setText(detail)
        tvColor.setText(color)
        tvName.setText(name)
        imgShoes.setImageResource(image)



        /*   Action   button   */

        btnBuy  = findViewById(R.id.btn_buy)
        btnShare  = findViewById(R.id.btn_share)

        btnBuy.setOnClickListener{
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Pembayaran")
            val view = layoutInflater.inflate(R.layout.popup_dialog, null)
            val pay : EditText = view.findViewById(R.id.et_pay)
            alert.setView(view)
            alert.setPositiveButton("Kirim", DialogInterface.OnClickListener() { _, _ ->


                if (pay.text.toString().isEmpty()) {
                    val dialog = AlertDialog.Builder(this)
                    val viewDialog = layoutInflater.inflate(R.layout.alert_dialog_empty, null)
                    dialog.setView(viewDialog)
                    dialog.show()

                }else if(pay.text.toString().toDouble() > price ) {
                    val dialog = AlertDialog.Builder(this)
                    val viewDialog = layoutInflater.inflate(R.layout.alert_dialog_succes, null)
                    dialog.setView(viewDialog)
                    dialog.show()
                }else if(pay.text.toString().toDouble() != price){
                    val dialog = AlertDialog.Builder(this)
                    val viewDialog = layoutInflater.inflate(R.layout.alert_dialog_mines, null)
                    dialog.setView(viewDialog)
                    dialog.show()
                }else{
                    val dialog = AlertDialog.Builder(this)
                    val viewDialog = layoutInflater.inflate(R.layout.alert_dialog_success2, null)
                    dialog.setView(viewDialog)
                    dialog.show()
                }

            })

            alert.show()
        }




        btnShare.setOnClickListener(this)



    }

    override fun onClick(view: View?) {
        when (view) {
            btnShare -> {
                val share = "$tvName , $imgShoes"
                val subject = "New Sneakers Original"
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_SUBJECT , subject)
                intent.putExtra(Intent.EXTRA_TEXT , share)
                startActivity(Intent.createChooser(intent ,"Share To :"))

            }
        }

    }









}


