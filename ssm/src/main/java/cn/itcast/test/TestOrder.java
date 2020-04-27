package cn.itcast.test;

import cn.itcast.dao.CommodityDao;
import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Commodity;
import cn.itcast.domain.Order;
import cn.itcast.service.TestService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;


public class TestOrder {
    @Test
    public void run(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        OrderDao od= (OrderDao) ac.getBean("orderDao");
        List<Order> list=od.findByNOuser("boniii");
        for(Order order:list){
            System.out.println(order);
        }
    }
    @Test
    public void run1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CommodityDao cd= (CommodityDao) ac.getBean("commodityDao");
        List<Commodity> list=cd.findByCuser("boniii");
        for(Commodity commodity:list){
            System.out.println(commodity);
        }
    }
    @Test
    public void run2() throws Exception {
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestService ts= (TestService) ac.getBean("testService");
        Date d=new Date(System.currentTimeMillis());
        System.out.println(d);
        ts.orderst("boniii","巧克力","漏杨波",10000000,10,d);
    }
}
