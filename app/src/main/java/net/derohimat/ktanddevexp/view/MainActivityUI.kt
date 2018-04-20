package net.derohimat.ktanddevexp.view

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import net.derohimat.ktanddevexp.MainActivity
import net.derohimat.ktanddevexp.adapter.MainAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI(private val mAdapter: MainAdapter) : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {

        return relativeLayout {
            padding = dip(16)
            lparams(width = matchParent, height = wrapContent)

            recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = mAdapter
            }
        }
    }
}