package com.entity.model;

import com.entity.QiyejihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 企业计划
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QiyejihuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 企业计划编号
     */
    private String qiyejihuaUuidNumber;


    /**
     * 企业计划标题
     */
    private String qiyejihuaName;


    /**
     * 企业计划类型
     */
    private Integer qiyejihuaTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qiyejihuaZhixingTime;


    /**
     * 企业计划详情
     */
    private String qiyejihuaContent;


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
	 * 获取：企业计划编号
	 */
    public String getQiyejihuaUuidNumber() {
        return qiyejihuaUuidNumber;
    }


    /**
	 * 设置：企业计划编号
	 */
    public void setQiyejihuaUuidNumber(String qiyejihuaUuidNumber) {
        this.qiyejihuaUuidNumber = qiyejihuaUuidNumber;
    }
    /**
	 * 获取：企业计划标题
	 */
    public String getQiyejihuaName() {
        return qiyejihuaName;
    }


    /**
	 * 设置：企业计划标题
	 */
    public void setQiyejihuaName(String qiyejihuaName) {
        this.qiyejihuaName = qiyejihuaName;
    }
    /**
	 * 获取：企业计划类型
	 */
    public Integer getQiyejihuaTypes() {
        return qiyejihuaTypes;
    }


    /**
	 * 设置：企业计划类型
	 */
    public void setQiyejihuaTypes(Integer qiyejihuaTypes) {
        this.qiyejihuaTypes = qiyejihuaTypes;
    }
    /**
	 * 获取：执行时间
	 */
    public Date getQiyejihuaZhixingTime() {
        return qiyejihuaZhixingTime;
    }


    /**
	 * 设置：执行时间
	 */
    public void setQiyejihuaZhixingTime(Date qiyejihuaZhixingTime) {
        this.qiyejihuaZhixingTime = qiyejihuaZhixingTime;
    }
    /**
	 * 获取：企业计划详情
	 */
    public String getQiyejihuaContent() {
        return qiyejihuaContent;
    }


    /**
	 * 设置：企业计划详情
	 */
    public void setQiyejihuaContent(String qiyejihuaContent) {
        this.qiyejihuaContent = qiyejihuaContent;
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
