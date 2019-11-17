package fil.elioy.bibliotheque

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view_book.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindBook(book: Book, onItemClick: (book: Book) -> Unit) {
        itemView.title.text = book.title
        itemView.price.text = book.price + "€"
        Picasso.get().load(book.cover).into(itemView.cover)
        itemView.setOnClickListener {
            onItemClick(book)
        }
    }
}