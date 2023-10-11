package com.example.tagapp

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tagapp.databinding.ActivityMainBinding


import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bluetoothAdapter: BluetoothAdapter
    private lateinit var deviceListAdapter: ArrayAdapter<String>
    private lateinit var deviceList: ListView
    private val BLUETOOTH_PERMISSION_REQUEST = 1

    private fun checkBluetoothPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission hasn't been granted, request it.
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.BLUETOOTH),
                BLUETOOTH_PERMISSION_REQUEST
            )
        } else {
            // Permission is already granted, you can proceed to use Bluetooth.
            // You can start scanning for devices here.
        }
    }

    private val bluetoothReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            val myTextView = findViewById<TextView>(R.id.display)
            myTextView.text = "FOUND ONE"

            when (intent.action) {
                BluetoothDevice.ACTION_FOUND -> {
                    val device =
                        intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)


                    val deviceName = if (ActivityCompat.checkSelfPermission(
                            context,
                            Manifest.permission.BLUETOOTH_ADMIN
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.

                        return
                    } else {


                    }
                    device?.name ?: "Unknown Device"
                    val deviceAddress = device?.address ?: "No Address"
                    val deviceInfo = "$deviceName\n$deviceAddress"


                    deviceListAdapter.add(deviceInfo)
                    deviceListAdapter.notifyDataSetChanged()
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Bluetooth
        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)

        bluetoothAdapter = bluetoothManager.adapter
        //bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        deviceListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        deviceList = findViewById(R.id.deviceView)
        deviceList.adapter = deviceListAdapter

        val scanButton: Button = findViewById(R.id.scanButton)
        val myTextView = findViewById<TextView>(R.id.display)

        scanButton.setOnClickListener {
            //myTextView.text = "Button Pressed"
            startBluetoothScan()
        }

        if (bluetoothAdapter == null) {
            myTextView.text = "ADAPTER == NULL"
        }else if (!bluetoothAdapter.isEnabled()) {
            myTextView.text = "ADAPTER == Not Enabled"
        }else {
            checkBluetoothPermissions()
            myTextView.text = "ADAPTER != NULL"
        }

    }
    private fun startBluetoothScan() {
        deviceListAdapter.clear() // Clear previous results


        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        registerReceiver(bluetoothReceiver, filter)
        val myTextView = findViewById<TextView>(R.id.display)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_ADMIN
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_SCAN
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            var permissionsToRequest = arrayOf(Manifest.permission.BLUETOOTH_ADMIN)
            val requestCode = 123 // You can use any unique code
            ActivityCompat.requestPermissions(this, permissionsToRequest, requestCode)

            permissionsToRequest = arrayOf(Manifest.permission.BLUETOOTH_SCAN)
            ActivityCompat.requestPermissions(this, permissionsToRequest, requestCode)

            val myTextView = findViewById<TextView>(R.id.display)
            myTextView.text = "Button Pressed + Not Working"

            return
        }else{


        }
        myTextView.text = "Button Pressed -> Bt should work"
        bluetoothAdapter?.startDiscovery()

    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            123 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, you can now perform the task that requires this permission.
                } else {
                    // Permission denied, handle it (e.g., show a message to the user).
                }
            }
        }
    }



}