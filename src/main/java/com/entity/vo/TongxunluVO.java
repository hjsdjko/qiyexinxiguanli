package com.entity.vo;

import com.entity.TongxunluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 通讯录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tongxunlu")
public class TongxunluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
