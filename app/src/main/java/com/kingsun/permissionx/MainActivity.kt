package com.kingsun.permissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kingsun.fanda.PermissionX
import com.kingsun.permissionx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.makeCallBtn.setOnClickListener {
            PermissionX.request(this,Manifest.permission.CALL_PHONE){ allGranted,deniedList ->
                if (allGranted) {
                    call()
                }else {
                    Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun call(){
        try {
            startActivity(Intent(Intent.ACTION_CALL).apply { data = Uri.parse("tel:10086") })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}