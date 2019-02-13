package com.org.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * menuVo
 */
@Data
public class ShowMenu implements Serializable{

    private static final long serialVersionUID = -7714594080308108786L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "父id")
    private  Long pid;

    @ApiModelProperty(value = "名字标题")
    private String title;

    @ApiModelProperty(value = "链接")
    private String href;

    @ApiModelProperty(value = "是否展开")
    private Boolean spread = false;

    @ApiModelProperty(value = "菜单")
    private List<ShowMenu> children = new ArrayList<>();
}
