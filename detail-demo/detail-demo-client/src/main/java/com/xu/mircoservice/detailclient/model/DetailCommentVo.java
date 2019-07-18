package com.xu.mircoservice.detailclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
public class DetailCommentVo implements Serializable {
    private Long productId;
    private Long userId;
    private Long subOrderId;

    private String productName;
    private String catName;

    private Date commentTime;
    private String content;
}
