package com.dao;

import com.entity.DiscussmoguxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmoguxinxiVO;
import com.entity.view.DiscussmoguxinxiView;


/**
 * 蘑菇信息评论表
 * 
 * @author 
 * @email 
 * @date 2025-03-17 20:02:02
 */
public interface DiscussmoguxinxiDao extends BaseMapper<DiscussmoguxinxiEntity> {
	
	List<DiscussmoguxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussmoguxinxiEntity> wrapper);
	
	DiscussmoguxinxiVO selectVO(@Param("ew") Wrapper<DiscussmoguxinxiEntity> wrapper);
	
	List<DiscussmoguxinxiView> selectListView(@Param("ew") Wrapper<DiscussmoguxinxiEntity> wrapper);

	List<DiscussmoguxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmoguxinxiEntity> wrapper);

	
	DiscussmoguxinxiView selectView(@Param("ew") Wrapper<DiscussmoguxinxiEntity> wrapper);
	

}
