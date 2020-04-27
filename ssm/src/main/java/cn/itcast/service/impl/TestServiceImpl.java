package cn.itcast.service.impl;

import cn.itcast.Exc.SysException;
import cn.itcast.dao.CommodityDao;
import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Commodity;
import cn.itcast.domain.Order;
import cn.itcast.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    public void orderst(String Cuser,String Cname,String buyuser, Integer NOodernum, Integer NOnum, Date NOdate)throws SysException{
        try{
            //1.根据商品名称查询出商品的信息并创建实例类的对象
            Commodity commodity =commodityDao.findByCuserandCname(Cname);
            //2.根据下单信息创建订单的信息的实例类的对象
            Order order=new Order();
            order.setNOuser(commodity.getCuser());
            order.setNObuyuser(buyuser);
            order.setNOodernum(NOodernum);
            order.setNOname(commodity.getCname());
            order.setNOnum(NOnum);
            order.setNOprice(commodity.getCPprice()*commodity.getCdiscount());
            order.setNOdate(NOdate);
            order.setNOsign(0);
            //3.扣去仓库商品的数量
            commodity.setCnum(commodity.getCnum()-NOnum);
            //4.跟新数据库中仓库商品信息
            commodityDao.update(commodity);
            int i=1/0;
            //5.跟新数据库中订单信息
            orderDao.save(order);
        }catch (Exception e){
            //控制台打印异常信息
            e.printStackTrace();
            throw new SysException("下订单出现了错误");
        }
    }

    @Override
    public void lyb() {
        System.out.println("这是一个方法");
    }
}
