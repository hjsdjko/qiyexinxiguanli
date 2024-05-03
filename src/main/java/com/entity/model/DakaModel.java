package com.entity.model;

import com.entity.DakaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 上下班打卡
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DakaModel implements Serializable {
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
     * 打卡类型
     */
    private Integer dakaTypes;


    /**
     * 打卡状态
     */
    private Integer dakaZhuangtaiTypes;


    /**
     * 打卡时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date dakaTime;


    /**
     * 打卡日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 打卡备注
     */
    private String dakaContent;


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
	 * 获取：打卡类型
	 */
    public Integer getDakaTypes() {
        return dakaTypes;
    }


    /**
	 * 设置：打卡类型
	 */
    public void setDakaTypes(Integer dakaTypes) {
        this.dakaTypes = dakaTypes;
    }
    /**
	 * 获取：打卡状态
	 */
    public Integer getDakaZhuangtaiTypes() {
        return dakaZhuangtaiTypes;
    }


    /**
	 * 设置：打卡状态
	 */
    public void setDakaZhuangtaiTypes(Integer dakaZhuangtaiTypes) {
        this.dakaZhuangtaiTypes = dakaZhuangtaiTypes;
    }
    /**
	 * 获取：打卡时间
	 */
    public Date getDakaTime() {
        return dakaTime;
    }


    /**
	 * 设置：打卡时间
	 */
    public void setDakaTime(Date dakaTime) {
        this.dakaTime = dakaTime;
    }
    /**
	 * 获取：打卡日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：打卡日期
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：打卡备注
	 */
    public String getDakaContent() {
        return dakaContent;
    }


    /**
	 * 设置：打卡备注
	 */
    public void setDakaContent(String dakaContent) {
        this.dakaContent = dakaContent;
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
