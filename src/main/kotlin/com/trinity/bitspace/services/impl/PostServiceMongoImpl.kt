package com.trinity.bitspace.services.impl

import com.trinity.bitspace.entities.Post
import com.trinity.bitspace.repository.PostRepository
import com.trinity.bitspace.services.PostService
import org.springframework.stereotype.Service

@Service
class PostServiceMongoImpl(
    private val postRepository: PostRepository
) : PostService {

    override fun getAllPosts(): List<Post> {
        return postRepository.findAll()
    }

    override fun addPost(post: Post): Post {
        return postRepository.save(post)
    }

    override fun getPostById(id: String): Post? {
        return postRepository.findById(id).orElseGet(null)
    }

    override fun deletePostById(id: String) {
        postRepository.deleteById(id)
    }

}
