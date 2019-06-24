package com.werden.mycv.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.werden.mycv.R
import com.werden.mycv.common.CommonFunctions
import com.werden.mycv.models.FreeLanceExperience


class AdapterFreelance(private var freelancers: ArrayList<FreeLanceExperience>, private val context: Context):  RecyclerView.Adapter<ViewHolderFreelance>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFreelance {
        return ViewHolderFreelance(
            LayoutInflater.from(context).inflate(
                R.layout.card_freelance,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return freelancers.size
    }

    override fun onBindViewHolder(holder: ViewHolderFreelance, position: Int) {
        holder.project.text = freelancers[position].project
        holder.period.text = freelancers[position].period
        holder.description.text = freelancers[position].description
        holder.activities.text = CommonFunctions().fillItems(freelancers[position].activities)
    }

}

class ViewHolderFreelance (view: View): RecyclerView.ViewHolder(view){
    val project: TextView = view.findViewById(R.id.freelance_project)
    val period: TextView = view.findViewById(R.id.freelance_period)
    val description: TextView = view.findViewById(R.id.freelance_description)
    val activities: TextView = view.findViewById(R.id.freelance_description)
}