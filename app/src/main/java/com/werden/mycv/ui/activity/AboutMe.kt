package com.werden.mycv.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.gson.Gson
import com.werden.mycv.R
import com.werden.mycv.models.Resume
import kotlinx.android.synthetic.main.activity_about_me.*

class AboutMe: AppCompatActivity() {

    private var resume: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        resume = intent.getStringExtra("resume")

        val aboutMe  = Gson().fromJson(resume, Resume::class.java)

        text_about_me.text = aboutMe.aboutMe[0] + "\n\n\n\n" + aboutMe.aboutMe[1]
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val intent = Intent(this@AboutMe, Home::class.java)
                intent.putExtra("resume", resume)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@AboutMe, Home::class.java)
        intent.putExtra("resume", resume)
        startActivity(intent)
        finish()
    }

}
