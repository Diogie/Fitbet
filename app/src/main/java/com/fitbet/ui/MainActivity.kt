package com.fitbet.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.fitbet.*
import com.fitbet.application.RicheraceApplication
import com.fitbet.data.AppDatabase
import com.fitbet.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var db: AppDatabase
    lateinit var binding: ActivityMainBinding

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Challenge deleted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        (applicationContext as RicheraceApplication).mAppComponent.inject(this)


        val viewModelFactory = ChallengeViewModelFactory(db.challengeDao(), application)
        val challengeViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(ChallengeViewModel::class.java)

        binding.lifecycleOwner = this

        binding.contentMain.challengesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.contentMain.challengesRecyclerView.adapter = ChallengeAdapter(listOf(), startForResult)

        challengeViewModel.getAllChallenges().observe(this, Observer {
            binding.contentMain.challengesRecyclerView.adapter = ChallengeAdapter(
                it,
                startForResult
            )
        })

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { _ ->
            startActivity(Intent(this, NewChallengeActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        when (item.itemId) {
            R.id.action_profile -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }

        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_profile -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}