package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 个人计划
 *
 * @author 
 * @email
 */
@TableName("gerenjihua")
public class GerenjihuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GerenjihuaEntity() {

	}

	public GerenjihuaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 员工
     */
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 个人计划编号
     */
    @TableField(value = "gerenjihua_uuid_number")

    private String gerenjihuaUuidNumber;


    /**
     * 个人计划标题
     */
    @TableField(value = "gerenjihua_name")

    private String gerenjihuaName;


    /**
     * 个人计划类型
     */
    @TableField(value = "gerenjihua_types")

    private Integer gerenjihuaTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "gerenjihua_zhixing_time")

    private Date gerenjihuaZhixingTime;


    /**
     * 个人计划详情
     */
    @TableField(value = "gerenjihua_content")

    private String gerenjihuaContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：个人计划编号
	 */
    public String getGerenjihuaUuidNumber() {
        return gerenjihuaUuidNumber;
    }
    /**
	 * 获取：个人计划编号
	 */

    public void setGerenjihuaUuidNumber(String gerenjihuaUuidNumber) {
        this.gerenjihuaUuidNumber = gerenjihuaUuidNumber;
    }
    /**
	 * 设置：个人计划标题
	 */
    public String getGerenjihuaName() {
        return gerenjihuaName;
    }
    /**
	 * 获取：个人计划标题
	 */

    public void setGerenjihuaName(String gerenjihuaName) {
        this.gerenjihuaName = gerenjihuaName;
    }
    /**
	 * 设置：个人计划类型
	 */
    public Integer getGerenjihuaTypes() {
        return gerenjihuaTypes;
    }
    /**
	 * 获取：个人计划类型
	 */

    public void setGerenjihuaTypes(Integer gerenjihuaTypes) {
        this.gerenjihuaTypes = gerenjihuaTypes;
    }
    /**
	 * 设置：执行时间
	 */
    public Date getGerenjihuaZhixingTime() {
        return gerenjihuaZhixingTime;
    }
    /**
	 * 获取：执行时间
	 */

    public void setGerenjihuaZhixingTime(Date gerenjihuaZhixingTime) {
        this.gerenjihuaZhixingTime = gerenjihuaZhixingTime;
    }
    /**
	 * 设置：个人计划详情
	 */
    public String getGerenjihuaContent() {
        return gerenjihuaContent;
    }
    /**
	 * 获取：个人计划详情
	 */

    public void setGerenjihuaContent(String gerenjihuaContent) {
        this.gerenjihuaContent = gerenjihuaContent;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Gerenjihua{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", gerenjihuaUuidNumber=" + gerenjihuaUuidNumber +
            ", gerenjihuaName=" + gerenjihuaName +
            ", gerenjihuaTypes=" + gerenjihuaTypes +
            ", gerenjihuaZhixingTime=" + gerenjihuaZhixingTime +
            ", gerenjihuaContent=" + gerenjihuaContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
