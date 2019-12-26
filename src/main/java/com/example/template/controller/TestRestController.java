package com.example.template.controller;

import com.example.template.data.MyClassJDBCDAO;
import com.example.template.model.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TestRestController {

    @Autowired
    MyClassJDBCDAO jdbcDAO;

    @RequestMapping("/v1/retrieve")
    public List<MyClass> controllerMethod(Model model) {

        List<MyClass> dbData = jdbcDAO.getMyClassData();
        return dbData;
    }

}
