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

public class PostAdapter extends ArrayAdapter<Post> {
    Context context;
    int layoutResourceId;
    ArrayList<Post> postList = null;

    public PostAdapter(Context context, int layoutResourceId, ArrayList<Post> postList) {
        super(context, layoutResourceId, postList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.postList = postList;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PostAdapter.PostHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new PostAdapter.PostHolder();
            holder.txtBody = (TextView)row.findViewById(R.id.textViewBody);

            row.setTag(holder);
        }
        else
        {
            holder = (PostAdapter.PostHolder)row.getTag();
        }

        Post cat = postList.get(position);
        holder.txtBody.setText(cat.getPostBody());
        return row;
    }

    static class PostHolder
    {
        TextView txtBody;

    }
}
