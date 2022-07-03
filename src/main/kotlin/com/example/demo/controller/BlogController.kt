package com.example.demo.controller

import com.example.demo.model.BlogResponse
import com.example.demo.model.Post
import com.example.demo.model.User
import com.example.demo.service.BlogService
import com.example.demo.service.PostService
import com.example.demo.service.UsersService
//import io.opentelemetry.extension.annotations.WithSpan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/blog")
class BlogController(
    private val usersService: UsersService,
    private val postService: PostService,
    private val blogService: BlogService
) {

    @GetMapping("/users")
    @ResponseBody
    fun getBlogUsers(): List<User>? {
        return usersService.fetchUsers()
    }

    @GetMapping("/posts")
    @ResponseBody
    fun getBlogPosts(): List<Post>? {
        return postService.fetchPosts()
    }

    @GetMapping("/stitch")
    @ResponseBody
//    @WithSpan
    fun getDecoratedPosts(): List<BlogResponse?>? {
        return blogService.stitchUsersAndPosts()
    }
}