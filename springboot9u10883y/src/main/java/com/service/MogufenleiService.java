package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MogufenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MogufenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MogufenleiView;


/**
 * 蘑菇分类
 *
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
public interface MogufenleiService extends IService<MogufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MogufenleiVO> selectListVO(Wrapper<MogufenleiEntity> wrapper);
   	
   	MogufenleiVO selectVO(@Param("ew") Wrapper<MogufenleiEntity> wrapper);
   	
   	List<MogufenleiView> selectListView(Wrapper<MogufenleiEntity> wrapper);
   	
   	MogufenleiView selectView(@Param("ew") Wrapper<MogufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MogufenleiEntity> wrapper);

   	

}

