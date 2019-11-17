package fil.elioy.bibliotheque

import retrofit2.Call
import retrofit2.http.GET



interface HenriPotierService {

    @GET("books")
    fun getBooks(): Call<List<Book>>
}