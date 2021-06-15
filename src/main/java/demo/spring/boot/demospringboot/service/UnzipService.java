package demo.spring.boot.demospringboot.service;

import demo.spring.boot.demospringboot.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UnzipService {


    public static void generateUnzipBash(String classPath) throws IOException {
        /**
         * 获取所有的待解压的数据
         */
        Map<Integer, List<String>> integerListMap = CommonUtil.readListFromClassCSV(classPath);
        Map<String, String> result = new HashMap<>();//存放id和name的对应关系
        integerListMap.forEach((id, list) -> {
            if (list.size() == 2) {
                if (StringUtils.isNotBlank(list.get(0))
                        && StringUtils.isNotBlank(list.get(1)))
                    result.put(list.get(0), list.get(1));
            }
        });

        /**
         * 根据rar 和 zip 生成不同的命令
         */
        result.forEach((id, name) -> {
            if (name.endsWith(CommonUtil.ZIP)) {
                log.info("bash: unzip /home/ASP3000/PHP/{} -d /home/ASP3000/PHPUnzip/{}", id, id);
            } else if (name.endsWith(CommonUtil.RAR)) {
                log.info("bash: mkdir /home/ASP3000/PHPUnzip/{} & unrar x /home/ASP3000/PHP/{} /home/ASP3000/PHPUnzip/{}", id, id, id);
            } else if (name.endsWith(CommonUtil.TARGZ)) {
                log.info("bash: mkdir /home/ASP3000/PHPUnzip/{} & tar -xzvf /home/ASP3000/PHP/{} -C /home/ASP3000/PHPUnzip/{}", id, id, id);
            } else {
                log.info("未处理数据:{} -> {}", id, name);
            }
        });


    }
}
