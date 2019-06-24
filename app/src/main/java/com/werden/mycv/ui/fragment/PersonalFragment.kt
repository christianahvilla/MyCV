package com.werden.mycv.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson

import com.werden.mycv.R
import com.werden.mycv.models.Resume
import kotlinx.android.synthetic.main.fragment_personal.*
import kotlinx.android.synthetic.main.fragment_personal.view.*

class PersonalFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.fragment_personal, container, false)
        val resume: String = arguments?.get("resume") as String
        val information  = Gson().fromJson(resume, Resume::class.java)

        view.personal_name.text = information.information.personal.name
        view.personal_birthday.text = information.information.personal.birthday
        view.personal_nationality.text = information.information.personal.nationality

        return view
    }


}
