package com.asysyifazahrasalsabila.buttonnavapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val items = intent.getParcelableExtra<Model>("extra_item")
        dtlName.text = items.name
        dtlDesc.text = items.desc
        dtlPhoto.setImageResource(items.photo)
    }
}
