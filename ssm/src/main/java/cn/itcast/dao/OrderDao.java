package cn.itcast.dao;

import cn.itcast.domain.Order;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    @Select("select * from commodityorder where NOuser=#{NOuser}")
    List<Order> findByNOuser(String NOuser);

    @Insert("insert into commodityorder(NOuser,NObuyuser,NOodernum,NOname,NOnum,NOprice,NOsign,NOdate)values(#{NOuser},#{NObuyuser},#{NOodernum},#{NOname},#{NOnum},#{NOprice},#{NOsign},#{NOdate})")
    void save(Order order);

}
