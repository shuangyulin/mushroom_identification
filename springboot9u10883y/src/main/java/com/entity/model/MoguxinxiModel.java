package com.entity.model;

import com.entity.MoguxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 蘑菇信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
public class MoguxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 蘑菇分类
	 */
	
	private String mogufenlei;
		
	/**
	 * 蘑菇图片
	 */
	
	private String mogutupian;
		
	/**
	 * 出产地区
	 */
	
	private String chuchandiqu;
		
	/**
	 * 营养成分
	 */
	
	private String yingyangchengfen;
		
	/**
	 * 食用价值
	 */
	
	private String shiyongjiazhi;
		
	/**
	 * 种植技巧
	 */
	
	private String zhongzhijiqiao;
		
	/**
	 * 蘑菇详情
	 */
	
	private String moguxiangqing;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：蘑菇分类
	 */
	 
	public void setMogufenlei(String mogufenlei) {
		this.mogufenlei = mogufenlei;
	}
	
	/**
	 * 获取：蘑菇分类
	 */
	public String getMogufenlei() {
		return mogufenlei;
	}
				
	
	/**
	 * 设置：蘑菇图片
	 */
	 
	public void setMogutupian(String mogutupian) {
		this.mogutupian = mogutupian;
	}
	
	/**
	 * 获取：蘑菇图片
	 */
	public String getMogutupian() {
		return mogutupian;
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
	 * 设置：营养成分
	 */
	 
	public void setYingyangchengfen(String yingyangchengfen) {
		this.yingyangchengfen = yingyangchengfen;
	}
	
	/**
	 * 获取：营养成分
	 */
	public String getYingyangchengfen() {
		return yingyangchengfen;
	}
				
	
	/**
	 * 设置：食用价值
	 */
	 
	public void setShiyongjiazhi(String shiyongjiazhi) {
		this.shiyongjiazhi = shiyongjiazhi;
	}
	
	/**
	 * 获取：食用价值
	 */
	public String getShiyongjiazhi() {
		return shiyongjiazhi;
	}
				
	
	/**
	 * 设置：种植技巧
	 */
	 
	public void setZhongzhijiqiao(String zhongzhijiqiao) {
		this.zhongzhijiqiao = zhongzhijiqiao;
	}
	
	/**
	 * 获取：种植技巧
	 */
	public String getZhongzhijiqiao() {
		return zhongzhijiqiao;
	}
				
	
	/**
	 * 设置：蘑菇详情
	 */
	 
	public void setMoguxiangqing(String moguxiangqing) {
		this.moguxiangqing = moguxiangqing;
	}
	
	/**
	 * 获取：蘑菇详情
	 */
	public String getMoguxiangqing() {
		return moguxiangqing;
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
