package net.derohimat.ktanddevexp.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import net.derohimat.ktanddevexp.R
import net.derohimat.ktanddevexp.model.Item
import net.derohimat.ktanddevexp.view.ItemViewUI
import org.jetbrains.anko.AnkoContext

class MainAdapter(ls: MutableList<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var mutableList: MutableList<Item> = ls

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
        val imgIcon: ImageView = itemView?.findViewById(R.id.image) as ImageView
        val txtName: TextView = itemView?.findViewById(R.id.name) as TextView

        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {

            txtName.text = item.name
            Glide.with(itemView.context).load(item.image).into(imgIcon)
            setOnClickListener { listener(item) }
        }
    }

    fun update(ls: List<Item>) {
        mutableList = ls as MutableList<Item>
        notifyDataSetChanged()
    }
}