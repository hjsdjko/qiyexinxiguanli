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
 * 通讯录
 *
 * @author 
 * @email
 */
@TableName("tongxunlu")
public class TongxunluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TongxunluEntity() {

	}

	public TongxunluEntity(T t) {
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
     * 朋友姓名
     */
    @TableField(value = "tongxunlu_name")

    private String tongxunluName;


    /**
     * 朋友手机号
     */
    @TableField(value = "tongxunlu_phone")

    private String tongxunluPhone;


    /**
     * 朋友照片
     */
    @TableField(value = "tongxunlu_photo")

    private String tongxunluPhoto;


    /**
     * 朋友现住址
     */
    @TableField(value = "tongxunlu_address")

    private String tongxunluAddress;


    /**
     * 朋友性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 朋友所在公司
     */
    @TableField(value = "tongxunlu_gongsi")

    private String tongxunluGongsi;


    /**
     * 朋友所属职位
     */
    @TableField(value = "tongxunlu_zhiwei")

    private String tongxunluZhiwei;


    /**
     * 朋友电子邮箱
     */
    @TableField(value = "tongxunlu_email")

    private String tongxunluEmail;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
	 * 设置：朋友姓名
	 */
    public String getTongxunluName() {
        return tongxunluName;
    }
    /**
	 * 获取：朋友姓名
	 */

    public void setTongxunluName(String tongxunluName) {
        this.tongxunluName = tongxunluName;
    }
    /**
	 * 设置：朋友手机号
	 */
    public String getTongxunluPhone() {
        return tongxunluPhone;
    }
    /**
	 * 获取：朋友手机号
	 */

    public void setTongxunluPhone(String tongxunluPhone) {
        this.tongxunluPhone = tongxunluPhone;
    }
    /**
	 * 设置：朋友照片
	 */
    public String getTongxunluPhoto() {
        return tongxunluPhoto;
    }
    /**
	 * 获取：朋友照片
	 */

    public void setTongxunluPhoto(String tongxunluPhoto) {
        this.tongxunluPhoto = tongxunluPhoto;
    }
    /**
	 * 设置：朋友现住址
	 */
    public String getTongxunluAddress() {
        return tongxunluAddress;
    }
    /**
	 * 获取：朋友现住址
	 */

    public void setTongxunluAddress(String tongxunluAddress) {
        this.tongxunluAddress = tongxunluAddress;
    }
    /**
	 * 设置：朋友性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：朋友性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：朋友所在公司
	 */
    public String getTongxunluGongsi() {
        return tongxunluGongsi;
    }
    /**
	 * 获取：朋友所在公司
	 */

    public void setTongxunluGongsi(String tongxunluGongsi) {
        this.tongxunluGongsi = tongxunluGongsi;
    }
    /**
	 * 设置：朋友所属职位
	 */
    public String getTongxunluZhiwei() {
        return tongxunluZhiwei;
    }
    /**
	 * 获取：朋友所属职位
	 */

    public void setTongxunluZhiwei(String tongxunluZhiwei) {
        this.tongxunluZhiwei = tongxunluZhiwei;
    }
    /**
	 * 设置：朋友电子邮箱
	 */
    public String getTongxunluEmail() {
        return tongxunluEmail;
    }
    /**
	 * 获取：朋友电子邮箱
	 */

    public void setTongxunluEmail(String tongxunluEmail) {
        this.tongxunluEmail = tongxunluEmail;
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
        return "Tongxunlu{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", tongxunluName=" + tongxunluName +
            ", tongxunluPhone=" + tongxunluPhone +
            ", tongxunluPhoto=" + tongxunluPhoto +
            ", tongxunluAddress=" + tongxunluAddress +
            ", sexTypes=" + sexTypes +
            ", tongxunluGongsi=" + tongxunluGongsi +
            ", tongxunluZhiwei=" + tongxunluZhiwei +
            ", tongxunluEmail=" + tongxunluEmail +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
