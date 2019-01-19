package com.org.utils;

import lombok.Data;

import java.util.List;

/**
 * Created by Simple on 2018-12-28 16:42:37.
 */
@Data
public class LayerData<T> {

    private Integer code = 0;
    private Integer count;
    private List<T> data;
    private String msg = "";
}
