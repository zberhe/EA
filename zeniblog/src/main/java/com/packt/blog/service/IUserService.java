/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.blog.service;

import com.packt.blog.domain.Comment;
import com.packt.blog.domain.Post;
import com.packt.blog.domain.User;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author nimaclara
 */
public interface IUserService {

    Collection<User> getAllUsers();

    User getUserByUsername(String username);

    public void addPost(String username, Post post);

    public Collection<Post> getAllPosts();

    public void editPost(Post post);

    public void deletePost(int postId);

    void addComment(int postId, Comment comment);

    void editComment(int postId, Comment comment);

    //public void removeComment(int postId, Comment comment);
     public void removeComment(int commentId);

    void addUser(User user);

    public List<Post> getPostByUsername(String username);

    public Post getPostById(int postId);
     public List<Comment> getCommentByPostId(int postId);
      public void editPost(String username,Post post);
    

}
