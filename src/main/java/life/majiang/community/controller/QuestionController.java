package life.majiang.community.controller;

import life.majiang.community.entity.Question;
import life.majiang.community.entity.Questiondto;
import life.majiang.community.entity.User;
import life.majiang.community.service.QuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
//发布问题
    @PostMapping("/publish")
    @ResponseBody
    public Map publish(@Param("question")Question question,
                          HttpSession httpSession){
        Map<String,String> map = new HashMap<String, String>();
        System.out.println(question);
        if (httpSession.getAttribute("user") == null){
            System.out.println("1");
            map.put("msg","请先登录后再发起提问！！");
            return map;
        }
        else if (question.getTitle().equals("")){
            System.out.println("2");
            map.put("msg","标题不能为空");
            return map;
        }
        else if (question.getDescription().equals("")){
            System.out.println("3");
            map.put("msg","问题详情不能为空");
            return map;
        }
        else if (question.getTag().equals("")){
            System.out.println("4");
            map.put("msg","标签不能为空");
            return map;
        }else {
            System.out.println("5");
            question.setCreateTime(new Date());
            User user = (User) httpSession.getAttribute("user");
            question.setCreator(user.getUserId());
            int result = questionService.insertQuestion(question);
            if (result>0){
                map.put("msg","问题提交成功！！");
                return map;
            }
            else {
                map.put("msg","提问失败请重新提问！！");
                return map;
            }
        }

    }
    //查看问题
    @GetMapping("/question/{id}")
    public String question(@PathVariable("id")int id,
                           Model model){
        Questiondto questiondto = questionService.getQuestionId(id);
        model.addAttribute("question",questiondto);
        return "question";
    }
}
