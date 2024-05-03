
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
 * 部门计划
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bumenjihua")
public class BumenjihuaController {
    private static final Logger logger = LoggerFactory.getLogger(BumenjihuaController.class);

    @Autowired
    private BumenjihuaService bumenjihuaService;


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
        PageUtils page = bumenjihuaService.queryPage(params);

        //字典表数据转换
        List<BumenjihuaView> list =(List<BumenjihuaView>)page.getList();
        for(BumenjihuaView c:list){
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
        BumenjihuaEntity bumenjihua = bumenjihuaService.selectById(id);
        if(bumenjihua !=null){
            //entity转view
            BumenjihuaView view = new BumenjihuaView();
            BeanUtils.copyProperties( bumenjihua , view );//把实体数据重构到view中

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
    public R save(@RequestBody BumenjihuaEntity bumenjihua, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bumenjihua:{}",this.getClass().getName(),bumenjihua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<BumenjihuaEntity> queryWrapper = new EntityWrapper<BumenjihuaEntity>()
            .eq("bumenjihua_uuid_number", bumenjihua.getBumenjihuaUuidNumber())
            .eq("bumenjihua_name", bumenjihua.getBumenjihuaName())
            .eq("bumenjihua_types", bumenjihua.getBumenjihuaTypes())
            .eq("bumenjihua_zhixing_time", new SimpleDateFormat("yyyy-MM-dd").format(bumenjihua.getBumenjihuaZhixingTime()))
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BumenjihuaEntity bumenjihuaEntity = bumenjihuaService.selectOne(queryWrapper);
        if(bumenjihuaEntity==null){
            bumenjihua.setInsertTime(new Date());
            bumenjihua.setCreateTime(new Date());
            bumenjihuaService.insert(bumenjihua);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BumenjihuaEntity bumenjihua, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bumenjihua:{}",this.getClass().getName(),bumenjihua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<BumenjihuaEntity> queryWrapper = new EntityWrapper<BumenjihuaEntity>()
            .notIn("id",bumenjihua.getId())
            .andNew()
            .eq("bumenjihua_uuid_number", bumenjihua.getBumenjihuaUuidNumber())
            .eq("bumenjihua_name", bumenjihua.getBumenjihuaName())
            .eq("bumenjihua_types", bumenjihua.getBumenjihuaTypes())
            .eq("bumenjihua_zhixing_time", new SimpleDateFormat("yyyy-MM-dd").format(bumenjihua.getBumenjihuaZhixingTime()))
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(bumenjihua.getInsertTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BumenjihuaEntity bumenjihuaEntity = bumenjihuaService.selectOne(queryWrapper);
        if(bumenjihuaEntity==null){
            bumenjihuaService.updateById(bumenjihua);//根据id更新
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
        bumenjihuaService.deleteBatchIds(Arrays.asList(ids));
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
            List<BumenjihuaEntity> bumenjihuaList = new ArrayList<>();//上传的东西
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
                            BumenjihuaEntity bumenjihuaEntity = new BumenjihuaEntity();
//                            bumenjihuaEntity.setBumenjihuaUuidNumber(data.get(0));                    //部门计划编号 要改的
//                            bumenjihuaEntity.setBumenjihuaName(data.get(0));                    //部门计划标题 要改的
//                            bumenjihuaEntity.setBumenjihuaTypes(Integer.valueOf(data.get(0)));   //部门计划类型 要改的
//                            bumenjihuaEntity.setBumenjihuaZhixingTime(sdf.parse(data.get(0)));          //执行时间 要改的
//                            bumenjihuaEntity.setBumenjihuaContent("");//详情和图片
//                            bumenjihuaEntity.setInsertTime(date);//时间
//                            bumenjihuaEntity.setCreateTime(date);//时间
                            bumenjihuaList.add(bumenjihuaEntity);


                            //把要查询是否重复的字段放入map中
                                //部门计划编号
                                if(seachFields.containsKey("bumenjihuaUuidNumber")){
                                    List<String> bumenjihuaUuidNumber = seachFields.get("bumenjihuaUuidNumber");
                                    bumenjihuaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> bumenjihuaUuidNumber = new ArrayList<>();
                                    bumenjihuaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("bumenjihuaUuidNumber",bumenjihuaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //部门计划编号
                        List<BumenjihuaEntity> bumenjihuaEntities_bumenjihuaUuidNumber = bumenjihuaService.selectList(new EntityWrapper<BumenjihuaEntity>().in("bumenjihua_uuid_number", seachFields.get("bumenjihuaUuidNumber")));
                        if(bumenjihuaEntities_bumenjihuaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BumenjihuaEntity s:bumenjihuaEntities_bumenjihuaUuidNumber){
                                repeatFields.add(s.getBumenjihuaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [部门计划编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        bumenjihuaService.insertBatch(bumenjihuaList);
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
