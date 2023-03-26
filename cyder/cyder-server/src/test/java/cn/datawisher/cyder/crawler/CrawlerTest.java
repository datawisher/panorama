package cn.datawisher.cyder.crawler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CrawlerTest {
    public static void main(String[] args) throws IOException {
        // 构造URL
        String url = "http://quotes.money.163.com/service/chddata.html?code=0000001&start=19901219&end=20230325&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;VOTURNOVER";

        // 发送HTTP请求并获取数据
        URL u = new URL(url);
        Scanner scanner = new Scanner(u.openStream(), StandardCharsets.UTF_8.toString());
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();

        // 将数据写入本地CSV文件
        PrintWriter out = new PrintWriter(new FileWriter("sh.csv"));
        out.write(data);
        out.close();

        // 读取CSV文件并打印前5行
        Scanner scanner2 = new Scanner(new FileReader("sh.csv"));
        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            System.out.println(line);
        }
        scanner2.close();
    }
}
