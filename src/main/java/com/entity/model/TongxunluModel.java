package com.entity.model;

import com.entity.TongxunluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 通讯录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TongxunluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 朋友姓名
     */
    private String tongxunluName;


    /**
     * 朋友手机号
     */
    private String tongxunluPhone;


    /**
     * 朋友照片
     */
    private String tongxunluPhoto;


    /**
     * 朋友现住址
     */
    private String tongxunluAddress;


    /**
     * 朋友性别
     */
    private Integer sexTypes;


    /**
     * 朋友所在公司
     */
    private String tongxunluGongsi;


    /**
     * 朋友所属职位
     */
    private String tongxunluZhiwei;


    /**
     * 朋友电子邮箱
     */
    private String tongxunluEmail;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：朋友姓名
	 */
    public String getTongxunluName() {
        return tongxunluName;
    }


    /**
	 * 设置：朋友姓名
	 */
    public void setTongxunluName(String tongxunluName) {
        this.tongxunluName = tongxunluName;
    }
    /**
	 * 获取：朋友手机号
	 */
    public String getTongxunluPhone() {
        return tongxunluPhone;
    }


    /**
	 * 设置：朋友手机号
	 */
    public void setTongxunluPhone(String tongxunluPhone) {
        this.tongxunluPhone = tongxunluPhone;
    }
    /**
	 * 获取：朋友照片
	 */
    public String getTongxunluPhoto() {
        return tongxunluPhoto;
    }


    /**
	 * 设置：朋友照片
	 */
    public void setTongxunluPhoto(String tongxunluPhoto) {
        this.tongxunluPhoto = tongxunluPhoto;
    }
    /**
	 * 获取：朋友现住址
	 */
    public String getTongxunluAddress() {
        return tongxunluAddress;
    }


    /**
	 * 设置：朋友现住址
	 */
    public void setTongxunluAddress(String tongxunluAddress) {
        this.tongxunluAddress = tongxunluAddress;
    }
    /**
	 * 获取：朋友性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：朋友性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：朋友所在公司
	 */
    public String getTongxunluGongsi() {
        return tongxunluGongsi;
    }


    /**
	 * 设置：朋友所在公司
	 */
    public void setTongxunluGongsi(String tongxunluGongsi) {
        this.tongxunluGongsi = tongxunluGongsi;
    }
    /**
	 * 获取：朋友所属职位
	 */
    public String getTongxunluZhiwei() {
        return tongxunluZhiwei;
    }


    /**
	 * 设置：朋友所属职位
	 */
    public void setTongxunluZhiwei(String tongxunluZhiwei) {
        this.tongxunluZhiwei = tongxunluZhiwei;
    }
    /**
	 * 获取：朋友电子邮箱
	 */
    public String getTongxunluEmail() {
        return tongxunluEmail;
    }


    /**
	 * 设置：朋友电子邮箱
	 */
    public void setTongxunluEmail(String tongxunluEmail) {
        this.tongxunluEmail = tongxunluEmail;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
