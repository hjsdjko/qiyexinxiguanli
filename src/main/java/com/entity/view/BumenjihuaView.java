package com.entity.view;

import com.entity.BumenjihuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 部门计划
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bumenjihua")
public class BumenjihuaView extends BumenjihuaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 部门计划类型的值
		*/
		private String bumenjihuaValue;



	public BumenjihuaView() {

	}

	public BumenjihuaView(BumenjihuaEntity bumenjihuaEntity) {
		try {
			BeanUtils.copyProperties(this, bumenjihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 部门计划类型的值
			*/
			public String getBumenjihuaValue() {
				return bumenjihuaValue;
			}
			/**
			* 设置： 部门计划类型的值
			*/
			public void setBumenjihuaValue(String bumenjihuaValue) {
				this.bumenjihuaValue = bumenjihuaValue;
			}














}
