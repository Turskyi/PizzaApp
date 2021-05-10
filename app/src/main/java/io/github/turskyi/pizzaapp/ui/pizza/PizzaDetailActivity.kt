package io.github.turskyi.pizzaapp.ui.pizza

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import io.github.turskyi.pizzaapp.Pizza
import io.github.turskyi.pizzaapp.R

class PizzaDetailActivity : AppCompatActivity(R.layout.activity_pizza_detail) {
    companion object {
        const val EXTRA_PIZZA_ID = "pizzaId"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Set the toolbar as the activity's app bar */
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        /* Display details of the pizza */
        val pizzaId = intent.extras?.get(EXTRA_PIZZA_ID) as Int
        val pizzaName = Pizza.pizzas[pizzaId].name
        val textView = findViewById<TextView>(R.id.pizza_text)
        textView.text = pizzaName
        val pizzaImage = Pizza.pizzas[pizzaId].imageResourceId
        val imageView = findViewById<ImageView>(R.id.pizza_image)
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage))
        imageView.contentDescription = pizzaName
    }
}