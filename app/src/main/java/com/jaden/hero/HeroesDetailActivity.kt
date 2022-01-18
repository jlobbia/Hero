package com.jaden.hero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jaden.hero.databinding.ActivityHeroesDetailBinding

class HeroesDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesDetailBinding

    companion object{
        val EXTRA_HERO = "The Hero"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO)

        binding.HeroName.text = hero?.name ?: "Hero"
        binding.image.setImageDrawable(
            getDrawable(resources.getIdentifier(hero?.image, "drawable", packageName))
        )
        binding.descline.text = hero?.description
        binding.rankline.text = hero?.ranking.toString()
        binding.superline.text = hero?.superpower
    }
}