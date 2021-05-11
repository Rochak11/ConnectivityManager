package com.example.myproject
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    lateinit var input: EditText

    private  var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {

            when(intent?.action){
                "android.intent.action.HDMI_PLUGGED  " -> {
                    val state = intent.getBooleanExtra("state", false)

                }
                "android.net.conn.CONNECTIVITY_CHANGE" ->{


                    checknetwork()

                }
            }
        }

    }
    private val mIntentFilters = IntentFilter().apply {
        this.addAction("android.intent.action.HDMI_PLUGGED")
        this.addAction("android.net.conn.CONNECTIVITY_CHANGE")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(broadcastReceiver,mIntentFilters)


        btn3 = findViewById(R.id.btn3)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        input = findViewById(R.id.etInput)


        val c = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = c.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            if (networkInfo.type == ConnectivityManager.TYPE_MOBILE)
                Toast.makeText(this, "Connected to mobile network", Toast.LENGTH_SHORT).show()
        }
        if (networkInfo != null) {
            if (networkInfo.type == ConnectivityManager.TYPE_WIFI)
                Toast.makeText(this, "Connected to Wifi network", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Connection in unavailable", Toast.LENGTH_SHORT).show()
        }

        btn1.setOnClickListener {
            checknetwork()

        }
        btn2.setOnClickListener {
            val density = Intent(this, MainActivity2::class.java)
            startActivity(density)
        }
        btn3.setOnClickListener {
            val manager = Intent(this,FileManager::class.java)
            startActivity(manager)
        }


    }

    private fun checknetwork() {


        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        val networkInfo = cm.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            if (networkInfo.type == ConnectivityManager.TYPE_MOBILE)
                Toast.makeText(this, "Connected to mobile network", Toast.LENGTH_SHORT).show()
        }
        if (networkInfo != null) {
            if (networkInfo.type == ConnectivityManager.TYPE_WIFI)
                Toast.makeText(this, "Connected to Wifi network", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Connection in unavailable", Toast.LENGTH_SHORT).show()
        }

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Toast.makeText(this, "$keyCode", Toast.LENGTH_SHORT).show()
        return super.onKeyDown(keyCode, event)

    }

}