package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TuxiangshibieEntity;
import com.entity.view.TuxiangshibieView;

import com.service.TuxiangshibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import java.io.File;
import org.json.JSONObject;
import com.utils.BaiduUtil;
import org.springframework.util.ResourceUtils;
import java.io.FileNotFoundException;

/**
 * 图像识别
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-17 20:01:59
 */
@RestController
@RequestMapping("/tuxiangshibie")
public class TuxiangshibieController {
    @Autowired
    private TuxiangshibieService tuxiangshibieService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuxiangshibieEntity tuxiangshibie,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tuxiangshibie.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<TuxiangshibieEntity> ew = new EntityWrapper<TuxiangshibieEntity>();


        //查询结果
		PageUtils page = tuxiangshibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuxiangshibie), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuxiangshibieEntity tuxiangshibie, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TuxiangshibieEntity> ew = new EntityWrapper<TuxiangshibieEntity>();

        //查询结果
		PageUtils page = tuxiangshibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuxiangshibie), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuxiangshibieEntity tuxiangshibie){
       	EntityWrapper<TuxiangshibieEntity> ew = new EntityWrapper<TuxiangshibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuxiangshibie, "tuxiangshibie")); 
        return R.ok().put("data", tuxiangshibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuxiangshibieEntity tuxiangshibie){
        EntityWrapper< TuxiangshibieEntity> ew = new EntityWrapper< TuxiangshibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuxiangshibie, "tuxiangshibie")); 
		TuxiangshibieView tuxiangshibieView =  tuxiangshibieService.selectView(ew);
		return R.ok("查询图像识别成功").put("data", tuxiangshibieView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuxiangshibieEntity tuxiangshibie = tuxiangshibieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tuxiangshibie,deSens);
        return R.ok().put("data", tuxiangshibie);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuxiangshibieEntity tuxiangshibie = tuxiangshibieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tuxiangshibie,deSens);
        return R.ok().put("data", tuxiangshibie);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuxiangshibieEntity tuxiangshibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuxiangshibie);
        tuxiangshibieService.insert(tuxiangshibie);
        return R.ok().put("data",tuxiangshibie.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuxiangshibieEntity tuxiangshibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuxiangshibie);
        tuxiangshibieService.insert(tuxiangshibie);
        return R.ok().put("data",tuxiangshibie.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TuxiangshibieEntity tuxiangshibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuxiangshibie);
        //全部更新
        tuxiangshibieService.updateById(tuxiangshibie);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuxiangshibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








    /**
     * 通用物体和场景识别
     */
    @RequestMapping("/baidu/advancedGeneral")
    @IgnoreAuth
    public R baiduAdvancedGeneral(@RequestParam("fileName") String fileName,HttpServletRequest request) {
        JSONObject jb = null;
        try {
            File path = new File(ResourceUtils.getURL("classpath:static").getPath());
            if(!path.exists()) {
                path = new File("");
            }
            File upload = new File(path.getAbsolutePath(),"/upload/");
            if(!upload.exists()) {
                upload.mkdirs();
            }
            File file = new File(upload.getAbsolutePath()+"/"+fileName);
            if(file.exists()){
                jb = BaiduUtil.advancedGeneral(file.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return R.ok().put("data", com.alibaba.fastjson.JSONObject.parseObject(jb.getJSONArray("result").get(0).toString()));
    }

}
