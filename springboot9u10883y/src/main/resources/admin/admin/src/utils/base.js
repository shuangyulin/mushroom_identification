const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot9u10883y/",
            name: "springboot9u10883y",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot9u10883y/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于深度学习的蘑菇种类识别系统的设计与实现"
        } 
    }
}
export default base
