package com.werden.mycv.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.werden.mycv.R
import com.werden.mycv.adapters.ViewerPagerAdapter
import kotlinx.android.synthetic.main.activity_information.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class Information : AppCompatActivity() {

    private var resume: String = ""
    private lateinit var adapter: ViewerPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        resume = intent.getStringExtra("resume")

        setSupportActionBar(toolBar)

        adapter = ViewerPagerAdapter(supportFragmentManager, resume)
        view_pager.adapter = adapter

        tab_layout.setupWithViewPager(view_pager)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val intent = Intent(this@Information, Home::class.java)
                intent.putExtra("resume", resume)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@Information, Home::class.java)
        intent.putExtra("resume", resume)
        startActivity(intent)
        finish()
    }

}
