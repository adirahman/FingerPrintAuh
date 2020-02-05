package com.arc.a2020_fingerprintauth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SuccessActivity : AppCompatActivity() {

    companion object{
        fun startThisActivity(ctx: Context){
            val intent = Intent(ctx,SuccessActivity::class.java)
            ctx.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
    }
}
