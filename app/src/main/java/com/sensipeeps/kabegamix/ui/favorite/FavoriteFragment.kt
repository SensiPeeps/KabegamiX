package com.sensipeeps.kabegamix.ui.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sensipeeps.kabegamix.R
import com.sensipeeps.kabegamix.utils.JsonStructure

class FavoriteFragment : Fragment() {

    private lateinit var structure: JsonStructure

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_favorite, container, false)
        structure = JsonStructure(context)
        Log.d("FAV_FRAG", "author " + (structure.retrieve(0, "wall_sam.json")?.get(0)) +
                                    " url " + (structure.retrieve(0, "wall_sam.json")?.get(1)) +
                                    " name " + (structure.retrieve(0, "wall_sam.json")?.get(2))
        )
        return view;
    }
}