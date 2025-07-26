package com.junaxer.kotlinspringcrud.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "posts")
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "title", nullable = false)
    val title: String = "",
    @Column(name = "content", nullable = false)
    val content: String = ""
)
