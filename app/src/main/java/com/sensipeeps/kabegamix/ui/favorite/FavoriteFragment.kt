package com.sensipeeps.kabegamix.ui.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sensipeeps.kabegamix.R
import com.sensipeeps.kabegamix.utils.jsonStructure

class FavoriteFragment : Fragment() {

    lateinit var jsonStructure: jsonStructure

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_favorite, container, false)
        jsonStructure = jsonStructure(context)
        Log.d("FAV_FRAG", "author " + jsonStructure.retrieve(0, "wall_sam.json")[0] +
                                    " url " + jsonStructure.retrieve(0, "wall_sam.json")[1] +
                                    " name " + jsonStructure.retrieve(0, "wall_sam.json")[2] )
        return view;
    }
}