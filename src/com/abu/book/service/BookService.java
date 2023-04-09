package com.abu.book.service;
import com.abu.book.bean.BookBean;
import com.abu.book.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
*@author 阿卜杜赛麦提
*@date 2023/3/20
*@version 1.0
*/
    public class BookService {

//        全局就一个hash对象
   public static HashMap<String, BookBean> hash=new HashMap<String,BookBean>();
//   初始化数据
    static {
        hash.put("西游记",new BookBean(1024,"西游记",5, View.date()));
        hash.put("水浒传",new BookBean(1023,"水浒传",3, View.date()));
        hash.put("三国演义",new BookBean(3145,"三国演义",7, View.date()));
    }

//    1.添加操作
    public boolean add(String name,Integer num,String date) {
//        随机id
        BookBean bookBean = hash.get(name);
//        bookBean当书不存是添加
        if (bookBean==null){
            BookBean bean = new BookBean(generate(), name, num, date);
            hash.put(name,bean);
            return true;
        }
        return false;
    }
    //    2.删除操作
    public boolean delete(String name){
        BookBean remove = hash.remove(name);
        if (remove==null){
            return false;
        }
        return true;
    }


//    3.修改操作
    //    4.库存查询操作
    public void query(){
        if (hash.size()==0){
            System.out.println("无库存。。。");
            return;
        }
//        用map的迭代器对象来遍历hashmap的数据
        Iterator<Map.Entry<String, BookBean>> iterator = hash.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, BookBean> next = iterator.next();
            BookBean book = next.getValue();
            System.out.println(book.toString());
        }
    }
//    4.修改操作
    public boolean update(String name,int number){
        if (quest(name)&&number>0){
            hash.get(name).setNumb(number);
            return true;
        }
        return false;
    }
//    查询一个书是否存在
    public boolean quest(String name){
        BookBean bookBean = hash.get(name);
        if (bookBean==null){
            return false;
        }
        return true;
    }
//随机生成编号
    public static int generate() {
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }
    }








