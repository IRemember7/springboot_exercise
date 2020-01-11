package life.majiang.community.dao;

import life.majiang.community.entity.Question;
import life.majiang.community.entity.Questiondto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface QuestionMapper {
    int insertQuestion(@Param("question")Question question);

    List<Question> getIndexQuestion(@Param("page")int page ,@Param("size") int size);

    int countQuestion();
}
