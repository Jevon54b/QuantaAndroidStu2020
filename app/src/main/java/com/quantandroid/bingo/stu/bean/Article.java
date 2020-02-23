package com.quantandroid.bingo.stu.bean;

public class Article {

    //ALT+insert 唤出gsonformat

    /**
     * id : 4
     * title : “胃！你好吗？”
     * author : 詹晶晶中医生
     * realease_time : 1577504586000
     * content : null
     * pic : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577514687028&di=109989f3628a49a6328d6dd6542c6927&imgtype=0&src=http%3A%2F%2Fwww.51yuansu.com%2Fpic2%2Fcover%2F00%2F29%2F41%2F580c18aab97d1_610.jpg
     * read_num : 40
     * comment_num : 11
     */

    private String id;
    private String title;
    private String author;
    private long realease_time;
    private Object content;
    private String pic;
    private int read_num;
    private int comment_num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getRealease_time() {
        return realease_time;
    }

    public void setRealease_time(long realease_time) {
        this.realease_time = realease_time;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getRead_num() {
        return read_num;
    }

    public void setRead_num(int read_num) {
        this.read_num = read_num;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }
}
