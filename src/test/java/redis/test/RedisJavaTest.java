package redis.test;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.List;

/**
 * Created by kage on 2017/8/12.
 */
public class RedisJavaTest {
     @Test
     public void testConnect(){
         Jedis jedis = new Jedis("192.168.187.129");
         System.out.println("连接成功");
         //查看服务是否运行
         System.out.println("服务正在运行: "+jedis.ping());
         jedis.set("myname", "honglibi");
         System.out.println("myname:"+ jedis.get("myname"));
         jedis.lpush("list", "nice " ," to", " meet", " you");
         List<String> list = jedis.lrange("list", 0, 10);
         for(String str :list){
             System.out.print(str + ", ");
         }
         System.out.println();


     }

     @Test
     public void pdfToWord() throws Exception{
         String name1 = "D:\\book\\高性能MySQL（第3版）1.pdf";
         org.pdfbox.pdmodel.PDDocument doc = org.pdfbox.pdmodel.PDDocument.load(name1);
         int pagenumber = 10;
         name1 = name1.substring(0, name1.lastIndexOf("."));
         String fileName = name1 + ".doc";
         createFile(fileName);
         FileOutputStream fos = new FileOutputStream(fileName);
         Writer writer = new OutputStreamWriter(fos, "UTF-8");
         org.pdfbox.util.PDFTextStripper stripper = new org.pdfbox.util.PDFTextStripper();
         stripper.setSortByPosition(true);
         stripper.setStartPage(1);
         stripper.setEndPage(pagenumber);
         stripper.writeText(doc, writer);
         writer.close();
         doc.close();
         System.out.println("pdf转换word成功！");
         String a = null;
         


     }

    private static void createDir(String destDirName) {
        File dir = new File(destDirName);
        if(dir.exists()) {
            System.out.println("创建目录失败，目标目录已存在！");
        }

        if(!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }

        if(dir.mkdirs()) {
            System.out.println("创建目录成功！" + destDirName);
        } else {
            System.out.println("创建目录失败！");
        }

    }

    public static void createFile(String filePath) {
        File file = new File(filePath);
        if(file.exists()) {
            System.out.println("目标文件已存在" + filePath);
        }

        if(filePath.endsWith(File.separator)) {
            System.out.println("目标文件不能为目录！");
        }

        if(!file.getParentFile().exists()) {
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if(!file.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在的目录失败！");
            }
        }

        try {
            if(file.createNewFile()) {
                System.out.println("创建文件成功:" + filePath);
            } else {
                System.out.println("创建文件失败！");
            }
        } catch (IOException var3) {
            var3.printStackTrace();
            System.out.println("创建文件失败！" + var3.getMessage());
        }

    }
}
