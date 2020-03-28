package com.asysyifazahrasalsabila.buttonnavapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.asysyifazahrasalsabila.buttonnavapp.ListAdapter
import com.asysyifazahrasalsabila.buttonnavapp.Model
import com.asysyifazahrasalsabila.buttonnavapp.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*

class DashboardFragment : Fragment() {

    private val list = ArrayList<Model>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTv.setHasFixedSize(true)

        list.addAll(getListData())
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvTv.layoutManager = LinearLayoutManager(context)
        val listAdapter = ListAdapter(list)
        rvTv.adapter = listAdapter
    }

    private fun getListData(): ArrayList<Model> {
        val dataName = resources.getStringArray(R.array.judul_tv)
        val dataDesc = resources.getStringArray(R.array.desc_tv)
        val dataPhoto = resources.obtainTypedArray(R.array.foto_tv)
        val listData = ArrayList<Model>()
        for (position in dataName.indices){
            val model = Model(
                dataName[position],
                dataDesc[position],
                dataPhoto.getResourceId(position, -1)
            )
            listData.add(model)
        }
        return listData
    }
}