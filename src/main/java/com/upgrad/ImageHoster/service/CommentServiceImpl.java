package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.common.CommentManager;
import com.upgrad.ImageHoster.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentManager commentManager;

    public CommentServiceImpl() {
        commentManager = new CommentManager();
    }


    @Override
    public void save(Comment comment) { commentManager.saveComment(comment); }


}
