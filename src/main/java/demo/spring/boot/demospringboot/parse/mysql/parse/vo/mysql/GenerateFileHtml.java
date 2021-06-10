package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.html.AllHtmlFtl;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.html.DataJsFtl;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.AllJavaFtl;
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

@Slf4j(topic = "生成html文件")
public class GenerateFileHtml {


    /**
     * 根据数据库名称+表名称+包名称 -> 生成vue -> 这里可能会借用Java生成的代码
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public static AllHtmlFtl GenerateFile(List<AllVueFtl> allVueFtls) throws SQLException, ClassNotFoundException, IOException, TemplateException {


        AllHtmlFtl allHtmlFtl = new AllHtmlFtl();
        allHtmlFtl.setAllVueFtls(allVueFtls);//存放前端的生成结果

        DataJsFtl dataJsFtl = null;
        if (allVueFtls.size() > 0) {
            Map<String, Map<String, KeyToUrlVo>> keyToKeyToUrlsAllMap = allVueFtls.get(0).getApiJsFtl().getKeyToKeyToUrlsAllMap();
            dataJsFtl = GenerateFileHtml.getDataJsFtl(allHtmlFtl, keyToKeyToUrlsAllMap);
        }

        allHtmlFtl.setDataJsFtl(dataJsFtl);
        return allHtmlFtl;

    }


    /**
     * 获取ApiJs的操作
     */
    private static DataJsFtl getDataJsFtl(AllHtmlFtl allHtmlFtl, Map<String, Map<String, KeyToUrlVo>> keyToKeyToUrlsAllMap) throws IOException, TemplateException {

        DataJsFtl apiJsFtl = new GenerateHtmlUtil<DataJsFtl>() {
            @Override
            public DataJsFtl getFtlVo() {
                DataJsFtl vo = new DataJsFtl();
                vo.setKeyToKeyToUrlsAllMap(keyToKeyToUrlsAllMap);//vue中的产生的结果
                /**
                 * 转化和key和具体的实体对应
                 */
                Map<String, List<JavaField>> keyToVoJavaFields = new HashMap<>();
                Map<String, List<JavaField>> keyToVoPrimaryKeyJavaFields = new HashMap<>();
                allHtmlFtl.getAllVueFtls().forEach(allVueFtl -> {
                    allVueFtl.getAllJavaFtls().forEach(allJavaFtl -> {
                        String type = allJavaFtl.getVoFtl().getClassName().substring(0, allJavaFtl.getVoFtl().getClassName().lastIndexOf("Vo"));
                        keyToVoJavaFields.put(type, allJavaFtl.getVoFtl().getJavaFields());
                        keyToVoPrimaryKeyJavaFields.put(type, allJavaFtl.getVoFtl().getPrimaryKeyJavaFields());
                    });
                });

                vo.setDirPath("demoHtml/vueJs/");//data的位置
                vo.setKeyToVoJavaFields(keyToVoJavaFields);
                vo.setKeyToVoPrimaryKeyJavaFields(keyToVoPrimaryKeyJavaFields);

                return vo;
            }

            @Override
            public AllHtmlFtl getAllHtmlFtl() {
                return allHtmlFtl;
            }
        }.grenerate();

        return apiJsFtl;
    }


}
