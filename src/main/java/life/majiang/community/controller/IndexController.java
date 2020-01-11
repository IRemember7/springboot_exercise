package life.majiang.community.controller;

import life.majiang.community.entity.Questiondto;
import life.majiang.community.service.IndexService;
import life.majiang.community.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @GetMapping(value ={"/index.html","/index","/main","/"})
    public String getIndex(Model model,
                           @RequestParam(value = "page" ,defaultValue = "1" ) Integer page){
        //获取数据库总记录数
        int totalCount = indexService.countQuestion();
        //每页大小
        int pageSize = 5;
        PageResult pageResult = new PageResult(totalCount,pageSize,page);
        List<Questiondto> questiondtos = indexService.getIndexQuestion(pageResult);
        model.addAttribute("questions",questiondtos);
        model.addAttribute("nowPage",page);
        model.addAttribute("totalCount",pageResult.getTotalPage());
        return "index";
    }
}
