package com.dao;

import com.entity.KepufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KepufenleiVO;
import com.entity.view.KepufenleiView;


/**
 * 科普分类
 * 
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
public interface KepufenleiDao extends BaseMapper<KepufenleiEntity> {
	
	List<KepufenleiVO> selectListVO(@Param("ew") Wrapper<KepufenleiEntity> wrapper);
	
	KepufenleiVO selectVO(@Param("ew") Wrapper<KepufenleiEntity> wrapper);
	
	List<KepufenleiView> selectListView(@Param("ew") Wrapper<KepufenleiEntity> wrapper);

	List<KepufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<KepufenleiEntity> wrapper);

	
	KepufenleiView selectView(@Param("ew") Wrapper<KepufenleiEntity> wrapper);
	

}
