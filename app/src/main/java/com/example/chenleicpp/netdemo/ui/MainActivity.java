package com.example.chenleicpp.netdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.chenleicpp.netdemo.NetApplication;
import com.example.chenleicpp.netdemo.R;
import com.example.chenleicpp.netdemo.http.GsonGetRequest;
import com.example.chenleicpp.netdemo.model.CategoryList;
import com.example.chenleicpp.netdemo.model.NewsList;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getTestRequest1();
        getTestRequest2();
    }

    private void getTestRequest2() {
        //http://testweb.timeerp.com/mobile/getWjtcList.asp?type=5&page_num=1&page_size=5
        String url = "http://testweb.timeerp.com/mobile/getWjtcList.asp";
        GsonGetRequest<NewsList> request = new GsonGetRequest<NewsList>(url, NewsList.class,
                new Response.Listener<NewsList>() {
                    @Override
                    public void onResponse(NewsList response) {
                        Log.i("chenleicpp",response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("type","5");
                map.put("page_num","1");
                map.put("page_size","5");
                return map;
            }
        };
        NetApplication.addToRequestQueue(this,request);
    }

    private void getTestRequest1() {
        String url = "http://testweb.timeerp.com/mobile/getNavigation.asp";
        GsonGetRequest<CategoryList> gRequest = new GsonGetRequest<CategoryList>(url, CategoryList.class,
                new Response.Listener<CategoryList>() {
                    @Override
                    public void onResponse(CategoryList response) {
                        Log.i("chenleicpp",response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        NetApplication.addToRequestQueue(this,gRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
