package com.werden.mycv.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.google.gson.Gson
import com.werden.mycv.R
import com.werden.mycv.adapters.AdapterWork
import com.werden.mycv.models.Resume
import com.werden.mycv.models.WorkExperience
import kotlinx.android.synthetic.main.activity_work.*

class Work : AppCompatActivity() {

    private var resume: String = ""
    private lateinit var works: ArrayList<WorkExperience>
    private var adapter: AdapterWork? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        resume = intent.getStringExtra("resume")

        val work: Resume = Gson().fromJson(resume, Resume::class.java)

        works = work.workExperience

        setRecycler()

    }

    private fun setRecycler() {
        val lim = LinearLayoutManager(this)
        lim.orientation = LinearLayoutManager.VERTICAL
        recyclerWork.layoutManager = lim
        adapter = AdapterWork(works,this@Work)
        recyclerWork.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val intent = Intent(this@Work, Home::class.java)
                intent.putExtra("resume", resume)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@Work, Home::class.java)
        intent.putExtra("resume", resume)
        startActivity(intent)
        finish()
    }
}