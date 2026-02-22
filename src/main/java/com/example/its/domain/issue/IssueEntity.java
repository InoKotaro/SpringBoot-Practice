package com.example.its.domain.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

//データモデル層
//DBテーブルと対応
@AllArgsConstructor
@Data
public class IssueEntity {
    private long id;
    private String summary;
    private String description;
}

