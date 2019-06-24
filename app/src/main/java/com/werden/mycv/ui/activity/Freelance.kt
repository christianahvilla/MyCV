package com.werden.mycv.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.google.gson.Gson
import com.werden.mycv.R
import com.werden.mycv.adapters.AdapterFreelance
import com.werden.mycv.models.FreeLanceExperience
import com.werden.mycv.models.Resume
import kotlinx.android.synthetic.main.activity_freelance.*

class Freelance : AppCompatActivity() {

    private var resume: String = ""
    private lateinit var freelnacers: ArrayList<FreeLanceExperience>
    private var adapter: AdapterFreelance? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freelance)

        resume = intent.getStringExtra("resume")

        val freelance: Resume = Gson().fromJson(resume, Resume::class.java)

        freelnacers = freelance.freeLanceExperience

        setRecycler()

    }

    private fun setRecycler() {
        val lim = LinearLayoutManager(this)
        lim.orientation = LinearLayoutManager.VERTICAL
        recyclerFreelance.layoutManager = lim
        adapter = AdapterFreelance(freelnacers,this@Freelance)
        recyclerFreelance.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val intent = Intent(this@Freelance, Home::class.java)
                intent.putExtra("resume", resume)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@Freelance, Home::class.java)
        intent.putExtra("resume", resume)
        startActivity(intent)
        finish()
    }
}