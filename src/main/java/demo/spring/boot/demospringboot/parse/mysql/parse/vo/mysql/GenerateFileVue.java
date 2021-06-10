package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.*;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.*;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin.ChildModuleEnum;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin.InterfaceEnum;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin.KeyToUrlVo;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin.Module;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@Slf4j(topic = "生成vue文件")
public class GenerateFileVue {


    /**
     * 根据数据库名称+表名称+包名称 -> 生成vue -> 这里可能会借用Java生成的代码
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public static AllVueFtl GenerateFile(AllJavaFtl allJavaFtl, List<AllJavaFtl> allJavaFtls) throws SQLException, ClassNotFoundException, IOException, TemplateException {


        AllVueFtl allVueFtl = new AllVueFtl();
        allVueFtl.setAllJavaFtl(allJavaFtl);//设置javaFtl
        allVueFtl.setAllJavaFtls(allJavaFtls);//存放所有的javaFtls

        String controllerName = allJavaFtl.getControllerFtl().getClassName();
        String moduleName = controllerName.substring(0, controllerName.lastIndexOf("Controller")) + "Module";//移除最后的 Controller -> TUser

        ApiJsFtl apiJsFtl = GenerateFileVue.getApiJsFtl(allVueFtl, moduleName);//API的参数
        allVueFtl.setApiJsFtl(apiJsFtl);

        ViewVueFtl viewVueFtl = GenerateFileVue.getViewVueFtl(allVueFtl, moduleName);//View界面
        allVueFtl.setViewVueFtl(viewVueFtl);

        EditVueFtl editVueFtl = GenerateFileVue.getEditVueFtl(allVueFtl, moduleName);//Edit界面
        allVueFtl.setEditVueFtl(editVueFtl);

        ListVueFtl listVueFtl = GenerateFileVue.getListVueFtl(allVueFtl, moduleName);//List界面
        allVueFtl.setListVueFtl(listVueFtl);

        IndexJsFtl indexJsFtl = GenerateFileVue.getIndexJsFtl(allVueFtl);//Index.js界面
        allVueFtl.setIndexJsFtl(indexJsFtl);

        AddVueFtl addVueFtl = GenerateFileVue.getAddVueFtl(allVueFtl, moduleName);//Add界面
        allVueFtl.setAddVueFtl(addVueFtl);

        return allVueFtl;

    }


    /**
     * 获取ApiJs的操作
     */
    private static ApiJsFtl getApiJsFtl(AllVueFtl allVueFtl, String moduleName) throws IOException, TemplateException {

        ApiJsFtl apiJsFtl = new GenerateVueUtil<ApiJsFtl>() {
            @Override
            public ApiJsFtl getFtlVo() {
                ApiJsFtl vo = new ApiJsFtl();
                List<String> apis = Arrays.asList("insert", "inserts", "queryBase", "updateBase", "updateBaseIncludeNull",
                        "deleteBase", "queryByPrimaryKey", "deleteByPrimaryKey");
                vo.setApis(apis);
                /**
                 * 处理接口 -> 这里需要处理所有的vo-> controller
                 */
                /**
                 * 处理接口 -> 这里需要处理所有的vo-> controller
                 */
                Map<String, Map<String, KeyToUrlVo>> keyToKeyToUrlsAllMap = new HashMap<>();
                allVueFtl.getAllJavaFtls().forEach(allJavaFtl -> {
                    String controllerName = allJavaFtl.getControllerFtl().getClassName(); // -> TUserController
                    String baseName = controllerName.substring(0, controllerName.lastIndexOf("Controller"));//移除最后的 Controller -> TUser
                    Map<String, KeyToUrlVo> keyToKeyToUrls = new HashMap<>();
                    Arrays.stream(InterfaceEnum.values()).forEach(interfaceEnum -> {
                        KeyToUrlVo keyToUrlVo = new KeyToUrlVo();
                        keyToUrlVo.setComment(interfaceEnum.getComment() + baseName);
                        keyToUrlVo.setVueKey(interfaceEnum.getPrefix() + baseName + interfaceEnum.getSuffix());
                        keyToUrlVo.setUrl(controllerName + "/" + interfaceEnum.getKey());
                        keyToKeyToUrls.put(interfaceEnum.getKey(), keyToUrlVo);
                    });
                    keyToKeyToUrlsAllMap.put(baseName, keyToKeyToUrls);//放入map中 -> 这里的数据全部是给api.js.ftl 使用的，下面的是给各个使用的
                });
                vo.setKeyToKeyToUrlsAllMap(keyToKeyToUrlsAllMap);

                String controllerName = allVueFtl.getAllJavaFtl().getControllerFtl().getClassName(); // -> TUserController
                String baseName = controllerName.substring(0, controllerName.lastIndexOf("Controller"));//移除最后的 Controller -> TUser
                Map<String, KeyToUrlVo> keyToKeyToUrls = new HashMap<>();
                Arrays.stream(InterfaceEnum.values()).forEach(interfaceEnum -> {
                    KeyToUrlVo keyToUrlVo = new KeyToUrlVo();
                    keyToUrlVo.setComment(interfaceEnum.getComment() + baseName);
                    keyToUrlVo.setVueKey(interfaceEnum.getPrefix() + baseName + interfaceEnum.getSuffix());
                    keyToUrlVo.setUrl(controllerName + "/" + interfaceEnum.getKey());
                    keyToKeyToUrls.put(interfaceEnum.getKey(), keyToUrlVo);
                });
                vo.setKeyToKeyToUrls(keyToKeyToUrls);
                vo.setBaseName(baseName);
                vo.setDirPath("demoWeb/src/utils");

                /**
                 * 用作跳转的统一
                 */
                vo.setEditModulePath(moduleName + "Edit");
                vo.setViewModulePath(moduleName + "View");
                vo.setListModulePath(moduleName + "List");
                vo.setAddModulePath(moduleName + "Add");
                return vo;
            }

            @Override
            public AllVueFtl getAllVueFtl() {
                return allVueFtl;
            }
        }.grenerate();

        return apiJsFtl;
    }

    /**
     * 获取ApiJs的操作
     */
    private static ListVueFtl getListVueFtl(AllVueFtl allVueFtl, String moduleDirName) throws IOException, TemplateException {

        ListVueFtl ftl = new GenerateVueUtil<ListVueFtl>() {
            @Override
            public ListVueFtl getFtlVo() {
                ListVueFtl vo = new ListVueFtl();
                vo.setDirPath("demoWeb/src/views" + "/" + moduleDirName);
                vo.setFileName("List.Vue");
                vo.setModulePath(moduleDirName + "List");
                return vo;
            }

            @Override
            public AllVueFtl getAllVueFtl() {
                return allVueFtl;
            }
        }.grenerate();

        return ftl;
    }

    /**
     * 获取ftl的操作
     */
    private static ViewVueFtl getViewVueFtl(AllVueFtl allVueFtl, String moduleDirName) throws IOException, TemplateException {

        ViewVueFtl ftl = new GenerateVueUtil<ViewVueFtl>() {
            @Override
            public ViewVueFtl getFtlVo() {
                ViewVueFtl vo = new ViewVueFtl();
                vo.setDirPath("demoWeb/src/views" + "/" + moduleDirName);
                vo.setFileName("View.Vue");
                vo.setFreeMarkFtlPath("View.vue.ftl");
                vo.setModulePath(moduleDirName + "View");
                vo.setJavaFields(allVueFtl.getAllJavaFtl().getVoFtl().getJavaFields());
                vo.setPrimaryKeyJavaFields(allVueFtl.getAllJavaFtl().getVoFtl().getPrimaryKeyJavaFields());
                return vo;
            }

            @Override
            public AllVueFtl getAllVueFtl() {
                return allVueFtl;
            }
        }.grenerate();

        return ftl;
    }

    /**
     * 获取ftl的操作
     */
    private static EditVueFtl getEditVueFtl(AllVueFtl allVueFtl, String moduleDirName) throws IOException, TemplateException {

        EditVueFtl ftl = new GenerateVueUtil<EditVueFtl>() {
            @Override
            public EditVueFtl getFtlVo() {
                EditVueFtl vo = new EditVueFtl();
                vo.setDirPath("demoWeb/src/views" + "/" + moduleDirName);
                vo.setFileName("Edit.Vue");
                vo.setFreeMarkFtlPath("Edit.vue.ftl");
                vo.setModulePath(moduleDirName + "Edit");
                vo.setJavaFields(allVueFtl.getAllJavaFtl().getVoFtl().getJavaFields());
                vo.setPrimaryKeyJavaFields(allVueFtl.getAllJavaFtl().getVoFtl().getPrimaryKeyJavaFields());
                return vo;
            }

            @Override
            public AllVueFtl getAllVueFtl() {
                return allVueFtl;
            }
        }.grenerate();

        return ftl;
    }

    /**
     * 获取ftl的操作
     */
    private static IndexJsFtl getIndexJsFtl(AllVueFtl allVueFtl) throws IOException, TemplateException {

        IndexJsFtl ftl = new GenerateVueUtil<IndexJsFtl>() {
            @Override
            public IndexJsFtl getFtlVo() {
                IndexJsFtl vo = new IndexJsFtl();
                vo.setDirPath("demoWeb/src/router");
                vo.setFileName("index.js");
                /**
                 * modules -> 这里注意是全部的对象的modules
                 */
                List<Module> modules = new ArrayList<>();

                allVueFtl.getAllJavaFtls().forEach(allJavaFtl -> {
                    //
                    String controllerName = allJavaFtl.getControllerFtl().getClassName();
                    String moduleName = controllerName.substring(0, controllerName.lastIndexOf("Controller")) + "Module";//移除最后的 Controller -> TUser
                    Arrays.stream(ChildModuleEnum.values()).forEach(childModuleEnum -> {
                        Module moduleVo = new Module();
                        moduleVo.setBaseModule(moduleName);
                        moduleVo.setComponent(moduleName + childModuleEnum.getChildModuleNameSuffix());
                        moduleVo.setPath(moduleName + childModuleEnum.getRealPathSuffix());
                        moduleVo.setRealPath("@/views/" + moduleName + "/" + childModuleEnum.getRealPathSuffix());
                        moduleVo.setMetaTitle(moduleName + childModuleEnum.getMetaTitleSuffix());
                        moduleVo.setHidden(childModuleEnum.getIsHidden());
                        modules.add(moduleVo);
                    });

                });
                vo.setModules(modules);
                return vo;
            }

            @Override
            public AllVueFtl getAllVueFtl() {
                return allVueFtl;
            }
        }.grenerate();

        return ftl;
    }

    /**
     * 获取ftl的操作
     */
    private static AddVueFtl getAddVueFtl(AllVueFtl allVueFtl, String moduleDirName) throws IOException, TemplateException {

        AddVueFtl ftl = new GenerateVueUtil<AddVueFtl>() {
            @Override
            public AddVueFtl getFtlVo() {
                AddVueFtl vo = new AddVueFtl();
                vo.setDirPath("demoWeb/src/views" + "/" + moduleDirName);
                vo.setFileName("Add.Vue");
                vo.setModulePath(moduleDirName + "Edit");
                vo.setJavaFields(allVueFtl.getAllJavaFtl().getVoFtl().getJavaFields());
                vo.setPrimaryKeyJavaFields(allVueFtl.getAllJavaFtl().getVoFtl().getPrimaryKeyJavaFields());
                return vo;
            }

            @Override
            public AllVueFtl getAllVueFtl() {
                return allVueFtl;
            }
        }.grenerate();

        return ftl;
    }


}
