package com.jaden.hero

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


    class HeroAdapter(var dataSet: List<Hero>) :
        RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textViewRanking: TextView
            val textViewName: TextView
            val textViewDesc: TextView
            val layout: ConstraintLayout

            init {
                // Define click listener for the ViewHolder's View.
                textViewRanking = view.findViewById(R.id.rank)
                textViewName = view.findViewById(R.id.name)
                textViewDesc = view.findViewById(R.id.desc)
                layout = view.findViewById(R.id.layout_heroItem)
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_hero, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            val hero = dataSet[position]
            viewHolder.textViewRanking.text = dataSet[position].ranking.toString()
            viewHolder.textViewName.text = hero.name
            viewHolder.textViewDesc.text = hero.description
            viewHolder.layout.setOnClickListener {

                Toast.makeText(it.context,"You clicked on ${hero.name}", Toast.LENGTH_SHORT).show()
                val context = viewHolder.layout.context
                val heroDetailIntent = Intent(context, HeroesDetailActivity::class.java).apply{
                    putExtra(HeroesDetailActivity.EXTRA_HERO, hero)
                }
                context.startActivity(heroDetailIntent)
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size

    }

