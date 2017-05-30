package sg.edu.rp.c346.c302miniprojectp06;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by 15017608 on 30/5/2017.
 */

public class TodoAdapter extends ArrayAdapter<Todo>{
    Context context;
    int layoutResourceId;
    ArrayList<Todo> todoList = null;

    public TodoAdapter(Context context, int layoutResourceId, ArrayList<Todo> todoList) {
        super(context, layoutResourceId, todoList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.todoList = todoList;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TodoHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new TodoHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.textViewTitle);
            holder.txtComplete= (TextView)row.findViewById(R.id.textViewComplete);

            row.setTag(holder);
        }
        else
        {
            holder = (TodoHolder)row.getTag();
        }

        Todo cat = todoList.get(position);
        holder.txtTitle.setText(cat.getTodoTitle());
        holder.txtComplete.setText("" + cat.getTodoComplete());
        return row;
    }

    static class TodoHolder
    {
        TextView txtTitle;
        TextView txtComplete;
    }


}
