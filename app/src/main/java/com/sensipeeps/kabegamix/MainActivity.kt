package com.sensipeeps.kabegamix

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.sensipeeps.kabegamix.ui.home.HomeFragment
import com.sensipeeps.kabegamix.ui.favorite.FavoriteFragment
import com.sensipeeps.kabegamix.ui.more.MoreFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragment1: Fragment = HomeFragment()
    private val fragment2: Fragment = FavoriteFragment()
    private val fragment3: Fragment = MoreFragment()
    private val fm = supportFragmentManager
    private var active = fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_favorite, R.id.navigation_more
            )
        )
        setSupportActionBar(home_toolbar)
        supportActionBar?.title = getString(R.string.title_home)
        navView.setupWithNavController(navController)
        home_toolbar.setupWithNavController(navController, appBarConfiguration)

        val navigation = findViewById<BottomNavigationView>(R.id.nav_view)
        fm.beginTransaction().add(R.id.nav_host_fragment, fragment3, "3").hide(fragment3).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, fragment1, "1").commit()
        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    fm.beginTransaction().hide(active).show(fragment1).commit()
                    active = fragment1
                    supportActionBar?.title = getString(R.string.title_home)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_favorite -> {
                    fm.beginTransaction().hide(active).show(fragment2).commit()
                    active = fragment2
                    supportActionBar?.title = getString(R.string.title_fav)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_more -> {
                    fm.beginTransaction().hide(active).show(fragment3).commit()
                    active = fragment3
                    supportActionBar?.title = getString(R.string.title_more)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }
}