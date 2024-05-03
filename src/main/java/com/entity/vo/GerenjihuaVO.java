package com.entity.vo;

import com.entity.GerenjihuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 个人计划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gerenjihua")
public class GerenjihuaVO implements Serializable {
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
     * 个人计划编号
     */

    @TableField(value = "gerenjihua_uuid_number")
    private String gerenjihuaUuidNumber;


    /**
     * 个人计划标题
     */

    @TableField(value = "gerenjihua_name")
    private String gerenjihuaName;


    /**
     * 个人计划类型
     */

    @TableField(value = "gerenjihua_types")
    private Integer gerenjihuaTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "gerenjihua_zhixing_time")
    private Date gerenjihuaZhixingTime;


    /**
     * 个人计划详情
     */

    @TableField(value = "gerenjihua_content")
    private String gerenjihuaContent;


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
	 * 设置：个人计划编号
	 */
    public String getGerenjihuaUuidNumber() {
        return gerenjihuaUuidNumber;
    }


    /**
	 * 获取：个人计划编号
	 */

    public void setGerenjihuaUuidNumber(String gerenjihuaUuidNumber) {
        this.gerenjihuaUuidNumber = gerenjihuaUuidNumber;
    }
    /**
	 * 设置：个人计划标题
	 */
    public String getGerenjihuaName() {
        return gerenjihuaName;
    }


    /**
	 * 获取：个人计划标题
	 */

    public void setGerenjihuaName(String gerenjihuaName) {
        this.gerenjihuaName = gerenjihuaName;
    }
    /**
	 * 设置：个人计划类型
	 */
    public Integer getGerenjihuaTypes() {
        return gerenjihuaTypes;
    }


    /**
	 * 获取：个人计划类型
	 */

    public void setGerenjihuaTypes(Integer gerenjihuaTypes) {
        this.gerenjihuaTypes = gerenjihuaTypes;
    }
    /**
	 * 设置：执行时间
	 */
    public Date getGerenjihuaZhixingTime() {
        return gerenjihuaZhixingTime;
    }


    /**
	 * 获取：执行时间
	 */

    public void setGerenjihuaZhixingTime(Date gerenjihuaZhixingTime) {
        this.gerenjihuaZhixingTime = gerenjihuaZhixingTime;
    }
    /**
	 * 设置：个人计划详情
	 */
    public String getGerenjihuaContent() {
        return gerenjihuaContent;
    }


    /**
	 * 获取：个人计划详情
	 */

    public void setGerenjihuaContent(String gerenjihuaContent) {
        this.gerenjihuaContent = gerenjihuaContent;
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
