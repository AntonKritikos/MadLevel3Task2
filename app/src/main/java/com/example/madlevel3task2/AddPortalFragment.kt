package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.add_portal_fragment.*

const val REQ_PORTAL_KEY = "req_reminder"
const val BUNDLE_PORTAL_NAME = "bundle_portal_name"
const val BUNDLE_PORTAL_URL = "bundle_portal_url"
/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_portal_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addPortal.setOnClickListener {
            addNewPortal()
        }
    }

    fun addNewPortal() {
        val portalName = title.text.toString()
        val portalUrl = url.text.toString()

        if (portalName.isNotBlank() && portalUrl.isNotBlank()) {
            setFragmentResult(REQ_PORTAL_KEY, bundleOf(Pair(BUNDLE_PORTAL_NAME, portalName), Pair(BUNDLE_PORTAL_URL, portalUrl)))

            findNavController().popBackStack()
        } else {
            Toast.makeText(
                activity,
                R.string.not_valid, Toast.LENGTH_SHORT
            ).show()
        }

    }
}