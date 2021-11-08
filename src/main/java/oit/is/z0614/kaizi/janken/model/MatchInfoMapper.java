package oit.is.z0614.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import oit.is.z0614.kaizi.janken.model.MatchInfo;

@Mapper
public interface MatchInfoMapper {
  @Select("select * from matchinfo")
  ArrayList<MatchInfo> selectAllMatchinfo();

  @Select("select * from matchinfo where isactive = true")
  ArrayList<MatchInfo> selectTrueMatchinfo();

  @Insert("insert into matchinfo (user1,user2,user1Hand,isactive) VALUES (#{user1},#{user2},#{user1Hand},#{isActive});")
  boolean insertMatchInfo(MatchInfo mInfo);

  @Update("update matchinfo set isactive = false where id = #{id}")
  void updateFalseIsactive(MatchInfo mInfo);
}
