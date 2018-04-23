package net.derohimat.ktanddevexp.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view.view.*
import net.derohimat.ktanddevexp.model.Item
import net.derohimat.ktanddevexp.view.ItemViewUI
import org.jetbrains.anko.AnkoContext

class MainAdapter(list: MutableList<Item>, private val listener: (Item) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var mutableList: MutableList<Item> = list

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mutableList[position], listener)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemViewUI().createView(AnkoContext.create(parent.context)))
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {

            itemView.name.text = item.name
            Glide.with(itemView.context).load(item.image).into(itemView.image)
            setOnClickListener { listener(item) }
        }
    }

    fun update(ls: List<Item>) {
        mutableList = ls as MutableList<Item>
        notifyDataSetChanged()
    }
}