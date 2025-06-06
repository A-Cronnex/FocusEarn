package com.example.focusearn
import com.example.focusearn.R

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.focusearn.ui.theme.FocusEarnTheme
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.example.focusearn.leaderboard.LeaderboardFragment
import com.example.focusearn.profile.ProfileFragment
import com.example.focusearn.timer.TimerFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val navigationView = findViewById<BottomNavigationView>(R.id.navigation_bar)

        val leaderboadButton = findViewById<ImageButton>(R.id.leaderboardButton)
        val timerButton = findViewById<ImageButton>(R.id.mainTimerButton)
        val profileButton = findViewById<ImageButton>(R.id.profileButton)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.host, TimerFragment())
                .commit()
        }

        leaderboadButton.setOnClickListener {
            loadFragment(LeaderboardFragment())
        }

        timerButton.setOnClickListener {
            loadFragment(TimerFragment())
        }

        profileButton.setOnClickListener {
            loadFragment(ProfileFragment())
        }
    }

    fun loadFragment(fragment: Fragment){

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.host, fragment)
        transaction.commit()
    }


}
