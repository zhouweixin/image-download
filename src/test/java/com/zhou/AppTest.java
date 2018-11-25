package com.zhou;

import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    public void test1(){
        String url = "http://forensics.inf.tu-dresden.de/ddimgdb/images/gallery/Canon_Ixus55_0_2873.JPG";

        try {
            Connection.Response execute = Jsoup.connect(url).ignoreContentType(true).maxBodySize(3000000).timeout(5 * 60000).ignoreHttpErrors(true).execute();
            byte[] bytes = execute.bodyAsBytes();
            Map<String, String> headers = execute.headers();

            IOUtils.write(bytes, new FileOutputStream("test.jpg"));
            System.out.println("完成");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
