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
        this.recordSize = 10;
        this.pageSize = 10;
    }

    public SearchCondition(int page) {
        this();
        this.page = page;
    }

    public SearchCondition(int page, String key, String word) {
        this(page);
        this.key = key;
        this.word = word;
    }

    public SearchCondition(int page, String key, String word, String orderBy) {
        this(page, key, word);
        this.orderBy = orderBy;
    }

    public SearchCondition(int page, String key, String word, String orderBy, String orderByDir) {
        this(page, key, word, orderBy);
        this.orderByDir = orderByDir;
    }
}
