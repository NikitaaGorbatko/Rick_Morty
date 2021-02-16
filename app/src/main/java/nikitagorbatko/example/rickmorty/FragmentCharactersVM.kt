package nikitagorbatko.example.rickmorty

import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nikitagorbatko.example.rickmorty.common.Common
import nikitagorbatko.example.rickmorty.retrofit.RetrofitServices
import retrofit2.Callback

class FragmentCharactersVM: ViewModel() {
    val characters = MutableLiveData<ArrayList<Character>>()
    private var service: RetrofitServices = Common.retrofitService
    private var pages = 100
    private var page = 1

    fun getCharacters(): Boolean {

        if (page > pages) return false//hardcode
        service.getCharacters(page++).enqueue(object : Callback<ObjectRM> {
            override fun onFailure(call: retrofit2.Call<ObjectRM>, t: Throwable) {

            }
            override fun onResponse(
                call: retrofit2.Call<ObjectRM>,
                response: Response<ObjectRM>
            ) {
                pages = response.body()?.info?.pages ?: return
                characters.postValue(response.body()?.results)
                getCharacters()
            }
        })
        return true
    }
}