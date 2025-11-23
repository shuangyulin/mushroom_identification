<template>
	<div>
	<!--  -->
		<div class="breadcrumb-preview">
			<el-breadcrumb :separator="'>'">
				<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
				<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" :to="'/index/discussmoguxinxi?centerType=' + (centerType?'1':'0')"><a>{{item.name}}</a></el-breadcrumb-item>
				<el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<div class="back_box">
			<el-button class="backBtn" size="mini" @click="backClick">
				<span class="icon iconfont icon-jiantou33"></span>
				<span class="text">返回</span>
			</el-button>
		</div>
		<div class="detail-preview">
			<div class="attr">
				<div class="info">
					<div class="title-item">
						<div class="detail-title">
						</div>
					</div>
					<div class="item">
						<div class="lable">关联表id</div>
						<div class="text "  >{{detail.refid}}</div>
					</div>
					<div class="item">
						<div class="lable">用户名</div>
						<div class="text "  >{{detail.nickname}}</div>
					</div>
					<div class="item">
						<div class="lable">评论内容</div>
						<div class="text "  >{{detail.content}}</div>
					</div>
					<div class="item">
						<div class="lable">回复内容</div>
						<div class="text "  >{{detail.reply}}</div>
					</div>
					<div class="item">
						<div class="lable">置顶(1:置顶,0:非置顶)</div>
						<div class="text "  >{{detail.istop}}</div>
					</div>
					<div class="item">
						<div class="lable">赞用户ids</div>
						<div class="text "  >{{detail.tuserids}}</div>
					</div>
					<div class="item">
						<div class="lable">踩用户ids</div>
						<div class="text "  >{{detail.cuserids}}</div>
					</div>
					<div class="btn_box">
						<el-button class="editBtn" v-if="btnAuth('discussmoguxinxi','修改')" @click="editClick">修改</el-button>
						<el-button class="delBtn" v-if="btnAuth('discussmoguxinxi','删除')" @click="delClick">删除</el-button>
					</div>
				</div>
			</div>
		
			<div class="detail-swpier2" v-if="detailBanner.length">
				<div class="swiper21">
					<div class="swiper-container mySwiper21">
						<div class="swiper-wrapper">
							<div class="swiper-slide" v-for="item in detailBanner" :key="item.id">
								<div class="swiper-item">
									<img v-if="item.substr(0,4)=='http'" :src="item" class="image">
									<img v-else :src="baseUrl + item" class="image">
								</div>
							</div>
						</div>
						<div class="swiper-button-prev">
							<span class="icon iconfont icon-jiantou39"></span>
						</div>
						<div class="swiper-button-next">
							<span class="icon iconfont icon-jiantou18"></span>
						</div>
					</div>
				</div>
				<div class="swiper22">
					<div class="swiper-container mySwiper22">
						<div class="swiper-wrapper">
							<div class="swiper-slide" v-for="item in detailBanner" :key="item.id">
								<div class="swiper-item">
									<img v-if="item.substr(0,4)=='http'" :src="item" class="image">
									<img v-else :src="baseUrl + item" class="image">
								</div>
							</div>
						</div>
						<div class="swiper-button-prev">
							<span class="icon iconfont icon-jiantou39"></span>
						</div>
						<div class="swiper-button-next">
							<span class="icon iconfont icon-jiantou18"></span>
						</div>
					</div>
				</div>
			</div>


		

			<div class="detail2">
				<el-form class="add commentForm" :model="form" :rules="rules" ref="form">
					<el-form-item class="item" label="评论" prop="content">
						<editor
							myQuillEditor="content"
							v-model="form.content" 
							class="editor" 
							action="file/upload">
						</editor>
					</el-form-item>
					<el-form-item class="commentBtn">
						<el-button class="submitBtn" type="primary" @click="submitForm('form')">立即提交</el-button>
						<el-button class="resetBtn" @click="resetForm('form')">重置</el-button>
					</el-form-item>
				</el-form>
				
				<div v-if="infoList.length" class="comment-list">
					<div class="comment-item" v-for="item in infoList" :key="item.id" @mouseenter="discussEnter(item.id)" @mouseleave="discussLeave">
						<div class="istop" v-if="item.istop">
							<span class="icon iconfont icon-jiantou24"></span>
						</div>
						<div class="user">
							<el-image v-if="item.avatarurl" :size="50" :src="baseUrl + item.avatarurl"></el-image>
							<el-image v-if="!item.avatarurl" :size="50" :src="require('@/assets/touxiang.png')"></el-image>
							<div class="name">{{item.nickname}}</div>
						</div>
						<div class="comment-content-box">
							<div class="ql-snow ql-editor" v-html="item.content"></div>
							<div class="comment-time">{{item.addtime}}</div>
							<div class="zancai-box">
								<div v-if="!comcaiChange(item)" class="zan-item" :class="comzanChange(item)?'active':''" @click="comzanClick(item)">
									<span class="icon iconfont" :class="comzanChange(item)?'icon-zan01':'icon-zan19'"></span>
									<span class="label">{{comzanChange(item)?'已赞':'赞'}}</span>
									<span class="num">({{item.thumbsupnum}})</span>
								</div>
								<div v-if="!comzanChange(item)" class="cai-item" :class="comcaiChange(item)?'active':''" @click="comcaiClick(item)">
									<span class="icon iconfont" :class="comcaiChange(item)?'icon-cai16':'icon-cai01'"></span>
									<span class="label">{{comcaiChange(item)?'已踩':'踩'}}</span>
									<span class="num">({{item.crazilynum}})</span>
								</div>
							</div>
							<div class="comment-btn">
								<!-- <el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#A86D23","width":"auto","lineHeight":"34px","fontSize":"14px","height":"34px"}'>回复</el-button> -->
								<el-button class="comment-del" v-if="showIndex==item.id&&userid==item.userid" @click="discussDel(item.id)">删除</el-button>
							</div>
						</div>
						<div class="comment-content-box" v-if="item.reply">
							回复：<span class="ql-snow ql-editor" v-html="item.reply"></span>
						</div>
					</div>
				</div>
				
				<el-pagination
					background
					id="pagination" class="pagination"
					:page-size="pageSize"
					prev-text="上一页"
					next-text="下一页"
					:hide-on-single-page="false"
					:layout='["total","prev","pager","next","sizes","jumper"].join()'
					:total="total"
					@current-change="curChange"
					@prev-click="prevClick"
					@next-click="nextClick"
					@size-change="sizeChange"
					></el-pagination>
			</div>
			<el-tabs class="detail-tabs" v-model="activeName" type="border-card" v-if="tabsNum>0" >
			</el-tabs>

			<div class="idea1"></div>
			<div class="idea2"></div>
		</div>
	</div>
</template>

<script>
	import axios from 'axios'
	import Swiper from "swiper";
	export default {
		//数据集合
		data() {
			return {
				tablename: 'discussmoguxinxi',
				baseUrl: '',
				breadcrumbItem: [
					{
						name: '蘑菇信息评论表'
					}
				],
				title: '',
				detailBanner: [],
				userid: Number(localStorage.getItem('frontUserid')),
				id: 0,
				detail: {},
				tabsNum: 0,
				activeName: 'second',
				form: {
					content: '',
					userid: Number(localStorage.getItem('frontUserid')),
					nickname: localStorage.getItem('username'),
					avatarurl: '',
				},
				showIndex: -1,
				infoList: [],
				rules: {
					content: [
						{ required: true, message: '请输入内容', trigger: 'blur' }
					],
				},
				total: 1,
				pageSize: 10,
				totalPage: 1,
				buynumber: 1,
				centerType: false,
				storeupType: false,
			}
		},
		created() {
			if(this.$route.query.centerType&&this.$route.query.centerType!=0) {
				this.centerType = true
			}
			if(this.$route.query.storeupType&&this.$route.query.storeupType!=0) {
				this.storeupType = true
			}
			
			this.init();
		},
		mounted() {
			setTimeout(()=>{
				let mySwiper22 = new Swiper(".mySwiper22", {"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"freeMode":true,"watchSlidesVisibility":true,"watchSlidesProgress":true,"loopedSlides":5,"slidesPerView":4,"spaceBetween":10})
				let option21 = {...{"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"loopedSlides":5,"spaceBetween":10}}
				option21.thumbs = {
					swiper: mySwiper22
				}
				new Swiper(".mySwiper21", option21)
			},100)
		},
		//方法集合
		methods: {
			init() {
				this.id = this.$route.query.id
				this.baseUrl = this.$config.baseUrl;
				this.$http.get(this.tablename + '/detail/'  + this.id, {}).then(res => {
					if (res.data.code == 0) {
						this.detail = res.data.data;
						this.$forceUpdate();
						this.getDiscussList(1);
						if(localStorage.getItem('frontToken')){
						}

					}
				});
			},
			curChange(page) {
				this.getDiscussList(page);
			},
			prevClick(page) {
				this.getDiscussList(page);
			},
			nextClick(page) {
				this.getDiscussList(page);
			},
			sizeChange(size){
				this.pageSize = size
				this.getDiscussList(1);
			},
			// 返回按钮
			backClick(){
				if(this.storeupType){
					history.back()
				}else{
					let params = {}
					if(this.centerType){
						params.centerType = 1
					}
					this.$router.push({path: '/index/discussmoguxinxi', query: params});
				}
			},
			// 下载
			download(file ){
				if(!file) {
					this.$message({
						type: 'error',
						message: '文件不存在',
						duration: 1500,
					});
					return;
				}
				let arr = file.replace(new RegExp('upload/', "g"), "")
				axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
					headers: {
						token: localStorage.getItem("frontToken")
					},
					responseType: "blob"
				}).then(({
					data
				}) => {
					const binaryData = [];
					binaryData.push(data);
					const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
						type: 'application/pdf;chartset=UTF-8'
					}))
					const a = document.createElement('a')
					a.href = objectUrl
					a.download = arr
					// a.click()
					// 下面这个写法兼容火狐
					a.dispatchEvent(new MouseEvent('click', {
						bubbles: true,
						cancelable: true,
						view: window
					}))
					window.URL.revokeObjectURL(data)
				},err=>{
					axios.get((location.href.split(this.$config.name).length>1 ? location.href.split(this.$config.name)[0] :'') + this.$config.name + '/file/download?fileName=' + arr, {
						headers: {
							token: localStorage.getItem("frontToken")
						},
						responseType: "blob"
					}).then(({
						data
					}) => {
						const binaryData = [];
						binaryData.push(data);
						const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
							type: 'application/pdf;chartset=UTF-8'
						}))
						const a = document.createElement('a')
						a.href = objectUrl
						a.download = arr
						// a.click()
						// 下面这个写法兼容火狐
						a.dispatchEvent(new MouseEvent('click', {
							bubbles: true,
							cancelable: true,
							view: window
						}))
						window.URL.revokeObjectURL(data)
					})
				})
			},
			getDiscussList(page) {
				this.$http.get('discussdiscussmoguxinxi/list', {params: {page, limit: this.pageSize, refid: this.detail.id,sort: 'istop',order: 'desc'}}).then(res => {
					if (res.data.code == 0) {
						this.infoList = res.data.data.list;
						this.total = res.data.data.total;
						this.pageSize = Number(res.data.data.pageSize);
						this.totalPage = res.data.data.totalPage;
					}
				});
			},
			comzanChange(row){
				if(row.tuserids){
					let arr = row.tuserids.split(',')
					for(let x in arr){
						if(arr[x] == this.userid){
							return true
						}
					}
				}
				return false
			},
			comzanClick(row){
				if(!this.userid){
					return false
				}
				if(!this.comzanChange(row)){
					row.thumbsupnum++
					if(row.tuserids){
						row.tuserids = row.tuserids + ',' + this.userid
					}else {
						row.tuserids = String(this.userid)
					}
					this.$http.post('discussdiscussmoguxinxi/update',row).then(rs=>{
						this.$message.success('点赞成功')
					})
				}else {
					row.thumbsupnum--
					let arr = row.tuserids.split(',')
					for(let x in arr){
						if(arr[x] == this.userid){
							arr.splice(x,1)
						}
					}
					row.tuserids = arr.join(',')
					this.$http.post('discussdiscussmoguxinxi/update',row).then(rs=>{
						this.$message.success('取消成功')
					})
				}
			},
			comcaiChange(row){
				if(row.cuserids){
					let arr = row.cuserids.split(',')
					for(let x in arr){
						if(arr[x] == this.userid){
							return true
						}
					}
				}
				return false
			},
			comcaiClick(row){
				if(!this.userid){
					return false
				}
				if(!this.comcaiChange(row)){
					row.crazilynum++
					if(row.cuserids){
						row.cuserids = row.cuserids + ',' + this.userid
					}else {
						row.cuserids = String(this.userid)
					}
					this.$http.post('discussdiscussmoguxinxi/update',row).then(rs=>{
						this.$message.success('点踩成功')
					})
				}else {
					row.crazilynum--
					let arr = row.cuserids.split(',')
					for(let x in arr){
						if(arr[x] == this.userid){
							arr.splice(x,1)
						}
					}
					row.cuserids = arr.join(',')
					this.$http.post('discussdiscussmoguxinxi/update',row).then(rs=>{
						this.$message.success('取消成功')
					})
				}
			},
			discussEnter(index){
				this.showIndex = index
			},
			discussLeave(){
				this.showIndex = -1
			},
			discussDel(id){
				this.$confirm('是否删除此评论？').then(_ => {
					this.$http.post('discussdiscussmoguxinxi/delete',[id]).then(res=>{
						if(res.data&&res.data.code==0){
							this.addDiscussNum(1)
							this.$message({
								type: 'success',
								message: '删除成功!',
								duration: 1500,
								onClose: () => {
									this.getDiscussList(1);
								}
							});
						}
					})
				}).catch(_ => {});
			},
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if (valid) {
						this.form.refid = this.detail.id;
						this.form.avatarurl = localStorage.getItem('frontHeadportrait')?localStorage.getItem('frontHeadportrait'):'';
						this.$http.post('discussdiscussmoguxinxi/add', this.form).then(rs2 => {
							if (rs2.data.code == 0) {
								this.form.content = '';
								this.addDiscussNum(2)
								this.getDiscussList(1);
								this.$message({
									type: 'success',
									message: '评论成功!',
									duration: 1500,
								});
							}
						});
					} else {
						return false;
					}
				});
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			},
			addDiscussNum(type){
				if(type==2){
					this.detail.discussnum++
				}else if(type==1){
					if(this.detail.discussnum!=0){
						this.detail.discussnum--
					}else{
						this.detail.discussnum = 0
					}
				}
				this.$http.post('discussmoguxinxi/update',this.detail).then(res=>{})
			},


			// 权限判断
			btnAuth(tableName,key){
				if(this.centerType){
					return this.isBackAuth(tableName,key)
				}else{
					return this.isAuth(tableName,key)
				}
			},
			// 修改
			editClick(){
				this.$router.push(`/index/discussmoguxinxiAdd?type=edit&&id=${this.detail.id}`);
			},
			// 删除
			async delClick(){
				await this.$confirm('是否删除此蘑菇信息评论表？') .then(_ => {
					this.$http.post('discussmoguxinxi/delete', [this.detail.id]).then(async res => {
						if (res.data.code == 0) {
							this.$message({
								type: 'success',
								message: '删除成功!',
								duration: 1500,
								onClose: () => {
									history.back()
								}
							});
						}
					});
				}).catch(_ => {});
			},
		},
		components: {
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.detail-preview {
		padding: 20px 0;
		margin: 0px auto;
		color: #666;
		display: flex;
		width: 1200px;
		font-size: 16px;
		justify-content: flex-start;
		align-items: flex-start;
		position: relative;
		flex-wrap: wrap;
		.attr {
			padding: 0;
			background: none;
			flex: 1;
			display: block;
			width: 100%;
			position: relative;
			order: 2;
			.info {
				padding: 0;
				margin: 0;
				background: none;
				width: 100%;
				.title-item {
					border-radius: 4px;
					padding: 0 10px;
					margin: 0 auto 3px;
					background: none;
					display: flex;
					border-color: #eee;
					border-width: 0 0 1px;
					line-height: 40px;
					justify-content: space-between;
					align-items: center;
					border-style: solid;
					.detail-title {
						color: #333;
						font-weight: 600;
						font-size: 20px;
					}
				}
				.item {
					border-radius: 0px;
					padding: 0;
					margin: 0 0 3px 0;
					background: none;
					display: flex;
					border-color: #eee;
					border-width:  0 0 1px;
					justify-content: spaceBetween;
					border-style: solid;
					.lable {
						padding: 0 20px;
						color: #333;
						white-space: nowrap;
						font-weight: 500;
						width: auto;
						font-size: inherit;
						line-height: 32px;
						text-align: right;
						height: 32px;
					}
					.text {
						padding: 4px 10px 0;
						color: inherit;
						word-break: break-all;
						flex: 1;
						font-size: inherit;
						line-height: 24px;
						height: auto;
					}
					.price {
						color: #f00;
					}
					.bold {
						font-weight: bold;
					}
					.link {
						cursor: pointer;
						text-decoration: underline;
					}
				}
				.btn_box {
					padding: 10px 0;
					display: flex;
					flex-wrap: wrap;
				}
				.editBtn {
					border: 1px solid rgba(64, 158, 255, .3);
					cursor: pointer;
					border-radius: 4px;
					padding: 0 10px;
					margin: 0 5px 0 0;
					color: rgba(64, 158, 255, 1);
					background: none;
					width: auto;
					font-size: inherit;
					line-height: 40px;
					height: 40px;
				}
				.editBtn:hover {
					background: rgba(64, 158, 255, .1);
				}
				.delBtn {
					border: 1px solid rgba(209, 6, 2, .3);
					cursor: pointer;
					border-radius: 4px;
					padding: 0 10px;
					margin: 0 5px 0 0;
					outline: none;
					color: rgba(209, 6, 2, 1);
					background: none;
					width: auto;
					font-size: inherit;
					line-height: 40px;
					height: 40px;
				}
				.delBtn:hover {
					background: rgba(209, 6, 2, .1);
				}
			}
		}
		.detail-swpier2 {
			margin: 0 50px 0 0;
			background: #fff;
			width: 480px;
			height: auto;
			.swiper21 {
				width: 100%;
				height: auto;
				.swiper-button-prev:after {
					display:none;
				}
				.swiper-button-next:after {
					display:none;
				}
				.swiper-item {
					width: 100%;
					height: auto;
					img {
						object-fit: cover;
						width: 100%;
						height: 400px;
					}
				}
				.swiper-button-prev {
					margin: -12px 0 0;
					top: 50%;
					width: 24px;
					height: 24px;
					.icon {
						color: #fff;
						width: 24px;
						font-size: 24px;
						height: 24px;
					}
				}
				.swiper-button-next {
					margin: -12px 0 0;
					top: 50%;
					width: 24px;
					height: 24px;
					.icon {
						color: #fff;
						width: 24px;
						font-size: 24px;
						height: 24px;
					}
				}
			}
			.swiper22 {
				width: 100%;
				height: auto;
				
				.swiper-button-prev:after {
					display:none;
				}
				.swiper-button-next:after {
					display:none;
				}
				
				.swiper-item {
					width: 100%;
					opacity: 0.4;
					height: auto;
					img {
						object-fit: cover;
						width: 100%;
						height: 100px;
					}
				}
				.swiper-slide.swiper-slide-thumb-active div {
					opacity: 1;
				}
				.swiper-button-prev {
					margin: -7px 0 0;
					top: 50%;
					width: 14px;
					height: 14px;
					.icon {
						color: #fff;
						width: 14px;
						font-size: 14px;
						height: 14px;
					}
				}
				.swiper-button-next {
					margin: -7px 0 0;
					top: 50%;
					width: 14px;
					height: 14px;
					.icon {
						color: #fff;
						width: 14px;
						font-size: 14px;
						height: 14px;
					}
				}
			}
		}
		.detail2 {
			border: 0;
			padding: 0;
			box-shadow: none;
			margin: 20px 0;
			background: #fff;
			width: 100%;
			order: 20;
			.desc-view {
				padding: 0;
				color: #333;
				background: none;
				width: 100%;
				font-size: 24px;
				line-height: 65px;
				text-align: center;
				.desc-label {
					color: #A91B1B;
					font-weight: 600;
					font-size: 32px;
				}
			}
			.desc-text {
				padding: 20px;
				background: #fff;
			}
			.add.commentForm {
				padding: 0;
				margin: 20px 0;
				.item {
					display: flex;
					width: 100%;
					height: auto;
					/deep/ .el-form-item__label {
						padding: 0 10px 0 0;
						color: #666;
						white-space: nowrap;
						letter-spacing: 4px;
						width: auto;
						font-size: 16px;
						line-height: 40px;
						text-align: right;
					}
					.editor {
						border: 1px solid #ddd;
						border-radius: 4px;
						outline: none;
						color: #333;
						width: 100%;
						font-size: 14px;
						min-height: 400px;
						line-height: 32px;
						/deep/ .avatar-uploader {
							height: 0;
							line-height: 0;
						}
					}
				}
				.commentBtn {
					padding: 0 0 0 60px;
					margin: 10px 0 0;
					width: 100%;
					text-align: center;
					height: auto;
					.submitBtn {
						border: 0;
						cursor: pointer;
						border-radius: 4px;
						padding: 0;
						margin: 0 20px 0 0;
						outline: none;
						color: rgba(255, 255, 255, 1);
						background: rgba(137,1,5,1);
						width: 120px;
						font-size: 15px;
						line-height: 40px;
						height: 40px;
					}
					.submitBtn:hover {
					}
					.resetBtn {
						border: 0;
						cursor: pointer;
						border-radius: 4px;
						padding: 0;
						margin: 0 20px 0 0;
						outline: none;
						color: rgba(255, 255, 255, 1);
						background: #A86D23;
						width: 120px;
						font-size: 15px;
						line-height: 40px;
						height: 40px;
					}
					.resetBtn:hover {
					}
				}
			}
			.comment-list {
				padding: 0;
				display: flex;
				justify-content: space-between;
				flex-wrap: wrap;
				.comment-item {
					padding: 10px 10px;
					margin: 0 0 20px;
					width: 100%;
					align-items: center;
					height: auto;
					.istop {
						box-shadow: 0 4px 8px rgba(0,0,0,.1);
						top: 0;
						background: #fff;
						position: absolute;
						right: 10px;
						.icon {
							color: #000;
						}
					}
					.user {
						padding: 5px;
						background: #A86D2310;
						display: flex;
						width: 100%;
						align-items: center;
						height: auto;
						.el-image {
							border-radius: 100%;
							margin: 0 10px 0 0;
							object-fit: cover;
							width: 40px;
							height: 40px;
						}
						.name {
							color: #333;
							font-size: 16px;
						}
					}
					.comment-time {
					}
					.comment-content-box {
						border-radius: 4px;
						padding: 8px;
						margin: 10px 0px 0px;
						word-wrap: break-word;
						color: #666;
						background: none;
						font-size: 15px;
						line-height: 1.5;
						.zancai-box {
							margin: 8px 0 0 0;
							display: flex;
							width: 100%;
							font-size: 14px;
							justify-content: flex-end;
							align-items: center;
							height: 30px;
							.zan-item {
								margin: 0 10px 0 0;
								display: flex;
								align-items: center;
								.icon {
								font-size: 14px;
								}
								.label {
								font-size: 14px;
								}
								.num {
								font-size: 14px;
								}
							}
							.zan-item.active {
								margin: 0 10px 0 0;
								background: none;
								.icon {
								color: #ff0000;
								}
								.label {
								color: #ff0000;
								}
								.num {
								color: #ff0000;
								font-size: 14px;
								}
							}
							.zan-item:hover {
								opacity: 1;
								.icon {
								color: #ff0000;
								}
								.label {
								color: #ff0000;
								}
								.num {
								color: #ff0000;
								}
							}
							.cai-item {
								margin: 0 10px 0 0;
								display: flex;
								align-items: center;
								.icon {
								font-size: 14px;
								}
								.label {
								font-size: 14px;
								}
								.num {
								font-size: 14px;
								}
							}
							.cai-item.active {
								background: none;
								.icon {
								color: #ff0000;
								}
								.label {
								color: #ff0000;
								}
								.num {
								color: #ff0000;
								font-size: 14px;
								}
							}
							.cai-item:hover {
								opacity: 1;
								.icon {
								color: #ff0000;
								}
								.label {
								color: #ff0000;
								}
								.num {
								color: #ff0000;
								}
							}
						}
						.comment-btn {
							margin: 8px 0 0 0;
							display: flex;
							width: 100%;
							justify-content: flex-end;
							align-items: center;
							height: 40px;
							.comment-del {
								border: 0;
								cursor: pointer;
								border-radius: 4px;
								padding: 0 20px;
								margin: 0 10px;
								outline: none;
								color: rgba(255, 255, 255, 1);
								background: rgba(137,1,5,1);
								width: auto;
								font-size: 14px;
								line-height: 34px;
								height: 34px;
							}
						}
					}
				}
			}
		}
		.detail-tabs {
			border: 1px solid rgba(137,1,5,.3);
			box-shadow: none;
			padding: 0;
			margin: 20px auto 40px;
			background: #fff;
			width: 100%;
			order: 21;
			& /deep/ .el-tabs__header .el-tabs__nav-wrap {
				margin-bottom: 0;
			}
			/deep/ .el-tabs__header {
				padding: 10px 10px 0;
				margin: 0;
				background: none;
				border-color: #d1060230;
				border-width: 0 0 0px 0;
				border-style: solid;
			}
			
			/deep/ .el-tabs__header .el-tabs__item {
				border: 0;
				padding: 0 20px;
				margin: 0 5px;
				color: #333;
				font-weight: 500;
				display: inline-block;
				font-size: inherit;
				line-height: 34px;
				transition: all 0s;
				background: transparent;
				position: relative;
				list-style: none;
				height: 34px;
			}
			
			/deep/ .el-tabs__header .el-tabs__item:hover {
				border: 0;
				border-radius: 0;
				color: #fff;
				background: rgba(137,1,5,1);
			}
			
			/deep/ .el-tabs__header .el-tabs__item.is-active {
				border: 0;
				border-radius: 0;
				margin: 0 5px;
				color: #fff;
				background: rgba(137,1,5,1);
				font-size: inherit;
				line-height: 34px;
				height: 34px;
			}
			
			/deep/ .el-tabs__content {
				padding: 15px;
			}
		}
	}
	.idea1 {
		background: #fff;
		width: 100%;
		height: 10px;
		order: 4;
	}
	.idea2 {
		background: #fff;
		width: 100%;
		height: 10px;
		order: 10;
	}
</style>
