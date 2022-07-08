package com.example.retrofit_exampleapp.model

class Comments {
    var postId: Int? = null;
    var id: Int? = null;
    var name: String? = null;
    var email: String? = null;
    var body: String? = null;

    fun getpostId(): Int? {
        return postId
    }

    fun getid(): Int? {
        return id
    }

    fun getname(): String?{
        return name
    }

    fun getemail(): String?{
        return email
    }

    fun getbody(): String?{
        return body
    }
}