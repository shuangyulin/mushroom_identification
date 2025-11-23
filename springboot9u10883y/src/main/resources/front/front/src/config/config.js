export default {
	baseUrl: 'http://localhost:8080/springboot9u10883y/',
	name: '/springboot9u10883y',
	indexNav: [
		{
			name: '科普知识',
			url: '/index/kepuzhishi',
		},
		{
			name: '蘑菇信息',
			url: '/index/moguxinxi',
		},
		{
			name: '交流论坛',
			url: '/index/forum'
		}, 
		{
			name: '通知公告',
			url: '/index/news'
		},
		{
			name: '留言反馈',
			url: '/index/messages'
		},
	],
	cateList: [
		{
			name: '科普知识',
			refTable: 'kepufenlei',
			refColumn: 'kepufenlei',
		},
		{
			name: '蘑菇信息',
			refTable: 'mogufenlei',
			refColumn: 'mogufenlei',
		},
		{
			name: '交流论坛',
			refTable: 'forumtype',
			refColumn: 'typename',
		},
		{
			name: '通知公告',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}
