package com.zehua.asj.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_note")
public class Note implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer noteId;

//    @Column(name = "user_id")
//    private Integer userId;

    @Column(name = "note_context")
    private String noteContext;

    @Column(name = "note_date")
    private Date noteDate;

    @Column(name = "true_upvote")
    private Integer trueUpvote;

    @Column(name = "false_upvote")
    private Integer falseUpvote;

    @Column(name = "scan_num")
    private Long scanNum;

    public Long getScanNum() {
        return scanNum;
    }

    public void setScanNum(Long scanNum) {
        this.scanNum = scanNum;
    }

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public Integer getFalseUpvote() {
        return falseUpvote;
    }

    public void setFalseUpvote(Integer falseUpvote) {
        this.falseUpvote = falseUpvote;
    }

    public Integer getTrueUpvote() {
        return trueUpvote;
    }

    public void setTrueUpvote(Integer trueUpvote) {
        this.trueUpvote = trueUpvote;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getNoteContext() {
        return noteContext;
    }

    public void setNoteContext(String noteContext) {
        this.noteContext = noteContext;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
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
