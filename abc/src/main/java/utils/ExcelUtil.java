package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {
    public static List<String[]> readSheet(String filePath, String sheetName) {
        List<String[]> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rows = sheet.iterator();
            rows.next(); // skip header
            while (rows.hasNext()) {
                Row row = rows.next();
                String a = row.getCell(0).getStringCellValue();
                String b = row.getCell(1).getStringCellValue();
                data.add(new String[]{a, b});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
