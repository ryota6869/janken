package oit.is.z0614.kaizi.janken.model;

import java.util.ArrayList;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import oit.is.z0614.kaizi.janken.model.User;

@Mapper
public interface UserMappaer {
  @Select("select * from users;")
  ArrayList<User> selectAllUsers();
}
