package com.upgrad.ImageHoster.common;


import com.upgrad.ImageHoster.model.Comment;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import java.util.List;

@SuppressWarnings("unchecked")
public class CommentManager extends SessionManager{

    /**
     * This method saves an comment data to the database
     *
     * @param comment the Comment that we want to save to the database
     */
    public void saveComment(final Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
    }

}
