package cn.itcast.fun;

import cn.itcast.domain.Commodity;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.InputStream;


public class TestExcel {
    public static void start(InputStream is){
        try {
            String url="D://details (4).xls";
            //读取文件目录
//            InputStream is=new FileInputStream(url);
            //读取用户信息
            String Cuser="boniii";
            HSSFWorkbook hssfWorkbook=new HSSFWorkbook(is);
            Commodity commodity=new Commodity();
            for(int numSheet=0;numSheet<hssfWorkbook.getNumberOfSheets();numSheet++){
                //创建工作表
                HSSFSheet hssfSheet=hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet==null){
                    continue;
                }
                for(int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){
                    //创建行
                    HSSFRow hssfRow=hssfSheet.getRow(rowNum);
                    if(hssfRow!=null){
                        commodity.setCuser(Cuser);
                        commodity.setCname(hssfRow.getCell(0).getStringCellValue());
                        commodity.setCPprice(hssfRow.getCell(1).getNumericCellValue());
                        commodity.setCnum(hssfRow.getCell(2).getNumericCellValue());
                        commodity.setCdiscount(hssfRow.getCell(3).getNumericCellValue());
                        commodity.setCprice(hssfRow.getCell(4).getNumericCellValue());
                        commodity.setCdescribe(hssfRow.getCell(5).getStringCellValue());
                    }
                    System.out.println(commodity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
