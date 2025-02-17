package org.automationExercise.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "excelData")
    public static Object[][] getData(Method m) throws IOException{
        int rowIndex = 0;
        int cellIndex=0;
        List<List> outputList = new ArrayList<>();

        //Access the excel file

        FileInputStream file = new FileInputStream(
            "C:/Users/Kuntal/Documents/KuntalAutomation-QA-AutomationExercise/app/src/main/resources/AutomationExercise_DataInputSheet.xlsx");

        // Access the Workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        //Access the Sheet
        XSSFSheet selectedSheet = workbook.getSheet(m.getName());
        Iterator<Row> rowIterator = selectedSheet.rowIterator();

        while (rowIterator.hasNext()) {
            Row nextRow = rowIterator.next();
            List<String> innerList = new ArrayList<>();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                if(rowIndex>0 && cellIndex>0) {
                    if (nextCell.getCellType()==CellType.STRING) {
                        innerList.add(nextCell.getStringCellValue());
                    } else if(nextCell.getCellType()== CellType.NUMERIC) {
                        innerList.add(String.valueOf(nextCell.getNumericCellValue()));

                    }
                }
                cellIndex++;
            }
            rowIndex++;
            cellIndex=0;
            if (innerList.size()>0) {
                    outputList.add(innerList);
            }
        }
        file.close();
        String[][] stringArray = outputList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        return stringArray;


    }

}
