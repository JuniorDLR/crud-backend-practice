package com.junaxer.kotlinspringcrud.controller

import com.junaxer.kotlinspringcrud.model.PostEntity
import com.junaxer.kotlinspringcrud.service.PostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/posts")
class PostController(private val postService: PostService) {

    @GetMapping
    fun getAllPost(): ResponseEntity<List<PostEntity>> {
        val posts = postService.getAllPost()
        return ResponseEntity.ok(posts)
    }

    @GetMapping("/{id}")
    fun getPostById(
        @PathVariable id: Long
    ): ResponseEntity<PostEntity> {
        val postId = postService.getById(id)
        return postId?.let { entity ->
            ResponseEntity.ok(entity)
        } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createPost(
        @RequestBody postEntity: PostEntity
    ): ResponseEntity<PostEntity> {
        val savePost = postService.savePost(postEntity)

        return ResponseEntity
            .created(URI.create("/posts/${savePost.id}"))
            .body(savePost)
    }

    @PutMapping("/{id}")
    fun updatePost(
        @PathVariable id: Long, @RequestBody postEntity: PostEntity
    ): ResponseEntity<PostEntity> {
        val updatePost = postService.updatePost(id, postEntity)

        return updatePost?.let { postEntity ->
            ResponseEntity.ok(postEntity)
        } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deletePost(
        @PathVariable id: Long
    ): ResponseEntity<Void> {
        postService.deletePost(id)
        return ResponseEntity.noContent().build()
    }

}