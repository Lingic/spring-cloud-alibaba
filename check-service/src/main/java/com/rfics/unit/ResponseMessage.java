package com.rfics.unit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@ToString
public class ResponseMessage {

    // 返回结果代码 000000 六个零表示成功；非六个零则表示失败；
    @Getter
    @Setter
    private String rc;

    // 返回结果错误信息 如返回结果代码为非六个零则填入此错误信息；
    @Getter
    @Setter
    private String rt;

    // 返回结果Map，load business data info.
    @Getter
    @Setter
    private Map<String, Object> rb;
}
