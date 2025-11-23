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


import com.dao.DiscussmoguxinxiDao;
import com.entity.DiscussmoguxinxiEntity;
import com.service.DiscussmoguxinxiService;
import com.entity.vo.DiscussmoguxinxiVO;
import com.entity.view.DiscussmoguxinxiView;

@Service("discussmoguxinxiService")
public class DiscussmoguxinxiServiceImpl extends ServiceImpl<DiscussmoguxinxiDao, DiscussmoguxinxiEntity> implements DiscussmoguxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmoguxinxiEntity> page = this.selectPage(
                new Query<DiscussmoguxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussmoguxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmoguxinxiEntity> wrapper) {
		  Page<DiscussmoguxinxiView> page =new Query<DiscussmoguxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussmoguxinxiVO> selectListVO(Wrapper<DiscussmoguxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmoguxinxiVO selectVO(Wrapper<DiscussmoguxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmoguxinxiView> selectListView(Wrapper<DiscussmoguxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmoguxinxiView selectView(Wrapper<DiscussmoguxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
