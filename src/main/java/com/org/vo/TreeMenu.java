package com.org.vo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * menu树
 */
@Data
public class TreeMenu {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "父id")
    private  Long pid;

    @ApiModelProperty(value = "名字标题")
    private String title;

    @ApiModelProperty(value = "链接")
    private String href;

    @ApiModelProperty(value = "是否展开")
    private Boolean spread;

    @ApiModelProperty(value = "树")
    List<TreeMenu> children = Lists.newArrayList();

    public TreeMenu(Boolean spread) {
        this.spread = false;
    }

    public TreeMenu(Long id, Long pid, String title, String href) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.href = href;
    }

}
