package com.example.demo.service

import com.example.demo.model.BlogResponse
import com.example.demo.model.Post
import com.example.demo.model.User
import org.springframework.stereotype.Service

@Service
class BlogService(
    private val postService: PostService,
    private val usersService: UsersService
) {

    fun stitchUsersAndPosts(): List<BlogResponse?>? {
        val decoratedPost = mutableListOf<BlogResponse>()
        val users = usersService.fetchUsers()
        val posts = postService.fetchPosts()
        val usersById: Map<Int, User>? = users?.associateBy { it.id }
        val result = posts?.filter { usersById?.get(it.userId) != null }?.map { post ->
            usersById?.get(post.userId)?.let { user ->
                BlogResponse(user = user, post = post)
            }
        }
        return result
    }
}