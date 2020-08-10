package com.sensipeeps.kabegamix.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sensipeeps.kabegamix.R

class DashboardFragment : Fragment() {

    private lateinit var recyclerDashboard: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var progressLayout: RelativeLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerAdapter: DashboardRecyclerAdaptor

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)
        progressLayout = view.findViewById(R.id.progressLayout)
        progressBar = view.findViewById(R.id.progressBar)
        progressLayout.visibility = View.VISIBLE

        layoutManager = GridLayoutManager(activity as Context, 2)

        if (activity != null) {
            progressLayout.visibility = View.GONE
            recyclerAdapter = DashboardRecyclerAdaptor(activity as Context)
            recyclerDashboard.adapter = recyclerAdapter
            recyclerDashboard.layoutManager = layoutManager

        }
        return view
    }
}