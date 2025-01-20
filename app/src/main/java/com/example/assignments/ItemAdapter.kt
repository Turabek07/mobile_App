import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignments.Item
import com.example.assignments.R



class ItemAdapter(
    private val itemList: List<Item>,
    private val onItemClicked: (Int) -> Unit,
    private val onLikeClicked: (Int) -> Unit,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.itemImage)
        val itemTitle: TextView = view.findViewById(R.id.itemTitle)
        val likeButton: Button = view.findViewById(R.id.likeButton)


        init {

            view.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClicked(itemList[position].id)
                }
            }


            likeButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onLikeClicked(itemList[position].id)
                }
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemTitle.text = item.title

        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.itemImage)
    }


    override fun getItemCount(): Int = itemList.size
}

