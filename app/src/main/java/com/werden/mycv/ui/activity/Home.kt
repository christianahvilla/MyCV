package com.werden.mycv.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.werden.mycv.R

import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_about_me.*
import kotlinx.android.synthetic.main.content_education.*
import kotlinx.android.synthetic.main.content_freelance_experience.*
import kotlinx.android.synthetic.main.content_information.*
import kotlinx.android.synthetic.main.content_skills.*
import kotlinx.android.synthetic.main.content_soft_skills.*
import kotlinx.android.synthetic.main.content_work_experience.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        about_card.setOnClickListener{
            startAnotherActivity(1)
        }

        information_card.setOnClickListener{
            startAnotherActivity(2)
        }

        soft_card.setOnClickListener{
            startAnotherActivity(3)
        }

        skills_card.setOnClickListener{
            startAnotherActivity(4)
        }

        education_card.setOnClickListener{
            startAnotherActivity(5)
        }

        work_card.setOnClickListener{
            startAnotherActivity(6)
        }

        free_card.setOnClickListener{
            startAnotherActivity(7)
        }

    }


    private fun startAnotherActivity(option: Int){
        val resume: String = intent.getStringExtra("resume")
        var intent: Intent = Intent()
        when(option){
            1 -> {
                intent = Intent(this@Home, AboutMe::class.java)
            }
            2 -> {
                intent = Intent(this@Home, Information::class.java)
            }
            3 -> {
                intent = Intent(this@Home, SoftSkills::class.java)
            }
            4 -> {
                intent = Intent(this@Home, Skills::class.java)
            }
            5 -> {
                intent = Intent(this@Home, Education::class.java)
            }
            6 -> {
                intent = Intent(this@Home, Work::class.java)
            }
            7 -> {
                intent = Intent(this@Home, Freelance::class.java)
            }
        }
        intent.putExtra("resume", resume)
        startActivity(intent)
        finish()

    }

}
