package com.aaa.until;/*
 */

import lombok.Data;

import java.util.List;

@Data
public class PageModel<T> {

    //起始页数
    private Integer currentPage = 1;

    //每页显示的数据默认5
    private Integer pageSize = 5;

    //尾页
    private Integer lastPage;

    //一共多少条数据
    private Long total;

    //查询出的参数
    private List<T> rows;

    //搜索关键字
    private Object keyWord;


}
