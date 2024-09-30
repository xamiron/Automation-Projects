package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private String filePath;
    private Workbook workbook;

    public ExcelReader(String filePath) throws IOException {
        this.filePath = filePath;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
    }

    public String getCellData(String sheetName, int rowNumber, int cellNumber) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum();
    }

    public int getColumnCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(0);
        return row.getLastCellNum();
    }
}
