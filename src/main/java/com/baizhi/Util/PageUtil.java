package com.baizhi.Util;

import com.baizhi.entity.Album;

import java.util.List;

public class PageUtil <T>{
    private List<T> rows;//分页之后的展示集合
    private Integer total;//多少条

    public PageUtil() {
    }

    public PageUtil(List<T> rows, Integer total) {
        this.rows = rows;
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
