package com.entity.vo;

import com.entity.WaichudengjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 外出登记
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("waichudengji")
public class WaichudengjiVO implements Serializable {
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
     * 外出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "waichu_time")
    private Date waichuTime;


    /**
     * 外出事由
     */

    @TableField(value = "waichudengji_shiyou")
    private String waichudengjiShiyou;


    /**
     * 外出类型
     */

    @TableField(value = "waichudengji_types")
    private Integer waichudengjiTypes;


    /**
     * 外出详情
     */

    @TableField(value = "waichudengji_content")
    private String waichudengjiContent;


    /**
     * 登记时间
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
	 * 设置：外出时间
	 */
    public Date getWaichuTime() {
        return waichuTime;
    }


    /**
	 * 获取：外出时间
	 */

    public void setWaichuTime(Date waichuTime) {
        this.waichuTime = waichuTime;
    }
    /**
	 * 设置：外出事由
	 */
    public String getWaichudengjiShiyou() {
        return waichudengjiShiyou;
    }


    /**
	 * 获取：外出事由
	 */

    public void setWaichudengjiShiyou(String waichudengjiShiyou) {
        this.waichudengjiShiyou = waichudengjiShiyou;
    }
    /**
	 * 设置：外出类型
	 */
    public Integer getWaichudengjiTypes() {
        return waichudengjiTypes;
    }


    /**
	 * 获取：外出类型
	 */

    public void setWaichudengjiTypes(Integer waichudengjiTypes) {
        this.waichudengjiTypes = waichudengjiTypes;
    }
    /**
	 * 设置：外出详情
	 */
    public String getWaichudengjiContent() {
        return waichudengjiContent;
    }


    /**
	 * 获取：外出详情
	 */

    public void setWaichudengjiContent(String waichudengjiContent) {
        this.waichudengjiContent = waichudengjiContent;
    }
    /**
	 * 设置：登记时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：登记时间
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
