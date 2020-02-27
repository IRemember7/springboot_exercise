package life.majiang.community.controller;

import life.majiang.community.entity.Question;
import life.majiang.community.entity.Questiondto;
import life.majiang.community.entity.User;
import life.majiang.community.service.QuestionService;
import life.majiang.community.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    private QuestionService questionService;
    @RequestMapping("/profile/{action}")
    public String questions(Model model,
                            @PathVariable(name = "action") String action,
                            HttpSession httpSession,
                            @RequestParam(value = "page" ,defaultValue = "1" ) Integer page){
        User user = (User) httpSession.getAttribute("user");
        if ("questions".equals(action)) {
            //获取数据库总记录数
            int totalCount = questionService.myCountQuestion(user.getUserId());
            //每页大小
            int pageSize = 5;
            // 使用页面帮助类计算页数和当前页数
            PageResult pageResult = new PageResult(totalCount, pageSize, page);
            List<Question> questions = questionService.getMyQuestion(pageResult, user.getUserId());
            model.addAttribute("questions", questions);
            model.addAttribute("nowPage", page);
            model.addAttribute("totalCount", pageResult.getTotalPage());
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        }else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }
        return "profile";
    }



}
