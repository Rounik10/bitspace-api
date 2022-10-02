package com.trinity.bitspace.repository

import com.trinity.bitspace.entities.Post
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface PostRepository : MongoRepository<Post, String> {
    fun findOneById(id: ObjectId): Post
}