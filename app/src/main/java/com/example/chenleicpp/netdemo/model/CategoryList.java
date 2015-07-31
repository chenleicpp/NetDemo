package com.example.chenleicpp.netdemo.model;

import java.util.List;

/**
 * Created by chenleicpp on 2015/7/31.
 */
public class CategoryList {
    private int result_code;
    private List<Category> data;

    public static class Category{
        private int category_type;
        private int category_id;
        private String category_name;

        public int getCategory_type() {
            return category_type;
        }

        public void setCategory_type(int category_type) {
            this.category_type = category_type;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "category_type=" + category_type +
                    ", category_id=" + category_id +
                    ", category_name='" + category_name + '\'' +
                    '}';
        }
    }

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public List<Category> getData() {
        return data;
    }

    public void setData(List<Category> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CategoryList{" +
                "result_code=" + result_code +
                ", data=" + data +
                '}';
    }
}
