package com.packt.blog.controller;

import com.packt.blog.domain.Comment;
import com.packt.blog.domain.Post;
import com.packt.blog.domain.User;

import com.packt.blog.service.IUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewUserForm(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "registerUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewUserForm(@ModelAttribute("newUser") @Valid User newUser, BindingResult result) {
        if (!result.hasErrors()) {
            userService.addUser(newUser);
            return "redirect:/login";
        } else {
            return "registerUser";
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String viewPostByUsername(@PathVariable String username, Model model) {
        model.addAttribute("posts", userService.getPostByUsername(username));
        return "userpost";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String printUser(ModelMap model) {
        model.addAttribute("allposts", userService.getAllPosts());
        return "allPosts";

    }

    //edit post
    @RequestMapping(value = "/edit", params = "id", method = RequestMethod.GET)
    public String updatePost(@RequestParam("id") int postId, Model model) {
        model.addAttribute("postToEdit", userService.getPostById(postId));
        //model.addAttribute("postToEdit",userService.editPost(post)); 
        return "editPost";
    }

    @RequestMapping(value = "/edit", params = "id", method = RequestMethod.POST)
    public String updatePostButton(@ModelAttribute("postToEdit") Post post) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        userService.editPost(username, post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public String getCreatePostForm(Model model) {
        Post newPost = new Post();
        model.addAttribute("newPost", newPost);
        return "createPost";
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String CreatePost(@ModelAttribute("newPost") @Valid Post post, BindingResult result) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if (!result.hasErrors()) {

            userService.addPost(username, post);
            return "redirect:/posts";
        } else {
            return "createPost";
        }

    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public String getPostToComment(Model model, @ModelAttribute("comment") Comment comment, @PathVariable("id") int postId) {
        model.addAttribute("post", userService.getPostById(postId));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username", username);
        model.addAttribute("comments", userService.getCommentByPostId(postId));
        return "comment";

    }

    @RequestMapping(value = "/comment/{postId}", method = RequestMethod.POST)
    public String CreateComment(@ModelAttribute("comment") @Valid Comment comment, BindingResult result, @PathVariable("postId") int postId) {
//        userService.addComment(postId, comment);
//        return "redirect:/comment/{postId}";
        if (!result.hasErrors()) {
            userService.addComment(postId, comment);
            return "redirect:/comment/{postId}";
        } else {
            return "redirect:/comment/{postId}"; //? NO PRG violated?
        }
    }

    @RequestMapping("/posts")
    public String postList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("posts", userService.getPostByUsername(username));
        return "posts";
    }

    //Delete post
    @RequestMapping(value = "/delete", params = "id", method = RequestMethod.GET)
    public String deletePost(@RequestParam("id") int postId, Model model) {
        userService.deletePost(postId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("posts", userService.getPostByUsername(username));
        return "posts";
    }

    @RequestMapping(value = "/delete", params = "id", method = RequestMethod.POST)
    public String deletedPost(@ModelAttribute Comment comment, @RequestParam("id") int postId, RedirectAttributes att) {
        userService.deletePost(postId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        att.addFlashAttribute("posts", userService.getPostByUsername(username));
        return "redirect:/posts";
    }

    //Delete comment
    @RequestMapping(value = "/deleteComment", params = "id", method = RequestMethod.GET)
    public String deleteComment(@ModelAttribute Comment comment, @RequestParam("id") int commentId, @RequestParam("postId") int postId, Model model) {
        userService.removeComment(commentId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username", username);
        model.addAttribute("post", userService.getPostById(postId));
        model.addAttribute("comments", userService.getCommentByPostId(postId));
        return "comment";
    }

}
