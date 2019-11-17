package fil.elioy.bibliotheque

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_library.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import android.content.res.Configuration.ORIENTATION_LANDSCAPE

class LibraryActivity : AppCompatActivity(), OnClickBookListener{

    val libraryFragment: LibraryFragment = LibraryFragment()
    val bookFragment: BookFragment = BookFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        if(resources.configuration.orientation != ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_library, libraryFragment)
                .commit()
        }
        else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_library_1, libraryFragment)
                .commit()
        }
    }


    override fun onClickBook(book: Book) {
        Log.d("click", book.title)
        bookFragment.book = book
        if(resources.configuration.orientation != ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_library, bookFragment)
                .addToBackStack("book")
                .commit()
        }
        else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_library_2, bookFragment)
                .addToBackStack("book")
                .commit()
        }
    }

}
