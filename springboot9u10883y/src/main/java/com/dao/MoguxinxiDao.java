package com.dao;

import com.entity.MoguxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MoguxinxiVO;
import com.entity.view.MoguxinxiView;


/**
 * 蘑菇信息
 * 
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
public interface MoguxinxiDao extends BaseMapper<MoguxinxiEntity> {
	
	List<MoguxinxiVO> selectListVO(@Param("ew") Wrapper<MoguxinxiEntity> wrapper);
	
	MoguxinxiVO selectVO(@Param("ew") Wrapper<MoguxinxiEntity> wrapper);
	
	List<MoguxinxiView> selectListView(@Param("ew") Wrapper<MoguxinxiEntity> wrapper);

	List<MoguxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<MoguxinxiEntity> wrapper);

	
	MoguxinxiView selectView(@Param("ew") Wrapper<MoguxinxiEntity> wrapper);
	

}
