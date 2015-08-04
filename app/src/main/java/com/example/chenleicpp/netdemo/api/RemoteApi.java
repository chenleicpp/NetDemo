package com.example.chenleicpp.netdemo.api;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.example.chenleicpp.netdemo.NetApplication;
import com.example.chenleicpp.netdemo.http.GsonGetRequest;
import com.example.chenleicpp.netdemo.http.HttpConstants;
import com.example.chenleicpp.netdemo.model.CategoryList;
import com.example.chenleicpp.netdemo.model.NewsList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenleicpp on 2015/8/3.
 */
public class RemoteApi {

    public static void getNavigation(Response.Listener<CategoryList> listener){
        String navigationUrl = "getNavigation.asp";
        NetApplication.addToRequestQueue(NetApplication.getInstance(),
                new GsonGetRequest<CategoryList>(getAbsoluteApiUrl(navigationUrl),CategoryList.class,
                null,listener,errorListener()));
    }

    public static void getWjtcList(Response.Listener<NewsList> listener,String type,String page_size,String page_num){
        String navigationUrl = "getWjtcList.asp";
        Map<String,String> params = new HashMap<String,String>();
        params.put("type",type);
        params.put("page_num",page_size);
        params.put("page_size",page_num);
        NetApplication.addToRequestQueue(NetApplication.getInstance(),
                new GsonGetRequest<NewsList>(getAbsoluteApiUrl(navigationUrl),NewsList.class,
                        params,listener,errorListener()));
    }

    private static String getAbsoluteApiUrl(String partUrl) {
        String url = String.format(HttpConstants.API_URL, partUrl);
        return url;
    }

    private static Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if( error instanceof NetworkError) {
                    //Indicates that there was a network error when performing a Volley request.
                    Toast.makeText(NetApplication.getInstance(), "NetworkError", Toast.LENGTH_SHORT).show();
                } else if( error instanceof ServerError) {
                    //Indicates that the server responded with an error response.
                    Toast.makeText(NetApplication.getInstance(),"ServerError",Toast.LENGTH_SHORT).show();
                } else if( error instanceof AuthFailureError) {
                    //Error indicating that there was an authentication failure when performing a Request.
                    Toast.makeText(NetApplication.getInstance(),"AuthFailureError",Toast.LENGTH_SHORT).show();
                } else if( error instanceof ParseError) {
                    //Indicates that the server's response could not be parsed.
                    Toast.makeText(NetApplication.getInstance(),"ParseError",Toast.LENGTH_SHORT).show();
                } else if( error instanceof NoConnectionError) {
                    //Error indicating that no connection could be established when performing a Volley request.
                    Toast.makeText(NetApplication.getInstance(),"NoConnectionError",Toast.LENGTH_SHORT).show();
                } else if( error instanceof TimeoutError) {
                    //Indicates that the connection or the socket timed out.
                    Toast.makeText(NetApplication.getInstance(),"TimeoutError",Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}
