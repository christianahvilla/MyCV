package com.werden.mycv.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.gson.Gson
import com.werden.mycv.R
import com.werden.mycv.common.CommonFunctions
import com.werden.mycv.models.Resume
import kotlinx.android.synthetic.main.activity_skills.*
import kotlinx.android.synthetic.main.activity_soft_skills.*

class Skills : AppCompatActivity() {

    private var resume: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)

        resume = intent.getStringExtra("resume")

        val skills: Resume = Gson().fromJson(resume, Resume::class.java)

        skill_server.text = CommonFunctions().fillItems(skills.skills.serverConfiguration)
        skill_languages.text = CommonFunctions().fillItems(skills.skills.languagesPrograming)
        skill_databases.text = CommonFunctions().fillItems(skills.skills.dataBases)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val intent = Intent(this@Skills, Home::class.java)
                intent.putExtra("resume", resume)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@Skills, Home::class.java)
        intent.putExtra("resume", resume)
        startActivity(intent)
        finish()
    }
}
