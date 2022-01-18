package com.jaden.hero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jaden.hero.databinding.ActivityHeroesDetailBinding
import com.jaden.hero.databinding.ActivityHeroesListBinding
import java.io.InputStream

class HeroesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroesListBinding
    lateinit var adapter: HeroAdapter

    companion object{
        val TAG = "HeroesListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes_detail)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
            val inputStream = resources.openRawResource(R.raw.heroes)
            val jsonString = inputStream.bufferedReader().use {it.readText() }
            val gson = Gson()
            val type = object : TypeToken<List<Hero>>(){}.type
            val heroesList = gson.fromJson<List<Hero>>(jsonString,type)
            Log.d(TAG, "onCreate: \n${HeroesListActivity}")

            adapter = HeroAdapter(heroesList)
            binding.recyclerViewHeroesList.adapter = adapter
            binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)




    }


}