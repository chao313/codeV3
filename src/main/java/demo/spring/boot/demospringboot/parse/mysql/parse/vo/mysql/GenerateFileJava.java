package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql;

import demo.spring.boot.demospringboot.parse.mysql.parse.db.DBInfo;
import demo.spring.boot.demospringboot.util.CamelUtils;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.MysqlTable;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.*;
import demo.spring.boot.demospringboot.util.TypeMap;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j(topic = "生成java文件")
public class GenerateFileJava {


    /**
     * 根据数据库名称+表名称+包名称 -> 生成code
     * -> 这里是静态方法，目前的链接是硬编码，需要升级
     * 1.获取指定表的所有信息
     * 2.获取指定表的所有字段信息
     * 3.提取出主键字段
     * 4.补全vo类包名,类名，文件名
     * 5.补全dao类包名,类名，文件名
     * 6.补全service类包名,类名，文件名
     * 7.补全serviceImpl类包名,类名，文件名
     * 8.补全Controller类包名,类名，文件名
     * 9.补全Mapper类包名,类名，文件名
     *
     * @param dataBase
     * @param ptableName
     * @param basePackage
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public static AllJavaFtl GenerateFile(String dataBase, String ptableName, String basePackage) throws SQLException, ClassNotFoundException, IOException, TemplateException {
        DBInfo dbInfo = new DBInfo();
        /**
         * 返回这个表的所有相关信息:表名称,表类型,引擎,表的字符集,表的注释<br>
         */
        MysqlTable mysqlTable = dbInfo.obtainTableInfo(dataBase, ptableName);
        /**
         * 获取字段的信息：字段名称,字段类型,字段注释,字段是否允许为null,字段是否为主键
         */
        List<MysqlField> mysqlFields = dbInfo.obtainFieldsInfo(dataBase, ptableName);

        /**
         * 1.转换名称为驼峰
         * 2.转换mysql类型为java类型
         */
        List<JavaField> javaFields = new ArrayList<>();
        mysqlFields.forEach(mysqlField -> {
            JavaField javaField = new JavaField();
            javaField.setComment(mysqlField.getComment());
            javaField.setName(CamelUtils.toLowerCaseFirstOne(CamelUtils.underline2Camel(mysqlField.getName())));
            javaField.setType(TypeMap.getTypeMap().get(mysqlField.getType()));
            javaField.setDbType(mysqlField.getType());
            javaField.setIsNotNull(mysqlField.getIsNotNull());
            javaField.setIsPRI(mysqlField.getIsPRI());
            javaFields.add(javaField);
        });
        /**
         * 把主键字段中从全部字段中筛选出来
         */
        List<MysqlField> primaryKeyMysqlFields = MysqlTable.getPRIFromFields(mysqlFields);
        List<JavaField> primaryKeyJavaFields = new ArrayList<>();
        /**
         * 1.转换名称为驼峰
         * 2.转换mysql类型为java类型
         */
        primaryKeyMysqlFields.forEach(primaryKeyMysqlField -> {
            JavaField javaField = new JavaField();
            javaField.setComment(primaryKeyMysqlField.getComment());
            javaField.setName(CamelUtils.toLowerCaseFirstOne(CamelUtils.underline2Camel(primaryKeyMysqlField.getName())));
            javaField.setType(TypeMap.getTypeMap().get(primaryKeyMysqlField.getType()));
            javaField.setDbType(primaryKeyMysqlField.getType());
            javaField.setIsNotNull(primaryKeyMysqlField.getIsNotNull());
            javaField.setIsPRI(primaryKeyMysqlField.getIsPRI());
            primaryKeyJavaFields.add(javaField);
        });

        Set<String> javaFieldTypes = new HashSet<>();
        /**
         * 提取所有的type
         */
        javaFields.forEach(javaField -> {
            javaFieldTypes.add(javaField.getType());
        });

        Table table = new Table();
        BeanUtils.copyProperties(mysqlTable, table);


        /**
         * className的前缀(驼峰命名)
         */
        String classNamePrefix = CamelUtils.toUpperCaseFirstOne(CamelUtils.underline2Camel(table.getTableName()));

        AllJavaFtl allJavaFtl = new AllJavaFtl();
        VoFtl voFtl = GenerateFileJava.getVoFtl(table, basePackage, classNamePrefix, mysqlFields, primaryKeyMysqlFields, javaFields, primaryKeyJavaFields, javaFieldTypes);
        allJavaFtl.setVoFtl(voFtl);
        MultiTermVoFtl multiTermVoFtl = GenerateFileJava.getMultiTermVoFtl(table, basePackage, classNamePrefix, mysqlFields, primaryKeyMysqlFields, javaFields, primaryKeyJavaFields, javaFieldTypes);
        allJavaFtl.setMultiTermVoFtl(multiTermVoFtl);
        VoPriFtl voPriFtl = GenerateFileJava.getVoPriFtl(table, basePackage, classNamePrefix, javaFields, javaFieldTypes);
        allJavaFtl.setVoPriFtl(voPriFtl);
        VoNoPriFtl voNoPriFtl = GenerateFileJava.getVoNoPriFtl(table, basePackage, classNamePrefix, javaFields, javaFieldTypes);
        allJavaFtl.setVoNoPriFtl(voNoPriFtl);
        RequestUpdateBaseFtl requestUpdateBaseFtl = GenerateFileJava.getRequestUpdateBaseFtl(table, basePackage, classNamePrefix, allJavaFtl);
        allJavaFtl.setRequestUpdateBaseFtl(requestUpdateBaseFtl);
        RequestUpdatePrimaryKeyFtl requestUpdatePrimaryKeyFtl = GenerateFileJava.getRequestUpdatePrimaryKeyFtl(table, basePackage, classNamePrefix, allJavaFtl);
        allJavaFtl.setRequestUpdatePrimaryKeyFtl(requestUpdatePrimaryKeyFtl);

        DAOFtl daoFtl = GenerateFileJava.getDAOFtl(table, basePackage, classNamePrefix, mysqlFields, primaryKeyMysqlFields, javaFields, primaryKeyJavaFields, javaFieldTypes, allJavaFtl);
        allJavaFtl.setDaoFtl(daoFtl);
        ServiceFtl serviceFtl = GenerateFileJava.getServiceFtl(table, basePackage, classNamePrefix, mysqlFields, primaryKeyMysqlFields, javaFields, primaryKeyJavaFields, javaFieldTypes, allJavaFtl);
        allJavaFtl.setServiceFtl(serviceFtl);
        ServiceImplFtl serviceImplFtl = GenerateFileJava.getServiceImplFtl(table, basePackage, classNamePrefix, mysqlFields, primaryKeyMysqlFields, javaFields, primaryKeyJavaFields, javaFieldTypes, allJavaFtl);
        allJavaFtl.setServiceImplFtl(serviceImplFtl);
        MapperFtl mapperFtl = GenerateFileJava.getMapperFtl(table, basePackage, classNamePrefix, mysqlFields, primaryKeyMysqlFields, javaFields, primaryKeyJavaFields, javaFieldTypes, allJavaFtl);
        allJavaFtl.setMapperFtl(mapperFtl);
        ControllerFtl controllerFtl = GenerateFileJava.getControllerFtl(table, basePackage, classNamePrefix, mysqlFields, primaryKeyMysqlFields, javaFields, primaryKeyJavaFields, javaFieldTypes, allJavaFtl);
        allJavaFtl.setControllerFtl(controllerFtl);
        return allJavaFtl;

    }

    /**
     * @param table
     * @param basePackage
     * @param classNamePrefix
     * @param mysqlFields
     * @param primaryKeyMysqlFields
     * @param javaFields
     * @param primaryKeyJavaFields
     * @param javaFieldTypes
     * @return
     */
    private static VoFtl getVoFtl(Table table,
                                  String basePackage,
                                  String classNamePrefix,
                                  List<MysqlField> mysqlFields,
                                  List<MysqlField> primaryKeyMysqlFields,
                                  List<JavaField> javaFields,
                                  List<JavaField> primaryKeyJavaFields,
                                  Set<String> javaFieldTypes
    ) throws IOException, TemplateException {
        VoFtl voFtl = new GenerateJavaUtil<VoFtl>() {
            @Override
            public VoFtl getFtlVo() {
                VoFtl vo = new VoFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "Vo");
                vo.setMysqlFields(mysqlFields);
                vo.setPrimaryKeyMysqlFields(primaryKeyMysqlFields);
                vo.setJavaFields(javaFields);
                vo.setPrimaryKeyJavaFields(primaryKeyJavaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return null;
            }
        }.grenerate();

        return voFtl;
    }
    /**
     * @param table
     * @param basePackage
     * @param classNamePrefix
     * @param mysqlFields
     * @param primaryKeyMysqlFields
     * @param javaFields
     * @param primaryKeyJavaFields
     * @param javaFieldTypes
     * @return
     */
    private static MultiTermVoFtl getMultiTermVoFtl(Table table,
                                  String basePackage,
                                  String classNamePrefix,
                                  List<MysqlField> mysqlFields,
                                  List<MysqlField> primaryKeyMysqlFields,
                                  List<JavaField> javaFields,
                                  List<JavaField> primaryKeyJavaFields,
                                  Set<String> javaFieldTypes
    ) throws IOException, TemplateException {
        MultiTermVoFtl voFtl = new GenerateJavaUtil<MultiTermVoFtl>() {
            @Override
            public MultiTermVoFtl getFtlVo() {
                MultiTermVoFtl vo = new MultiTermVoFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "MultiTermVo");
                vo.setMysqlFields(mysqlFields);
                vo.setPrimaryKeyMysqlFields(primaryKeyMysqlFields);
                vo.setJavaFields(javaFields);
                vo.setPrimaryKeyJavaFields(primaryKeyJavaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return null;
            }
        }.grenerate();

        return voFtl;
    }


    /**
     * 主键vo
     *
     * @param table
     * @param basePackage
     * @param classNamePrefix
     * @param javaFields
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    private static VoPriFtl getVoPriFtl(Table table,
                                        String basePackage,
                                        String classNamePrefix,
                                        List<JavaField> javaFields,
                                        Set<String> javaFieldTypes
    ) throws IOException, TemplateException {
        VoPriFtl ftl = new GenerateJavaUtil<VoPriFtl>() {
            @Override
            public VoPriFtl getFtlVo() {
                VoPriFtl vo = new VoPriFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir() + ".plugin");
                vo.setClassName(classNamePrefix + "PriVo");
                vo.setJavaFields(javaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return null;
            }
        }.grenerate();

        return ftl;
    }

    /**
     * 非主键vo
     *
     * @param table
     * @param basePackage
     * @param classNamePrefix
     * @param javaFields
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    private static VoNoPriFtl getVoNoPriFtl(Table table,
                                            String basePackage,
                                            String classNamePrefix,
                                            List<JavaField> javaFields,
                                            Set<String> javaFieldTypes
    ) throws IOException, TemplateException {
        VoNoPriFtl ftl = new GenerateJavaUtil<VoNoPriFtl>() {
            @Override
            public VoNoPriFtl getFtlVo() {
                VoNoPriFtl vo = new VoNoPriFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir() + ".plugin");
                vo.setClassName(classNamePrefix + "NoPriVo");
                vo.setJavaFields(javaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return null;
            }
        }.grenerate();

        return ftl;
    }

    /**
     * updateBase 的请求的RequestVo
     *
     * @param table
     * @param basePackage
     * @param classNamePrefix
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    private static RequestUpdateBaseFtl getRequestUpdateBaseFtl(Table table,
                                                                String basePackage,
                                                                String classNamePrefix,
                                                                AllJavaFtl allJavaFtl
    ) throws IOException, TemplateException {
        RequestUpdateBaseFtl ftl = new GenerateJavaUtil<RequestUpdateBaseFtl>() {
            @Override
            public RequestUpdateBaseFtl getFtlVo() {
                RequestUpdateBaseFtl vo = new RequestUpdateBaseFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + ".vo" + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "RequestUpdateBase");
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return allJavaFtl;
            }
        }.grenerate();

        return ftl;
    }

    /**
     * updateBase 的请求的RequestVo
     *
     * @param table
     * @param basePackage
     * @param classNamePrefix
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    private static RequestUpdatePrimaryKeyFtl getRequestUpdatePrimaryKeyFtl(Table table,
                                                                            String basePackage,
                                                                            String classNamePrefix,
                                                                            AllJavaFtl allJavaFtl
    ) throws IOException, TemplateException {
        RequestUpdatePrimaryKeyFtl ftl = new GenerateJavaUtil<RequestUpdatePrimaryKeyFtl>() {
            @Override
            public RequestUpdatePrimaryKeyFtl getFtlVo() {
                RequestUpdatePrimaryKeyFtl vo = new RequestUpdatePrimaryKeyFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + ".vo" + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "RequestUpdatePrimaryKey");
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return allJavaFtl;
            }
        }.grenerate();

        return ftl;
    }


    /**
     * DAO文件的操作
     */
    private static DAOFtl getDAOFtl(Table table,
                                    String basePackage,
                                    String classNamePrefix,
                                    List<MysqlField> mysqlFields,
                                    List<MysqlField> primaryKeyMysqlFields,
                                    List<JavaField> javaFields,
                                    List<JavaField> primaryKeyJavaFields,
                                    Set<String> javaFieldTypes,
                                    AllJavaFtl allJavaFtl
    ) throws IOException, TemplateException {
        DAOFtl daoFtl = new GenerateJavaUtil<DAOFtl>() {
            @Override
            public DAOFtl getFtlVo() {
                DAOFtl vo = new DAOFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "DAO");
                vo.setMysqlFields(mysqlFields);
                vo.setPrimaryKeyMysqlFields(primaryKeyMysqlFields);
                vo.setJavaFields(javaFields);
                vo.setPrimaryKeyJavaFields(primaryKeyJavaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return allJavaFtl;
            }
        }.grenerate();

        return daoFtl;
    }

    /**
     * Service文件的操作
     */
    private static ServiceFtl getServiceFtl(Table table,
                                            String basePackage,
                                            String classNamePrefix,
                                            List<MysqlField> mysqlFields,
                                            List<MysqlField> primaryKeyMysqlFields,
                                            List<JavaField> javaFields,
                                            List<JavaField> primaryKeyJavaFields,
                                            Set<String> javaFieldTypes,
                                            AllJavaFtl allJavaFtl
    ) throws IOException, TemplateException {
        ServiceFtl serviceFtl = new GenerateJavaUtil<ServiceFtl>() {
            @Override
            public ServiceFtl getFtlVo() {
                ServiceFtl vo = new ServiceFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "Service");
                vo.setMysqlFields(mysqlFields);
                vo.setPrimaryKeyMysqlFields(primaryKeyMysqlFields);
                vo.setJavaFields(javaFields);
                vo.setPrimaryKeyJavaFields(primaryKeyJavaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return allJavaFtl;
            }
        }.grenerate();

        return serviceFtl;
    }

    /**
     * Service文件的操作
     */
    private static ServiceImplFtl getServiceImplFtl(Table table,
                                                    String basePackage,
                                                    String classNamePrefix,
                                                    List<MysqlField> mysqlFields,
                                                    List<MysqlField> primaryKeyMysqlFields,
                                                    List<JavaField> javaFields,
                                                    List<JavaField> primaryKeyJavaFields,
                                                    Set<String> javaFieldTypes,
                                                    AllJavaFtl allJavaFtl
    ) throws IOException, TemplateException {
        ServiceImplFtl serviceImplFtl = new GenerateJavaUtil<ServiceImplFtl>() {
            @Override
            public ServiceImplFtl getFtlVo() {
                ServiceImplFtl vo = new ServiceImplFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "ServiceImpl");
                vo.setMysqlFields(mysqlFields);
                vo.setPrimaryKeyMysqlFields(primaryKeyMysqlFields);
                vo.setJavaFields(javaFields);
                vo.setPrimaryKeyJavaFields(primaryKeyJavaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return allJavaFtl;
            }
        }.grenerate();

        return serviceImplFtl;
    }

    /**
     * Service文件的操作
     */
    private static MapperFtl getMapperFtl(Table table,
                                          String basePackage,
                                          String classNamePrefix,
                                          List<MysqlField> mysqlFields,
                                          List<MysqlField> primaryKeyMysqlFields,
                                          List<JavaField> javaFields,
                                          List<JavaField> primaryKeyJavaFields,
                                          Set<String> javaFieldTypes,
                                          AllJavaFtl allJavaFtl
    ) throws IOException, TemplateException {

        /**
         * 这个是为Mapper准备的
         */
        List<MysqlAndJavaField> mysqlAndJavaFields = new ArrayList<>();
        for (int i = 0; i < mysqlFields.size(); i++) {
            MysqlAndJavaField mysqlAndJavaField = new MysqlAndJavaField();
            mysqlAndJavaField.setJavaField(javaFields.get(i));
            mysqlAndJavaField.setMysqlField(mysqlFields.get(i));
            mysqlAndJavaFields.add(mysqlAndJavaField);
        }
        //
        List<MysqlAndJavaField> primaryKeyMysqlAndJavaFields = new ArrayList<>();
        for (int i = 0; i < primaryKeyJavaFields.size(); i++) {
            MysqlAndJavaField mysqlAndJavaField = new MysqlAndJavaField();
            mysqlAndJavaField.setJavaField(primaryKeyJavaFields.get(i));
            mysqlAndJavaField.setMysqlField(primaryKeyMysqlFields.get(i));
            primaryKeyMysqlAndJavaFields.add(mysqlAndJavaField);
        }

        MapperFtl mapperFtl = new GenerateJavaUtil<MapperFtl>() {
            @Override
            public MapperFtl getFtlVo() {
                MapperFtl vo = new MapperFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "Mapper");
                vo.setMysqlFields(mysqlFields);
                vo.setPrimaryKeyMysqlFields(primaryKeyMysqlFields);
                vo.setJavaFields(javaFields);
                vo.setPrimaryKeyJavaFields(primaryKeyJavaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".xml");
                /**
                 * 这个是Mapper独有的
                 */
                vo.setMysqlAndJavaFields(mysqlAndJavaFields);
                vo.setPrimaryKeyMysqlAndJavaFields(primaryKeyMysqlAndJavaFields);
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return allJavaFtl;
            }
        }.grenerate();

        return mapperFtl;
    }

    /**
     * Service文件的操作
     */
    private static ControllerFtl getControllerFtl(Table table,
                                                  String basePackage,
                                                  String classNamePrefix,
                                                  List<MysqlField> mysqlFields,
                                                  List<MysqlField> primaryKeyMysqlFields,
                                                  List<JavaField> javaFields,
                                                  List<JavaField> primaryKeyJavaFields,
                                                  Set<String> javaFieldTypes,
                                                  AllJavaFtl allJavaFtl
    ) throws IOException, TemplateException {
        ControllerFtl controllerFtl = new GenerateJavaUtil<ControllerFtl>() {
            @Override
            public ControllerFtl getFtlVo() {
                ControllerFtl vo = new ControllerFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "Controller");
                vo.setMysqlFields(mysqlFields);
                vo.setPrimaryKeyMysqlFields(primaryKeyMysqlFields);
                vo.setJavaFields(javaFields);
                vo.setPrimaryKeyJavaFields(primaryKeyJavaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return allJavaFtl;
            }
        }.grenerate();

        return controllerFtl;
    }


}
