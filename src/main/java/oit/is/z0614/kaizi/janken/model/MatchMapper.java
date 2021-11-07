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

  @Select("select * from matches where isactive = true")
  Match selectActiveTrueMatch();

  @Insert("insert into matches (user1,user2,user1Hand,user2Hand,isactive) VALUES (#{user1},#{user2},#{user1Hand},#{user2Hand},#{isActive});")
  void insertMatch(Match match);
}
