package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MoguxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MoguxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MoguxinxiView;


/**
 * 蘑菇信息
 *
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
public interface MoguxinxiService extends IService<MoguxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MoguxinxiVO> selectListVO(Wrapper<MoguxinxiEntity> wrapper);
   	
   	MoguxinxiVO selectVO(@Param("ew") Wrapper<MoguxinxiEntity> wrapper);
   	
   	List<MoguxinxiView> selectListView(Wrapper<MoguxinxiEntity> wrapper);
   	
   	MoguxinxiView selectView(@Param("ew") Wrapper<MoguxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MoguxinxiEntity> wrapper);

   	

}

