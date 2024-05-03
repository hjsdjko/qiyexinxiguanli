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
 * 企业计划
 *
 * @author 
 * @email
 */
@TableName("qiyejihua")
public class QiyejihuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiyejihuaEntity() {

	}

	public QiyejihuaEntity(T t) {
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
     * 企业计划编号
     */
    @TableField(value = "qiyejihua_uuid_number")

    private String qiyejihuaUuidNumber;


    /**
     * 企业计划标题
     */
    @TableField(value = "qiyejihua_name")

    private String qiyejihuaName;


    /**
     * 企业计划类型
     */
    @TableField(value = "qiyejihua_types")

    private Integer qiyejihuaTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "qiyejihua_zhixing_time")

    private Date qiyejihuaZhixingTime;


    /**
     * 企业计划详情
     */
    @TableField(value = "qiyejihua_content")

    private String qiyejihuaContent;


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
	 * 设置：企业计划编号
	 */
    public String getQiyejihuaUuidNumber() {
        return qiyejihuaUuidNumber;
    }
    /**
	 * 获取：企业计划编号
	 */

    public void setQiyejihuaUuidNumber(String qiyejihuaUuidNumber) {
        this.qiyejihuaUuidNumber = qiyejihuaUuidNumber;
    }
    /**
	 * 设置：企业计划标题
	 */
    public String getQiyejihuaName() {
        return qiyejihuaName;
    }
    /**
	 * 获取：企业计划标题
	 */

    public void setQiyejihuaName(String qiyejihuaName) {
        this.qiyejihuaName = qiyejihuaName;
    }
    /**
	 * 设置：企业计划类型
	 */
    public Integer getQiyejihuaTypes() {
        return qiyejihuaTypes;
    }
    /**
	 * 获取：企业计划类型
	 */

    public void setQiyejihuaTypes(Integer qiyejihuaTypes) {
        this.qiyejihuaTypes = qiyejihuaTypes;
    }
    /**
	 * 设置：执行时间
	 */
    public Date getQiyejihuaZhixingTime() {
        return qiyejihuaZhixingTime;
    }
    /**
	 * 获取：执行时间
	 */

    public void setQiyejihuaZhixingTime(Date qiyejihuaZhixingTime) {
        this.qiyejihuaZhixingTime = qiyejihuaZhixingTime;
    }
    /**
	 * 设置：企业计划详情
	 */
    public String getQiyejihuaContent() {
        return qiyejihuaContent;
    }
    /**
	 * 获取：企业计划详情
	 */

    public void setQiyejihuaContent(String qiyejihuaContent) {
        this.qiyejihuaContent = qiyejihuaContent;
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
        return "Qiyejihua{" +
            "id=" + id +
            ", qiyejihuaUuidNumber=" + qiyejihuaUuidNumber +
            ", qiyejihuaName=" + qiyejihuaName +
            ", qiyejihuaTypes=" + qiyejihuaTypes +
            ", qiyejihuaZhixingTime=" + qiyejihuaZhixingTime +
            ", qiyejihuaContent=" + qiyejihuaContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
