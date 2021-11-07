package oit.is.z0614.kaizi.janken.model;

import oit.is.z0614.kaizi.janken.model.User;

public class MatchInfo {
  int playerId;
  int othUserId;
  String playerHand;
  boolean isActive;

  public MatchInfo(User player, User othUser, String playerHand){
    this.setPlayerId(player.getId());
    this.setOthUserId(othUser.getId());
    this.setPlayerHand(playerHand);
    this.setActive(true);
  }

  public int getPlayerId() {
    return playerId;
  }
  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }
  public int getOthUserId() {
    return othUserId;
  }
  public void setOthUserId(int othUserId) {
    this.othUserId = othUserId;
  }
  public String getPlayerHand() {
    return playerHand;
  }
  public void setPlayerHand(String playerHand) {
    this.playerHand = playerHand;
  }
  public boolean isActive() {
    return isActive;
  }
  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

}
