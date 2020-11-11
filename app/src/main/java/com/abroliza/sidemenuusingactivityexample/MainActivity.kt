package com.abroliza.sidemenuusingactivityexample

import android.R.attr.duration
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.setNavigationOnClickListener {
            val intent = Intent(MainActivity@this, SideMenuActivity::class.java)
            startActivity(intent)
        }

        header.setOnClickListener {
            if(expandable.visibility == View.GONE){
                expand()
            }
            else{
                collapse()
            }
        }
    }

    private fun expand() {
        expandable.visibility = View.VISIBLE
        /*expandable.visibility = View.VISIBLE
        val widthSpec = View.MeasureSpec.makeMeasureSpec(
            0,
            View.MeasureSpec.EXACTLY
        )
        val heightSpec = View.MeasureSpec.makeMeasureSpec(
            0,
            View.MeasureSpec.EXACTLY
        )
        expandable.measure(widthSpec, heightSpec)

        val mAnimator: ValueAnimator? = slideAnimator(0, expandable.getMeasuredHeight())
        mAnimator?.start()*/

        /*val anim =
            ValueAnimator.ofInt(expandable.getMeasuredHeight(), 100)
        anim.addUpdateListener { valueAnimator ->
            val `val` = valueAnimator.animatedValue as Int
            val layoutParams: ViewGroup.LayoutParams = expandable.getLayoutParams()
            layoutParams.height = `val`
            expandable.setLayoutParams(layoutParams)
        }
        anim.duration = 1000
        anim.start()*/

        /*val resizeAnimation = ResizeAnimation(
            expandable,
            150,
            0
        )
        resizeAnimation.duration = 1000
        expandable.startAnimation(resizeAnimation)*/
    }

    private fun collapse() {
        expandable.visibility = View.GONE
    }

    private fun slideAnimator(start: Int, end: Int): ValueAnimator? {
        val animator = ValueAnimator.ofInt(start, end)
        animator.addUpdateListener { valueAnimator ->
            //Update Height
            val value = valueAnimator.animatedValue as Int
            val layoutParams: ViewGroup.LayoutParams = expandable.getLayoutParams()
            layoutParams.height = value
            expandable.setLayoutParams(layoutParams)
        }
        return animator
    }
}
