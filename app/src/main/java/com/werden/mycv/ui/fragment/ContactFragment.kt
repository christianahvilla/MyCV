package com.werden.mycv.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson

import com.werden.mycv.R
import com.werden.mycv.models.Resume
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.fragment_contact.view.*
import kotlinx.android.synthetic.main.fragment_personal.*

class ContactFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        val resume: String = arguments?.get("resume") as String
        val information  = Gson().fromJson(resume, Resume::class.java)

        view.contact_email.text = information.information.contact.email
        view.contact_cellphone.text = information.information.contact.mobile
        view.contact_linkedin.text = information.information.contact.linkedIn

        return view
    }


}
