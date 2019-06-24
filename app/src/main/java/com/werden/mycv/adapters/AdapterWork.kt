package com.werden.mycv.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.werden.mycv.R
import com.werden.mycv.common.CommonFunctions
import com.werden.mycv.models.WorkExperience


class AdapterWork(private var works: ArrayList<WorkExperience>, private val context: Context):  RecyclerView.Adapter<ViewHolderWork>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderWork {
        return ViewHolderWork(
            LayoutInflater.from(context).inflate(
                R.layout.card_work,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return works.size
    }

    override fun onBindViewHolder(holder: ViewHolderWork, position: Int) {
        holder.company.text = works[position].company
        holder.project.text = works[position].project
        holder.period.text = works[position].period
        holder.description.text = works[position].description
        holder.activities.text = CommonFunctions().fillItems(works[position].activities)
    }

}

class ViewHolderWork (view: View): RecyclerView.ViewHolder(view){
    val company: TextView = view.findViewById(R.id.work_company)
    val project: TextView = view.findViewById(R.id.work_project)
    val period: TextView = view.findViewById(R.id.work_period)
    val description: TextView = view.findViewById(R.id.work_description)
    val activities: TextView = view.findViewById(R.id.work_activities)
}