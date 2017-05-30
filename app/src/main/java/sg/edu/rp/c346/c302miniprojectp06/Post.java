package sg.edu.rp.c346.c302miniprojectp06;

/**
 * Created by 15017608 on 30/5/2017.
 */

public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;


    public int getPostUserId(){
        return userId;
    }
    public void setPostUserId(int userId) {
        this.userId = userId;
    }
    public int getPostId(){
        return id;
    }
    public void setPostId(int id){
        this.id = id;
    }
    public String getPostTitle(){
        return title;
    }
    public void setPostTitle(String title){
        this.title = title;
    }
    public String getPostBody(){
        return body;
    }
    public void setPostBody(String body){
        this.body = body;
    }
}
