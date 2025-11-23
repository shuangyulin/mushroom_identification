import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import tuxiangshibieList from '../pages/tuxiangshibie/list'
import tuxiangshibieDetail from '../pages/tuxiangshibie/detail'
import tuxiangshibieAdd from '../pages/tuxiangshibie/add'
import kepuzhishiList from '../pages/kepuzhishi/list'
import kepuzhishiDetail from '../pages/kepuzhishi/detail'
import kepuzhishiAdd from '../pages/kepuzhishi/add'
import kepufenleiList from '../pages/kepufenlei/list'
import kepufenleiDetail from '../pages/kepufenlei/detail'
import kepufenleiAdd from '../pages/kepufenlei/add'
import moguxinxiList from '../pages/moguxinxi/list'
import moguxinxiDetail from '../pages/moguxinxi/detail'
import moguxinxiAdd from '../pages/moguxinxi/add'
import mogufenleiList from '../pages/mogufenlei/list'
import mogufenleiDetail from '../pages/mogufenlei/detail'
import mogufenleiAdd from '../pages/mogufenlei/add'
import forumtypeList from '../pages/forumtype/list'
import forumtypeDetail from '../pages/forumtype/detail'
import forumtypeAdd from '../pages/forumtype/add'
import forumreportList from '../pages/forumreport/list'
import forumreportDetail from '../pages/forumreport/detail'
import forumreportAdd from '../pages/forumreport/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discusskepuzhishiList from '../pages/discusskepuzhishi/list'
import discusskepuzhishiDetail from '../pages/discusskepuzhishi/detail'
import discusskepuzhishiAdd from '../pages/discusskepuzhishi/add'
import discussmoguxinxiList from '../pages/discussmoguxinxi/list'
import discussmoguxinxiDetail from '../pages/discussmoguxinxi/detail'
import discussmoguxinxiAdd from '../pages/discussmoguxinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'tuxiangshibie',
					component: tuxiangshibieList
				},
				{
					path: 'tuxiangshibieDetail',
					component: tuxiangshibieDetail
				},
				{
					path: 'tuxiangshibieAdd',
					component: tuxiangshibieAdd
				},
				{
					path: 'kepuzhishi',
					component: kepuzhishiList
				},
				{
					path: 'kepuzhishiDetail',
					component: kepuzhishiDetail
				},
				{
					path: 'kepuzhishiAdd',
					component: kepuzhishiAdd
				},
				{
					path: 'kepufenlei',
					component: kepufenleiList
				},
				{
					path: 'kepufenleiDetail',
					component: kepufenleiDetail
				},
				{
					path: 'kepufenleiAdd',
					component: kepufenleiAdd
				},
				{
					path: 'moguxinxi',
					component: moguxinxiList
				},
				{
					path: 'moguxinxiDetail',
					component: moguxinxiDetail
				},
				{
					path: 'moguxinxiAdd',
					component: moguxinxiAdd
				},
				{
					path: 'mogufenlei',
					component: mogufenleiList
				},
				{
					path: 'mogufenleiDetail',
					component: mogufenleiDetail
				},
				{
					path: 'mogufenleiAdd',
					component: mogufenleiAdd
				},
				{
					path: 'forumtype',
					component: forumtypeList
				},
				{
					path: 'forumtypeDetail',
					component: forumtypeDetail
				},
				{
					path: 'forumtypeAdd',
					component: forumtypeAdd
				},
				{
					path: 'forumreport',
					component: forumreportList
				},
				{
					path: 'forumreportDetail',
					component: forumreportDetail
				},
				{
					path: 'forumreportAdd',
					component: forumreportAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discusskepuzhishi',
					component: discusskepuzhishiList
				},
				{
					path: 'discusskepuzhishiDetail',
					component: discusskepuzhishiDetail
				},
				{
					path: 'discusskepuzhishiAdd',
					component: discusskepuzhishiAdd
				},
				{
					path: 'discussmoguxinxi',
					component: discussmoguxinxiList
				},
				{
					path: 'discussmoguxinxiDetail',
					component: discussmoguxinxiDetail
				},
				{
					path: 'discussmoguxinxiAdd',
					component: discussmoguxinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
