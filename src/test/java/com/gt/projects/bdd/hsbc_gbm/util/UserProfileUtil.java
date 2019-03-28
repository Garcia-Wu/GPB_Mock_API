package com.gt.projects.bdd.hsbc_gbm.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserProfileUtil {

    private static Logger logger = LoggerFactory.getLogger(UserProfileUtil.class);

    public static String excelName;

    public static final int CUSTOMER_LEVEL = 1;
    public static final int ACCOUNT_LEVEL = 2;
    public static final int PORTFOLIO_LEVEL = 3;

    private static ThreadLocal<UserProfile> currentUserProfile = new ThreadLocal<>();
    private static Map<String, UserProfile> userProfiles = new HashMap<>();

    public static void readExcel(){
        logger.info("Read UserProfile excel start!");
        try {
            if(excelName == null){
                excelName = "UserProfile.xlsx";
            }
            logger.info("Excel name: "+excelName);
            InputStream in = UserProfileUtil.class.getClassLoader().getResourceAsStream(excelName);
            XSSFWorkbook wb = new XSSFWorkbook(in);
            Sheet sheet = wb.getSheetAt(0);
            Row row0 = sheet.getRow(0);

            // get table header
            List<String> fieldNames = new ArrayList<>();
            for (Cell cell : row0){
                String fieldName = cell.getStringCellValue();
                fieldNames.add(fieldName);
            }

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                UserProfile userProfile = new UserProfile();
//                System.out.println("Preset Excel Row:"+row.getRowNum()+" CellTotalNum:"+row.getPhysicalNumberOfCells());
                for(Cell cell : row){
                    if(cell != null){
                        Field field = UserProfile.class.getDeclaredField(fieldNames.get(cell.getColumnIndex()));
                        field.setAccessible(true);
                        if(cell.getCellType() == 0){
                            field.set(userProfile, (int)cell.getNumericCellValue());
//                            System.out.println("number value:"+cell.getNumericCellValue()+" index:"+cell.getColumnIndex());
                        } else if (cell.getCellType() == 1){
                            field.set(userProfile, cell.getStringCellValue());
//                            System.out.println("string value:"+cell.getStringCellValue()+" index:"+cell.getColumnIndex());
                        } else {
                            logger.error("type not preset:"+cell.getCellType()+"  row num:"+ (row.getRowNum() + 1) +"  cell num:"+(cell.getColumnIndex() + 1));
                        }
                    }
                }
                userProfiles.put(userProfile.getType(), userProfile);
            }
//            for (UserProfile userProfile : userProfiles){
//                System.out.println("userProfile:"+userProfile);
//            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Read UserProfile excel error!", false);
        }
        logger.info("Read UserProfile excel end!");
    }

    public static UserProfile getUserProfileByType(String type){
        return userProfiles.get(type);
    }

    public static void setCurrentUserProfile(UserProfile userProfile){
        currentUserProfile.set(userProfile);
    }

    public static UserProfile getCurrentUserProfile(){
        return currentUserProfile.get();
    }
}
