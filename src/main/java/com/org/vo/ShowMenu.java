package com.org.vo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * menuVo
 */
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
    private List<ShowMenu> children = Lists.newArrayList();

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

    public List<ShowMenu> getChildren() {
        return children;
    }

    public void setChildren(List<ShowMenu> children) {
        this.children = children;
    }

}
