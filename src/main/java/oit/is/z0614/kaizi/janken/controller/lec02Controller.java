package oit.is.z0614.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0614.kaizi.janken.model.Entry;
import oit.is.z0614.kaizi.janken.model.Janken;

@Controller

public class lec02Controller {
  @Autowired
  private Entry entry;

  @GetMapping("/lec02")
  public String lec02() {
    return "lec02.html";
  }

  @PostMapping("/lec02")
  public String lec02(@RequestParam String name, ModelMap model) {
    model.addAttribute("name", name);
    return "lec02.html";
  }

  @GetMapping("/lec02janken")
  public String jankenResalut(@RequestParam String hand, ModelMap model, Principal prin) {
    String loginUser = prin.getName();
    Janken janken = new Janken(hand);

    this.entry.addUser(loginUser);
    model.addAttribute("users", this.entry.getUsers());
    model.addAttribute("janken", janken);
    return "lec02.html";
  }
}
