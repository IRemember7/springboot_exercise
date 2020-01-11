package life.majiang.community.service;

import life.majiang.community.dao.QuestionMapper;
import life.majiang.community.dao.UserMapper;
import life.majiang.community.entity.Question;
import life.majiang.community.entity.Questiondto;
import life.majiang.community.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public List<Questiondto> getIndexQuestion() {
        List<Question> questions= questionMapper.getIndexQuestion();
        List<Questiondto> questiondtos = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            Questiondto questiondto = new Questiondto();
            BeanUtils.copyProperties(question,questiondto);
            questiondto.setUser(user);
            questiondtos.add(questiondto);
        }
        return questiondtos;
    }
}
