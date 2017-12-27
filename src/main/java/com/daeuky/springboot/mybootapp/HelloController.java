package com.daeuky.springboot.mybootapp;

import com.daeuky.springboot.mybootapp.entities.MyData;
import com.daeuky.springboot.mybootapp.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    MyDataRepository myDataRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("formModel") MyData myData, ModelAndView mav) {
        mav.setViewName("index");
        Iterable<MyData> list = myDataRepository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("formModel") MyData myData, ModelAndView mav) {
        myDataRepository.saveAndFlush(myData);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/other")
    public String other() {
        return "redirect:/";
    }

    @RequestMapping("/home")
    public String home() {
        return "forward:/";
    }
}