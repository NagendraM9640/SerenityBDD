package starter.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZippingDirectory {
    List<String> filesListInDir = new ArrayList<String>();

    //Method for ZIP folder to specific Directory
    public  void zipDirectory(File dir, String zipDirName) {
        try {
            populateFilesList(dir);
            //now ZIP files one by one
            //create ZipOutputStream to write to the ZIP file
            FileOutputStream fos = new FileOutputStream(zipDirName);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for(String filePath : filesListInDir){
                //For ZipEntry we need to keep only relative file path, so we used substring on absolute path
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);
                //Read the file and write to ZipOutputStream
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }

                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //This method populates all the files in a directory to a List
    public  void populateFilesList(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
            else populateFilesList(file);
        }
    }

    //Usage
    public static void main(String[] args) throws InterruptedException{
        ZippingDirectory zip = new ZippingDirectory();
        File filename = new File("C:/Users/003FF8744/pmi-clipp-test-automation-dev@8e4c03a9b36/target/site/serenity");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        zip.zipDirectory(filename, "Automation_Report_"+dtf.format(now)+".zip");
        System.out.println("Zipping of AutomationReports successfully");
    }


}
