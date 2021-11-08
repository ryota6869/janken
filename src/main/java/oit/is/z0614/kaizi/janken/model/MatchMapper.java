package oit.is.z0614.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MatchMapper {
  @Select("select * from matches;")
  ArrayList<Match> selectAllMatches();

  @Select("select * from matches where isactive = true")
  Match selectActiveTrueMatch();

  @Select("select * from matches where user1 = #{user1} and user2 = #{user2} and user1Hand = #{user1Hand} and user2Hand = #{user2Hand} and isactive = #{isActive}")
  Match selectByAllData(Match match);

  @Insert("insert into matches (user1,user2,user1Hand,user2Hand,isactive) VALUES (#{user1},#{user2},#{user1Hand},#{user2Hand},#{isActive});")
  void insertMatch(Match match);

  @Update("update matches set isactive = false where id = #{id}")
  boolean updateFalseIsactive(Match match);
}
