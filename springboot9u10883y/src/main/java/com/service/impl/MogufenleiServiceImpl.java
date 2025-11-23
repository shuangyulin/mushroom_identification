package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.MogufenleiDao;
import com.entity.MogufenleiEntity;
import com.service.MogufenleiService;
import com.entity.vo.MogufenleiVO;
import com.entity.view.MogufenleiView;

@Service("mogufenleiService")
public class MogufenleiServiceImpl extends ServiceImpl<MogufenleiDao, MogufenleiEntity> implements MogufenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MogufenleiEntity> page = this.selectPage(
                new Query<MogufenleiEntity>(params).getPage(),
                new EntityWrapper<MogufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MogufenleiEntity> wrapper) {
		  Page<MogufenleiView> page =new Query<MogufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MogufenleiVO> selectListVO(Wrapper<MogufenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MogufenleiVO selectVO(Wrapper<MogufenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MogufenleiView> selectListView(Wrapper<MogufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MogufenleiView selectView(Wrapper<MogufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
