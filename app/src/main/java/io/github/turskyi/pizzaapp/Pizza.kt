package io.github.turskyi.pizzaapp

class Pizza private constructor(
    val name: String,
    val imageResourceId: Int
) {
    companion object {
        val pizzas = arrayOf(
            Pizza("Diavolo", R.drawable.pic_diavolo),
            Pizza("Funghi", R.drawable.pic_funghi)
        )
    }
}