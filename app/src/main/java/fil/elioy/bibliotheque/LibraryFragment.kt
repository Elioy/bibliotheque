package fil.elioy.bibliotheque

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class LibraryFragment : Fragment() {

    lateinit var listener: OnClickBookListener
    lateinit var bookAdapter: BookAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickBookListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val url: String = "http://henri-potier.xebia.fr/"
        getBooks(url)
        val view = inflater.inflate(R.layout.fragment_library, container, false)
        val recycleListView = view.findViewById<RecyclerView>(R.id.fragment_library)
        recycleListView.layoutManager = LinearLayoutManager(context)
        bookAdapter = BookAdapter(emptyList(), listener::onClickBook)
        recycleListView.adapter = bookAdapter
        return view
    }

    fun getBooks(url: String) {
        val retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retrofit.create(HenriPotierService::class.java)
        val bookRequest = service.getBooks()
        bookRequest.enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                val books = response.body()
                if (books != null) {
                    for (book in books) {
                        Log.d("getBooks", book.title);
                    }
                    bookAdapter.setListBooks(books)
                }
            }
            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Log.d("getBooks", "Cannot get books")
            }
        })
    }
}
