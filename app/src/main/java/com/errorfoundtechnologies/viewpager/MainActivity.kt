package com.errorfoundtechnologies.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //calling function
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        vp1.adapter = mSectionsPagerAdapter

        tablayout.setupWithViewPager(vp1) //for linking viewpager to tab_layout

    }
//adapter starts
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 3 total pages.

            return 3
        }

        override fun getPageTitle(position: Int): CharSequence {
         return when (position) {
                0 -> "All"
                1 -> "New"
                else -> {
                return "Near you"
            }}}

    } //adapter closes


    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {

             var rootView=view
            if (arguments?.getInt(ARG_SECTION_NUMBER)== 1 ) {
                rootView = inflater.inflate(R.layout.fragment_one, vp1, false)
                //rootView.section_label.text = getString(R.string.section_format, arguments?.getInt(ARG_SECTION_NUMBER))
                return rootView

            }
            else {
                if (arguments?.getInt(ARG_SECTION_NUMBER)== 2){
                    rootView = inflater.inflate(R.layout.fragment_two, vp1, false)
                    return rootView
                }
                else{
                    rootView = inflater.inflate(R.layout.fragment_three, vp1, false)
                    return rootView
                }
            }



        }
        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
