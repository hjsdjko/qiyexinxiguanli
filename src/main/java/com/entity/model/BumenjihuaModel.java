package com.entity.model;

import com.entity.BumenjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 部门计划
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BumenjihuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 部门计划编号
     */
    private String bumenjihuaUuidNumber;


    /**
     * 部门计划标题
     */
    private String bumenjihuaName;


    /**
     * 部门计划类型
     */
    private Integer bumenjihuaTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date bumenjihuaZhixingTime;


    /**
     * 部门计划详情
     */
    private String bumenjihuaContent;


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
	 * 获取：部门计划编号
	 */
    public String getBumenjihuaUuidNumber() {
        return bumenjihuaUuidNumber;
    }


    /**
	 * 设置：部门计划编号
	 */
    public void setBumenjihuaUuidNumber(String bumenjihuaUuidNumber) {
        this.bumenjihuaUuidNumber = bumenjihuaUuidNumber;
    }
    /**
	 * 获取：部门计划标题
	 */
    public String getBumenjihuaName() {
        return bumenjihuaName;
    }


    /**
	 * 设置：部门计划标题
	 */
    public void setBumenjihuaName(String bumenjihuaName) {
        this.bumenjihuaName = bumenjihuaName;
    }
    /**
	 * 获取：部门计划类型
	 */
    public Integer getBumenjihuaTypes() {
        return bumenjihuaTypes;
    }


    /**
	 * 设置：部门计划类型
	 */
    public void setBumenjihuaTypes(Integer bumenjihuaTypes) {
        this.bumenjihuaTypes = bumenjihuaTypes;
    }
    /**
	 * 获取：执行时间
	 */
    public Date getBumenjihuaZhixingTime() {
        return bumenjihuaZhixingTime;
    }


    /**
	 * 设置：执行时间
	 */
    public void setBumenjihuaZhixingTime(Date bumenjihuaZhixingTime) {
        this.bumenjihuaZhixingTime = bumenjihuaZhixingTime;
    }
    /**
	 * 获取：部门计划详情
	 */
    public String getBumenjihuaContent() {
        return bumenjihuaContent;
    }


    /**
	 * 设置：部门计划详情
	 */
    public void setBumenjihuaContent(String bumenjihuaContent) {
        this.bumenjihuaContent = bumenjihuaContent;
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
