package com.ssafy.faraway.common;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class PlanSearchCondition {
    private String key = "none";
    private String word;
    private String orderBy="none";
    private String orderByDir = "desc";

    @Builder
    public PlanSearchCondition(String key, String word) {
        this(key, word, "none");
    }

    @Builder
    public PlanSearchCondition(String key, String word, String orderBy) {
        this(key, word, orderBy, "desc");
    }

    @Builder
    public PlanSearchCondition(String key, String word, String orderBy, String orderByDir) {
        this.key = key;
        this.word = word;
        this.orderBy = orderBy;
        this.orderByDir = orderByDir;
    }
}

