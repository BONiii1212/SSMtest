package cn.itcast.controller;

import cn.itcast.Exc.SysException;
import cn.itcast.domain.Commodity;
import cn.itcast.domain.User;
import cn.itcast.fun.TestExcel;
import cn.itcast.service.TestService;
import cn.itcast.service.UserService;
import jdk.internal.util.xml.impl.Input;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/test")
public class testController {
//    @Autowired
//    private TestService testService;
    @RequestMapping("/in")
    public void  in(@RequestParam("file") MultipartFile file){
        System.out.println("运行了");
        try {
            InputStream in=file.getInputStream();
            if(in==null){
                System.out.println("数据流为空");
            }
            TestExcel.start(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/orderst")
    public String orderst() throws Exception {
        System.out.println("进入表现层mvc");
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestService ts= (TestService) ac.getBean("testService");
        Date d=new Date(System.currentTimeMillis());
        System.out.println(d);
        ts.orderst("boniii","巧克力","漏杨波",10000000,10,d);
        return "list";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    @ResponseBody
    public void print(HttpServletResponse response) throws IOException {
        //获取session对象
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        HttpSession session=request.getSession();
        String username= (String) session.getAttribute("username");
        System.out.println(username);
        //从数据库中查询出此用户信息
        User user=userService.findByUsername(username);
        System.out.println(user);
        //获得此用户下仓库商品信息
        List<Commodity> list=user.getCommodity();
        //创建一个Excl表格对象
        HSSFWorkbook wb=new HSSFWorkbook();
        //建立一个新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("仓库商品信息表格");
        //在shtte里面创建第二行
        HSSFRow row1=sheet.createRow(0);
        //创建第一行设置的那元格式内容
        row1.createCell(0).setCellValue("商品名称");
        row1.createCell(1).setCellValue("商品进价");
        row1.createCell(2).setCellValue("库存数量");
        row1.createCell(3).setCellValue("当前折扣");
        row1.createCell(4).setCellValue("销售价格");
        row1.createCell(5).setCellValue("商品描述");
        int i=1;
        for(Commodity commodity:list){
            HSSFRow row=sheet.createRow(i);
            row.createCell(0).setCellValue(commodity.getCname());
            row.createCell(1).setCellValue(commodity.getCPprice());
            row.createCell(2).setCellValue(commodity.getCnum());
            row.createCell(3).setCellValue(commodity.getCdiscount());
            row.createCell(4).setCellValue(commodity.getCprice());
            row.createCell(5).setCellValue(commodity.getCdescribe());
            i++;
        }

        ServletOutputStream outputStream=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition","attachment;filename=details.xls");
        response.setContentType("application/msexcel");
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
