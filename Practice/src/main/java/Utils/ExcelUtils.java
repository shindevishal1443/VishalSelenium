package Utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtils(String excelPath) {
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);  // Read first sheet
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int rowNum, int colNum) {

        try {
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null) return "";

            XSSFCell cell = row.getCell(colNum);
            if (cell == null) return "";

            return cell.toString().trim();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
