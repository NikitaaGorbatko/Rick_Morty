package nikitagorbatko.example.rickmorty.retrofit
import retrofit2.Call
import nikitagorbatko.example.rickmorty.Character
import nikitagorbatko.example.rickmorty.ObjectRM
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServices {
    @GET("character")
    fun getCharacters(@Query("page") page: Int): Call<ObjectRM>
}