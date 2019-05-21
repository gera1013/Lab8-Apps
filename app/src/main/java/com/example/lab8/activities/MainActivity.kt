package com.example.lab8.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.lab8.R
import com.example.lab8.databinding.ActivityMainBinding
import com.example.lab8.fragments.InventariosFragment
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {
    //Almacena el resultado del scan
    companion object{
        var CODIGO = ""
    }

    private lateinit var drawerLayout : DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //FAB para abrir el scan de QRs
        binding.buttonAdd.setOnClickListener {
            val scanner = IntentIntegrator(this)
            scanner.initiateScan()
        }

        //Se carga el fragment inicial
        val fragment = InventariosFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction  = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.placeHolder, fragment)

        //Drawer layout de la actividad
        drawerLayout = binding.drawerLayout

        //Se llama al navHostFragment, que es la actividad
        val navController = this.findNavController(R.id.myNavHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        //Configuracion del action bar y del nav controller
        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    //Controla la navegacion desde el app bar
    override fun onNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    //Metodo que recibe el resultado del scan de ser exitoso
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK){
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if(result != null){
                if(result.contents == null){
                    Toast.makeText(this, "Escaneo cancelado", Toast.LENGTH_LONG).show()
                } else {
                    CODIGO = result.contents
                }
            } else{
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}
