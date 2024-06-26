
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
 * 个人计划
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gerenjihua")
public class GerenjihuaController {
    private static final Logger logger = LoggerFactory.getLogger(GerenjihuaController.class);

    @Autowired
    private GerenjihuaService gerenjihuaService;


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
        PageUtils page = gerenjihuaService.queryPage(params);

        //字典表数据转换
        List<GerenjihuaView> list =(List<GerenjihuaView>)page.getList();
        for(GerenjihuaView c:list){
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
        GerenjihuaEntity gerenjihua = gerenjihuaService.selectById(id);
        if(gerenjihua !=null){
            //entity转view
            GerenjihuaView view = new GerenjihuaView();
            BeanUtils.copyProperties( gerenjihua , view );//把实体数据重构到view中

                //级联表
                YuangongEntity yuangong = yuangongService.selectById(gerenjihua.getYuangongId());
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
    public R save(@RequestBody GerenjihuaEntity gerenjihua, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gerenjihua:{}",this.getClass().getName(),gerenjihua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            gerenjihua.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<GerenjihuaEntity> queryWrapper = new EntityWrapper<GerenjihuaEntity>()
            .eq("yuangong_id", gerenjihua.getYuangongId())
            .eq("gerenjihua_uuid_number", gerenjihua.getGerenjihuaUuidNumber())
            .eq("gerenjihua_name", gerenjihua.getGerenjihuaName())
            .eq("gerenjihua_types", gerenjihua.getGerenjihuaTypes())
            .eq("gerenjihua_zhixing_time", new SimpleDateFormat("yyyy-MM-dd").format(gerenjihua.getGerenjihuaZhixingTime()))
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GerenjihuaEntity gerenjihuaEntity = gerenjihuaService.selectOne(queryWrapper);
        if(gerenjihuaEntity==null){
            gerenjihua.setInsertTime(new Date());
            gerenjihua.setCreateTime(new Date());
            gerenjihuaService.insert(gerenjihua);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GerenjihuaEntity gerenjihua, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gerenjihua:{}",this.getClass().getName(),gerenjihua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            gerenjihua.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<GerenjihuaEntity> queryWrapper = new EntityWrapper<GerenjihuaEntity>()
            .notIn("id",gerenjihua.getId())
            .andNew()
            .eq("yuangong_id", gerenjihua.getYuangongId())
            .eq("gerenjihua_uuid_number", gerenjihua.getGerenjihuaUuidNumber())
            .eq("gerenjihua_name", gerenjihua.getGerenjihuaName())
            .eq("gerenjihua_types", gerenjihua.getGerenjihuaTypes())
            .eq("gerenjihua_zhixing_time", new SimpleDateFormat("yyyy-MM-dd").format(gerenjihua.getGerenjihuaZhixingTime()))
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(gerenjihua.getInsertTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GerenjihuaEntity gerenjihuaEntity = gerenjihuaService.selectOne(queryWrapper);
        if(gerenjihuaEntity==null){
            gerenjihuaService.updateById(gerenjihua);//根据id更新
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
        gerenjihuaService.deleteBatchIds(Arrays.asList(ids));
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
            List<GerenjihuaEntity> gerenjihuaList = new ArrayList<>();//上传的东西
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
                            GerenjihuaEntity gerenjihuaEntity = new GerenjihuaEntity();
//                            gerenjihuaEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            gerenjihuaEntity.setGerenjihuaUuidNumber(data.get(0));                    //个人计划编号 要改的
//                            gerenjihuaEntity.setGerenjihuaName(data.get(0));                    //个人计划标题 要改的
//                            gerenjihuaEntity.setGerenjihuaTypes(Integer.valueOf(data.get(0)));   //个人计划类型 要改的
//                            gerenjihuaEntity.setGerenjihuaZhixingTime(sdf.parse(data.get(0)));          //执行时间 要改的
//                            gerenjihuaEntity.setGerenjihuaContent("");//详情和图片
//                            gerenjihuaEntity.setInsertTime(date);//时间
//                            gerenjihuaEntity.setCreateTime(date);//时间
                            gerenjihuaList.add(gerenjihuaEntity);


                            //把要查询是否重复的字段放入map中
                                //个人计划编号
                                if(seachFields.containsKey("gerenjihuaUuidNumber")){
                                    List<String> gerenjihuaUuidNumber = seachFields.get("gerenjihuaUuidNumber");
                                    gerenjihuaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> gerenjihuaUuidNumber = new ArrayList<>();
                                    gerenjihuaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("gerenjihuaUuidNumber",gerenjihuaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //个人计划编号
                        List<GerenjihuaEntity> gerenjihuaEntities_gerenjihuaUuidNumber = gerenjihuaService.selectList(new EntityWrapper<GerenjihuaEntity>().in("gerenjihua_uuid_number", seachFields.get("gerenjihuaUuidNumber")));
                        if(gerenjihuaEntities_gerenjihuaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GerenjihuaEntity s:gerenjihuaEntities_gerenjihuaUuidNumber){
                                repeatFields.add(s.getGerenjihuaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [个人计划编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gerenjihuaService.insertBatch(gerenjihuaList);
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
