package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {

    private static final String XL_FILE = System.getProperty("user.dir") + "/src/test/resources/testData/BookingData.xlsx";
    private static final String XL_SHEET = "Sheet1";
    public static FileInputStream fi;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String getCellData(int rownum,int colnum) throws IOException
    {
        fi=new FileInputStream(XL_FILE);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(XL_SHEET);
        row=ws.getRow(rownum);
        cell=row.getCell(colnum);
        String data;
        try
        {
            //data=cell.toString();
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
        }
        catch (Exception e)
        {
            data="";
        }
        wb.close();
        fi.close();
        return data;
    }
}
