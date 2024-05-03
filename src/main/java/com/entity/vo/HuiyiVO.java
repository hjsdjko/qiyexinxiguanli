package com.entity.vo;

import com.entity.HuiyiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 会议
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huiyi")
public class HuiyiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 会议编号
     */

    @TableField(value = "huiyi_uuid_number")
    private String huiyiUuidNumber;


    /**
     * 会议名称
     */

    @TableField(value = "huiyi_name")
    private String huiyiName;


    /**
     * 会议类型
     */

    @TableField(value = "huiyi_types")
    private Integer huiyiTypes;


    /**
     * 会议地点
     */

    @TableField(value = "huiyi_address")
    private String huiyiAddress;


    /**
     * 开会时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "kaihui_time")
    private Date kaihuiTime;


    /**
     * 会议详情
     */

    @TableField(value = "zuoye_content")
    private String zuoyeContent;


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
	 * 设置：会议编号
	 */
    public String getHuiyiUuidNumber() {
        return huiyiUuidNumber;
    }


    /**
	 * 获取：会议编号
	 */

    public void setHuiyiUuidNumber(String huiyiUuidNumber) {
        this.huiyiUuidNumber = huiyiUuidNumber;
    }
    /**
	 * 设置：会议名称
	 */
    public String getHuiyiName() {
        return huiyiName;
    }


    /**
	 * 获取：会议名称
	 */

    public void setHuiyiName(String huiyiName) {
        this.huiyiName = huiyiName;
    }
    /**
	 * 设置：会议类型
	 */
    public Integer getHuiyiTypes() {
        return huiyiTypes;
    }


    /**
	 * 获取：会议类型
	 */

    public void setHuiyiTypes(Integer huiyiTypes) {
        this.huiyiTypes = huiyiTypes;
    }
    /**
	 * 设置：会议地点
	 */
    public String getHuiyiAddress() {
        return huiyiAddress;
    }


    /**
	 * 获取：会议地点
	 */

    public void setHuiyiAddress(String huiyiAddress) {
        this.huiyiAddress = huiyiAddress;
    }
    /**
	 * 设置：开会时间
	 */
    public Date getKaihuiTime() {
        return kaihuiTime;
    }


    /**
	 * 获取：开会时间
	 */

    public void setKaihuiTime(Date kaihuiTime) {
        this.kaihuiTime = kaihuiTime;
    }
    /**
	 * 设置：会议详情
	 */
    public String getZuoyeContent() {
        return zuoyeContent;
    }


    /**
	 * 获取：会议详情
	 */

    public void setZuoyeContent(String zuoyeContent) {
        this.zuoyeContent = zuoyeContent;
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
