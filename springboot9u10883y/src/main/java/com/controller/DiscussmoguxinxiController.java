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

import com.entity.DiscussmoguxinxiEntity;
import com.entity.view.DiscussmoguxinxiView;

import com.service.DiscussmoguxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 蘑菇信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-17 20:02:02
 */
@RestController
@RequestMapping("/discussmoguxinxi")
public class DiscussmoguxinxiController {
    @Autowired
    private DiscussmoguxinxiService discussmoguxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussmoguxinxiEntity discussmoguxinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussmoguxinxiEntity> ew = new EntityWrapper<DiscussmoguxinxiEntity>();


        //查询结果
		PageUtils page = discussmoguxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmoguxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussmoguxinxiEntity discussmoguxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussmoguxinxiEntity> ew = new EntityWrapper<DiscussmoguxinxiEntity>();

        //查询结果
		PageUtils page = discussmoguxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmoguxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussmoguxinxiEntity discussmoguxinxi){
       	EntityWrapper<DiscussmoguxinxiEntity> ew = new EntityWrapper<DiscussmoguxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussmoguxinxi, "discussmoguxinxi")); 
        return R.ok().put("data", discussmoguxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussmoguxinxiEntity discussmoguxinxi){
        EntityWrapper< DiscussmoguxinxiEntity> ew = new EntityWrapper< DiscussmoguxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussmoguxinxi, "discussmoguxinxi")); 
		DiscussmoguxinxiView discussmoguxinxiView =  discussmoguxinxiService.selectView(ew);
		return R.ok("查询蘑菇信息评论表成功").put("data", discussmoguxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussmoguxinxiEntity discussmoguxinxi = discussmoguxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussmoguxinxi,deSens);
        return R.ok().put("data", discussmoguxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussmoguxinxiEntity discussmoguxinxi = discussmoguxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussmoguxinxi,deSens);
        return R.ok().put("data", discussmoguxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussmoguxinxiEntity discussmoguxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmoguxinxi);
        discussmoguxinxiService.insert(discussmoguxinxi);
        return R.ok().put("data",discussmoguxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussmoguxinxiEntity discussmoguxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmoguxinxi);
        discussmoguxinxiService.insert(discussmoguxinxi);
        return R.ok().put("data",discussmoguxinxi.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussmoguxinxiEntity discussmoguxinxi = discussmoguxinxiService.selectOne(new EntityWrapper<DiscussmoguxinxiEntity>().eq("", username));
        return R.ok().put("data", discussmoguxinxi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussmoguxinxiEntity discussmoguxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmoguxinxi);
        //全部更新
        discussmoguxinxiService.updateById(discussmoguxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussmoguxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussmoguxinxiEntity discussmoguxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussmoguxinxiEntity> ew = new EntityWrapper<DiscussmoguxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = discussmoguxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmoguxinxi), params), params));
        return R.ok().put("data", page);
    }








}
