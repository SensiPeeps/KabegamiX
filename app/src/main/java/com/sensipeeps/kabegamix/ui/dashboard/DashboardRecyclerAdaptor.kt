package com.sensipeeps.kabegamix.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sensipeeps.kabegamix.R

class DashboardRecyclerAdaptor(val context: Context) :
    RecyclerView.Adapter<DashboardRecyclerAdaptor.DashboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_dashboard_row, parent, false)

        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.imgBookIcon.setImageResource(R.drawable.hyunjinwall)
    }

    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgBookIcon: ImageView = view.findViewById(R.id.imgBookIcon)

    }

}