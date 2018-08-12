/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX;

/**
 *
 * @author Ramonella
 */
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import java.text.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ReadExcel {

    static DecimalFormat df = new DecimalFormat("#####0");

    public String convertSheet(String name, String filename) {
        FileWriter fostream;
        PrintWriter out = null;
        String strOutputPath = "C:\\Users\\Ramonella\\Desktop\\";
        String strFilePrefix = "";
        File af = new File(filename);
        if (af.exists()) {
            try {
                strFilePrefix = af.getName().replace(".xlsx", "")+"_"+name;
                InputStream inputStream = new FileInputStream(af);
                Workbook wb = WorkbookFactory.create(inputStream);
                Sheet sheet = wb.getSheet(name);
                fostream = new FileWriter(strOutputPath + "\\" + strFilePrefix + ".xml");
                out = new PrintWriter(new BufferedWriter(fostream));
                out.println("<"+name+">");
                boolean firstRow = true;
                int cont = 0;
                List<String> headers = new ArrayList<>();
                for (Row row : sheet) {
                    if (firstRow == true) {
                        firstRow = false;
                        while ((row.getCell(cont) != null)) {
                            if (row.getCell(cont).toString().equals("")) {
                                // continuidad = false;
                            } else {
                                headers.add(row.getCell(cont).toString());
                            }
                            cont++;
                        }
                        continue;
                    }
                    out.println("\t<pregunta>");
                    for (int i = 0; i < headers.size(); i++) {
                        out.println(formatElement("\t\t", headers.get(i), formatCell(row.getCell(i))));
                    }
                    out.println("\t</pregunta>");
                }
                out.write("</"+name+">");
                out.flush();
                out.close();
                return strOutputPath + "\\" + strFilePrefix + ".xml";
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ruta no valida para archivo xlsx", "Error " , JOptionPane.ERROR_MESSAGE);
        }
         return "";

    }

    private String formatCell(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                return "";
            case Cell.CELL_TYPE_BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case Cell.CELL_TYPE_ERROR:
                return "*error*";
            case Cell.CELL_TYPE_NUMERIC:
                return ReadExcel.df.format(cell.getNumericCellValue());
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                return "<unknown value>";
        }
    }

    private String formatElement(String prefix, String tag, String value) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("<");
        sb.append(tag);
        if (value != null && value.length() > 0) {
            sb.append(">");
            sb.append(value);
            sb.append("</");
            sb.append(tag);
            sb.append(">");
        } else {
            sb.append(">");
            sb.append("</");
            sb.append(tag);
            sb.append(">");
        }
        return sb.toString();
    }
}
