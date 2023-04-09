package com.abu.book.bean;

/**
 * @author 阿卜杜赛麦提
 * @version 1.0
 * @date 2023/3/20
 */
public class BookBean {
    private Integer id;
    private Integer numb;
    private String name;
    private String date;

    /**
     *
     * @param id 书id
     * @param name 书名称
     * @param numb 库存
     * @param date 添加日期
     */
    public BookBean(Integer id, String name,Integer numb, String date) {
        this.id = id;
        this.name = name;
        this.numb = numb;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumb() {
        return numb;
    }

    public void setNumb(Integer numb) {
        this.numb = numb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public  String toString() {
        return  id + "\t\t" + name + "\t\t" + numb + "\t\t" + date ;
    }
}
