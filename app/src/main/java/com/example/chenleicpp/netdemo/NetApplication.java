package com.example.chenleicpp.netdemo;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;
import com.example.chenleicpp.netdemo.http.OkHttpStack;

/**
 * Created by chenleicpp on 2015/7/31.
 */
public class NetApplication extends Application {

    private static RequestQueue mRequestQueue;
    public static final String DEFAULT_REQUEST_TAG = "VolleyRequest";
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static void initVolley(Context context){
        if (mRequestQueue != null){
            return;
        }
        mRequestQueue = Volley.newRequestQueue(context,new OkHttpStack());
    }

    public static RequestQueue getRequestQueue(Context context) {
        if (mRequestQueue == null) {
            initVolley(context);
        }

        return mRequestQueue;
    }

    public static <T> void addToRequestQueue(Context context, Request<T> request, String tag) {
        // Use default request tag if tag is empty.
        request.setTag(TextUtils.isEmpty(tag) ? DEFAULT_REQUEST_TAG : tag);

        VolleyLog.d("Adding request to queue: %s", request.getUrl());

        getRequestQueue(context).add(request);
    }

    public static <T> void addToRequestQueue(Context context, Request<T> request) {
        // Use default request tag.
        request.setTag(DEFAULT_REQUEST_TAG);

        getRequestQueue(context).add(request);
    }

    public static void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
