package com.trinity.bitspace.controllers

import com.trinity.bitspace.entities.Post
import com.trinity.bitspace.requests.PostDto
import com.trinity.bitspace.services.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpResponse

@RestController
@RequestMapping("posts")
class PostController(
    private val postService: PostService
) {
    @GetMapping("/")
    fun getAllPosts(): List<Post> = postService.getAllPosts()

    @GetMapping("/{id}")
    fun getPostById(@PathVariable("id") id: String): Post? {
        return postService.getPostById(id)
    }

    @DeleteMapping("/{id}")
    fun deletePostById(@PathVariable("id") id: String): String {
        postService.deletePostById(id)
        return "Deleted the post with id: $id"
    }

    @PostMapping("/add", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addNewPost(
        @RequestBody data: PostDto,
    ): ResponseEntity<Post> {
        return try {
            val post = postService.addPost(
                Post(
                    title = data.title,
                    description = data.description
                )
            )
            ResponseEntity.ok(post)
        } catch (e: Exception) {
            e.printStackTrace()
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }
    }
}