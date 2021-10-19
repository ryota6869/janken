package oit.is.z0614.kaizi.janken.model;

import java.util.Random;

public class Janken {
  String playerHand = new String();
  String cpuHand = new String();
  String result = new String();

  public Janken(String playerHand) {
    this.setPlayerHand(playerHand);
    this.initCPUHand();
    this.play();
  }

  private void initCPUHand() {
    int randNum;
    Random rand = new Random();

    randNum = rand.nextInt(3);
    if (randNum == 0) {
      this.cpuHand = "Gu";
    } else if (randNum == 1) {
      this.cpuHand = "Tyoki";
    } else if (randNum == 2) {
      this.cpuHand = "Pa";
    }
  }

  public void play() {

    if (playerHand.equals(cpuHand)) {
      this.result = "draw";
    } else if ((playerHand.equals("Gu") && cpuHand.equals("Tyoki"))
        || (playerHand.equals("Tyoki") && cpuHand.equals("Pa"))
        || ((playerHand.equals("Pa") && cpuHand.equals("Gu")))) {
      this.result = "You win!";
    } else if ((playerHand.equals("Gu") && cpuHand.equals("Pa"))
        || (playerHand.equals("Tyoki") && cpuHand.equals("Gu"))
        || (playerHand.equals("Pa") && cpuHand.equals("Tyoki"))) {
      this.result = "You lose...";
    }
  }

  public String getPlayerHand() {
    return playerHand;
  }

  public void setPlayerHand(String playerHand) {
    this.playerHand = playerHand;
  }

  public String getCpuHand() {
    return cpuHand;
  }

  public void setCpuHand(String cpuHand) {
    this.cpuHand = cpuHand;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }


}
