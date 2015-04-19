package com.hotels.controller;

import com.hotels.form.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;
import java.util.Map;
/**
 * Created by sandeep on 4/19/2015.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String showLoginForm(ModelMap modelMap) {
        logger.debug("In login Controller");
        modelMap.addAttribute("userForm", new User());
        return "login";

    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("userForm") User userForm,
                          BindingResult result, Map<String, Object> model) {

        if (result.hasErrors()) {
            return "login";
        }
        ModelAndView modelObj = new ModelAndView();
        modelObj.setViewName("index");
        modelObj.addObject("name", userForm.getUserName());

        return "index";
    }


}
