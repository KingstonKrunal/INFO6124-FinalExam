package com.example.krunalshah.info6124_finalexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LatLngFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LatLngFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var lat: String? = null
    private var lng: String? = null

    private lateinit var latText: TextView
    private lateinit var lngText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            lat = it.getString("latitude")
//            lng = it.getString("longitude")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_lat_lng, container, false)

        latText = view.findViewById(R.id.latitudeText)
        lngText = view.findViewById(R.id.longitudeText)

        lngText.text = lng

        val model: SharedViewModel by activityViewModels()

        model.latSelect.observe(viewLifecycleOwner) { lat ->
            latText.text = lat.substring(0, 15)
        }
        model.lngSelect.observe(viewLifecycleOwner) { lng ->
            lngText.text = lng.substring(0, 15)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LatLngFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LatLngFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}