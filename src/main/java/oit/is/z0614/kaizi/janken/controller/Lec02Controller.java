package oit.is.z0614.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z0614.kaizi.janken.model.Entry;
import oit.is.z0614.kaizi.janken.model.Janken;
import oit.is.z0614.kaizi.janken.model.Match;
import oit.is.z0614.kaizi.janken.model.MatchMapper;
import oit.is.z0614.kaizi.janken.model.User;
import oit.is.z0614.kaizi.janken.model.UserMappaer;
import oit.is.z0614.kaizi.janken.service.AsyncKekka;
import oit.is.z0614.kaizi.janken.model.MatchInfo;
import oit.is.z0614.kaizi.janken.model.MatchInfoMapper;

@Controller

public class Lec02Controller {
  @Autowired
  private Entry entry;

  @Autowired
  UserMappaer userMappaer;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  MatchInfoMapper matchInfoMapper;

  @Autowired
  private AsyncKekka acKekka;

  @GetMapping("/lec02")
  public String lec02(Principal principal, ModelMap model) {
    String loginUser = principal.getName();
    this.entry.addUser(loginUser);
    ArrayList<User> users = userMappaer.selectAllUsers();
    model.addAttribute("users", users);
    ArrayList<Match> matchs = matchMapper.selectAllMatches();
    ArrayList<MatchInfo> mInfos = matchInfoMapper.selectTrueMatchinfo();
    model.addAttribute("mInfos", mInfos);
    model.addAttribute("matchs", matchs);
    model.addAttribute("entry", this.entry);
    model.addAttribute("loginUser", loginUser);
    return "lec02.html";
  }

  @GetMapping("/lec02janken")
  @Transactional
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

  @GetMapping("/match")
  @Transactional
  public String match(@RequestParam Integer id, Principal prin, ModelMap model){
    User user = userMappaer.selectByid(id);
    model.addAttribute("login_user", prin.getName());
    model.addAttribute("user", user);
    return "match.html";
  }

  @GetMapping("/wait")
  @Transactional
  public String wait(@RequestParam Integer id, @RequestParam String hand, Principal prin, ModelMap model) {
    MatchInfo mInfo = new MatchInfo();
    ArrayList<MatchInfo> mInfos = matchInfoMapper.selectTrueMatchinfo();
    Match match = new Match();
    boolean matchingFlag = false;

    model.addAttribute("login_user", prin.getName());
    User player = userMappaer.selectByName(prin.getName());
    User othUser = userMappaer.selectByid(id);

    for (MatchInfo mi : mInfos) {
      if (mi.getUser1() == othUser.getId() && mi.getUser2() == player.getId()) {
        match.setAllData(player, othUser, hand, mi.getUser1Hand());
        matchMapper.insertMatch(match);
        matchingFlag = true;
        break;
      }
    }
    if (matchingFlag == false) {
      mInfo.setAllData(player, othUser, hand);
      matchInfoMapper.insertMatchInfo(mInfo);
    }
    return "wait.html";
  }

  @GetMapping("/result")
  public SseEmitter showResult() {
    final SseEmitter sseEmitter = new SseEmitter();
        this.acKekka.asnyShowMatchResult(sseEmitter);
        return sseEmitter;
  }
}
