package com.xu.mircoservice.commeclient.service;

import com.xu.mircoservice.commeclient.model.CommentVo;

import java.util.List;

public interface CommentService {
    public List<CommentVo> getUserComments(Long userId);
    public List<CommentVo> getProductComments(Long productId);
}
