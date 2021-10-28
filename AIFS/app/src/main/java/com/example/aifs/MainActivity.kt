package com.example.aifs


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var chipNavigationBar: ChipNavigationBar? = null
    private var fragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chipNavigationBar = findViewById(R.id.chipNavigationView)
        chipNavigationView.setItemSelected(R.id.homeFragment, true)
        supportFragmentManager.beginTransaction().replace(R.id.frag, HomeFragment()).commit()
        chipNavigationView.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                when (id) {
                    R.id.homeFragment -> fragment = HomeFragment()
                    R.id.atsFragment -> fragment = AtsFragment()
                }
                if (fragment != null) {
                    supportFragmentManager.beginTransaction().replace(R.id.frag, fragment!!).commit()
                }
            }
        })

    }


}