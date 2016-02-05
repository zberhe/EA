/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.blog.dao.Impl;

import com.packt.blog.dao.IUserDao;
import com.packt.blog.domain.Comment;
import com.packt.blog.domain.Post;
import com.packt.blog.domain.Role;
import com.packt.blog.domain.User;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zehafta M
 */
@Transactional
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {

    }

//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
    @Override
    public Collection<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User getUser(String username) {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.username = :username");
        query.setParameter("username", username);
        userList = query.list();
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override

    public void addUser(User user) {

        Role r = new Role();
        r.setName("USER_ROLE");
        List<Role> roles = new ArrayList<>();

        roles.add(r);
        user.setAuthorities(roles);
//        sessionFactory.getCurrentSession().persist(r);
        sessionFactory.getCurrentSession().persist(user);

    }

    //edit a comment
    @Override
    public void editPost(String username, Post post) {
        User user = getUser(username);
        post.setUser(user);
        openSession().merge(post);
    }

    @Override
    public Collection<Post> getAllPosts() {
        return sessionFactory.getCurrentSession().createQuery("from Post").list();
    }

    @Override
    public void addPost(String username, Post post) {
        User user = getUser(username);
        post.setUser(user);
        user.addPost(post);

        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void editPost(Post post) {
        sessionFactory.getCurrentSession().merge(post);
    }

    @Override
    public void deletePost(int id) {
        Query query = openSession().createQuery("delete from Post p where p.id = :id");

        query.setParameter("id", id);
        query.executeUpdate();
    }

//    @Override
//    public Post getPostById(int post_id) {
//       return (Post)sessionFactory.getCurrentSession().ge
//    }
    @Override
    public List<Post> getAllPostsByUsername(String username) {
        List<Post> postList = new ArrayList<Post>();
        Query query = openSession().createQuery("from Post p where p.user.username = :username");
        query.setParameter("username", username);
        postList = query.list();
        if (postList.size() > 0) {
            return postList;
        } else {
            return null;
        }
    }

    /////////////////////////////////////////////////////////////////
    @Override
    public void editComment(int postId, Comment comment) {
        sessionFactory.getCurrentSession().merge(comment);
    }

    @Override
    public void removeComment(int id) {
//        Session s = sessionFactory.getCurrentSession();
//        s.delete(s.load(Comment.class, id));
        
         Query query = openSession().createQuery("delete from Comment c where c.id = :id");

        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Comment getCommentById(int commentId) {
        return (Comment) sessionFactory.getCurrentSession().get(Comment.class, commentId);
    }

    @Override
    public Post getPostById(int postId) {
        return (Post) sessionFactory.getCurrentSession().get(Post.class, postId);
    }

    @Override
    public List<Comment> getCommentByPostId(int postId) {
        List<Comment> commentList = new ArrayList<Comment>();
        Query query = openSession().createQuery("select c from Post p join p.comments c where p.id = :id");
        query.setParameter("id", postId);
        commentList = query.list();
        if (commentList.size() > 0) {
            return commentList;
        } else {
            return null;
        }
    }

    @Override
    public void addComment(int postId, Comment comment) {
        Post post = (Post) sessionFactory.getCurrentSession().get(Post.class, postId);
        System.out.println("Object founds" + post.getTitle() + " " + comment.getId());
        comment.setId(0);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        comment.setCommenter(username);
        post.addComment(comment);
        sessionFactory.getCurrentSession().update(post);
        //  sessionFactory.getCurrentSession().persist(comment);
    }

}
