package com.palash.device_information

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.os.BuildCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDeviceInformation()
    }

    // Function to get device information
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getDeviceInformation(): String {
        val stringBuilder = StringBuilder()

        // Build information
        stringBuilder.append("Device Model: ${Build.MODEL}\n")
        Log.d("Device Model", Build.MODEL)//output-> RMX2193

        stringBuilder.append("Manufacturer: ${Build.MANUFACTURER}\n")
        Log.d("Manufacturer", Build.MANUFACTURER)//output-> realme

        stringBuilder.append("Brand: ${Build.BRAND}\n")
        Log.d("Brand", Build.BRAND)//output-> realme

        stringBuilder.append("Product: ${Build.PRODUCT}\n")
        Log.d("Product", Build.PRODUCT)//output-> RMX2193

        // Android version information
        stringBuilder.append("Android Version: ${Build.VERSION.RELEASE}\n")
        Log.d("Android Version", Build.VERSION.RELEASE)//output-> 11

        stringBuilder.append("API Level: ${Build.VERSION.SDK_INT}\n")
        Log.d("API Level", "${ Build.VERSION.SDK_INT }")//output-> 30

        // Check if the device is running on a specific API level
        if (BuildCompat.isAtLeastQ()) {
            stringBuilder.append("Device is running on Android Q or later\n")
            Log.d("Device is running on Android Q or later", "\n")//output-> Device is running on Android Q or later
        }

        // Additional information (requires API level 23 or higher)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            stringBuilder.append("Security Patch Level: ${Build.VERSION.SECURITY_PATCH}\n")
            Log.d("Security Patch Level", Build.VERSION.SECURITY_PATCH)//output-> 2022-09-05
        }

        return stringBuilder.toString()
    }
}