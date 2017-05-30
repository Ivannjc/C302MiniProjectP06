package sg.edu.rp.c346.c302miniprojectp06;

/**
 * Created by 15017608 on 30/5/2017.
 */

public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;


    public int getTodoUserId(){
        return userId;
    }
    public void setTodoUserId(int userId) {
        this.userId = userId;
    }
    public int getTodoId(){
        return id;
    }
    public void setTodoId(int id){
        this.id = id;
    }
    public String getTodoTitle(){
        return title;
    }
    public void setTodoTitle(String title){
        this.title = title;
    }
    public boolean getTodoComplete(){
        return completed;
    }
    public void setTodoCompleted(Boolean completed){
        this.completed = completed;
    }

}
