package com.entity.model;

import com.entity.WaichudengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 外出登记
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WaichudengjiModel implements Serializable {
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
     * 外出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date waichuTime;


    /**
     * 外出事由
     */
    private String waichudengjiShiyou;


    /**
     * 外出类型
     */
    private Integer waichudengjiTypes;


    /**
     * 外出详情
     */
    private String waichudengjiContent;


    /**
     * 登记时间
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
	 * 获取：外出时间
	 */
    public Date getWaichuTime() {
        return waichuTime;
    }


    /**
	 * 设置：外出时间
	 */
    public void setWaichuTime(Date waichuTime) {
        this.waichuTime = waichuTime;
    }
    /**
	 * 获取：外出事由
	 */
    public String getWaichudengjiShiyou() {
        return waichudengjiShiyou;
    }


    /**
	 * 设置：外出事由
	 */
    public void setWaichudengjiShiyou(String waichudengjiShiyou) {
        this.waichudengjiShiyou = waichudengjiShiyou;
    }
    /**
	 * 获取：外出类型
	 */
    public Integer getWaichudengjiTypes() {
        return waichudengjiTypes;
    }


    /**
	 * 设置：外出类型
	 */
    public void setWaichudengjiTypes(Integer waichudengjiTypes) {
        this.waichudengjiTypes = waichudengjiTypes;
    }
    /**
	 * 获取：外出详情
	 */
    public String getWaichudengjiContent() {
        return waichudengjiContent;
    }


    /**
	 * 设置：外出详情
	 */
    public void setWaichudengjiContent(String waichudengjiContent) {
        this.waichudengjiContent = waichudengjiContent;
    }
    /**
	 * 获取：登记时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：登记时间
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
