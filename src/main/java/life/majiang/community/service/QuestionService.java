package life.majiang.community.service;

import life.majiang.community.dao.QuestionMapper;
import life.majiang.community.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    public int insertQuestion(Question question){
        int result = questionMapper.insertQuestion(question);
        return result;
    }
}
