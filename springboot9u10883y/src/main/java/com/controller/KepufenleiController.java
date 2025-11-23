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

import com.entity.KepufenleiEntity;
import com.entity.view.KepufenleiView;

import com.service.KepufenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 科普分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
@RestController
@RequestMapping("/kepufenlei")
public class KepufenleiController {
    @Autowired
    private KepufenleiService kepufenleiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KepufenleiEntity kepufenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<KepufenleiEntity> ew = new EntityWrapper<KepufenleiEntity>();


        //查询结果
		PageUtils page = kepufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kepufenlei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,KepufenleiEntity kepufenlei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<KepufenleiEntity> ew = new EntityWrapper<KepufenleiEntity>();

        //查询结果
		PageUtils page = kepufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kepufenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KepufenleiEntity kepufenlei){
       	EntityWrapper<KepufenleiEntity> ew = new EntityWrapper<KepufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kepufenlei, "kepufenlei")); 
        return R.ok().put("data", kepufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KepufenleiEntity kepufenlei){
        EntityWrapper< KepufenleiEntity> ew = new EntityWrapper< KepufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kepufenlei, "kepufenlei")); 
		KepufenleiView kepufenleiView =  kepufenleiService.selectView(ew);
		return R.ok("查询科普分类成功").put("data", kepufenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KepufenleiEntity kepufenlei = kepufenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(kepufenlei,deSens);
        return R.ok().put("data", kepufenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KepufenleiEntity kepufenlei = kepufenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(kepufenlei,deSens);
        return R.ok().put("data", kepufenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KepufenleiEntity kepufenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(kepufenleiService.selectCount(new EntityWrapper<KepufenleiEntity>().eq("kepufenlei", kepufenlei.getKepufenlei()))>0) {
            return R.error("科普分类已存在");
        }
        //ValidatorUtils.validateEntity(kepufenlei);
        kepufenleiService.insert(kepufenlei);
        return R.ok().put("data",kepufenlei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KepufenleiEntity kepufenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(kepufenleiService.selectCount(new EntityWrapper<KepufenleiEntity>().eq("kepufenlei", kepufenlei.getKepufenlei()))>0) {
            return R.error("科普分类已存在");
        }
        //ValidatorUtils.validateEntity(kepufenlei);
        kepufenleiService.insert(kepufenlei);
        return R.ok().put("data",kepufenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KepufenleiEntity kepufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kepufenlei);
        //验证字段唯一性，否则返回错误信息
        if(kepufenleiService.selectCount(new EntityWrapper<KepufenleiEntity>().ne("id", kepufenlei.getId()).eq("kepufenlei", kepufenlei.getKepufenlei()))>0) {
            return R.error("科普分类已存在");
        }
        //全部更新
        kepufenleiService.updateById(kepufenlei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kepufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
