package com.abroliza.sidemenuusingactivityexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        btnInNavigationAct.setOnClickListener {
            val intent = Intent(NavigationActivity@this, SideMenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            //overridePendingTransition(R.anim.stay, R.anim.slide_in_from_left)
            startActivity(intent)


        }
    }
}