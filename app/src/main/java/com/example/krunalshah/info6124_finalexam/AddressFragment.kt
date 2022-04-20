package com.example.krunalshah.info6124_finalexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import org.json.JSONException
import org.json.JSONObject
import java.io.FileWriter
import java.io.PrintWriter
import java.nio.charset.Charset

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddressFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddressFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var addressText: TextView
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_address, container, false)

        addressText = view.findViewById(R.id.addressText)

        val model: SharedViewModel by activityViewModels()

        model.addressSelect.observe(viewLifecycleOwner) { address ->
            addressText.text = address
        }

        saveButton = view.findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
//            val toast = Toast(context)
//            val view = ImageView(context)
//            view.setImageResource(android.R.drawable.ic_lock_idle_alarm)
//            toast.setView(view)
//            toast.show()

            var latitude = ""
            var longitude = ""

            model.latSelect.observe(viewLifecycleOwner) { lat ->
                latitude = lat.substring(0, 15)
            }
            model.lngSelect.observe(viewLifecycleOwner) { lng ->
                longitude = lng.substring(0, 15)
            }

            val path = "/Users/kingstonkrunal/Desktop/INFO6124FinalExam/app/src/main/res/json/latLng.json"

            val json = JSONObject()

            try {
                json.put("latitude", latitude)
                json.put("longitude", longitude)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            try {
                PrintWriter(FileWriter(path, true)).use {
                    it.write(json.toString())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            Toast.makeText(context, "Latitude/Longitude saved", Toast.LENGTH_LONG).show()
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
         * @return A new instance of fragment AddressFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddressFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}