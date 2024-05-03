package com.dao;

import com.entity.GerenjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GerenjihuaView;

/**
 * 个人计划 Dao 接口
 *
 * @author 
 */
public interface GerenjihuaDao extends BaseMapper<GerenjihuaEntity> {

   List<GerenjihuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
