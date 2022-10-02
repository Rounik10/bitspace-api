package com.trinity.bitspace.entities

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("posts")
data class Post(
    @Id val id: ObjectId = ObjectId.get(),
    val title: String,
    val description: String
)