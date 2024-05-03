
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
 * 企业计划
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qiyejihua")
public class QiyejihuaController {
    private static final Logger logger = LoggerFactory.getLogger(QiyejihuaController.class);

    @Autowired
    private QiyejihuaService qiyejihuaService;


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
        PageUtils page = qiyejihuaService.queryPage(params);

        //字典表数据转换
        List<QiyejihuaView> list =(List<QiyejihuaView>)page.getList();
        for(QiyejihuaView c:list){
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
        QiyejihuaEntity qiyejihua = qiyejihuaService.selectById(id);
        if(qiyejihua !=null){
            //entity转view
            QiyejihuaView view = new QiyejihuaView();
            BeanUtils.copyProperties( qiyejihua , view );//把实体数据重构到view中

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
    public R save(@RequestBody QiyejihuaEntity qiyejihua, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiyejihua:{}",this.getClass().getName(),qiyejihua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<QiyejihuaEntity> queryWrapper = new EntityWrapper<QiyejihuaEntity>()
            .eq("qiyejihua_uuid_number", qiyejihua.getQiyejihuaUuidNumber())
            .eq("qiyejihua_name", qiyejihua.getQiyejihuaName())
            .eq("qiyejihua_types", qiyejihua.getQiyejihuaTypes())
            .eq("qiyejihua_zhixing_time", new SimpleDateFormat("yyyy-MM-dd").format(qiyejihua.getQiyejihuaZhixingTime()))
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiyejihuaEntity qiyejihuaEntity = qiyejihuaService.selectOne(queryWrapper);
        if(qiyejihuaEntity==null){
            qiyejihua.setInsertTime(new Date());
            qiyejihua.setCreateTime(new Date());
            qiyejihuaService.insert(qiyejihua);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QiyejihuaEntity qiyejihua, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,qiyejihua:{}",this.getClass().getName(),qiyejihua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<QiyejihuaEntity> queryWrapper = new EntityWrapper<QiyejihuaEntity>()
            .notIn("id",qiyejihua.getId())
            .andNew()
            .eq("qiyejihua_uuid_number", qiyejihua.getQiyejihuaUuidNumber())
            .eq("qiyejihua_name", qiyejihua.getQiyejihuaName())
            .eq("qiyejihua_types", qiyejihua.getQiyejihuaTypes())
            .eq("qiyejihua_zhixing_time", new SimpleDateFormat("yyyy-MM-dd").format(qiyejihua.getQiyejihuaZhixingTime()))
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(qiyejihua.getInsertTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiyejihuaEntity qiyejihuaEntity = qiyejihuaService.selectOne(queryWrapper);
        if(qiyejihuaEntity==null){
            qiyejihuaService.updateById(qiyejihua);//根据id更新
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
        qiyejihuaService.deleteBatchIds(Arrays.asList(ids));
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
            List<QiyejihuaEntity> qiyejihuaList = new ArrayList<>();//上传的东西
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
                            QiyejihuaEntity qiyejihuaEntity = new QiyejihuaEntity();
//                            qiyejihuaEntity.setQiyejihuaUuidNumber(data.get(0));                    //企业计划编号 要改的
//                            qiyejihuaEntity.setQiyejihuaName(data.get(0));                    //企业计划标题 要改的
//                            qiyejihuaEntity.setQiyejihuaTypes(Integer.valueOf(data.get(0)));   //企业计划类型 要改的
//                            qiyejihuaEntity.setQiyejihuaZhixingTime(sdf.parse(data.get(0)));          //执行时间 要改的
//                            qiyejihuaEntity.setQiyejihuaContent("");//详情和图片
//                            qiyejihuaEntity.setInsertTime(date);//时间
//                            qiyejihuaEntity.setCreateTime(date);//时间
                            qiyejihuaList.add(qiyejihuaEntity);


                            //把要查询是否重复的字段放入map中
                                //企业计划编号
                                if(seachFields.containsKey("qiyejihuaUuidNumber")){
                                    List<String> qiyejihuaUuidNumber = seachFields.get("qiyejihuaUuidNumber");
                                    qiyejihuaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qiyejihuaUuidNumber = new ArrayList<>();
                                    qiyejihuaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qiyejihuaUuidNumber",qiyejihuaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //企业计划编号
                        List<QiyejihuaEntity> qiyejihuaEntities_qiyejihuaUuidNumber = qiyejihuaService.selectList(new EntityWrapper<QiyejihuaEntity>().in("qiyejihua_uuid_number", seachFields.get("qiyejihuaUuidNumber")));
                        if(qiyejihuaEntities_qiyejihuaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QiyejihuaEntity s:qiyejihuaEntities_qiyejihuaUuidNumber){
                                repeatFields.add(s.getQiyejihuaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [企业计划编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qiyejihuaService.insertBatch(qiyejihuaList);
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
