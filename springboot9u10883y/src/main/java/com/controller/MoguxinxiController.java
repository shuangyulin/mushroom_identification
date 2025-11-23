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

import com.entity.MoguxinxiEntity;
import com.entity.view.MoguxinxiView;

import com.service.MoguxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 蘑菇信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
@RestController
@RequestMapping("/moguxinxi")
public class MoguxinxiController {
    @Autowired
    private MoguxinxiService moguxinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MoguxinxiEntity moguxinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<MoguxinxiEntity> ew = new EntityWrapper<MoguxinxiEntity>();


        //查询结果
		PageUtils page = moguxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, moguxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,MoguxinxiEntity moguxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<MoguxinxiEntity> ew = new EntityWrapper<MoguxinxiEntity>();

        //查询结果
		PageUtils page = moguxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, moguxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MoguxinxiEntity moguxinxi){
       	EntityWrapper<MoguxinxiEntity> ew = new EntityWrapper<MoguxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( moguxinxi, "moguxinxi")); 
        return R.ok().put("data", moguxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MoguxinxiEntity moguxinxi){
        EntityWrapper< MoguxinxiEntity> ew = new EntityWrapper< MoguxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( moguxinxi, "moguxinxi")); 
		MoguxinxiView moguxinxiView =  moguxinxiService.selectView(ew);
		return R.ok("查询蘑菇信息成功").put("data", moguxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MoguxinxiEntity moguxinxi = moguxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(moguxinxi,deSens);
        return R.ok().put("data", moguxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MoguxinxiEntity moguxinxi = moguxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(moguxinxi,deSens);
        return R.ok().put("data", moguxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MoguxinxiEntity moguxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(moguxinxi);
        moguxinxiService.insert(moguxinxi);
        return R.ok().put("data",moguxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MoguxinxiEntity moguxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(moguxinxi);
        moguxinxiService.insert(moguxinxi);
        return R.ok().put("data",moguxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MoguxinxiEntity moguxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(moguxinxi);
        //全部更新
        moguxinxiService.updateById(moguxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        moguxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
