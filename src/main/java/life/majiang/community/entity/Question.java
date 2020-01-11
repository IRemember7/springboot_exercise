package life.majiang.community.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Question {
    private Integer questionId;
    private String title;
    private String  description;
    private Date createTime;
    private Date modifiedTime;
    private String commentCount;
    private String viewCount;
    private String likeCount;
    private String tag;
    private int creator;
    private int active;
}
