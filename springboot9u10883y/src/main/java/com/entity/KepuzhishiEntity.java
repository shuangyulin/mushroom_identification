package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 科普知识
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-17 20:02:00
 */
@TableName("kepuzhishi")
public class KepuzhishiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KepuzhishiEntity() {
		
	}
	
	public KepuzhishiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 科普名称
	 */
					
	private String kepumingcheng;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：科普名称
	 */
	public void setKepumingcheng(String kepumingcheng) {
		this.kepumingcheng = kepumingcheng;
	}
	/**
	 * 获取：科普名称
	 */
	public String getKepumingcheng() {
		return kepumingcheng;
	}
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
