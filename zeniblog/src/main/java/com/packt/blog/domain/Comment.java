/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.blog.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Zehafta M
 */
@Entity
public class Comment{

    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.DATE)
    private Date commentDate;
    @NotEmpty
    private String content;
      private String commenter;

    public Comment() {
    }
//     public Comment(Date commentDate,String content) {
//         this.commentDate=commentDate;
//         this.content=content;
//         //this.commenter=commenter;
//    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }
    
}
