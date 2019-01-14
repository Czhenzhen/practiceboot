package com.wisely.security.control;

import com.wisely.security.entity.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 *
 * @author changzhenzhen
 * @date 2019-01-09
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    @ResponseBody
    public String index(Model model) {
        Msg msg = new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg",msg);
        return "index";
    }


}
