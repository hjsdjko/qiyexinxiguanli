package com.entity.vo;

import com.entity.DakaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 上下班打卡
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("daka")
public class DakaVO implements Serializable {
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
     * 打卡类型
     */

    @TableField(value = "daka_types")
    private Integer dakaTypes;


    /**
     * 打卡状态
     */

    @TableField(value = "daka_zhuangtai_types")
    private Integer dakaZhuangtaiTypes;


    /**
     * 打卡时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "daka_time")
    private Date dakaTime;


    /**
     * 打卡日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 打卡备注
     */

    @TableField(value = "daka_content")
    private String dakaContent;


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
	 * 设置：打卡类型
	 */
    public Integer getDakaTypes() {
        return dakaTypes;
    }


    /**
	 * 获取：打卡类型
	 */

    public void setDakaTypes(Integer dakaTypes) {
        this.dakaTypes = dakaTypes;
    }
    /**
	 * 设置：打卡状态
	 */
    public Integer getDakaZhuangtaiTypes() {
        return dakaZhuangtaiTypes;
    }


    /**
	 * 获取：打卡状态
	 */

    public void setDakaZhuangtaiTypes(Integer dakaZhuangtaiTypes) {
        this.dakaZhuangtaiTypes = dakaZhuangtaiTypes;
    }
    /**
	 * 设置：打卡时间
	 */
    public Date getDakaTime() {
        return dakaTime;
    }


    /**
	 * 获取：打卡时间
	 */

    public void setDakaTime(Date dakaTime) {
        this.dakaTime = dakaTime;
    }
    /**
	 * 设置：打卡日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：打卡日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：打卡备注
	 */
    public String getDakaContent() {
        return dakaContent;
    }


    /**
	 * 获取：打卡备注
	 */

    public void setDakaContent(String dakaContent) {
        this.dakaContent = dakaContent;
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
