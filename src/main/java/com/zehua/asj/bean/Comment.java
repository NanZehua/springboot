package com.zehua.asj.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer positiveId;

    @Column(name = "note_id")
    private Integer noteId;

    @Column(name = "note_user_id")
    private Integer noteUserId;

    @Column(name = "reply_user_id")
    private Integer replyUserId;

    @Column(name = "reply_context")
    private String positiveContext;

    @Column(name = "reply_date")
    private Date replyDate;

    @Column(name = "true_upvote")
    private Integer trueUpvote;

    @Column(name = "false_upvote")
    private Integer falseUpvote;

    public Integer getPositiveId() {
        return positiveId;
    }

    public void setPositiveId(Integer positiveId) {
        this.positiveId = positiveId;
    }

    public String getPositiveContext() {
        return positiveContext;
    }

    public void setPositiveContext(String positiveContext) {
        this.positiveContext = positiveContext;
    }

    public Integer getTrueUpvote() {
        return trueUpvote;
    }

    public void setTrueUpvote(Integer trueUpvote) {
        this.trueUpvote = trueUpvote;
    }

    public Integer getFalseUpvote() {
        return falseUpvote;
    }

    public void setFalseUpvote(Integer falseUpvote) {
        this.falseUpvote = falseUpvote;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getNoteUserId() {
        return noteUserId;
    }

    public void setNoteUserId(Integer noteUserId) {
        this.noteUserId = noteUserId;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
