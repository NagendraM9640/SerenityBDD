package starter.Utility;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CommonFunctions {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    public static String ReadExcelData(String SheetName, String ParmName) throws Exception {

        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet worksheet = workbook.getSheet(SheetName);
            Iterator<Row> rowIterator = worksheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(ParmName)) {
                    if (row.getCell(1) != null)
                        if (row.getCell(1).getCellType() == CellType.NUMERIC) {
                            return String.valueOf(row.getCell(1).getNumericCellValue());
                        } else {
                            return row.getCell(1).getStringCellValue();
                        }
                }
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve value from test data xlsx \n" + e.getMessage());
        }
        return null;
    }
    public static Properties loadConfig(String path) {
        InputStream in = null;
        Properties prop = new Properties();
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            try {
                prop.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static Map<String, String> initConfig(Properties prop) {
        Map<String, String> configMap = new HashMap<String, String>();

        Enumeration<?> enu = prop.propertyNames();
        while (enu.hasMoreElements()) {
            Object key = enu.nextElement();
            configMap.put((String) key, prop.getProperty((String) key));
        }
        return configMap;
    }

    public static String getFutureDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        String futureDate = sdf.format(cal.getTime());
        return futureDate;
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentdate = sdf.format(date);
        return currentdate;
    }

    public static String getPastDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -days);
        String pastDate = sdf.format(cal.getTime());
        return pastDate;

    }

    public By locatorParser(String locator) {

        By loc = By.id(locator);
        if (locator.contains("id"))
            loc = By.id(locator.substring(locator.indexOf("\"") + 1,
                    locator.length() - 2));

        else if (locator.contains("name"))
            loc = By.name(locator.substring(locator.indexOf("\"") + 1,
                    locator.length() - 2));
        else if (locator.contains("cssSelector"))
            loc = By.cssSelector(locator.substring(locator.indexOf("\"") + 1,
                    locator.length() - 2));

        if (locator.contains("xpath"))
            loc = By.xpath(locator.substring(locator.indexOf("\"") + 1,
                    locator.length() - 2));

        return loc;

    }

    public static void getAllFiles(File dir, List<File> fileList) {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                fileList.add(file);
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    getAllFiles(file, fileList);
                } else {
                    System.out.println("     file:" + file.getCanonicalPath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeZipFile(File directoryToZip, List<File> fileList) {

        try {
            FileOutputStream fos = new FileOutputStream(directoryToZip.getName() + ".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (File file : fileList) {
                if (!file.isDirectory()) { // we only zip files, not directories
                    addToZip(directoryToZip, file, zos);
                }
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToZip(File directoryToZip, File file, ZipOutputStream zos)
            throws FileNotFoundException, IOException {

        FileInputStream fis = new FileInputStream(file);
        String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
                file.getCanonicalPath().length());
        System.out.println("Writing '" + zipFilePath + "' to zip file");
        ZipEntry zipEntry = new ZipEntry(zipFilePath);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }
        zos.closeEntry();
        fis.close();
    }

   /* public Response getApiCall(String accessToken, HashMap<String, String> header, String uri) {
        Response response = null;
        response = SerenityRest.with().contentType("application/json")
                .given()
                .body(header).log().all()
                .header("Authorization", accessToken)
                .request().get(uri);
        response.then().statusCode(200);
        response.prettyPrint();
        return response;
    }

    public Response postApiCall(String accessToken, HashMap<String, String> body, String uri) {
        Response response = null;
        response = SerenityRest.with().contentType("application/json")
                .given()
                .header("Authorization", accessToken)
                .body(body).log().all()
                .request().post(uri);
        response.then().statusCode(201);
        response.prettyPrint();
        return response;
    }

    public Response deleteAPiCall(String accessToken, String ID) {
        Response response = null;
        response = SerenityRest.with().contentType("application/json")
                .given()
                .header("Authorization", accessToken)
                .request().delete(variables.getProperty("BaseUrl") + "/server/odata/Part('" + ID + "')");
        response.then().statusCode(204);
        response.prettyPrint();
        return response;
    }*/

    public void updateCellValue(String fileName) throws IOException {
        String fileNAme=System.getProperty("user.dir")+"/src/test/resources/TestData/"+fileName+".xlsx";
        FileInputStream inputstream = new FileInputStream(new File(fileNAme));
        XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(inputstream);
        XSSFSheet worksheet = my_xlsx_workbook.getSheetAt(0);
       // worksheet.getRow(0).
        Cell cell = worksheet.getRow(2).getCell(1);
        cell.setCellValue(cell.getNumericCellValue() - 5);
        inputstream.close();
        FileOutputStream output_file =new FileOutputStream(new File(fileNAme));

        my_xlsx_workbook.write(output_file);
        output_file.close();
    }

  /*  public static List<Map<String, String>> readdata() {
        List<Map<String, String>> testData = null;
        ExcelReader reader = new ExcelReader();
        try {
            testData =
                    reader.getData(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\Datafile.xlsx", "Sheet1");
            System.out.println("data: " + testData.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }*/
}