
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 外出登记
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/waichudengji")
public class WaichudengjiController {
    private static final Logger logger = LoggerFactory.getLogger(WaichudengjiController.class);

    @Autowired
    private WaichudengjiService waichudengjiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YuangongService yuangongService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = waichudengjiService.queryPage(params);

        //字典表数据转换
        List<WaichudengjiView> list =(List<WaichudengjiView>)page.getList();
        for(WaichudengjiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WaichudengjiEntity waichudengji = waichudengjiService.selectById(id);
        if(waichudengji !=null){
            //entity转view
            WaichudengjiView view = new WaichudengjiView();
            BeanUtils.copyProperties( waichudengji , view );//把实体数据重构到view中

                //级联表
                YuangongEntity yuangong = yuangongService.selectById(waichudengji.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WaichudengjiEntity waichudengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,waichudengji:{}",this.getClass().getName(),waichudengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            waichudengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WaichudengjiEntity> queryWrapper = new EntityWrapper<WaichudengjiEntity>()
            .eq("yuangong_id", waichudengji.getYuangongId())
            .eq("waichudengji_shiyou", waichudengji.getWaichudengjiShiyou())
            .eq("waichudengji_types", waichudengji.getWaichudengjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WaichudengjiEntity waichudengjiEntity = waichudengjiService.selectOne(queryWrapper);
        if(waichudengjiEntity==null){
            waichudengji.setInsertTime(new Date());
            waichudengji.setCreateTime(new Date());
            waichudengjiService.insert(waichudengji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WaichudengjiEntity waichudengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,waichudengji:{}",this.getClass().getName(),waichudengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            waichudengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<WaichudengjiEntity> queryWrapper = new EntityWrapper<WaichudengjiEntity>()
            .notIn("id",waichudengji.getId())
            .andNew()
            .eq("yuangong_id", waichudengji.getYuangongId())
            .eq("waichudengji_shiyou", waichudengji.getWaichudengjiShiyou())
            .eq("waichudengji_types", waichudengji.getWaichudengjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WaichudengjiEntity waichudengjiEntity = waichudengjiService.selectOne(queryWrapper);
        if(waichudengjiEntity==null){
            waichudengjiService.updateById(waichudengji);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        waichudengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<WaichudengjiEntity> waichudengjiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WaichudengjiEntity waichudengjiEntity = new WaichudengjiEntity();
//                            waichudengjiEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            waichudengjiEntity.setWaichuTime(sdf.parse(data.get(0)));          //外出时间 要改的
//                            waichudengjiEntity.setWaichudengjiShiyou(data.get(0));                    //外出事由 要改的
//                            waichudengjiEntity.setWaichudengjiTypes(Integer.valueOf(data.get(0)));   //外出类型 要改的
//                            waichudengjiEntity.setWaichudengjiContent("");//详情和图片
//                            waichudengjiEntity.setInsertTime(date);//时间
//                            waichudengjiEntity.setCreateTime(date);//时间
                            waichudengjiList.add(waichudengjiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        waichudengjiService.insertBatch(waichudengjiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
