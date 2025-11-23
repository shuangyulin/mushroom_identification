package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuxiangshibieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuxiangshibieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuxiangshibieView;


/**
 * 图像识别
 *
 * @author 
 * @email 
 * @date 2025-03-17 20:01:59
 */
public interface TuxiangshibieService extends IService<TuxiangshibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuxiangshibieVO> selectListVO(Wrapper<TuxiangshibieEntity> wrapper);
   	
   	TuxiangshibieVO selectVO(@Param("ew") Wrapper<TuxiangshibieEntity> wrapper);
   	
   	List<TuxiangshibieView> selectListView(Wrapper<TuxiangshibieEntity> wrapper);
   	
   	TuxiangshibieView selectView(@Param("ew") Wrapper<TuxiangshibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuxiangshibieEntity> wrapper);

   	

}

