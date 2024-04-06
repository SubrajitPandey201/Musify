package com.example.musify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musify.ui.theme.MusiFyTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContent {

            val retrofitBuilder = Retrofit.Builder()
                .baseUrl("https://deezerdevs-deezer.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterFace::class.java)

            val retrofitData = retrofitBuilder.getData(query = "eminem")

            retrofitData.enqueue(object : Callback<List<MusicData>?> {
                //if the api call is success then we can get the api onResponse
                override fun onResponse(
                    call: Call<List<MusicData>?>,
                    response: Response<List<MusicData>?>
                ) {
                    val dataList = response.body()
                }

                //if the api call is in failure one then we can get the api onResponse
                override fun onFailure(p0: Call<List<MusicData>?>, p1: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}


