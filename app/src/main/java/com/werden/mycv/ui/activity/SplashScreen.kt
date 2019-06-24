package com.werden.mycv.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.werden.mycv.R
import com.werden.mycv.api.Controller
import com.werden.mycv.api.ServiceVolley
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {


    private val serviceVolley = ServiceVolley()
    private val controller = Controller(serviceVolley)
    private val mHandler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val ani = AnimationUtils.loadAnimation(this, R.anim.splashanimation)
        splashIcon.startAnimation(ani)
        splashText.startAnimation(ani)

        controller.get(this.resources.getString(R.string.cv)) { response ->
            val monitor = Runnable {
                mHandler.postDelayed(startHome(response.toString()),2000)
            }
            monitor.run()
        }
    }

    private fun startHome(response: String): Runnable {
        return Runnable {
            val intent = Intent(this@SplashScreen, Home::class.java)
            intent.putExtra("resume", response)
            startActivity(intent)
            finish()
        }
    }
}
