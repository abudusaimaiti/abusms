import com.abu.book.bean.BookBean;
import com.abu.book.view.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author 阿卜杜赛麦提
 * @version 1.0
 * @date ${DATE}
 */
public class Main {
    public static HashMap<String, BookBean> hash=new HashMap<String,BookBean>();
    public static void main(String[] args) {
        System.out.println(generate());
//        BookBean put = hash.put("西游记", new BookBean(1024, "西游记", 5, View.date()));
//        System.out.println(put);
//        aa();
    }
    public static void aa() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println("Formatted date and time: " + formattedDateTime);
    }


        public static int generate() {
            Random random = new Random();
            return random.nextInt(90000) + 10000;
        }
}