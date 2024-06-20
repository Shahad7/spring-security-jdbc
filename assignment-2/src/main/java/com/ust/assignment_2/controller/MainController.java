package com.ust.assignment_2.controller;

import com.ust.assignment_2.model.Employee;
import com.ust.assignment_2.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    MainService service;
    @GetMapping(value = "/employee")
    public String getExpDevs(Model model){
        model.addAttribute("employees",service.getExpDevs());
        return "main";
    }

    @GetMapping("/")
    public String returnHome(){
        return "home";
    }

    @GetMapping("/login")
    public String returnLogin(){
        return "login";
    }

    @GetMapping("/free")
    public String returnFree(){
        return "free";
    }

    @GetMapping("/admin")
    public String returnAdmin(){
        return "admin";
    }


    @GetMapping("/encode")
    public String encode() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode( "zxcv");
    }


    @PostMapping("/signup")
    public String signup(@RequestBody Map body){
        String username = (String) body.get("username");
        String passwd = (String) body.get("password");
        String authority = (String) body.get("authority");
        String encodedPasswd = new BCryptPasswordEncoder().encode(passwd);
        Connection conn;
        try {
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","rootcapsx");
            PreparedStatement stmt = conn.prepareStatement("insert into users (username, password,enabled) values(?,?,?)");
            stmt.setString(1,username);
            stmt.setString(2,encodedPasswd);
            stmt.setBoolean(3,true);
            stmt.execute();

            PreparedStatement stmt1 = conn.prepareStatement("insert into authorities (username, authority) values(?,?)");
            stmt1.setString(1,username);
            stmt1.setString(2,authority);
            stmt1.execute();
            return "success";
        } catch (SQLException e) {
            return "failure "+e.getMessage();
        }


    }

}
