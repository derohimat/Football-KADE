package net.derohimat.ktanddevexp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.derohimat.ktanddevexp.R.array.club_image
import net.derohimat.ktanddevexp.R.array.club_name
import net.derohimat.ktanddevexp.adapter.MainAdapter
import net.derohimat.ktanddevexp.model.Item
import net.derohimat.ktanddevexp.view.MainActivityUI
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    val data = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        generateData()

        val adapter = MainAdapter(data) { item ->
            startActivity(intentFor<DetailActivity>("data" to item))
        }

        MainActivityUI(adapter).setContentView(this)
    }

    private fun generateData() {
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)

        data.clear()
        for (i in name.indices) {
            data.add(Item(name[i],
                    image.getResourceId(i, 0)))
        }
        image.recycle()
    }
}
