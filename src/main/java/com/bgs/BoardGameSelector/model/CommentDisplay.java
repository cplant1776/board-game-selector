package com.bgs.BoardGameSelector.model;

public class CommentDisplay {

    public Integer commentId;
    public Integer userId;
    public String content;
    public Integer replyTo;
    public String username;
    public String avatar;

    public CommentDisplay(Integer commentId, Integer userId, String content, Integer replyTo, String username, String avatar) {
        this.commentId = commentId;
        this.userId = userId;
        this.content = content;
        this.replyTo = replyTo;
        this.username = username;
        this.avatar = avatar;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
