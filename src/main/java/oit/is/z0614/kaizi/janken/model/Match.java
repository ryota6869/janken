package oit.is.z0614.kaizi.janken.model;

public class Match {
  int id;
  String user1Hand;
  int user1;
  String user2Hand;
  int user2;
  boolean isActive;


  public void setAllData(User user1, User user2, String hand1, String hand2) {
    this.setUser1(user1.getId());
    this.setUser2(user2.getId());
    this.setUser1Hand(hand1);
    this.setUser2Hand(hand2);
    this.setActive(true);
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getUser1Hand() {
    return user1Hand;
  }
  public void setUser1Hand(String user1Hand) {
    this.user1Hand = user1Hand;
  }
  public int getUser1() {
    return user1;
  }
  public void setUser1(int user1) {
    this.user1 = user1;
  }
  public String getUser2Hand() {
    return user2Hand;
  }
  public void setUser2Hand(String user2Hand) {
    this.user2Hand = user2Hand;
  }
  public int getUser2() {
    return user2;
  }
  public void setUser2(int user2) {
    this.user2 = user2;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

}
