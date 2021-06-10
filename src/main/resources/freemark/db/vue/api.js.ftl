/* 设置后台项目名称 */
const BASE_URL = '/${ftlVo.BASE_URL}';
export default {

    /** Session操作 */
    "login": BASE_URL + '/SessionController/login',
    "adminLogin": BASE_URL + '/SessionController/admin/login',
    /* 登出 */
    "loginOut": BASE_URL + '/SessionController/loginOut',
    /* 获取用户的id */
    "getUserId": BASE_URL + '/SessionController/getUserId',
    /* 获取用户的Name */
    "getUserName": BASE_URL + '/SessionController/getUserName',


    /*后台的URL*/
    /** 资源管理 */

    "addResourceFile": BASE_URL + '/ResourceController/addFile',
    "existResourceFileByName": BASE_URL + '/ResourceController/existFileByName',
    "deleteResourceFileByName": BASE_URL + '/ResourceController/deleteFileByName',
    "getResourceFiles": BASE_URL + '/ResourceController/getFiles',
    "getResourceFileDetails": BASE_URL + '/ResourceController/getFileDetails',
    "getResourceFileDetailByFileName": BASE_URL + '/ResourceController/getFileDetailByFileName',
    "downloadByResourceFileName": BASE_URL + '/ResourceController/downloadByFileName',
    "preByResourceFileName": BASE_URL + '/ResourceController/preByFileName',

<#list ftlVo.keyToKeyToUrlsAllMap?keys as type>

      /* ${type} */
   <#list ftlVo.keyToKeyToUrlsAllMap[type]?keys as key>
      /* ${ftlVo.keyToKeyToUrlsAllMap[type][key].comment} */
      "${ftlVo.keyToKeyToUrlsAllMap[type][key].vueKey}": BASE_URL + '/${ftlVo.keyToKeyToUrlsAllMap[type][key].url}'<#if key_has_next>,</#if>
      </#list><#if type_has_next>,</#if>
</#list>


}
