package cn.itcast.dao;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("select * from usersign where username=#{usernanme}")
    @Results(id="userMap",value = {
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(property = "commodity",column = "username",
                    many = @Many(select = "cn.itcast.dao.CommodityDao.findByCuser",
                            fetchType= FetchType.LAZY)),
            @Result(property = "order",column = "username",
                    many = @Many(select = "cn.itcast.dao.OrderDao.findByNOuser",
                            fetchType = FetchType.LAZY))
    })
    User findByUsername(String username);


    @Insert("insert into usersign(username,password)values(#{username},#{password})")
    void createUser(User user);


}
