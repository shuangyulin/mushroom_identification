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


import com.dao.KepufenleiDao;
import com.entity.KepufenleiEntity;
import com.service.KepufenleiService;
import com.entity.vo.KepufenleiVO;
import com.entity.view.KepufenleiView;

@Service("kepufenleiService")
public class KepufenleiServiceImpl extends ServiceImpl<KepufenleiDao, KepufenleiEntity> implements KepufenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KepufenleiEntity> page = this.selectPage(
                new Query<KepufenleiEntity>(params).getPage(),
                new EntityWrapper<KepufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KepufenleiEntity> wrapper) {
		  Page<KepufenleiView> page =new Query<KepufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KepufenleiVO> selectListVO(Wrapper<KepufenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KepufenleiVO selectVO(Wrapper<KepufenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KepufenleiView> selectListView(Wrapper<KepufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KepufenleiView selectView(Wrapper<KepufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
