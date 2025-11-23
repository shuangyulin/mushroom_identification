package com.entity.view;

import com.entity.KepuzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 科普知识
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
@TableName("kepuzhishi")
public class KepuzhishiView  extends KepuzhishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KepuzhishiView(){
	}
 
 	public KepuzhishiView(KepuzhishiEntity kepuzhishiEntity){
 	try {
			BeanUtils.copyProperties(this, kepuzhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
