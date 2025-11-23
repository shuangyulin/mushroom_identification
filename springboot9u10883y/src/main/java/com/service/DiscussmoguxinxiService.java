package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmoguxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmoguxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmoguxinxiView;


/**
 * 蘑菇信息评论表
 *
 * @author 
 * @email 
 * @date 2025-03-17 20:02:02
 */
public interface DiscussmoguxinxiService extends IService<DiscussmoguxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmoguxinxiVO> selectListVO(Wrapper<DiscussmoguxinxiEntity> wrapper);
   	
   	DiscussmoguxinxiVO selectVO(@Param("ew") Wrapper<DiscussmoguxinxiEntity> wrapper);
   	
   	List<DiscussmoguxinxiView> selectListView(Wrapper<DiscussmoguxinxiEntity> wrapper);
   	
   	DiscussmoguxinxiView selectView(@Param("ew") Wrapper<DiscussmoguxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmoguxinxiEntity> wrapper);

   	

}

