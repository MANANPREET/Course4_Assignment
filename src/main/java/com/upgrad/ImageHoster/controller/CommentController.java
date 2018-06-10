package com.upgrad.ImageHoster.controller;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.ImageService;
import com.upgrad.ImageHoster.service.UserService;
import com.upgrad.ImageHoster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    /**
     * This method adds a comment to a specific image from the database
     *
     * @param id id of the image that we want to delete
     * @param comment comment of the  image
     *
     * @return redirects the images page
     */
    @RequestMapping("/image/{id}/comments/create")
    public String addComment(@PathVariable Integer id,
                             @RequestParam("comment") String comment,
                             HttpSession session
    ) {

        User currUser = (User) session.getAttribute("currUser");
        // if the user is not logged in, redirect to the home page
        if(currUser == null ){
            return "redirect:/";
        }
        else {

            Image image = imageService.getById(id);

            Comment newComment = new Comment(comment, currUser, image);
            commentService.save(newComment);

            return "redirect:/images/" + id ;
        }

    }
}
