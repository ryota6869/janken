package oit.is.z0614.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {
  @Select("select * from matches;")
  ArrayList<Match> selectAllMatches();

  @Insert("insert into matches (user1,user2,user1Hand,user2Hand) VALUES (2,1,#{playerHand},#{cpuHand});")
  void insertMatch(Janken janken);
}
