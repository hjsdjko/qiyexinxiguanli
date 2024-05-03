package com.dao;

import com.entity.WaichudengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WaichudengjiView;

/**
 * 外出登记 Dao 接口
 *
 * @author 
 */
public interface WaichudengjiDao extends BaseMapper<WaichudengjiEntity> {

   List<WaichudengjiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
