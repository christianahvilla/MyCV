package com.werden.mycv.adapters

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.werden.mycv.ui.fragment.ContactFragment
import com.werden.mycv.ui.fragment.PersonalFragment

class ViewerPagerAdapter constructor(fm: FragmentManager, resume: String): FragmentPagerAdapter(fm){

    private val resume = resume

    override fun getItem( position: Int): Fragment {
        val bundle = Bundle()
        bundle.putString("resume", resume)
        return when(position){
            0 -> {
                var personalFragment: PersonalFragment = PersonalFragment()
                personalFragment.arguments = bundle
                personalFragment
            }
            1 -> {
                var contactFragment: ContactFragment = ContactFragment()
                contactFragment.arguments = bundle
                contactFragment
            }
            else -> {
                var personalFragment: PersonalFragment = PersonalFragment()
                personalFragment.arguments = bundle
                personalFragment
            }
        }
    }

    override fun getCount(): Int {
        return  2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> {
                "Personal"
            }
            1 -> {
                "Contact"
            }
            else -> {
                ""
            }
        }
    }
}