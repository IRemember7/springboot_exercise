package life.majiang.community.dao;

import life.majiang.community.entity.Question;
import life.majiang.community.entity.Questiondto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface QuestionMapper {
    public int insertQuestion(@Param("question")Question question);

    public List<Question> getIndexQuestion();
}
