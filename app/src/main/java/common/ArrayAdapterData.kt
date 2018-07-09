package common

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import java.util.*
import android.widget.TextView
import com.example.nu_therabbit.bottombarproject.R
import android.view.LayoutInflater




class ArrayAdapterData : RecyclerView.Adapter<ArrayAdapterData.DataViewHolder>() {


    private val items = ArrayList<Data>()
    private var onItemsClicked: OnItemsClicked? = null

    fun add(item: Data) {
        items.add(item)
        notifyDataSetChanged()
    }

    fun setOnItemsClickListener(onItemsClicked: OnItemsClicked){
        this.onItemsClicked = onItemsClicked
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.items_view_data, parent, false)
        return DataViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.title.text = "Item "+items[position].i
        holder.itemView.setOnClickListener {
            onItemsClicked?.onItemsClicked()
        }
    }

    class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.text)
    }


    interface OnItemsClicked{
        fun onItemsClicked()
    }
}