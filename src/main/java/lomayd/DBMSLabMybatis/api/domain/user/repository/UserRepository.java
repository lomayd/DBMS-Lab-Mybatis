package lomayd.DBMSLabMybatis.api.domain.user.repository;

import org.apache.ibatis.annotations.*;

import lomayd.DBMSLabMybatis.api.domain.user.User;

@Mapper
public interface UserRepository {

    // SQL Annotation Version
    
    @Insert("INSERT User(id, password, name, nickname, email, age) VALUES (#{id}, #{password}, #{name}, #{nickname}, #{email}, #{age})")
    void save(User user);

    @Select("SELECT * FROM User WHERE id=#{id}")
    User findById(String id);

    @Delete("DELETE FROM User WHERE id=#{id}")
    void deleteById(String id);
    
    @Update("UPDATE User SET password=#{user.password},name=#{user.name},nickname=#{user.nickname},email=#{user.email},age=#{user.age} WHERE id=#{id}")
    void update(String id, User user);
    
    // XML Mapper Version

    void saveXml(User user);
    
    User findByIdXml(String id);
    
    void deleteByIdXml(String id);
    
    void updateXml(String id, User user);
}
