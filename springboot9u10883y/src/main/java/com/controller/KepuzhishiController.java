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

import com.entity.KepuzhishiEntity;
import com.entity.view.KepuzhishiView;

import com.service.KepuzhishiService;
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
 * 科普知识
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
@RestController
@RequestMapping("/kepuzhishi")
public class KepuzhishiController {
    @Autowired
    private KepuzhishiService kepuzhishiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KepuzhishiEntity kepuzhishi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<KepuzhishiEntity> ew = new EntityWrapper<KepuzhishiEntity>();


        //查询结果
		PageUtils page = kepuzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kepuzhishi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,KepuzhishiEntity kepuzhishi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<KepuzhishiEntity> ew = new EntityWrapper<KepuzhishiEntity>();

        //查询结果
		PageUtils page = kepuzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kepuzhishi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KepuzhishiEntity kepuzhishi){
       	EntityWrapper<KepuzhishiEntity> ew = new EntityWrapper<KepuzhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kepuzhishi, "kepuzhishi")); 
        return R.ok().put("data", kepuzhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KepuzhishiEntity kepuzhishi){
        EntityWrapper< KepuzhishiEntity> ew = new EntityWrapper< KepuzhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kepuzhishi, "kepuzhishi")); 
		KepuzhishiView kepuzhishiView =  kepuzhishiService.selectView(ew);
		return R.ok("查询科普知识成功").put("data", kepuzhishiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KepuzhishiEntity kepuzhishi = kepuzhishiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(kepuzhishi,deSens);
        return R.ok().put("data", kepuzhishi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KepuzhishiEntity kepuzhishi = kepuzhishiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(kepuzhishi,deSens);
        return R.ok().put("data", kepuzhishi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KepuzhishiEntity kepuzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kepuzhishi);
        kepuzhishiService.insert(kepuzhishi);
        return R.ok().put("data",kepuzhishi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KepuzhishiEntity kepuzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kepuzhishi);
        kepuzhishiService.insert(kepuzhishi);
        return R.ok().put("data",kepuzhishi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KepuzhishiEntity kepuzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kepuzhishi);
        //全部更新
        kepuzhishiService.updateById(kepuzhishi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kepuzhishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
