package oit.is.z0614.kaizi.janken.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z0614.kaizi.janken.model.Match;
import oit.is.z0614.kaizi.janken.model.MatchMapper;

@Service
public class AsyncKekka {
  boolean dbUpdated = false;

  private final Logger logger = LoggerFactory.getLogger(AsyncKekka.class);

  @Autowired
  MatchMapper matchMapper;

  public Match syscSetFalseActiveMatch(Match match) {
    matchMapper.updateFalseIsactive(match);
    return match;
  }

  public Match syscShowMatch() {

    return matchMapper.selectActiveTrueMatch();
  }

  @Async
  public void asnyShowMatchResult(SseEmitter emitter) {
    dbUpdated = true;
    try {
      while (true) {
        if (dbUpdated == false) {
          TimeUnit.MILLISECONDS.sleep(100);
          continue;
        }
        Match match = this.syscShowMatch();
        emitter.send(match);
        TimeUnit.MILLISECONDS.sleep(1000);
        dbUpdated = false;
        this.syscSetFalseActiveMatch(match);
      }
    } catch (Exception e) {
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
    } finally {
      emitter.complete();
    }
  }
}
