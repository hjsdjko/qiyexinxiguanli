package com.entity.vo;

import com.entity.QiyejihuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 企业计划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiyejihua")
public class QiyejihuaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 企业计划编号
     */

    @TableField(value = "qiyejihua_uuid_number")
    private String qiyejihuaUuidNumber;


    /**
     * 企业计划标题
     */

    @TableField(value = "qiyejihua_name")
    private String qiyejihuaName;


    /**
     * 企业计划类型
     */

    @TableField(value = "qiyejihua_types")
    private Integer qiyejihuaTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qiyejihua_zhixing_time")
    private Date qiyejihuaZhixingTime;


    /**
     * 企业计划详情
     */

    @TableField(value = "qiyejihua_content")
    private String qiyejihuaContent;


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
	 * 设置：企业计划编号
	 */
    public String getQiyejihuaUuidNumber() {
        return qiyejihuaUuidNumber;
    }


    /**
	 * 获取：企业计划编号
	 */

    public void setQiyejihuaUuidNumber(String qiyejihuaUuidNumber) {
        this.qiyejihuaUuidNumber = qiyejihuaUuidNumber;
    }
    /**
	 * 设置：企业计划标题
	 */
    public String getQiyejihuaName() {
        return qiyejihuaName;
    }


    /**
	 * 获取：企业计划标题
	 */

    public void setQiyejihuaName(String qiyejihuaName) {
        this.qiyejihuaName = qiyejihuaName;
    }
    /**
	 * 设置：企业计划类型
	 */
    public Integer getQiyejihuaTypes() {
        return qiyejihuaTypes;
    }


    /**
	 * 获取：企业计划类型
	 */

    public void setQiyejihuaTypes(Integer qiyejihuaTypes) {
        this.qiyejihuaTypes = qiyejihuaTypes;
    }
    /**
	 * 设置：执行时间
	 */
    public Date getQiyejihuaZhixingTime() {
        return qiyejihuaZhixingTime;
    }


    /**
	 * 获取：执行时间
	 */

    public void setQiyejihuaZhixingTime(Date qiyejihuaZhixingTime) {
        this.qiyejihuaZhixingTime = qiyejihuaZhixingTime;
    }
    /**
	 * 设置：企业计划详情
	 */
    public String getQiyejihuaContent() {
        return qiyejihuaContent;
    }


    /**
	 * 获取：企业计划详情
	 */

    public void setQiyejihuaContent(String qiyejihuaContent) {
        this.qiyejihuaContent = qiyejihuaContent;
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
