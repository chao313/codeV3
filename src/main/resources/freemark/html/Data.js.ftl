var queryBase = "http://127.0.0.1:8000/demomaster/TTitleController/queryBase";
var host = "http://127.0.0.1:8000/";

/** 设置后台项目名称 */
var BASE_URL = host+ '/${ftlVo.BASE_URL}';


function queryUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); // 匹配目标参数
    var result = window.location.search.substr(1).match(reg); // 对querystring匹配目标参数
    if (result != null) {
        return decodeURIComponent(result[2]);
    } else {
        return null;
    }
}

/** 后台的URL */
<#list ftlVo.keyToKeyToUrlsAllMap?keys as type>

/** ${type} */
    <#list ftlVo.keyToKeyToUrlsAllMap[type]?keys as key>
/** ${ftlVo.keyToKeyToUrlsAllMap[type][key].comment} */
var ${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey} = BASE_URL + '/${ftlVo.keyToKeyToUrlsAllMap[type][key].url}';
    </#list>
</#list>


var vue = new Vue({
    el: "#body",
    data: {
        alertError: "系统错误，请联系管理员！",
        alertSuccess: "操作成功",

        BASE_URL:BASE_URL,

        host:host,
<#--存储多个结果-->
<#list ftlVo.keyToKeyToUrlsAllMap?keys as type>
        /** 存储${type}多个结果*/
        ${type}Results:[{
    <#list ftlVo.keyToVoJavaFields[type] as javaField>
           ${javaField.name}: null<#if javaField_has_next>,</#if>
    </#list>
        }]
        ,
<#--处理的是单个查询结果-->
        /** 存储${type}单个结果*/
        ${type}Result:{
    <#list ftlVo.keyToVoJavaFields[type] as javaField>
          ${javaField.name}: null<#if javaField_has_next>,</#if>
    </#list>
        }
        ,
<#--处理的是插入查询结果-->
        /** 存储${type}插入结果*/
        ${type}InsertParam:{
    <#list ftlVo.keyToVoJavaFields[type] as javaField>
          ${javaField.name}: null<#if javaField_has_next>,</#if>
    </#list>
        }
        ,
<#--处理的是主键更新-->
       /** 存储${type}主键更新*/
       ${type}UpdateByPrimaryKeyParam:{
         source:{
    <#list ftlVo.keyToVoJavaFields[type] as javaField>
        <#if javaField.isPRI=false>
            ${javaField.name}: null<#if javaField_has_next>,</#if>
        </#if>
    </#list>
         }
         ,
         target:{
    <#list ftlVo.keyToVoJavaFields[type] as javaField>
        <#if javaField.isPRI=true>
            ${javaField.name}: null<#if javaField_has_next>,</#if>
        </#if>
    </#list>
         }
       }
       ,
<#--处理的更新-->
       /** 存储${type}更新*/
       ${type}UpdateBaseParam:{
         source:{
       <#list ftlVo.keyToVoJavaFields[type] as javaField>
           ${javaField.name}: null<#if javaField_has_next>,</#if>
       </#list>
         }
         ,
         target:{
    <#list ftlVo.keyToVoJavaFields[type] as javaField>
          ${javaField.name}: null<#if javaField_has_next>,</#if>
    </#list>
         }
       }
       ,
<#--存储多条件查询条件-->
       /** 存储${type}多条件查询条件*/
       ${type}QueryBaseParam:{
    <#list ftlVo.keyToVoJavaFields[type] as javaField>
          ${javaField.name}: null<#if javaField_has_next>,</#if>
    </#list>
       }
       ,
<#--存储多条件查询条件(分页，去除分页的num和size)-->
       /** 存储${type}多条件查询条件(分页，去除分页的num和size)*/
       ${type}QueryBasePageHelperParam:{
    <#list ftlVo.keyToVoJavaFields[type] as javaField>
          ${javaField.name}: null<#if javaField_has_next>,</#if>
    </#list>
       }
       ,
<#--存储多条件查询结果(分页，包含分页的所有数据)-->
       /** 存储${type}存储多条件查询结果(分页，去除分页的num和size)*/
       ${type}QueryBasePageHelperResult:{
          pageNum: null,
          pageSize: null,
          size: null,
          orderBy: null,
          startRow: null,
          endRow: null,
          total: null,
          pages: null,
          list: [{
    <#list ftlVo.keyToVoJavaFields[type] as javaField>
            ${javaField.name}: null<#if javaField_has_next>,</#if>
    </#list>
          }],
          firstPage: null,
          prePage: 0,
          nextPage: null,
          lastPage: null,
          isFirstPage: true,
          isLastPage: null,
          hasPreviousPage: null,
          hasNextPage: null,
          navigatePages: null,
          navigatepageNums: []
        }
    <#if type_has_next>,</#if>
</#list>
    },
    created() {
     /** 初始化 */
<#--<#list ftlVo.keyToKeyToUrlsAllMap?keys as type>-->
    <#--<#list ftlVo.keyToKeyToUrlsAllMap[type]?keys as key>-->
        <#--<#if (key=="queryBase")>-->
            <#--/*主键查询${type}*/-->
            <#--this.${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}();-->
        <#--</#if>-->
    <#--</#list>-->
<#--</#list>-->
    },
    methods: {
            /** 处理queryByPrimaryKey */
<#list ftlVo.keyToKeyToUrlsAllMap?keys as type>
    <#list ftlVo.keyToKeyToUrlsAllMap[type]?keys as key>
        <#if (key=="queryByPrimaryKey")>

            /** 主键查询${type} */
            ${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}(<#list ftlVo.keyToVoPrimaryKeyJavaFields[type] as javaField>${javaField.name}<#if javaField_has_next>,</#if></#list>) {
              let self = this;
              axios.get(${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}, {
                  params: {
            <#list ftlVo.keyToVoPrimaryKeyJavaFields[type] as javaField>
                ${javaField.name}:${javaField.name}<#if javaField_has_next>,</#if>
            </#list>
                  }
              }).then(function (response) {
                   let data = response.data;
                    console.log(data);
                    if (data.code == 0) {
                        self.${type}Result = data.content;
                        console.log(self.${type}Result);
                    } else {
                        alert(data.msg);
                    }
              }).catch(
                    function (response) {
                    //失败回调
                     alert(self.alertError);
              })
            },
        </#if>
        <#if (key=="deleteByPrimaryKey")>

            /** 主键删除${type} */
            ${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}(<#list ftlVo.keyToVoPrimaryKeyJavaFields[type] as javaField>${javaField.name}<#if javaField_has_next>,</#if></#list>) {
              let self = this;
              axios.post(${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey},  {
                  params: {
            <#list ftlVo.keyToVoPrimaryKeyJavaFields[type] as javaField>
                ${javaField.name}:${javaField.name}<#if javaField_has_next>,</#if>
            </#list>
                  }
             }).then(function (response) {
                   let data = response.data;
                    console.log(data);
                    if (data.code == 0) {
                         if(data.content == true)
                         alert("delete 成功");
                    } else {
                         alert(data.msg);
                    }
              }).catch(
              function (response) {
                  //失败回调
                  alert(self.alertError);
              })},
        </#if>
        <#if (key=="updateByPrimaryKey")>

            /** 主键更新${type} */
            ${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}() {
              let self = this;
              axios.post(${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}, self.${type}UpdateByPrimaryKeyParam)
              .then(function (response) {
                   let data = response.data;
                    console.log(data);
                    if (data.code == 0) {
                         if(data.content == true)
                         alert("delete 成功");
                    } else {
                         alert(data.msg);
                    }
              }).catch(
              function (response) {
                  //失败回调
                  alert(self.alertError);
              })},
        </#if>
        <#if (key=="insert")>

            /** 插入${type} */
            ${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}() {
              let self = this;
              axios.post(${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}, self.${type}InsertParam)
              .then(function (response) {
                   let data = response.data;
                    console.log(data);
                    if (data.code == 0) {
                         if(data.content == true)
                         alert("insert 成功");
                    } else {
                         alert(data.msg);
                    }
              }).catch(
              function (response) {
                  //失败回调
                  alert(self.alertError);
              })},
        </#if>
        <#if (key=="queryBase")>

            /** 多条件查询${type} */
            ${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}() {
              let self = this;
              axios.post(${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}, self.${type}QueryBaseParam)
              .then(function (response) {
                   let data = response.data;
                    console.log(data);
                    if (data.code == 0) {
                        self.${type}Results = data.content;
                        console.log(self.${type}Results);
                    } else {
                        alert(data.msg);
                    }
              }).catch(
              function (response) {
                  //失败回调
                  alert(self.alertError);
              })
            },
        </#if>
        <#if (key=="updateBase")>

            /** 多条件更新${type} */
            ${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}() {
              let self = this;
              axios.post(${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}, self.${type}UpdateBaseParam)
              .then(function (response) {
                   let data = response.data;
                    console.log(data);
                    if (data.code == 0) {
                         if(data.content == true)
                         alert("delete 成功");
                    } else {
                         alert(data.msg);
                    }
              }).catch(
              function (response) {
                  //失败回调
                  alert(self.alertError);
              })
           },
        </#if>
        <#if (key=="queryBasePageHelper")>

            /** 分页查询${type} -- 存放的是默认的data */
            ${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}(pageNum,pageSize) {
              let self = this;
              axios.post(${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}+"?pageNum="+pageNum+"&pageSize="+pageSize, self.${type}QueryBasePageHelperParam)
              .then(function (response) {
                   let data = response.data;
                    console.log(data);
                    if (data.code == 0) {
                        self.${type}QueryBasePageHelperResult = data.content;
                        console.log(self.${type}QueryBasePageHelperResult);
                    } else {
                        alert(data.msg);
                    }
              }).catch(
              function (response) {
                  //失败回调
                  alert(self.alertError);
              })
            },

           /** 分页查询${type}  --  存放的是指定的data.sub */
            ${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}Sub(pageNum,pageSize,sub) {
              let self = this;
              axios.post(${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}+"?pageNum="+pageNum+"&pageSize="+pageSize, self.${type}QueryBasePageHelperParam)
              .then(function (response) {
                   let data = response.data;
                    console.log(data);
                    if (data.code == 0) {
                        self.$set(self.${type}QueryBasePageHelperResult,sub,data.content);
                        console.log(self.${type}QueryBasePageHelperResult);
                    } else {
                        alert(data.msg);
                    }
              }).catch(
              function (response) {
                  //失败回调
                  alert(self.alertError);
              })
            },
        </#if>

    </#list>
</#list>

    }
});