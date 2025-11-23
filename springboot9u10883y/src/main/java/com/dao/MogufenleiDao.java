package com.dao;

import com.entity.MogufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MogufenleiVO;
import com.entity.view.MogufenleiView;


/**
 * 蘑菇分类
 * 
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
public interface MogufenleiDao extends BaseMapper<MogufenleiEntity> {
	
	List<MogufenleiVO> selectListVO(@Param("ew") Wrapper<MogufenleiEntity> wrapper);
	
	MogufenleiVO selectVO(@Param("ew") Wrapper<MogufenleiEntity> wrapper);
	
	List<MogufenleiView> selectListView(@Param("ew") Wrapper<MogufenleiEntity> wrapper);

	List<MogufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<MogufenleiEntity> wrapper);

	
	MogufenleiView selectView(@Param("ew") Wrapper<MogufenleiEntity> wrapper);
	

}
