package com.example.lab8.fragments


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab8.R
import com.example.lab8.adapters.InventarioAdapter
import com.example.lab8.databinding.FragmentInventariosBinding
import com.example.lab8.inventario.Inventario
import com.example.lab8.inventario.InventarioViewModel

class InventariosFragment : Fragment() {
    private lateinit var inventarioViewModel: InventarioViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentInventariosBinding = inflate(inflater, R.layout.fragment_inventarios, container, false)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val adapter = InventarioAdapter()
        recyclerView.adapter = adapter

        inventarioViewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)
        inventarioViewModel.getAllInventarios().observe(this, Observer {
            adapter.setInventarios(it)
        })

        if(ItemsFragment.FECHA != ""){
            inventarioViewModel.insert(Inventario(ItemsFragment.FECHA))
            ItemsFragment.FECHA = ""
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.inventarios_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.itemsFragment){
            return NavigationUI.onNavDestinationSelected(
                item, view!!.findNavController())
                    || super.onOptionsItemSelected(item)
        }
        else if(item.itemId == R.id.inventariosFragment){
            inventarioViewModel.deleteAllInventarios()
            Toast.makeText(activity, "Lista de inventarios reiniciada", Toast.LENGTH_LONG).show()
            return NavigationUI.onNavDestinationSelected(
                item, view!!.findNavController())
                    || super.onOptionsItemSelected(item)
        }
        return NavigationUI.onNavDestinationSelected(
            item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}
