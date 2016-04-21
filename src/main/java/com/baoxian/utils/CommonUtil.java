package com.baoxian.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import java.io.File;
import java.io.FileInputStream;

public class CommonUtil {

    private static Logger logger = Logger.getLogger(CommonUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();

    // JackSon反序列化JSON字符串
    public static <T> T toJsonObj(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) return null;
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("JackSon反序列化异常:", e);
            return null;
        }
    }

    // JackSon序列化Java对象
    public static String toJsonStr(Object obj) {
        if (null == obj) return null;
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("JackSon序列化异常:", e);
            return null;
        }
    }

    // 读取IO文件
    public static String read(String path, String charSet) {
        try {
            String content = null;
            File file = new File(path);
            Long size = file.length();
            byte[] buff = new byte[size.intValue()];
            FileInputStream fs = new FileInputStream(file);
            fs.read(buff);
            fs.close();
            content = new String(buff, charSet);
            return content;
        } catch (Exception e) {
            logger.error("I/O流读取异常：", e);
            return null;
        }
    }
}
