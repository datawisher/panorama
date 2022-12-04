import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author h407644
 * @date 2022-10-31
 */
public class TempTest {

    /*public static void main(String[] args) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String date = dateFormatter.format(LocalDate.now());
        System.out.println("date = " + date);
        String time = timeFormatter.format(LocalTime.now());
        System.out.println("time = " + time);
    }*/

    /*public static void main(String[] args) {
        Date from = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("from = " + from);
    }*/

    /*public static void main(String[] args) {
        System.out.println("new  = " + LocalDateTime.now());
    }*/

    /*public static void main(String[] args) {
        String str = "{\"id\":\"0\",\"message\":\"OK\",\"tick\":496478859,\"status\":\"OK\",\"type\":\"System.String\",\"obj\":null}";
        JSONObject jsonObject = JSONObject.parseObject(str);

    }*/

    /*public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map2.put("a", 1);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("a","zero");
        map3.put("b",2);
        map.putAll(map2);
        map.putAll(map3);
        System.out.println("map = " + map);

    }*/

    public static void main(String[] args) {
        String str = "区域调压柜_AAA_BBB__DDD";
        String str2 = StringUtils.substring(str, StringUtils.indexOf(str, "_") + 1);
        System.out.println("str2 =======> " + str2);
    }
}
