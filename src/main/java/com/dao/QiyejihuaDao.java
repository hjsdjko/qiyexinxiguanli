package com.dao;

import com.entity.QiyejihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QiyejihuaView;

/**
 * 企业计划 Dao 接口
 *
 * @author 
 */
public interface QiyejihuaDao extends BaseMapper<QiyejihuaEntity> {

   List<QiyejihuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
