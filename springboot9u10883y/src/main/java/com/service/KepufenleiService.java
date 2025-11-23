package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KepufenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KepufenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KepufenleiView;


/**
 * 科普分类
 *
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
public interface KepufenleiService extends IService<KepufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KepufenleiVO> selectListVO(Wrapper<KepufenleiEntity> wrapper);
   	
   	KepufenleiVO selectVO(@Param("ew") Wrapper<KepufenleiEntity> wrapper);
   	
   	List<KepufenleiView> selectListView(Wrapper<KepufenleiEntity> wrapper);
   	
   	KepufenleiView selectView(@Param("ew") Wrapper<KepufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KepufenleiEntity> wrapper);

   	

}

