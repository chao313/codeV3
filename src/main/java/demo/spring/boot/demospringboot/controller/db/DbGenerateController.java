package demo.spring.boot.demospringboot.controller.db;

import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;
import demo.spring.boot.demospringboot.mybatis.service.ColumnsService;
import demo.spring.boot.demospringboot.mybatis.service.SchemataService;
import demo.spring.boot.demospringboot.mybatis.service.TablesService;
import demo.spring.boot.demospringboot.mybatis.vo.ColumnsVo;
import demo.spring.boot.demospringboot.mybatis.vo.SchemataVo;
import demo.spring.boot.demospringboot.mybatis.vo.TablesVo;
import demo.spring.boot.demospringboot.util.FreeMarkUtil;
import demo.spring.boot.demospringboot.util.AwareUtil;
import demo.spring.boot.demospringboot.util.CamelUtils;
import demo.spring.boot.demospringboot.util.TypeMap;
import demo.spring.boot.demospringboot.util.TypeMapClass;
import demomaster.service.*;
import demomaster.vo.*;
import freemarker.template.TemplateException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/**
 * 2018/4/6    Created by   juan
 */

@RestController
@RequestMapping(value = "/db/generate")
@Slf4j
public class DbGenerateController {

    private static final String FREE_MARK_PATH = "classpath:freemark/db/java/";


    @Autowired
    private SchemataService schemataService;

    @Autowired
    private TablesService tablesService;

    @Autowired
    private ColumnsService columnsService;

    @Autowired
    private TProjectService tProjectService;

    @Autowired
    private TControllerService tControllerService;

    @Autowired
    private TServiceService tServiceService;

    @Autowired
    private TServiceImplService tServiceImplService;

    @Autowired
    private TDaoService tDaoService;

    @Autowired
    private TMapperService tMapperService;

    @Autowired
    private TVoService tVoService;

    @Autowired
    private TVoPriService tVoPriService;

    @Autowired
    private TVoNoPriService tVoNoPriService;

    @Autowired
    private TMultiTermVoService tMultiTermVoService;

    @Autowired
    private TFieldService tFieldService;

    /**
     * ????????????????????????
     *
     * @param dataBase
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "??????????????????")
    @GetMapping("/generateToDb")
    @Transactional
    public Response generateToDb(
            @ApiParam(example = "docker2") @RequestParam(value = "dataBase") String dataBase) throws Exception {
        Response response = new Response();
        try {
            /**?????????????????????*/
            Map<String, List<TFieldVo>> map = new HashMap<>();
            Map<String, List<TFieldVo>> mapPri = new HashMap<>();
            Map<String, List<TFieldVo>> mapNoPri = new HashMap<>();

            SchemataVo schemataQuery = new SchemataVo();
            schemataQuery.setSchemaName(dataBase);
            /**??????????????????*/
            List<SchemataVo> schemataVos = schemataService.queryBase(schemataQuery);
            TProjectVo tProjectVo = this.initTProjectVo(schemataVos.get(0));
            tProjectService.insert(tProjectVo);

            /**?????? fields ??????*/
            ColumnsVo columnsVoQuery = new ColumnsVo();
            columnsVoQuery.setTableSchema(dataBase);
            List<ColumnsVo> columnsVos = columnsService.queryBase(columnsVoQuery);
            List<TFieldVo> tFieldVos = this.initTFieldVos(columnsVos);
            tFieldService.insert(tFieldVos);
            /**?????????????????????*/
            map = this.toMapBYTableName(tFieldVos);
            mapPri = this.toPriMapBYTableName(tFieldVos);
            mapNoPri = this.toNoPriMapBYTableName(tFieldVos);

            TablesVo tablesVoQuery = new TablesVo();
            tablesVoQuery.setTableSchema(dataBase);
            List<TablesVo> tablesVos = tablesService.queryBase(tablesVoQuery);


            /**?????? vo ??????*/
            List<TVoVo> tVoVos = this.initTVoVo(tablesVos);
            tVoVos = this.initFreeMarkTVoVo(tVoVos, map);//??????freemark
            tVoService.insert(tVoVos);

            /**?????? voPri ??????*/
            List<TVoPriVo> tVoPriVos = this.initTVoPriVo(tablesVos);
            tVoPriVos = this.initFreeMarkTVoPriVo(tVoPriVos, mapPri);//??????freemark
            tVoPriService.insert(tVoPriVos);

            /**?????? voNoPri ??????*/
            List<TVoNoPriVo> tVoNoPriVos = this.initTVoNoPriVo(tablesVos);
            tVoNoPriVos = this.initFreeMarkTVoNoPriVo(tVoNoPriVos, mapNoPri);//??????freemark
            tVoNoPriService.insert(tVoNoPriVos);

            /**?????? MultiTermVo ??????*/
            List<TMultiTermVoVo> tMultiTermVoVos = this.initTMultiTermVo(tablesVos);
            tMultiTermVoService.insert(tMultiTermVoVos);

            /**?????? dao ??????*/
            List<TDaoVo> tDaoVos = this.initDaoVos(tablesVos);
            tDaoService.insert(tDaoVos);

            /**?????? Mapper ??????*/
            List<TMapperVo> tMapperVos = this.initTMapperVos(tablesVos);
            tMapperService.insert(tMapperVos);

            /**?????? service ??????*/
            List<TServiceVo> tServiceVos = this.initServiceVos(tablesVos);
            tServiceService.insert(tServiceVos);

            /**?????? serviceImpl ??????*/
            List<TServiceImplVo> tServiceImplVos = this.initTServiceImplVos(tablesVos);
            tServiceImplService.insert(tServiceImplVos);


            /**?????? Controller ??????*/
            List<TControllerVo> tControllerVos = this.initTControllerVos(tablesVos);
            tControllerService.insert(tControllerVos);

            response.setCode(Code.System.OK);
            response.setContent(true);
            log.info("success result -> {} ", true);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("?????? -> {} ", e.getMessage(), e);
        }
        return response;

    }


    /**
     * ????????? ??????
     *
     * @param schemataVo
     * @return
     */
    public TProjectVo initTProjectVo(SchemataVo schemataVo) {
        TProjectVo tProjectVo = new TProjectVo();
        tProjectVo.setDbName(schemataVo.getSchemaName());
        tProjectVo.setProjectName(CamelUtils.underline2Camel(schemataVo.getSchemaName(), false));
        tProjectVo.setProjectPort("80");
        tProjectVo.setProjectContextPath(CamelUtils.underline2Camel(schemataVo.getSchemaName(), true));
        tProjectVo.setProjectRootPackage("demo");
        return tProjectVo;
    }


    /**
     * ????????? Field
     *
     * @param columnsVos
     * @return
     */
    public List<TFieldVo> initTFieldVos(List<ColumnsVo> columnsVos) {
        List<TFieldVo> rs = new ArrayList<>();
        columnsVos.forEach(columnsVo -> {
            TFieldVo vo = new TFieldVo();
            vo.setDbName(columnsVo.getTableSchema());
            vo.setDbTableName(columnsVo.getTableName());
            vo.setFieldComment(columnsVo.getColumnComment());
            vo.setFieldIsPri(columnsVo.getColumnKey());
            vo.setFieldName(columnsVo.getColumnName());
            vo.setFieldJavaName(CamelUtils.underline2Camel(columnsVo.getColumnName(), true));
            vo.setFieldType(columnsVo.getDataType());
            vo.setFieldJavaType(TypeMap.getTypeMap().get(columnsVo.getDataType()));
            rs.add(vo);
        });
        return rs;
    }

    /**
     * ????????? vo
     *
     * @param tablesVos
     * @return
     */
    public List<TVoVo> initTVoVo(List<TablesVo> tablesVos) throws IOException {
        List<TVoVo> rs = new ArrayList<>();
        for (TablesVo tablesVo : tablesVos) {
            TVoVo vo = new TVoVo();
            String className = CamelUtils.underline2Camel(tablesVo.getTableName(), true);
            vo.setDbName(tablesVo.getTableSchema());
            vo.setDbTableName(tablesVo.getTableName());
            vo.setDbTableComment(tablesVo.getTableComment());
            vo.setPackageName("demo.vo");
            vo.setClassName(CamelUtils.toUpperCaseFirstOne(className));
            vo.setFileName(className + ".java");
            vo.setFreemarkPath("Vo.ftl");
            /**?????? freemark ?????????*/
            Resource resource = AwareUtil.resourceLoader.getResource(FREE_MARK_PATH + vo.getFreemarkPath());
            String freeMarkContent = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            vo.setFreemarkContent(freeMarkContent);
            /**?????? import ?????????*/
            String importsToString = this.getImportsToString(vo.getDbName(), vo.getDbTableName(), null, false);
            vo.setImports(importsToString);
            rs.add(vo);
        }
        return rs;
    }

    /**
     * ????????? vo ??? freeMark
     *
     * @return
     */
    public List<TVoVo> initFreeMarkTVoVo(List<TVoVo> tVoVos, Map<String, List<TFieldVo>> map) throws IOException, TemplateException {
        for (TVoVo tVoVo : tVoVos) {
            List<TFieldVo> tFieldVos = map.get(tVoVo.getDbTableName());
            Map<String, Object> mapInFreeMark = new HashMap<>();
            mapInFreeMark.put("vo", tVoVo);
            mapInFreeMark.put("tFieldVos", tFieldVos);
            StringBuffer freeMarkStr = FreeMarkUtil.generateXmlByTemplate(mapInFreeMark, tVoVo.getFreemarkContent());
            tVoVo.setFreemarkValue(freeMarkStr.toString());
        }
        return tVoVos;
    }

    /**
     * ????????? vo
     *
     * @param tablesVos
     * @return
     */
    public List<TMultiTermVoVo> initTMultiTermVo(List<TablesVo> tablesVos) throws IOException {
        List<TMultiTermVoVo> rs = new ArrayList<>();
        for (TablesVo tablesVo : tablesVos) {
            TMultiTermVoVo vo = new TMultiTermVoVo();
            String className = CamelUtils.underline2Camel(tablesVo.getTableName(), true);
            vo.setDbName(tablesVo.getTableSchema());
            vo.setDbTableName(tablesVo.getTableName());
            vo.setDbTableComment(tablesVo.getTableComment());
            vo.setPackageName("demo.vo");
            vo.setClassName(CamelUtils.toUpperCaseFirstOne(className));
            vo.setFileName(className + ".java");
            vo.setFreemarkPath("MultiTermVo.ftl");
            /**?????? freemark ?????????*/
            Resource resource = AwareUtil.resourceLoader.getResource(FREE_MARK_PATH + vo.getFreemarkPath());
            String freeMarkContent = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            vo.setFreemarkContent(freeMarkContent);
            /**?????? import ?????????*/
            String importsToString = this.getImportsToString(vo.getDbName(), vo.getDbTableName(), null, false);
            vo.setImports(importsToString);
            rs.add(vo);
        }
        return rs;
    }

    /**
     * ????????? VoPri
     *
     * @param tablesVos
     * @return
     */
    public List<TVoPriVo> initTVoPriVo(List<TablesVo> tablesVos) throws IOException {
        List<TVoPriVo> rs = new ArrayList<>();
        for (TablesVo tablesVo : tablesVos) {
            TVoPriVo vo = new TVoPriVo();
            String className = CamelUtils.underline2Camel(tablesVo.getTableName(), true);
            vo.setDbName(tablesVo.getTableSchema());
            vo.setDbTableName(tablesVo.getTableName());
            vo.setDbTableComment(tablesVo.getTableComment());
            vo.setPackageName("demo.vo");
            vo.setClassName(CamelUtils.toUpperCaseFirstOne(className));
            vo.setFileName(className + ".java");
            vo.setFreemarkPath("VoPri.ftl");
            /**?????? freemark ?????????*/
            Resource resource = AwareUtil.resourceLoader.getResource(FREE_MARK_PATH + vo.getFreemarkPath());
            String freeMarkContent = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            vo.setFreemarkContent(freeMarkContent);
            /**?????? import ?????????*/
            String importsToString = this.getImportsToString(vo.getDbName(), vo.getDbTableName(), true, false);
            vo.setImports(importsToString);
            rs.add(vo);
        }
        return rs;
    }

    /**
     * ????????? voPri ??? freeMark
     *
     * @return
     */
    public List<TVoPriVo> initFreeMarkTVoPriVo(List<TVoPriVo> tVoVos, Map<String, List<TFieldVo>> map) throws IOException, TemplateException {
        for (TVoPriVo vo : tVoVos) {
            List<TFieldVo> tFieldVos = map.get(vo.getDbTableName());
            Map<String, Object> mapInFreeMark = new HashMap<>();
            mapInFreeMark.put("vo", vo);
            mapInFreeMark.put("tFieldVos", tFieldVos);
            StringBuffer freeMarkStr = FreeMarkUtil.generateXmlByTemplate(mapInFreeMark, vo.getFreemarkContent());
            vo.setFreemarkValue(freeMarkStr.toString());
        }
        return tVoVos;
    }


    /**
     * ????????? VoNoPri
     *
     * @param tablesVos
     * @return
     */
    public List<TVoNoPriVo> initTVoNoPriVo(List<TablesVo> tablesVos) throws IOException {
        List<TVoNoPriVo> rs = new ArrayList<>();
        for (TablesVo tablesVo : tablesVos) {
            TVoNoPriVo vo = new TVoNoPriVo();
            String className = CamelUtils.underline2Camel(tablesVo.getTableName(), true);
            vo.setDbName(tablesVo.getTableSchema());
            vo.setDbTableName(tablesVo.getTableName());
            vo.setDbTableComment(tablesVo.getTableComment());
            vo.setPackageName("demo.vo");
            vo.setClassName(CamelUtils.toUpperCaseFirstOne(className));
            vo.setFileName(className + ".java");
            vo.setFreemarkPath("VoPri.ftl");
            /**?????? freemark ?????????*/
            Resource resource = AwareUtil.resourceLoader.getResource(FREE_MARK_PATH + vo.getFreemarkPath());
            String freeMarkContent = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            vo.setFreemarkContent(freeMarkContent);
            /**?????? import ?????????*/
            String importsToString = this.getImportsToString(vo.getDbName(), vo.getDbTableName(), false, false);
            vo.setImports(importsToString);
            rs.add(vo);
        }
        return rs;
    }

    /**
     * ????????? voPri ??? freeMark
     *
     * @return
     */
    public List<TVoNoPriVo> initFreeMarkTVoNoPriVo(List<TVoNoPriVo> tVoVos, Map<String, List<TFieldVo>> map) throws IOException, TemplateException {
        for (TVoNoPriVo vo : tVoVos) {
            List<TFieldVo> tFieldVos = map.get(vo.getDbTableName());
            Map<String, Object> mapInFreeMark = new HashMap<>();
            mapInFreeMark.put("vo", vo);
            mapInFreeMark.put("tFieldVos", tFieldVos);
            StringBuffer freeMarkStr = FreeMarkUtil.generateXmlByTemplate(mapInFreeMark, vo.getFreemarkContent());
            vo.setFreemarkValue(freeMarkStr.toString());
        }
        return tVoVos;
    }

    /**
     * ????????? DAO
     *
     * @param tablesVos
     * @return
     */
    public List<TDaoVo> initDaoVos(List<TablesVo> tablesVos) throws IOException {
        List<TDaoVo> rs = new ArrayList<>();
        for (TablesVo tablesVo : tablesVos) {
            TDaoVo vo = new TDaoVo();
            String className = CamelUtils.underline2Camel(tablesVo.getTableName(), true);
            vo.setDbName(tablesVo.getTableSchema());
            vo.setDbTableName(tablesVo.getTableName());
            vo.setDbTableComment(tablesVo.getTableComment());
            vo.setPackageName("demo.dao");
            vo.setClassName(CamelUtils.toUpperCaseFirstOne(className));
            vo.setFileName(className + ".java");
            vo.setFreemarkPath("DAO.ftl");
            /**?????? freemark ?????????*/
            Resource resource = AwareUtil.resourceLoader.getResource(FREE_MARK_PATH + vo.getFreemarkPath());
            String freeMarkContent = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            vo.setFreemarkContent(freeMarkContent);
            /**?????? import ?????????*/
            String importsToString = this.getImportsToString(vo.getDbName(), vo.getDbTableName(), null, true);
            vo.setImports(importsToString);
            rs.add(vo);
        }
        return rs;
    }

    /**
     * ????????? service
     *
     * @param tablesVos
     * @return
     */
    public List<TServiceVo> initServiceVos(List<TablesVo> tablesVos) throws IOException {
        List<TServiceVo> rs = new ArrayList<>();
        for (TablesVo tablesVo : tablesVos) {
            TServiceVo vo = new TServiceVo();
            String className = CamelUtils.underline2Camel(tablesVo.getTableName(), true);
            vo.setDbName(tablesVo.getTableSchema());
            vo.setDbTableName(tablesVo.getTableName());
            vo.setDbTableComment(tablesVo.getTableComment());
            vo.setPackageName("demo.service");
            vo.setClassName(CamelUtils.toUpperCaseFirstOne(className));
            vo.setFileName(className + ".java");
            vo.setFreemarkPath("Service.ftl");
            /**?????? freemark ?????????*/
            Resource resource = AwareUtil.resourceLoader.getResource(FREE_MARK_PATH + vo.getFreemarkPath());
            String freeMarkContent = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            vo.setFreemarkContent(freeMarkContent);
            /**?????? import ?????????*/
            String importsToString = this.getImportsToString(vo.getDbName(), vo.getDbTableName(), null, true);
            vo.setImports(importsToString);
            rs.add(vo);
        }
        return rs;
    }

    /**
     * ????????? serviceImpl
     *
     * @param tablesVos
     * @return
     */
    public List<TServiceImplVo> initTServiceImplVos(List<TablesVo> tablesVos) throws IOException {
        List<TServiceImplVo> rs = new ArrayList<>();
        for (TablesVo tablesVo : tablesVos) {
            TServiceImplVo vo = new TServiceImplVo();
            String className = CamelUtils.underline2Camel(tablesVo.getTableName(), true);
            vo.setDbName(tablesVo.getTableSchema());
            vo.setDbTableName(tablesVo.getTableName());
            vo.setDbTableComment(tablesVo.getTableComment());
            vo.setPackageName("demo.service.impl");
            vo.setClassName(CamelUtils.toUpperCaseFirstOne(className));
            vo.setFileName(className + ".java");
            vo.setFreemarkPath("ServiceImpl.ftl");
            /**?????? freemark ?????????*/
            Resource resource = AwareUtil.resourceLoader.getResource(FREE_MARK_PATH + vo.getFreemarkPath());
            String freeMarkContent = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            vo.setFreemarkContent(freeMarkContent);
            /**?????? import ?????????*/
            String importsToString = this.getImportsToString(vo.getDbName(), vo.getDbTableName(), null, true);
            vo.setImports(importsToString);
            rs.add(vo);
        }
        return rs;
    }

    /**
     * ????????? Controller
     *
     * @param tablesVos
     * @return
     */
    public List<TControllerVo> initTControllerVos(List<TablesVo> tablesVos) throws IOException {
        List<TControllerVo> rs = new ArrayList<>();
        for (TablesVo tablesVo : tablesVos) {
            TControllerVo vo = new TControllerVo();
            String className = CamelUtils.underline2Camel(tablesVo.getTableName(), true);
            vo.setDbName(tablesVo.getTableSchema());
            vo.setDbTableName(tablesVo.getTableName());
            vo.setDbTableComment(tablesVo.getTableComment());
            vo.setPackageName("demo.service.controller");
            vo.setClassName(CamelUtils.toUpperCaseFirstOne(className));
            vo.setFileName(className + ".java");
            vo.setFreemarkPath("Controller.ftl");
            /**?????? freemark ?????????*/
            Resource resource = AwareUtil.resourceLoader.getResource(FREE_MARK_PATH + vo.getFreemarkPath());
            String freeMarkContent = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            vo.setFreemarkContent(freeMarkContent);
            /**?????? import ?????????*/
            String importsToString = this.getImportsToString(vo.getDbName(), vo.getDbTableName(), null, true);
            vo.setImports(importsToString);
            rs.add(vo);
        }
        return rs;
    }


    /**
     * ????????? TMapperVo
     *
     * @param tablesVos
     * @return
     */
    public List<TMapperVo> initTMapperVos(List<TablesVo> tablesVos) throws IOException {
        List<TMapperVo> rs = new ArrayList<>();
        for (TablesVo tablesVo : tablesVos) {
            TMapperVo vo = new TMapperVo();
            String className = CamelUtils.underline2Camel(tablesVo.getTableName(), true);
            vo.setDbName(tablesVo.getTableSchema());
            vo.setDbTableName(tablesVo.getTableName());
            vo.setDbTableComment(tablesVo.getTableComment());
            vo.setDirName("demo/mapper");
            vo.setFileName(className + ".java");
            vo.setFreemarkPath("Mapper.ftl");
            /**?????? freemark ?????????*/
            Resource resource = AwareUtil.resourceLoader.getResource(FREE_MARK_PATH + vo.getFreemarkPath());
            String freeMarkContent = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            vo.setFreemarkContent(freeMarkContent);
            rs.add(vo);
        }
        return rs;
    }


    /**
     * @param dataBase
     * @param tableName
     * @param isPri         ???????????????
     * @param isIncludeList ????????????List
     * @return
     */
    private Set<String> getImports(String dataBase, String tableName, Boolean isPri, boolean isIncludeList) {
        Set<String> rs = new HashSet<>();
        ColumnsVo columnsVoQuery = new ColumnsVo();
        columnsVoQuery.setTableSchema(dataBase);
        columnsVoQuery.setTableName(tableName);
        List<ColumnsVo> columnsVos = columnsService.queryBase(columnsVoQuery);
        columnsVos.forEach(columnsVo -> {
            if (isPri == Boolean.TRUE) {
                if (columnsVo.getColumnKey().equalsIgnoreCase("pri")) {
                    /**???????????????*/
                    rs.add("import " + TypeMapClass.getTypeMap().get(columnsVo.getDataType()).getName() + ";");
                }
            } else if (isPri == Boolean.FALSE) {
                if (!columnsVo.getColumnKey().equalsIgnoreCase("pri")) {
                    rs.add("import " + TypeMapClass.getTypeMap().get(columnsVo.getDataType()).getName() + ";");
                }
            } else if (null == isPri) {
                rs.add("import " + TypeMapClass.getTypeMap().get(columnsVo.getDataType()).getName() + ";");
            }

        });
        if (isIncludeList == true) {
            rs.add("import java.util.List;");
        }
        return rs;
    }

    /**
     * @param dataBase
     * @param tableName
     * @param isPri         ???????????????
     * @param isIncludeList ????????????List
     * @return
     */
    private String getImportsToString(String dataBase, String tableName, Boolean isPri, boolean isIncludeList) {
        Set<String> rs = this.getImports(dataBase, tableName, isPri, isIncludeList);
        StringBuilder result = new StringBuilder();
        rs.forEach(s -> {
            result.append(s + "\n");
        });
        return result.toString();
    }

    /**
     * ?????????????????????  (????????????)
     *
     * @param tFieldVos
     * @return
     */
    private Map<String, List<TFieldVo>> toMapBYTableName(List<TFieldVo> tFieldVos) {
        Map<String, List<TFieldVo>> map = new HashMap<>();
        tFieldVos.forEach(tFieldVo -> {
            if (map.containsKey(tFieldVo.getDbTableName())) {
                map.get(tFieldVo.getDbTableName()).add(tFieldVo);
            } else {
                List<TFieldVo> tmp = new ArrayList<>();
                tmp.add(tFieldVo);
                map.put(tFieldVo.getDbTableName(), tmp);
            }
        });
        return map;
    }

    /**
     * ????????????????????? (???????????????)
     *
     * @param tFieldVos
     * @return
     */
    private Map<String, List<TFieldVo>> toNoPriMapBYTableName(List<TFieldVo> tFieldVos) {
        Map<String, List<TFieldVo>> map = new HashMap<>();
        tFieldVos.forEach(tFieldVo -> {
            if (!tFieldVo.getFieldIsPri().equalsIgnoreCase("pri")) {
                if (map.containsKey(tFieldVo.getDbTableName())) {
                    map.get(tFieldVo.getDbTableName()).add(tFieldVo);
                } else {
                    List<TFieldVo> tmp = new ArrayList<>();
                    tmp.add(tFieldVo);
                    map.put(tFieldVo.getDbTableName(), tmp);
                }
            }
        });
        return map;
    }

    /**
     * ????????????????????? (????????????)
     *
     * @param tFieldVos
     * @return
     */
    private Map<String, List<TFieldVo>> toPriMapBYTableName(List<TFieldVo> tFieldVos) {
        Map<String, List<TFieldVo>> map = new HashMap<>();
        tFieldVos.forEach(tFieldVo -> {
            if (tFieldVo.getFieldIsPri().equalsIgnoreCase("pri")) {
                if (map.containsKey(tFieldVo.getDbTableName())) {
                    map.get(tFieldVo.getDbTableName()).add(tFieldVo);
                } else {
                    List<TFieldVo> tmp = new ArrayList<>();
                    tmp.add(tFieldVo);
                    map.put(tFieldVo.getDbTableName(), tmp);
                }
            }
        });
        return map;
    }


}
