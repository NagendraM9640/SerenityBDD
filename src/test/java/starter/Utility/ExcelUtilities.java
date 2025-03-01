package starter.Utility;

import net.serenitybdd.core.Serenity;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import starter.PageObjectsPages.PVSPGPData;
import starter.PageObjectsPages.PartData;
import starter.PageObjectsPages.mSpecMCOData;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class ExcelUtilities {
    private final Map<String, Integer> itemTypeRowMap = new HashMap<>();

    private final Map<String, Integer> serialNumRowMap = new HashMap<>();

    public List<PartData> readExcelDataForParts(String filePath) throws IOException {
        List<PartData> rowDataList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet1 = workbook.getSheetAt(0);

            for (int row = 1; row <= sheet1.getLastRowNum(); row++) {
                Row currentRow = sheet1.getRow(row);
                if (currentRow == null) {
                    continue; // Skip null rows
                }
                String serialNum = getCellValue(currentRow.getCell(0));
                String itemType = getCellValue(currentRow.getCell(1));
                String subfamily = getCellValue(currentRow.getCell(2));
                String productGroup = getCellValue(currentRow.getCell(3));

                if (itemType.isEmpty() || subfamily.isEmpty() || productGroup.isEmpty()) {
                    continue; // Skip rows with empty ItemType, Subfamily, or ProductGroup
                }

                PartData rowData = new PartData();
                rowData.setRowNumber(row + 1);
                rowData.setItemType(itemType);
                rowData.setSubfamily(subfamily);
                rowData.setProductGroup(productGroup);
                rowData.setItemCode(getCellValue(currentRow.getCell(4)));
                rowData.setEcoItemCode(getCellValue(currentRow.getCell(5)));
                rowData.setJsonID(getCellValue(currentRow.getCell(6)));
                rowData.setIntegrationResponse(getCellValue(currentRow.getCell(7)));
                rowData.setErrorMsg(getCellValue(currentRow.getCell(8)));
                rowData.setpTempCode(getCellValue(currentRow.getCell(9)));
                rowDataList.add(rowData);

//                // Store the row number based on ItemType, Subfamily, and ProductGroup
//                String key = itemType + "|" + subfamily + "|" + productGroup;
                // Store the row number based on ItemType, Subfamily, and ProductGroup
                String key = itemType + "|" + subfamily + "|" + productGroup;
                itemTypeRowMap.put(key, row);
            }
        }
        return rowDataList;
    }

    public List<PartData> readExcelDataForPartSaveAs(String filePath) throws IOException {
        List<PartData> rowDataList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet1 = workbook.getSheetAt(0);

            for (int row = 1; row <= sheet1.getLastRowNum(); row++) {
                Row currentRow = sheet1.getRow(row);
                if (currentRow == null) {
                    continue; // Skip null rows
                }
                String serialNum = getCellValue(currentRow.getCell(0));
                String itemType = getCellValue(currentRow.getCell(1));
                String subfamily = getCellValue(currentRow.getCell(2));
                String productGroup = getCellValue(currentRow.getCell(3));
                String itemCode = getCellValue(currentRow.getCell(4));

                if (itemType.isEmpty() || itemCode.isEmpty() || serialNum.isEmpty()) {
                    continue; // Skip rows with empty ItemType, ItemCode
                }

                PartData rowData = new PartData();
                rowData.setRowNumber(row + 1);
                rowData.setSerialNum(serialNum);
                rowData.setItemType(itemType);
                rowData.setSubfamily(subfamily);
                rowData.setProductGroup(productGroup);
                rowData.setItemCode(getCellValue(currentRow.getCell(4)));
                rowData.setEcoItemCode(getCellValue(currentRow.getCell(5)));
                rowData.setJsonID(getCellValue(currentRow.getCell(6)));
                rowData.setIntegrationResponse(getCellValue(currentRow.getCell(7)));
                rowData.setErrorMsg(getCellValue(currentRow.getCell(8)));
                rowData.setpTempCode(getCellValue(currentRow.getCell(9)));
                rowDataList.add(rowData);

                // Store the row number based on ItemType, ItemCode
                String key = itemType + "|" + serialNum;
                System.out.println(key + "KeyValue");
                itemTypeRowMap.put(key, row);
            }
        }
        return rowDataList;
    }

    public List<mSpecMCOData> readExcelDataFormSpecs(String filePath) throws IOException {
        List<mSpecMCOData> rowDataList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet1 = workbook.getSheetAt(0);

            for (int row = 1; row <= sheet1.getLastRowNum(); row++) {
                Row currentRow = sheet1.getRow(row);
                if (currentRow == null) {
                    continue; // Skip null rows
                }
                String serialNum = getCellValue(currentRow.getCell(0));
                String mSpecItemCode = getCellValue(currentRow.getCell(1));
                String plantCode = getCellValue(currentRow.getCell(2));
                String eBomRevision = getCellValue(currentRow.getCell(3));
                String mcoNumber = getCellValue(currentRow.getCell(4));
                String integrationTabResponse = getCellValue(currentRow.getCell(5));
                String jsonId = getCellValue(currentRow.getCell(6));
                String errorMessage = getCellValue(currentRow.getCell(7));

                if (mSpecItemCode.isEmpty() || serialNum.isEmpty()) {
                    continue; // Skip rows with empty mSpecItemCode and serialNum
                }

                mSpecMCOData rowData = new mSpecMCOData();
                rowData.setRowNumber(row + 1);
                rowData.setSerialNum(serialNum);
                rowData.setmSpecItemCode(mSpecItemCode);
                rowData.setPlantCode(plantCode);
                rowData.seteBomRevision(eBomRevision);
                rowData.setMcoNumber(mcoNumber);
                rowData.setIntegrationResponse(integrationTabResponse);
                rowData.setJsonID(jsonId);
                rowData.setErrorMsg(errorMessage);
                rowDataList.add(rowData);

                // Store the row number based on Serial num
                itemTypeRowMap.put(serialNum, row);
            }
        }
        return rowDataList;
    }
    public void updateExcelDataFormSpecs(String filePath, mSpecMCOData newData) throws IOException {
        String key = newData.getSerialNum();
        System.out.println(key + "for update");
        Integer rowNumber = itemTypeRowMap.get(key);
        if (rowNumber == null) {
            throw new IllegalArgumentException("Combination not found: " + key);
        }

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowNumber);

            if (row == null) {
                row = sheet.createRow(rowNumber);
            }
            setCellValue(row, 0, newData.getSerialNum());
            setCellValue(row, 1, newData.getmSpecItemCode());
            setCellValue(row, 2, newData.getPlantCode());
            setCellValue(row, 3, newData.geteBomRevision());
            setCellValue(row, 4, newData.getMcoNumber());
            setCellValue(row, 5, newData.getIntegrationResponse());
            setCellValue(row, 6, newData.getJsonID());
            setCellValue(row, 7, newData.getErrorMsg());

            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                workbook.write(fileOutputStream);
            }
        }
    }
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    public Integer getRowNumberBySerialNum(String itemType) {
        return serialNumRowMap.get(itemType);
    }

    public void updateExcelData(String filePath, PartData newData) throws IOException {
        String key = newData.getItemType() + "|" + newData.getSubfamily() + "|" + newData.getProductGroup();
        Integer rowNumber = itemTypeRowMap.get(key);
        if (rowNumber == null) {
            throw new IllegalArgumentException("Combination not found: " + key);
        }

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowNumber);

            if (row == null) {
                row = sheet.createRow(rowNumber);
            }

            setCellValue(row, 0, newData.getItemType());
            setCellValue(row, 1, newData.getSubfamily());
            setCellValue(row, 2, newData.getProductGroup());
            setCellValue(row, 3, newData.getItemCode());
            setCellValue(row, 4, newData.getEcoItemCode());
            setCellValue(row, 5, newData.getJsonID());
            setCellValue(row, 6, newData.getIntegrationResponse());
            setCellValue(row, 7, newData.getErrorMsg());
            setCellValue(row, 8, newData.getpTempCode());

            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                workbook.write(fileOutputStream);
            }
        }
    }

    public void updateExcelDataPartSaveAs(String filePath, PartData newData) throws IOException {
        String key = newData.getItemType() + "|" + newData.getSerialNum();
        System.out.println(key + "for update");
        Integer rowNumber = itemTypeRowMap.get(key);
        if (rowNumber == null) {
            throw new IllegalArgumentException("Combination not found: " + key);
        }

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowNumber);

            if (row == null) {
                row = sheet.createRow(rowNumber);
            }
            setCellValue(row, 0, newData.getSerialNum());
            setCellValue(row, 1, newData.getItemType());
            setCellValue(row, 2, newData.getSubfamily());
            setCellValue(row, 3, newData.getProductGroup());
            setCellValue(row, 4, newData.getItemCode());
            setCellValue(row, 5, newData.getEcoItemCode());
            setCellValue(row, 6, newData.getJsonID());
            setCellValue(row, 7, newData.getIntegrationResponse());
            setCellValue(row, 8, newData.getErrorMsg());
            setCellValue(row, 9, newData.getpTempCode());

            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                workbook.write(fileOutputStream);
            }
        }
    }


    private void setCellValue(Row row, int cellIndex, String value) {
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            cell = row.createCell(cellIndex);
        }
        cell.setCellValue(value);
    }

    public static void captureScreenshot(String screenshotName) throws IOException {
        Random random = new Random();
        TakesScreenshot ts = (TakesScreenshot) Serenity.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "target/Integration/Error/screenshots/" + screenshotName + random.nextInt(1000) + ".png";
        Path destination = Paths.get(dest);

        // Create the directory if it doesn't exist
        if (Files.notExists(destination.getParent())) {
            Files.createDirectories(destination.getParent());
        }

        // Copy the screenshot to the destination
        Files.copy(source.toPath(), destination);
    }

    public static void captureScreenshotForPartsData(String folderName, String screenshotName) throws IOException {
        Random random = new Random();
        TakesScreenshot ts = (TakesScreenshot) Serenity.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "target/Integration/Parts/Success/screenshots/" + folderName + "/" + screenshotName + ".png";
        Path destination = Paths.get(dest);

        // Create the directory if it doesn't exist
        if (Files.notExists(destination.getParent())) {
            Files.createDirectories(destination.getParent());
        }

        // Copy the screenshot to the destination
        Files.copy(source.toPath(), destination);
    }

    public static void captureErrorScreenshotForPartsData(String folderName, String screenshotName) throws IOException {
        Random random = new Random();
        TakesScreenshot ts = (TakesScreenshot) Serenity.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "target/Integration/Parts/Error/screenshots/" + folderName + "/" + screenshotName + ".png";
        Path destination = Paths.get(dest);

        // Create the directory if it doesn't exist
        if (Files.notExists(destination.getParent())) {
            Files.createDirectories(destination.getParent());
        }

        // Copy the screenshot to the destination
        Files.copy(source.toPath(), destination);
    }


    public void insertScreenshot(String filePath, String sheetName, int screenshotIndex, String screenshotPath) throws IOException {
        // Check if the screenshot file exists
        File screenshotFile = new File(screenshotPath);
        if (!screenshotFile.exists()) {
            throw new FileNotFoundException("Screenshot file not found: " + screenshotPath);
        }

        // Open the Excel file and update the sheet with the screenshot
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            // Adjust row spacing and start from the first column
            int rowNumber = screenshotIndex * 10; // Adjust row spacing for testing
            int colNumber = 0;

            // Create the row if it doesn't exist
            Row row = sheet.getRow(rowNumber);
            if (row == null) {
                row = sheet.createRow(rowNumber);
            }

            // Insert the screenshot into the row
            try (InputStream inputStream = new FileInputStream(screenshotPath)) {
                byte[] bytes = IOUtils.toByteArray(inputStream);
                int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helper = workbook.getCreationHelper();
                Drawing<?> drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = helper.createClientAnchor();
                anchor.setCol1(colNumber);
                anchor.setRow1(rowNumber); // Place screenshot at the specified row
                anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
                Picture picture = drawing.createPicture(anchor, pictureIdx);
                picture.resize(0.5); // Resize the image to 50% of its original size
            }

            // Write the changes to the file
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                workbook.write(fileOutputStream);
                System.out.println("Excel file updated with screenshot at row: " + rowNumber);
            }
        } catch (IOException e) {
            System.err.println("Error inserting screenshot into Excel: " + e.getMessage());

            // Handle the exception by adding an error message in Excel file
            try (FileInputStream fileInputStream = new FileInputStream(filePath);
                 Workbook workbook = new XSSFWorkbook(fileInputStream)) {

                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    sheet = workbook.createSheet(sheetName);
                }

                int rowNumber = screenshotIndex * 10; // Adjust row spacing
                int colNumber = 0; // Start from the first column
                Row row = sheet.getRow(rowNumber);
                if (row == null) {
                    row = sheet.createRow(rowNumber);
                }

                Cell cell = row.createCell(colNumber);
                cell.setCellValue("Error: " + e.getMessage());

                // Write the changes to the file
                try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                    workbook.write(fileOutputStream);
                }
            } catch (IOException ex) {
                System.err.println("Error saving Excel file after exception: " + ex.getMessage());
            }
        }
    }

    public List<PVSPGPData> readExcelDataForProducts(String filePath) throws IOException {
        List<PVSPGPData> rowDataList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet1 = workbook.getSheetAt(1);

            for (int row = 1; row <= sheet1.getLastRowNum(); row++) {
                Row currentRow = sheet1.getRow(row);
                if (currentRow == null) {
                    continue; // Skip null rows
                }

                String serialNum = getCellValue(currentRow.getCell(0));
                if (serialNum.isEmpty()) {
                    continue; // Skip rows with empty ItemType
                }

                PVSPGPData rowData = new PVSPGPData();
                rowData.setSerialNumber(serialNum);
                rowData.setProductType(getCellValue(currentRow.getCell(1)));
                rowData.setProductCategory(getCellValue(currentRow.getCell(2)));
                rowData.setProductVariantIdentifier(getCellValue(currentRow.getCell(3)));
                rowData.setSellableProductIdentifier(getCellValue(currentRow.getCell(4)));
                rowData.setGlobalProductIdentifier(getCellValue(currentRow.getCell(5)));
                rowData.setPecoNumber(getCellValue(currentRow.getCell(6)));
                rowData.setPvJsonId(getCellValue(currentRow.getCell(7)));
                rowData.setSpJsonId(getCellValue(currentRow.getCell(8)));
                rowData.setGpJsonId(getCellValue(currentRow.getCell(9)));
                rowData.setPvIntegrationResponse(getCellValue(currentRow.getCell(10)));
                rowData.setSpIntegrationResponse(getCellValue(currentRow.getCell(11)));
                rowData.setGpIntegrationResponse(getCellValue(currentRow.getCell(12)));
                rowData.setErrorMessage(getCellValue(currentRow.getCell(13)));
                rowDataList.add(rowData);
                serialNumRowMap.put(serialNum, row);
            }


        }
        return rowDataList;
    }

    public void updateExcelDataForProducts(String filePath, String serialNumber, PVSPGPData newData) throws IOException {
        Integer rowNumber = getRowNumberBySerialNum(serialNumber);
        if (rowNumber == null) {
            throw new IllegalArgumentException("serialNumber not found: " + serialNumber);
        }

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(1);
            Row row = sheet.getRow(rowNumber);

            if (row == null) {
                row = sheet.createRow(rowNumber);
            }

            setCellValue(row, 0, newData.getSerialNumber());
            setCellValue(row, 1, newData.getProductType());
            setCellValue(row, 2, newData.getProductCategory());
            setCellValue(row, 3, newData.getProductVariantIdentifier());
            setCellValue(row, 4, newData.getSellableProductIdentifier());
            setCellValue(row, 5, newData.getGlobalProductIdentifier());
            setCellValue(row, 6, newData.getPecoNumber());
            setCellValue(row, 7, newData.getPvJsonId());
            setCellValue(row, 8, newData.getSpJsonId());
            setCellValue(row, 9, newData.getGpJsonId());
            setCellValue(row, 10, newData.getPvIntegrationResponse());
            setCellValue(row, 11, newData.getSpIntegrationResponse());
            setCellValue(row, 12, newData.getGpIntegrationResponse());
            setCellValue(row, 13, newData.getErrorMessage());

            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                workbook.write(fileOutputStream);
            }
        }
    }

}
