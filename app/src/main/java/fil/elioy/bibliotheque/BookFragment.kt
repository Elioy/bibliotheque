package fil.elioy.bibliotheque

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

class BookFragment : Fragment() {

    var book: Book? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    fun loadData() {
        if (book != null) {
            view?.findViewById<TextView>(R.id.titleBook)?.text = book?.title
            view?.findViewById<TextView>(R.id.isbnBook)?.text = book?.isbn
            view?.findViewById<TextView>(R.id.priceBook)?.text = book?.price + "€"
            val imageView = view?.findViewById<ImageView>(R.id.coverBook)
            Picasso.get().load(book?.cover).into(imageView)
            var synopsis = "\n"
            for(str in book!!.synopsis){
                synopsis += str + "\n\n"
            }
            view?.findViewById<TextView>(R.id.synopsisBook)?.text = synopsis
        }
    }
}