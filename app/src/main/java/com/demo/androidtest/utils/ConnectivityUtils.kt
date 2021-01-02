package com.demo.androidtest.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.M)
fun isNetworkAvailable(context: Context?): Boolean {

    val connectivityManager: ConnectivityManager? = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager?.activeNetwork
    val capabilities = connectivityManager?.getNetworkCapabilities(network)

    return capabilities != null &&
            ((capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
                    || (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)))

}