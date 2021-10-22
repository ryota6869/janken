package oit.is.z0614.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0614.kaizi.janken.model.Entry;
import oit.is.z0614.kaizi.janken.model.Janken;
import oit.is.z0614.kaizi.janken.model.Match;
import oit.is.z0614.kaizi.janken.model.MatchMapper;
import oit.is.z0614.kaizi.janken.model.User;
import oit.is.z0614.kaizi.janken.model.UserMappaer;

@Controller

public class lec02Controller {
  @Autowired
  private Entry entry;

  @Autowired
  UserMappaer userMappaer;

  @Autowired
  MatchMapper matchMapper;

  @GetMapping("/lec02")
  public String lec02(Principal principal, ModelMap model) {
    String loginUser = principal.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("entry", this.entry);
    model.addAttribute("loginUser", loginUser);
    return "lec02.html";
  }

  @GetMapping("/lec02janken")
  public String jankenResalut(@RequestParam String hand, ModelMap model) {

    Janken janken = new Janken(hand);
    model.addAttribute("janken", janken);
    model.addAttribute("entry", this.entry);
    ArrayList<User> users = userMappaer.selectAllUsers();
    model.addAttribute("users", users);
    ArrayList<Match> matchs = matchMapper.selectAllMatches();
    model.addAttribute("matchs", matchs);
    return "lec02.html";
  }
}
