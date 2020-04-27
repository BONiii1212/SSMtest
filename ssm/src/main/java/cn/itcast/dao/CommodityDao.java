package cn.itcast.dao;

import cn.itcast.domain.Commodity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityDao {

    @Select("select * from commodity where Cuser=#{Cuser}")
    List<Commodity> findByCuser(String Cuser);

    @Select("select * from commodity where Cname=#{Cname}")
    Commodity findByCuserandCname(String Cname);

    @Update("update commodity set Cnum=#{Cnum} where Cname=#{Cname}")
    void update(Commodity commodity);

    @Insert("insert into commodity(Cuser,Cname,CPprice,Cnum,Cdiscount,Cprice.Cdescribe)values(#{Cuser},#{Cname},#{CPprice},#{Cnum},#{Cdiscount},#{Cprice},#{Cdescribe})")
    void insert(Commodity commodity);
}
