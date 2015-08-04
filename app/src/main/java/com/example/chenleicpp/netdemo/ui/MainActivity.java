package com.example.chenleicpp.netdemo.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.example.chenleicpp.netdemo.R;
import com.example.chenleicpp.netdemo.api.RemoteApi;
import com.example.chenleicpp.netdemo.model.CategoryList;
import com.example.chenleicpp.netdemo.model.NewsList;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.btn_no_param)
    Button mBtnNoParam;
    @Bind(R.id.btn_with_param)
    Button mBtnWithParam;
    @Bind(R.id.tv_content)
    TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private Response.Listener<CategoryList> responseListener(){
        return new Response.Listener<CategoryList>() {
            @Override
            public void onResponse(CategoryList response) {
                mTvContent.setText(response.toString());
            }
        };
    }

    private Response.Listener<NewsList> getWjtcList = new Response.Listener<NewsList>() {
        @Override
        public void onResponse(NewsList response) {
            mTvContent.setText(response.toString());
        }
    };

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

    @OnClick({R.id.btn_no_param,R.id.btn_with_param})
    public void testPost(View view) {
        switch (view.getId()){
            case R.id.btn_no_param:
                RemoteApi.getNavigation(responseListener());
                break;
            case R.id.btn_with_param:
                RemoteApi.getWjtcList(getWjtcList,"5","5","1");
                break;
        }
    }
}
