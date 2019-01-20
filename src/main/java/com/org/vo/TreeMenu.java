package com.org.vo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * menu树
 */
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

    public TreeMenu(Long id, Long pid, String title,String href) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.href = href;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<TreeMenu> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMenu> children) {
        this.children = children;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
