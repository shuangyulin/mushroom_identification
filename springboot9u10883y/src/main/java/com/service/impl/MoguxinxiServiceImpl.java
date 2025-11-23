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


import com.dao.MoguxinxiDao;
import com.entity.MoguxinxiEntity;
import com.service.MoguxinxiService;
import com.entity.vo.MoguxinxiVO;
import com.entity.view.MoguxinxiView;

@Service("moguxinxiService")
public class MoguxinxiServiceImpl extends ServiceImpl<MoguxinxiDao, MoguxinxiEntity> implements MoguxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MoguxinxiEntity> page = this.selectPage(
                new Query<MoguxinxiEntity>(params).getPage(),
                new EntityWrapper<MoguxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MoguxinxiEntity> wrapper) {
		  Page<MoguxinxiView> page =new Query<MoguxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MoguxinxiVO> selectListVO(Wrapper<MoguxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MoguxinxiVO selectVO(Wrapper<MoguxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MoguxinxiView> selectListView(Wrapper<MoguxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MoguxinxiView selectView(Wrapper<MoguxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
