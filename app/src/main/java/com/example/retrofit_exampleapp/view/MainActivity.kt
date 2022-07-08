package com.example.retrofit_exampleapp.view

import android.graphics.PostProcessor
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_exampleapp.R
import com.example.retrofit_exampleapp.model.Comments
import com.example.retrofit_exampleapp.model.JsonHolderAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST


class MainActivity : AppCompatActivity() {
    var commentData: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        commentData = findViewById(R.id.commentdata)
        getCommentsfromAPI()
    }

    fun getCommentsfromAPI(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        var jsonHolderAPI: JsonHolderAPI = retrofit.create(JsonHolderAPI::class.java)
        var call: Call<List<Comments>> = jsonHolderAPI.getComments()

        call.enqueue(object : Callback<List<Comments>>{
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                if(!response.isSuccessful){
                    commentData?.text = response.message()
                }
                var commentsList: List<Comments>? = response.body()
                commentsList?.forEach {
                    val comments = Comments()
                    var content = ""
                    content.plus("userId:" + comments.getid())
                    content.plus("name:" + comments.getname())
                    content.plus("email:" + comments.getemail())
                    content.plus("Body:" + comments.getbody())

                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                commentData?.text = t.message
            }

        })
    }
}
