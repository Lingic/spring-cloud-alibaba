package com.rfics.unit;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PageMode {

    // 表示第几页
    @Getter
    @Setter
    @Builder.Default
    private int pageNum = 1;

    // 表示一页展示的数据
    @Getter
    @Setter
    @Builder.Default
    private int pageSize = 10;
}
