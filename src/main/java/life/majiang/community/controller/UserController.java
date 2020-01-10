package life.majiang.community.controller;

import life.majiang.community.entity.User;
import life.majiang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public String userLogin(@RequestParam String accountId,
                            @RequestParam String userPassword,
                            HttpSession httpSession){
        if (StringUtils.isEmpty(accountId) || StringUtils.isEmpty(userPassword)) {
            httpSession.setAttribute("errorMsg", "用户名或密码不能为空");
            return "login.html";
        }
        User user = userService.userLogin(accountId,userPassword);
        if (user !=null){
            httpSession.setAttribute("user", user);
            return "redirect:/main";
        }else {
            httpSession.setAttribute("errorMsg", "登陆失败");
            return "login.html";
        }
    }
}
