package oit.is.z0614.kaizi.janken.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import oit.is.z0614.kaizi.janken.model.MatchInfo;

@Mapper
public interface MatchInfoMapper {
  @Insert("insert into matchinfo (user1,user2,user1Hand,isactive) VALUES (#{playerId},#{othUserId},#{playerHand},#{isActive});")
  boolean insertMatchInfo(MatchInfo mInfo);
}
