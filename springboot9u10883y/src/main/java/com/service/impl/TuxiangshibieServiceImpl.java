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


import com.dao.TuxiangshibieDao;
import com.entity.TuxiangshibieEntity;
import com.service.TuxiangshibieService;
import com.entity.vo.TuxiangshibieVO;
import com.entity.view.TuxiangshibieView;

@Service("tuxiangshibieService")
public class TuxiangshibieServiceImpl extends ServiceImpl<TuxiangshibieDao, TuxiangshibieEntity> implements TuxiangshibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuxiangshibieEntity> page = this.selectPage(
                new Query<TuxiangshibieEntity>(params).getPage(),
                new EntityWrapper<TuxiangshibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuxiangshibieEntity> wrapper) {
		  Page<TuxiangshibieView> page =new Query<TuxiangshibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TuxiangshibieVO> selectListVO(Wrapper<TuxiangshibieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuxiangshibieVO selectVO(Wrapper<TuxiangshibieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuxiangshibieView> selectListView(Wrapper<TuxiangshibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuxiangshibieView selectView(Wrapper<TuxiangshibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
