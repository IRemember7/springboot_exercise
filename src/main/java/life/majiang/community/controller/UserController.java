package life.majiang.community.controller;

import life.majiang.community.entity.User;
import life.majiang.community.service.UserService;
import life.majiang.community.util.FileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;

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

    @PostMapping("/register")
    public String userRegister(@RequestParam String accountId,
                               @RequestParam String userPassword,
                               @RequestParam String userName,
                               @RequestParam("inputImg") MultipartFile file,
                               Model model){
        String userImg = FileSave.upload(file);
        System.out.println(accountId);
        if (userImg.equals("请选择文件")){
            model.addAttribute("msg","请添加图片作为您的头像");
            return "register.html";
        }else if (accountId.equals("")){
            model.addAttribute("msg","用户名不能为空");
            return "register.html";
        }else if(userPassword.equals("")){
            model.addAttribute("msg","密码不能为空");
            return "register.html";
        }else {
            User user = new User();
            user.setAccountId(accountId);
            user.setUserPassword(userPassword);
            user.setUserName(userName);
            user.setUserCreate(new Date());
            user.setUserImg(userImg);
            int result = userService.registerUser(user);
            if (result>0)
                return "login.html";
            else {
                model.addAttribute("msg","注册失败");
                return "register.html";
            }
        }

    }
}
