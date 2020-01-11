package life.majiang.community.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Questiondto extends Question{
    private User user;//多对一级联查询 问题创建者
}
