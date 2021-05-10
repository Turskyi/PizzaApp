package io.github.turskyi.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.MenuItemCompat
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import io.github.turskyi.pizzaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding
    private lateinit var shareActionProvider: ShareActionProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)

        /* Attach the SectionsPagerAdapter to the ViewPager */
        val pagerAdapter = SectionsPagerAdapter(this)
        binding.pager.adapter = pagerAdapter

        /* Attach the ViewPager to the TabLayout */
        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            tab.text = pagerAdapter.getPageTitle(position)
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        /* Inflate the menu; this adds items to the app bar. */
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu.findItem(R.id.action_share)
        shareActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        "Want to join me for pizza?".setShareActionIntent()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_create_order -> {
                val intent = Intent(this, OrderActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun String.setShareActionIntent() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, this)
        shareActionProvider.setShareIntent(intent)
    }

    private inner class SectionsPagerAdapter(activity: AppCompatActivity) :
        FragmentStateAdapter(activity) {
        val count: Int
            get() = 4

        fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return resources.getText(R.string.home_tab)
                1 -> return resources.getText(R.string.pizza_tab)
                2 -> return resources.getText(R.string.pasta_tab)
                3 -> return resources.getText(R.string.store_tab)
            }
            return null
        }

        override fun getItemCount() = count

        override fun createFragment(position: Int) =
            when (position) {
                0 -> TopFragment()
                1 -> PizzaFragment()
                2 -> PastaFragment()
                3 -> StoresFragment()
                else -> TopFragment()
            }
    }
}
