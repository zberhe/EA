/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.blog.dao;

import com.packt.blog.domain.Comment;
import com.packt.blog.domain.Post;
import com.packt.blog.domain.User;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Zehafta M
 */
public interface IUserDao {

    Collection<User> getAllUsers();

    void addUser(User user);

    public User getUser(String login);
    Collection<Post> getAllPosts();

    void addPost(String username,Post post);

    void editPost(Post post);

    void deletePost(int id);
    public List<Post> getAllPostsByUsername(String username);
    void editComment(int postId, Comment comment);

    void removeComment(int id);

    Post getPostById(int postId);
     Comment getCommentById(int commentId);
     List<Comment> getCommentByPostId(int postId);

   void addComment(int postId, Comment comment);
     public void editPost(String username,Post post);
}
