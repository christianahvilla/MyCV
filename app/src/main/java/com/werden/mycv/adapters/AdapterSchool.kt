package com.werden.mycv.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.werden.mycv.R
import com.werden.mycv.models.Education


class AdapterSchool(private var schools: ArrayList<Education>, private val context: Context):  RecyclerView.Adapter<ViewHolderSchool>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSchool {
        return ViewHolderSchool(
            LayoutInflater.from(context).inflate(
                R.layout.card_education,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return schools.size
    }

    override fun onBindViewHolder(holder: ViewHolderSchool, position: Int) {
        holder.name.text = schools[position].name
        holder.period.text = schools[position].period
        holder.career.text = schools[position].career
        holder.grade.text = schools[position].grade
    }

}

class ViewHolderSchool (view: View): RecyclerView.ViewHolder(view){
    val name: TextView = view.findViewById(R.id.school_name)
    val period: TextView = view.findViewById(R.id.school_period)
    val career: TextView = view.findViewById(R.id.school_career)
    val grade: TextView = view.findViewById(R.id.school_grade)
}