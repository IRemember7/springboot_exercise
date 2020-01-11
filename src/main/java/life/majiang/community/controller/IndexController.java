package life.majiang.community.controller;

import life.majiang.community.entity.Questiondto;
import life.majiang.community.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @GetMapping(value ={"/","/index.html","/index","/main"})
    public String getIndex(Model model){
        List<Questiondto> questiondtos = indexService.getIndexQuestion();
        model.addAttribute("questions",questiondtos);
        return "index";
    }
}
