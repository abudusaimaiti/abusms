package com.abu.book.view;

import com.abu.book.service.BookService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author 阿卜杜赛麦提
 * @version 1.0
 * @date 2023/3/20
 */
@SuppressWarnings({"all"})
public class View {

    private boolean loop = true;
    private BookService bookService = new BookService();

    public void MainMenu() {
        while (loop) {
            System.out.println("-------------1.显示图书信息-----------");
            System.out.println("-------------2.添加书----------------");
            System.out.println("-------------3.删除书-----------------");
            System.out.println("-------------4.修改-----------------");
            System.out.println("-------------0.退出系统-----------------");
            System.out.print("输入操作码：");
            int i = inputNumb();
            if (i != 0 || i < 5) {
                switch (i) {
                    case 1:
                        System.out.println("ID\t\t\t书名\t\t库存\t\t\t日期添加");
                       bookService.query();
                        break;
                    case 2:
                        //添加书
                        System.out.println("-------------2.添加书----------------");
                        addBook();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        update();
                        break;
                    case 0:
                        exit();
                        break;
                    default:
                        System.out.println("输入有误");
                }
            }
        }
    }
//添加操作
    public  void addBook() {
        System.out.print("请输入书名称");
        String name = inputStr();
        System.out.print("请输入数量");
        Integer num = inputNumb();
        boolean add = bookService.add( name, num, date());
        if (add){
            System.out.println("添加成功~");
        }else {
            System.out.println("添加失败~");
        }

    }
//    删除
    public void delete(){
        System.out.println("输入要删除的书名：");
        String s = inputStr();
        boolean delete = bookService.delete(s);
        if (delete){
            System.out.println(s+"删除成功~");
        }else {
            System.out.println("删除失败~");
        }
    }
//    退出
    public void exit(){
//        System.out.print("你确定要退出吗（N/Y）：");
//        char c = inputStr().charAt(0);
        while (true){
            System.out.print("你确定要退出吗（N/Y）：");
            char c = inputStr().charAt(0);
            if (c=='Y'||c=='y'){
                System.out.println("系统退出~");
                System.exit(0);
//                return;
            }else if (c=='N'||c=='n'){
                System.out.println("我后悔了，不退出~");
                return;
            }
           else {
                System.out.print("输入错误\n");
            }
        }
    }
//    修改
    public void update(){
        System.out.print("请输入要修改的书名：");
        String s = inputStr();
        System.out.print("请输入数量：");
        int i = inputNumb();
        boolean update = bookService.update(s, i);
        if (update){
            System.out.println("修改成功~");
        }else {
            System.out.println("修改失败~");
        }
    }

    //    读入一个数字工具
    public static int inputNumb() {
        int i = 0;
        Scanner sc;
       while (true) {
           sc = new Scanner(System.in);
           try {
               i = sc.nextInt();
               return i;
           } catch (Exception e) {
               System.out.println( "输入错误,请重新输入：");
               sc = new Scanner(System.in);
           }
       }
    }

    //    读入数据
    public static String inputStr() {
        Scanner sc;
        sc = new Scanner(System.in);
        String str = sc.next();
        return str;
    }

//    public static String date() {
//        // 获取当前的日期时间
//        LocalDateTime currentTime = LocalDateTime.now();
////        System.out.println("当前时间: " + currentTime);
//
//        LocalDate date1 = currentTime.toLocalDate();
//
////        System.out.println("date1: " + date1.toString());
////
////        Month month = currentTime.getMonth();
////        int day = currentTime.getDayOfMonth();
////        int seconds = currentTime.getSecond();
//
////        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);
//
//        return (date1.toString()+currentTime);
//    }
public static String date() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = now.format(formatter);
    return formattedDateTime;
//    System.out.println("Formatted date and time: " + formattedDateTime);
}



}