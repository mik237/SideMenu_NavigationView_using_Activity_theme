package com.abroliza.sidemenuusingactivityexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abroliza.sidemenuusingactivityexample.sidemenu.MyAddress
import com.abroliza.sidemenuusingactivityexample.sidemenu.MyCart
import com.abroliza.sidemenuusingactivityexample.sidemenu.MyOrders
import com.abroliza.sidemenuusingactivityexample.sidemenu.MyPayments
import kotlinx.android.synthetic.main.activity_side_menu.*

class SideMenuActivity : AppCompatActivity() {
    var comingFrom = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.stay)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side_menu)
        ll_side_menu.setOnClickListener {
            onBackPressed()
        }

        tvOrders.setOnClickListener {
            if(comingFrom.equals("MyOrders")){
                onBackPressed()
            }else {
                val intent = Intent(this, MyOrders::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                startActivity(intent)
                //finish()
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
            }
        }

        tvAddress.setOnClickListener {
            val intent = Intent(this, MyAddress::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
        }

        tvCart.setOnClickListener {
            val intent = Intent(this, MyCart::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
        }

        tvPayments.setOnClickListener {
            val intent = Intent(this, MyPayments::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
        }

        tvHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
        }

        intent?.let {
            if (it.hasExtra("comingFrom"))
                comingFrom = it.getStringExtra("comingFrom")
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let {
            if (it.hasExtra("comingFrom"))
                comingFrom = it.getStringExtra("comingFrom")
        }
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.stay)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.stay, R.anim.slide_out_to_left)
    }
}