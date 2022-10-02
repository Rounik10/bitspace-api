package com.trinity.bitspace.services

import com.trinity.bitspace.entities.Post
import com.trinity.bitspace.repository.PostRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

interface PostService {

    fun getAllPosts(): List<Post>

    fun addPost(post: Post): Post

    fun getPostById(id: String): Post?

    fun deletePostById(id: String)

}