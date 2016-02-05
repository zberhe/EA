package com.packt.blog.service.Impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.packt.blog.dao.IUserDao;
import com.packt.blog.domain.Comment;
import com.packt.blog.domain.Post;
import com.packt.blog.domain.User;
import com.packt.blog.service.IUserService;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zehafta M
 */
@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Collection<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        System.out.println("daf" + user.getEmail());
        userDao.addUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUser(username);
    }

    @Override
    public List<Post> getPostByUsername(String username) {

        return userDao.getAllPostsByUsername(username);
    }

    @Override
    public void addPost(String username, Post post) {
        userDao.addPost(username, post);
    }

    @Override
    public Collection<Post> getAllPosts() {
        return userDao.getAllPosts();
    }

    @Override
    public void editPost(Post post) {
        userDao.editPost(post);
    }

    @Override
    public void deletePost(int postId) {
        userDao.deletePost(postId);
    }

    @Override
    public void addComment(int postId, Comment comment) {
        userDao.addComment(postId,comment);
   
    }

    @Override
    public void removeComment(int commentId) {
       //Post post = userDao.getPostById(postId);
        userDao.removeComment(commentId);
    }

    @Override
    public void editComment(int postId, Comment comment) {
        userDao.editComment(postId, comment);
    }

    @Override
    public Post getPostById(int postId) {
        return userDao.getPostById(postId);
    }

    @Override
    public List<Comment> getCommentByPostId(int postId) {
        return userDao.getCommentByPostId(postId);
    }
     @Override
    public void editPost(String username,Post post) {
        userDao.editPost(username,post);
    }
    
}
