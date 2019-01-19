package com.org.base;


import com.baomidou.mybatisplus.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * Entity支持类
 * @param <T>
 */
public abstract class BaseEntity<T extends Model> extends Model<T> {

    @ApiModelProperty(value = "实体编号（唯一标识）")
    protected Long id;

    public BaseEntity() {

    }

    public BaseEntity(Long id) {
        this();
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @JsonSerialize(using=ToStringSerializer.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        BaseEntity<?> that = (BaseEntity<?>) obj;
        return null != this.getId() && this.getId().equals(that.getId());
    }




}
