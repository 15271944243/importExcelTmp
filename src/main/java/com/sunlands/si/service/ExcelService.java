package com.sunlands.si.service;

import com.sunlands.si.repository.AnswerRepository;
import com.sunlands.si.repository.QuestionRepository;
import com.sunlands.si.repository.QuestionTypeRepository;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service // 标记为ServiceBean
@Transactional // 为所有服务方法默认开启声明式事务
@Order(value = 1)
public class ExcelService implements ApplicationRunner{

    private Logger log = Logger.getLogger(ExcelService.class);

    @Autowired
    private QuestionTypeRepository questionTypeRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    private static final String ENCODING = "UTF-8";

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        String[] args = applicationArguments.getSourceArgs();
        String excelPath = null;
        if(args != null && args.length > 0){
            try {
                excelPath = args[0];
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }else{
            System.out.println("Exception info:"+"input args error!! ");
            return;
        }
        //创建输入流
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(excelPath));
            // 只处理2007以后的版本(xlsx后缀)
            //由输入流得到工作簿
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            this.handleExcel(workbook);
            //得到工作表
            XSSFSheet sheet = workbook.getSheetAt(0);
            //得到行,0表示第一行
            /*XSSFRow row = sheet.getRow(0);
            //创建单元格行号由row确定,列号作为参数传递给createCell;第一列从0开始计算
            XSSFCell cell = row.getCell(2);
            //给单元格赋值
            String cellValue = cell.getStringCellValue();
            System.out.println("C1的值是"+cellValue);
            int a[][] = new int[10][30];
            for(int i=0;i<a.length;i++){
                System.out.println(i);
            }*/


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fis = null;
        }
    }

    public String handleExcel(XSSFWorkbook workbook){
        //得到工作表
        XSSFSheet sheet = workbook.getSheet("Sheet1");


        return null;
    }
}
