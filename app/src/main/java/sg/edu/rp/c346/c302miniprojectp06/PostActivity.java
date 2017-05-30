package sg.edu.rp.c346.c302miniprojectp06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    private int currentId;

    ListView lvPost;
    ArrayList<Post> postList = new ArrayList<Post>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent i = getIntent();
        currentId = i.getIntExtra("userId", -1);

        lvPost = (ListView)findViewById(R.id.lvPost);
        String url = "http://trytocode.com/c302/posts.json";
        HttpRequest request = new HttpRequest(url);
        request.setMethod("GET");

        request.execute();
        try {
            //TODO 4
            String jsonString = request.getResponse();

            System.out.println(">>" + jsonString);
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int x = 0; x < jsonArray.length(); x++) {
                JSONObject jsonObj = jsonArray.getJSONObject(x);
                int id = jsonObj.getInt("userId");
                if(id == currentId){
                Post cat = new Post();
                //cat.setPostUserId(Integer.parseInt(jsonObj.getString("userId")));
                //cat.setPostId(Integer.parseInt(jsonObj.getString("id")));
                //cat.setPostTitle(jsonObj.getString("title"));
                cat.setPostBody(jsonObj.getString("body"));
                postList.add(cat);
            }

            }
        }catch(Exception e) {
            e.printStackTrace();
        }

        PostAdapter adapter = new PostAdapter(this,
                R.layout.row, postList);

        lvPost = (ListView)findViewById(R.id.lv1);

        lvPost.setAdapter(adapter);

    }
}
