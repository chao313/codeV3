<template>
  <div class="app-form mt20 ml40">
    <h5 class="form-tit">查看</h5>
    <section>
      <el-form :model="postForm" :rules="rules" ref="postForm" label-width="180px" size="mini" :inline-message="true">
        <div class="mt30 ml15">
          <#list ftlVo.javaFields as javaField>
          <el-form-item label="${javaField.name}：">
              <el-input v-model="postForm.${javaField.name}" maxlength="100" :disabled=true></el-input>
          </el-form-item>
          </#list>
        </div>
      </el-form>
    </section>
    <div class="mt40 ml40">
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
      };
    },
    created() {
      let self = this;
      /**
       * 1.接收外界参数
       */
      <#list ftlVo.primaryKeyJavaFields as javaField>
        const ${javaField.name} = this.$route.query && this.$route.query.${javaField.name}<#if javaField_has_next>;</#if>
      </#list>
      self.queryByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as javaField>${javaField.name}<#if javaField_has_next>,</#if></#list>)
    },
    watch: {},
    methods: {
       //获取具体的配置
        queryByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as javaField>${javaField.name}<#if javaField_has_next>,</#if></#list>) {
        let self = this;
        self.$http.get(self.api.${allVueFtl.apiJsFtl.keyToKeyToUrls["queryByPrimaryKey"].vueKey}, {
          params: {
            <#list ftlVo.primaryKeyJavaFields as javaField>
              ${javaField.name}:${javaField.name}<#if javaField_has_next>,</#if>
            </#list>
          }
        },function (response) {
                if (response.code == 0) {
                    self.postForm = response.content;
                    self.$message({
                        type: 'success',
                        message: '查询成功',
                        duration: 2000
                    });
                } else {
                    self.$message({
                        type: 'error',
                        message: response.msg,
                        duration: 2000
                    });
                }
        }, function (response) {
           //失败回调
           self.$message({
               type: 'warning',
               message: '请求异常',
               duration: 1000
           });
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
