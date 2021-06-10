<template>
  <div class="app-form mt20 ml40">
    <h5 class="form-tit">注册配置编辑</h5>
    <section>
      <el-form :model="postForm" :rules="rules" ref="postForm" label-width="180px" size="mini" :inline-message="true">
        <div class="mt30 ml15">
          <#list ftlVo.javaFields as javaField>
            <el-form-item label="${javaField.name}：">
                <el-input v-model="postForm.${javaField.name}" maxlength="100"></el-input>
            </el-form-item>
          </#list>
        </div>
      </el-form>
    </section>
    <div class="mt40 ml40">
      <el-button type="primary" @click="submitAddForm('postForm')">确定添加</el-button>
      <el-button type="primary" class="el-button-search" @click="routerToList()">返回列表</el-button>
    </div>
  </div>

</template>
<script>
  export default {
      name: 'moduleDetail',
      props: {
          isEdit: {
              type: Boolean,
              default: false
          }
      },
      data() {
          return {
              postForm: {
          <#list ftlVo.javaFields as javaField>
              ${javaField.name}: ''<#if javaField_has_next>,</#if>
          </#list>
      }
      }
          ;
      },
      created() {

      },
      watch: {},
      methods: {
          submitAddForm(formName) {
              let self = this;
              let params = new FormData();

             <#list ftlVo.javaFields as javaField>
              params.append('${javaField.name}', self.postForm.${javaField.name});
             </#list>
              /**
               * 转json
               */
              var paramsJson = {};
              params.forEach((value, key) => paramsJson[key] = value);

              self.$http.post(self.api.${allVueFtl.apiJsFtl.keyToKeyToUrls["insert"].vueKey}, paramsJson, {
                  headers: {
                      "Content-Type": "application/json"
                  },
              }, function (response) {
                  if (response.code == 0) {
                      if (response.content == true) {
                          self.$message({
                              type: 'success',
                              message: '添加成功，页面即将跳转至列表页',
                              duration: 500,
                              onClose: function () {
                                  self.$router.push({
                                      path: '/${allVueFtl.apiJsFtl.listModulePath}'
                                  })
                              }
                          });

                      } else {
                          self.$message({
                              type: 'warning',
                              message: '添加失败',
                              duration: 2000
                          });
                      }
                  }else {
                      self.$message({
                          type: 'error',
                          message: response.msg,
                          duration: 2000
                      });
                  }
              }, function (response) {
                  //失败回调
              })
          },
          routerToList() {
              //跳转回List
              window.open("#/${allVueFtl.apiJsFtl.listModulePath}", '_self');
          }
      }
  }
</script>
<style rel="stylesheet/scss" lang="scss">

</style>
