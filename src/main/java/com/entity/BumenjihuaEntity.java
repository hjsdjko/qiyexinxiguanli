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
 * 部门计划
 *
 * @author 
 * @email
 */
@TableName("bumenjihua")
public class BumenjihuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BumenjihuaEntity() {

	}

	public BumenjihuaEntity(T t) {
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
     * 部门计划编号
     */
    @TableField(value = "bumenjihua_uuid_number")

    private String bumenjihuaUuidNumber;


    /**
     * 部门计划标题
     */
    @TableField(value = "bumenjihua_name")

    private String bumenjihuaName;


    /**
     * 部门计划类型
     */
    @TableField(value = "bumenjihua_types")

    private Integer bumenjihuaTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "bumenjihua_zhixing_time")

    private Date bumenjihuaZhixingTime;


    /**
     * 部门计划详情
     */
    @TableField(value = "bumenjihua_content")

    private String bumenjihuaContent;


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
	 * 设置：部门计划编号
	 */
    public String getBumenjihuaUuidNumber() {
        return bumenjihuaUuidNumber;
    }
    /**
	 * 获取：部门计划编号
	 */

    public void setBumenjihuaUuidNumber(String bumenjihuaUuidNumber) {
        this.bumenjihuaUuidNumber = bumenjihuaUuidNumber;
    }
    /**
	 * 设置：部门计划标题
	 */
    public String getBumenjihuaName() {
        return bumenjihuaName;
    }
    /**
	 * 获取：部门计划标题
	 */

    public void setBumenjihuaName(String bumenjihuaName) {
        this.bumenjihuaName = bumenjihuaName;
    }
    /**
	 * 设置：部门计划类型
	 */
    public Integer getBumenjihuaTypes() {
        return bumenjihuaTypes;
    }
    /**
	 * 获取：部门计划类型
	 */

    public void setBumenjihuaTypes(Integer bumenjihuaTypes) {
        this.bumenjihuaTypes = bumenjihuaTypes;
    }
    /**
	 * 设置：执行时间
	 */
    public Date getBumenjihuaZhixingTime() {
        return bumenjihuaZhixingTime;
    }
    /**
	 * 获取：执行时间
	 */

    public void setBumenjihuaZhixingTime(Date bumenjihuaZhixingTime) {
        this.bumenjihuaZhixingTime = bumenjihuaZhixingTime;
    }
    /**
	 * 设置：部门计划详情
	 */
    public String getBumenjihuaContent() {
        return bumenjihuaContent;
    }
    /**
	 * 获取：部门计划详情
	 */

    public void setBumenjihuaContent(String bumenjihuaContent) {
        this.bumenjihuaContent = bumenjihuaContent;
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
        return "Bumenjihua{" +
            "id=" + id +
            ", bumenjihuaUuidNumber=" + bumenjihuaUuidNumber +
            ", bumenjihuaName=" + bumenjihuaName +
            ", bumenjihuaTypes=" + bumenjihuaTypes +
            ", bumenjihuaZhixingTime=" + bumenjihuaZhixingTime +
            ", bumenjihuaContent=" + bumenjihuaContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
