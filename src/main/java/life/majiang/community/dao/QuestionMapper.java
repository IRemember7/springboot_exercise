package life.majiang.community.dao;

import life.majiang.community.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface QuestionMapper {
    public int insertQuestion(@Param("question")Question question);
}
