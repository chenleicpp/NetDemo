package com.example.chenleicpp.netdemo.model;

import java.util.List;

/**
 * Created by chenleicpp on 2015/7/31.
 */
public class NewsList {
    private int result_code;
    private int total_count;
    private String message;
    private List<New> data;
    public static class New{
        private int new_id;
        private String new_title;
        private String new_img;

        public int getNew_id() {
            return new_id;
        }

        public void setNew_id(int new_id) {
            this.new_id = new_id;
        }

        public String getNew_title() {
            return new_title;
        }

        public void setNew_title(String new_title) {
            this.new_title = new_title;
        }

        public String getNew_img() {
            return new_img;
        }

        public void setNew_img(String new_img) {
            this.new_img = new_img;
        }

        @Override
        public String toString() {
            return "New{" +
                    "new_id=" + new_id +
                    ", new_title='" + new_title + '\'' +
                    ", new_img='" + new_img + '\'' +
                    '}';
        }
    }

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<New> getData() {
        return data;
    }

    public void setData(List<New> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NewsList{" +
                "result_code=" + result_code +
                ", total_count=" + total_count +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
