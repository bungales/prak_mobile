package com.example.bungaapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bungaapps.Home.Pertemuan_2.SecondActivity
import com.example.bungaapps.Home.Pertemuan_3.ThirdActivity
import com.example.bungaapps.databinding.ActivityMainBinding
import com.example.bungaapps.Home.pertemuan_4.FourthActivity
import com.example.bungaapps.Home.pertemuan_5.FifthActivity
import com.example.bungaapps.Home.pertemuan_7.SeventhActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()



                    val intent = Intent(this, AuthActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
        binding.button4.setOnClickListener {
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)

        }
        binding.button.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)

        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)

        }
        binding.button3.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)

        }
    }
}