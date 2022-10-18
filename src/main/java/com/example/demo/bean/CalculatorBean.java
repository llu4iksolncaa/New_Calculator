package com.example.demo.bean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CalculatorBean {



    @GetMapping("/")
    public String HOME( Model model) {
        return "HOME";
    }

    @GetMapping("/HOME")
    public String get(@RequestParam(value="first", required = false) double first,
                      @RequestParam(value="second", required = false) double second,
                      @RequestParam(value="operation", required = false ) String formula, Model model) {


        double solution = switch (formula) {
            case "+"-> first + second;
            case "-"-> first - second;
            case "*"-> first * second;
            case "/"-> first / second;
            default -> 0;
        };
        model.addAttribute("result", solution);

        return "RESULT";
    }

    @PostMapping("/HOME")
    public String post(@RequestParam(value="first", required = false) double first,
                       @RequestParam(value="second", required = false) double second,
                       @RequestParam(value="operation", required = false ) String operation, Model model) {


        double solution = switch (operation) {
            case "+"-> first + second;
            case "-"-> first - second;
            case "*"-> first * second;
            case "/"-> first / second;
            default -> 0;
        };
        model.addAttribute("result", solution);

        return "RESULT";
    }

}