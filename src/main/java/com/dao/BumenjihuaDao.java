package com.dao;

import com.entity.BumenjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BumenjihuaView;

/**
 * 部门计划 Dao 接口
 *
 * @author 
 */
public interface BumenjihuaDao extends BaseMapper<BumenjihuaEntity> {

   List<BumenjihuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
