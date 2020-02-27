package life.majiang.community.service;

import life.majiang.community.dao.QuestionMapper;
import life.majiang.community.dao.UserMapper;
import life.majiang.community.entity.Question;
import life.majiang.community.entity.Questiondto;
import life.majiang.community.entity.User;
import life.majiang.community.util.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public int insertQuestion(Question question){
        int result = questionMapper.insertQuestion(question);
        return result;
    }

    public int myCountQuestion(int creator){
        return questionMapper.myCountQuestion(creator);
    }

    public List<Question> getMyQuestion(PageResult pageResult,int creator){
        List<Question> questions= questionMapper.getMyQuestion(pageResult.getCurrPage(),pageResult.getPageSize(),creator);
        return questions;

    }

    public Questiondto getQuestionId(int id) {
        Question question =questionMapper.getQuestionByid(id);
        Questiondto questiondto = new Questiondto();
//        复制
        BeanUtils.copyProperties(question,questiondto);
        User user = userMapper.findById(question.getCreator());
        questiondto.setUser(user);
        return questiondto;
    }
}
