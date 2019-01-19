package com.org.base;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.org.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 数据Entity类
 */
@Data
public abstract class DataEntity<T extends Model> extends BaseEntity<T> {

    private static final long serialVersionUID = 115885993184581433L;

    @TableField(value = "create_date", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date createDate;

    @ApiModelProperty(value = "更新日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    protected Date updateDate;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "删除标记（Y：正常；N：删除；A：审核；）")
    protected Boolean delFlag;

    @TableField(strategy= FieldStrategy.IGNORED)
    @ApiModelProperty(value = "备注")
    protected String remarks;

    @ApiModelProperty(value = "创建者")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    protected Long createId;

    @ApiModelProperty(value = "更新者")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    protected Long updateId;

    @ApiModelProperty(value = "创建者")
    @TableField(exist = false)
    protected User createUser;

    @ApiModelProperty(value = "创建者")
    @TableField(exist = false)
    protected User updateUser;


    public DataEntity() {
        super();
        this.delFlag = false;
    }

    public DataEntity(Long id) {
        super(id);
    }

}
