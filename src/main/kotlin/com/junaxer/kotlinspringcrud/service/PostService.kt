package com.junaxer.kotlinspringcrud.service

import com.junaxer.kotlinspringcrud.model.PostEntity
import com.junaxer.kotlinspringcrud.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostService(private val postRepository: PostRepository) {

    fun getAllPost(): List<PostEntity> = postRepository.findAll()
    fun getById(id: Long): PostEntity? = postRepository.findByIdOrNull(id)
    fun savePost(postEntity: PostEntity): PostEntity = postRepository.save(postEntity)
    fun updatePost(id: Long, postEntity: PostEntity): PostEntity? {
        return postRepository.findByIdOrNull(id)?.let { existingPost ->

            val updatePostExisting = existingPost.copy(
                title = postEntity.title,
                content = postEntity.content
            )

            postRepository.save(updatePostExisting)
        }
    }

    fun deletePost(id: Long) = postRepository.deleteById(id)
}