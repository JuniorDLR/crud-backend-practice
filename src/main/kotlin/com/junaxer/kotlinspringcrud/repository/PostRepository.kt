package com.junaxer.kotlinspringcrud.repository

import com.junaxer.kotlinspringcrud.model.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<PostEntity, Long>