package com.jbit.dao;

import java.util.List;

import com.jbit.entity.Comment;

public interface CommentDao {
	Integer findCommentByPid(Integer pid);
	
	void insertComment(Comment comment);
	
	List<Comment> findPageList(Integer first,Integer max,Integer pid);
	
	Integer findcount(Integer pid);
}
