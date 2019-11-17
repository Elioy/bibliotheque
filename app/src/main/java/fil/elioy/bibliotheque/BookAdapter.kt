package fil.elioy.bibliotheque

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view_book.view.*

class BookAdapter(var books: List<Book>, val onItemClick: (book: Book) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int = books.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val lineView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_book, parent, false)
        return ViewHolder(lineView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindBook(books[position], onItemClick)
    }

    fun setListBooks(listBooks: List<Book>) {
        books = listBooks
        notifyDataSetChanged()
    }
}