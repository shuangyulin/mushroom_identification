package com.entity.model;

import com.entity.KepuzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 科普知识
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
public class KepuzhishiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 科普分类
	 */
	
	private String kepufenlei;
		
	/**
	 * 图片封面
	 */
	
	private String tupianfengmian;
		
	/**
	 * 出产地区
	 */
	
	private String chuchandiqu;
		
	/**
	 * 生长环境
	 */
	
	private String shengzhanghuanjing;
		
	/**
	 * 知识重点
	 */
	
	private String zhishizhongdian;
		
	/**
	 * 科普详情
	 */
	
	private String kepuxiangqing;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：科普分类
	 */
	 
	public void setKepufenlei(String kepufenlei) {
		this.kepufenlei = kepufenlei;
	}
	
	/**
	 * 获取：科普分类
	 */
	public String getKepufenlei() {
		return kepufenlei;
	}
				
	
	/**
	 * 设置：图片封面
	 */
	 
	public void setTupianfengmian(String tupianfengmian) {
		this.tupianfengmian = tupianfengmian;
	}
	
	/**
	 * 获取：图片封面
	 */
	public String getTupianfengmian() {
		return tupianfengmian;
	}
				
	
	/**
	 * 设置：出产地区
	 */
	 
	public void setChuchandiqu(String chuchandiqu) {
		this.chuchandiqu = chuchandiqu;
	}
	
	/**
	 * 获取：出产地区
	 */
	public String getChuchandiqu() {
		return chuchandiqu;
	}
				
	
	/**
	 * 设置：生长环境
	 */
	 
	public void setShengzhanghuanjing(String shengzhanghuanjing) {
		this.shengzhanghuanjing = shengzhanghuanjing;
	}
	
	/**
	 * 获取：生长环境
	 */
	public String getShengzhanghuanjing() {
		return shengzhanghuanjing;
	}
				
	
	/**
	 * 设置：知识重点
	 */
	 
	public void setZhishizhongdian(String zhishizhongdian) {
		this.zhishizhongdian = zhishizhongdian;
	}
	
	/**
	 * 获取：知识重点
	 */
	public String getZhishizhongdian() {
		return zhishizhongdian;
	}
				
	
	/**
	 * 设置：科普详情
	 */
	 
	public void setKepuxiangqing(String kepuxiangqing) {
		this.kepuxiangqing = kepuxiangqing;
	}
	
	/**
	 * 获取：科普详情
	 */
	public String getKepuxiangqing() {
		return kepuxiangqing;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
