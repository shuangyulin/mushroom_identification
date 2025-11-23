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

import com.entity.MogufenleiEntity;
import com.entity.view.MogufenleiView;

import com.service.MogufenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 蘑菇分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
@RestController
@RequestMapping("/mogufenlei")
public class MogufenleiController {
    @Autowired
    private MogufenleiService mogufenleiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MogufenleiEntity mogufenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<MogufenleiEntity> ew = new EntityWrapper<MogufenleiEntity>();


        //查询结果
		PageUtils page = mogufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mogufenlei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,MogufenleiEntity mogufenlei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<MogufenleiEntity> ew = new EntityWrapper<MogufenleiEntity>();

        //查询结果
		PageUtils page = mogufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mogufenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MogufenleiEntity mogufenlei){
       	EntityWrapper<MogufenleiEntity> ew = new EntityWrapper<MogufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mogufenlei, "mogufenlei")); 
        return R.ok().put("data", mogufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MogufenleiEntity mogufenlei){
        EntityWrapper< MogufenleiEntity> ew = new EntityWrapper< MogufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mogufenlei, "mogufenlei")); 
		MogufenleiView mogufenleiView =  mogufenleiService.selectView(ew);
		return R.ok("查询蘑菇分类成功").put("data", mogufenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MogufenleiEntity mogufenlei = mogufenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(mogufenlei,deSens);
        return R.ok().put("data", mogufenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MogufenleiEntity mogufenlei = mogufenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(mogufenlei,deSens);
        return R.ok().put("data", mogufenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MogufenleiEntity mogufenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(mogufenleiService.selectCount(new EntityWrapper<MogufenleiEntity>().eq("mogufenlei", mogufenlei.getMogufenlei()))>0) {
            return R.error("蘑菇分类已存在");
        }
        //ValidatorUtils.validateEntity(mogufenlei);
        mogufenleiService.insert(mogufenlei);
        return R.ok().put("data",mogufenlei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MogufenleiEntity mogufenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(mogufenleiService.selectCount(new EntityWrapper<MogufenleiEntity>().eq("mogufenlei", mogufenlei.getMogufenlei()))>0) {
            return R.error("蘑菇分类已存在");
        }
        //ValidatorUtils.validateEntity(mogufenlei);
        mogufenleiService.insert(mogufenlei);
        return R.ok().put("data",mogufenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MogufenleiEntity mogufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mogufenlei);
        //验证字段唯一性，否则返回错误信息
        if(mogufenleiService.selectCount(new EntityWrapper<MogufenleiEntity>().ne("id", mogufenlei.getId()).eq("mogufenlei", mogufenlei.getMogufenlei()))>0) {
            return R.error("蘑菇分类已存在");
        }
        //全部更新
        mogufenleiService.updateById(mogufenlei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mogufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
