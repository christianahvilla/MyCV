package com.werden.mycv.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.google.gson.Gson
import com.werden.mycv.R
import com.werden.mycv.adapters.AdapterSchool
import com.werden.mycv.models.Education
import com.werden.mycv.models.Resume
import kotlinx.android.synthetic.main.activity_education.*

class Education : AppCompatActivity() {

    private var resume: String = ""
    private lateinit var schools: ArrayList<Education>
    private var adapter: AdapterSchool? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)

        resume = intent.getStringExtra("resume")

        val education: Resume = Gson().fromJson(resume, Resume::class.java)

        schools = education.education

        setRecycler()
    }

    private fun setRecycler() {
        val lim = LinearLayoutManager(this)
        lim.orientation = LinearLayoutManager.VERTICAL
        recyclerSchool.layoutManager = lim
        adapter = AdapterSchool(schools,this@Education)
        recyclerSchool.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val intent = Intent(this@Education, Home::class.java)
                intent.putExtra("resume", resume)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@Education, Home::class.java)
        intent.putExtra("resume", resume)
        startActivity(intent)
        finish()
    }
}
