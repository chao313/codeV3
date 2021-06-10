package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java;

import lombok.Data;

@Data
public class AllJavaFtl {
    private VoFtl voFtl;
    private MultiTermVoFtl multiTermVoFtl;
    private VoPriFtl voPriFtl;
    private VoNoPriFtl voNoPriFtl;
    private RequestUpdateBaseFtl requestUpdateBaseFtl;
    private RequestUpdatePrimaryKeyFtl requestUpdatePrimaryKeyFtl;
    private DAOFtl daoFtl;
    private ServiceFtl serviceFtl;
    private ServiceImplFtl serviceImplFtl;
    private MapperFtl mapperFtl;
    private ControllerFtl controllerFtl;
}
