package io.github.turskyi.pizzaapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment
import io.github.turskyi.pizzaapp.R

/**
 * A simple [StoresFragment] subclass.
 */
class StoresFragment : ListFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = ArrayAdapter(
            inflater.context, android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.stores)
        )
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}