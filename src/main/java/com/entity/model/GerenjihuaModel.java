package com.entity.model;

import com.entity.GerenjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 个人计划
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GerenjihuaModel implements Serializable {
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
     * 个人计划编号
     */
    private String gerenjihuaUuidNumber;


    /**
     * 个人计划标题
     */
    private String gerenjihuaName;


    /**
     * 个人计划类型
     */
    private Integer gerenjihuaTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date gerenjihuaZhixingTime;


    /**
     * 个人计划详情
     */
    private String gerenjihuaContent;


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
	 * 获取：个人计划编号
	 */
    public String getGerenjihuaUuidNumber() {
        return gerenjihuaUuidNumber;
    }


    /**
	 * 设置：个人计划编号
	 */
    public void setGerenjihuaUuidNumber(String gerenjihuaUuidNumber) {
        this.gerenjihuaUuidNumber = gerenjihuaUuidNumber;
    }
    /**
	 * 获取：个人计划标题
	 */
    public String getGerenjihuaName() {
        return gerenjihuaName;
    }


    /**
	 * 设置：个人计划标题
	 */
    public void setGerenjihuaName(String gerenjihuaName) {
        this.gerenjihuaName = gerenjihuaName;
    }
    /**
	 * 获取：个人计划类型
	 */
    public Integer getGerenjihuaTypes() {
        return gerenjihuaTypes;
    }


    /**
	 * 设置：个人计划类型
	 */
    public void setGerenjihuaTypes(Integer gerenjihuaTypes) {
        this.gerenjihuaTypes = gerenjihuaTypes;
    }
    /**
	 * 获取：执行时间
	 */
    public Date getGerenjihuaZhixingTime() {
        return gerenjihuaZhixingTime;
    }


    /**
	 * 设置：执行时间
	 */
    public void setGerenjihuaZhixingTime(Date gerenjihuaZhixingTime) {
        this.gerenjihuaZhixingTime = gerenjihuaZhixingTime;
    }
    /**
	 * 获取：个人计划详情
	 */
    public String getGerenjihuaContent() {
        return gerenjihuaContent;
    }


    /**
	 * 设置：个人计划详情
	 */
    public void setGerenjihuaContent(String gerenjihuaContent) {
        this.gerenjihuaContent = gerenjihuaContent;
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
