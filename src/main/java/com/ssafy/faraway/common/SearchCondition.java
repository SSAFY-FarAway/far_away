package com.ssafy.faraway.common;

import lombok.*;

@Getter
@ToString
@Setter
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
        this.recordSize = 3;
        this.pageSize = 10;
    }


    public void setKey(String key) {
        if(!key.equals("")) {
            this.key = key;
        }

    }

    public void setWord(String word) {
        if(!word.equals("")) {
            this.word = word;
        }
    }
}
