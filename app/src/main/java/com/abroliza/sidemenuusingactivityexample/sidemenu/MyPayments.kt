package com.abroliza.sidemenuusingactivityexample.sidemenu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abroliza.sidemenuusingactivityexample.R
import com.abroliza.sidemenuusingactivityexample.SideMenuActivity
import kotlinx.android.synthetic.main.activity_from_side_menu.*

class MyPayments : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_side_menu)
        tvLabel.text = "My Payments Screen"

        toolbar.setNavigationOnClickListener {
            val intent = Intent(MainActivity@this, SideMenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.stay, R.anim.slide_out_to_right)
    }
}