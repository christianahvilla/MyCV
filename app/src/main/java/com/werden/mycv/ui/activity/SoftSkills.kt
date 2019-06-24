package com.werden.mycv.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.gson.Gson
import com.werden.mycv.R
import com.werden.mycv.models.Resume
import kotlinx.android.synthetic.main.activity_soft_skills.*

class SoftSkills : AppCompatActivity() {

    private var resume: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soft_skills)

        resume = intent.getStringExtra("resume")

        val softSkills:Resume  = Gson().fromJson(resume, Resume::class.java)

        soft_teamwork.text = softSkills.softSkills.teamWork
        soft_continuous.text = softSkills.softSkills.continuousLearning
        soft_open_minded.text = softSkills.softSkills.openMinded
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val intent = Intent(this@SoftSkills, Home::class.java)
                intent.putExtra("resume", resume)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@SoftSkills, Home::class.java)
        intent.putExtra("resume", resume)
        startActivity(intent)
        finish()
    }
}
