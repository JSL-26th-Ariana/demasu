package com.jsl26tp.jsl26tp.toilet.domain;

import lombok.Data;

@Data
public class ToiletTag {
    private Long id;
    private Long toiletId;
    private String tagName;
}
