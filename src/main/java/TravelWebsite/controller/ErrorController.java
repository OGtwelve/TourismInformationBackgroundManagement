package TravelWebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author 3187102230 王佳宝 旅游网 异常以及非管理用户登入
 */
@Controller
@RequestMapping(path ="/error")
public class ErrorController {
    @RequestMapping("")
    public ModelAndView error(ModelAndView modelAndView, HttpSession session){
        modelAndView.setViewName("/error");
        return modelAndView;
    }
}
