package com.ssafy.faraway.common;

import lombok.*;

@Setter
@Getter
@ToString
public class SearchCondition {
    private int page;
    private int recordSize;
    private int pageSize;
    private String key = "none";
    private String word;
    private String orderBy = "none";
    private String orderByDir = "desc";
    private Pagination pagination;

    public SearchCondition() {
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }

    public SearchCondition(String key, String word) {
        this();
        this.key = key;
        this.word = word;
    }

    public SearchCondition(String key, String word, String orderBy) {
        this(key, word);
        this.orderBy = orderBy;
    }

    public SearchCondition(String key, String word, String orderBy, String orderByDir) {
        this(key, word, orderBy);
        this.orderByDir = orderByDir;
    }
}
