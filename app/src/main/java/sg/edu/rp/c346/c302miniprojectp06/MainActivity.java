package sg.edu.rp.c346.c302miniprojectp06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView1;

    ArrayList<Todo> todoList = new ArrayList<Todo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://trytocode.com/c302/todo.json";
        HttpRequest request = new HttpRequest(url);
        request.setMethod("GET");

        request.execute();
        try {
            //TODO 4
            String jsonString = request.getResponse();

            System.out.println(">>" + jsonString);
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                Todo cat = new Todo();
                cat.setTodoUserId(Integer.parseInt(jsonObj.getString("userId")));
                cat.setTodoId(Integer.parseInt(jsonObj.getString("id")));
                cat.setTodoTitle(jsonObj.getString("title"));
                cat.setTodoCompleted(jsonObj.getBoolean("completed"));
                todoList.add(cat);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

        TodoAdapter adapter = new TodoAdapter(this,
                R.layout.row, todoList);

        listView1 = (ListView)findViewById(R.id.lv1);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                Todo category = (Todo) arg0.getItemAtPosition(arg2);

                Intent i = new Intent(getApplicationContext(), PostActivity.class);
                i.putExtra("userId", category.getTodoUserId());
                startActivity(i);

            }

        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//public boolean onOptionsItemSelected(MenuItem item) {
//    // Handle action bar item clicks here. The action bar will
//    // automatically handle clicks on the Home/Up button, so long
//    // as you specify a parent activity in AndroidManifest.xml.
//    int id = item.getItemId();
//
//    //noinspection SimplifiableIfStatement
//    if (id == R.id.action_settings) {
//        return true;
//    }
//
//    return super.onOptionsItemSelected(item);
//}
}

