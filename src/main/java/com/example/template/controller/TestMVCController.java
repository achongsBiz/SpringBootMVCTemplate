package com.example.template.controller;

import com.example.template.data.MyClassJDBCDAO;
import com.example.template.model.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class TestMVCController {

    @Autowired
    MyClassJDBCDAO jdbcDAO;

    @RequestMapping("/")
    public String controllerMethod(Model model) {


        List<MyClass> dbData = jdbcDAO.getMyClassData();
        model.addAttribute("dbData", dbData);

        return "samplePage";
    }

}
