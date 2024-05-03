package com.entity.view;

import com.entity.QiyejihuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 企业计划
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("qiyejihua")
public class QiyejihuaView extends QiyejihuaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 企业计划类型的值
		*/
		private String qiyejihuaValue;



	public QiyejihuaView() {

	}

	public QiyejihuaView(QiyejihuaEntity qiyejihuaEntity) {
		try {
			BeanUtils.copyProperties(this, qiyejihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 企业计划类型的值
			*/
			public String getQiyejihuaValue() {
				return qiyejihuaValue;
			}
			/**
			* 设置： 企业计划类型的值
			*/
			public void setQiyejihuaValue(String qiyejihuaValue) {
				this.qiyejihuaValue = qiyejihuaValue;
			}














}
