package com.entity.model;

import com.entity.HuiyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 会议
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuiyiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 会议编号
     */
    private String huiyiUuidNumber;


    /**
     * 会议名称
     */
    private String huiyiName;


    /**
     * 会议类型
     */
    private Integer huiyiTypes;


    /**
     * 会议地点
     */
    private String huiyiAddress;


    /**
     * 开会时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaihuiTime;


    /**
     * 会议详情
     */
    private String zuoyeContent;


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
	 * 获取：会议编号
	 */
    public String getHuiyiUuidNumber() {
        return huiyiUuidNumber;
    }


    /**
	 * 设置：会议编号
	 */
    public void setHuiyiUuidNumber(String huiyiUuidNumber) {
        this.huiyiUuidNumber = huiyiUuidNumber;
    }
    /**
	 * 获取：会议名称
	 */
    public String getHuiyiName() {
        return huiyiName;
    }


    /**
	 * 设置：会议名称
	 */
    public void setHuiyiName(String huiyiName) {
        this.huiyiName = huiyiName;
    }
    /**
	 * 获取：会议类型
	 */
    public Integer getHuiyiTypes() {
        return huiyiTypes;
    }


    /**
	 * 设置：会议类型
	 */
    public void setHuiyiTypes(Integer huiyiTypes) {
        this.huiyiTypes = huiyiTypes;
    }
    /**
	 * 获取：会议地点
	 */
    public String getHuiyiAddress() {
        return huiyiAddress;
    }


    /**
	 * 设置：会议地点
	 */
    public void setHuiyiAddress(String huiyiAddress) {
        this.huiyiAddress = huiyiAddress;
    }
    /**
	 * 获取：开会时间
	 */
    public Date getKaihuiTime() {
        return kaihuiTime;
    }


    /**
	 * 设置：开会时间
	 */
    public void setKaihuiTime(Date kaihuiTime) {
        this.kaihuiTime = kaihuiTime;
    }
    /**
	 * 获取：会议详情
	 */
    public String getZuoyeContent() {
        return zuoyeContent;
    }


    /**
	 * 设置：会议详情
	 */
    public void setZuoyeContent(String zuoyeContent) {
        this.zuoyeContent = zuoyeContent;
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
