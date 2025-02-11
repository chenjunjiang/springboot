package com.chenjj.spring.boot.component;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;

/**
 * @ClassName MyXxxHttpMessageConverter
 * @Description
 * @Author chenjunjiang
 * @Date 21:36 2025/2/10
 * @Version 1.0
 **/
@Slf4j
public class MyXxxHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    public MyXxxHttpMessageConverter() {
        super(new MediaType("application", "xxx", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * Read an object of the given type from the given input message.
     *
     * @param clazz        the type of object to return
     * @param inputMessage the HTTP input message to read from
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /**
     * Write an object of the given type to the given output message.
     *
     * @param o             the object to write to the output message
     * @param outputMessage the HTTP output message to write to
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = outputMessage.getBody();
        StringWriter stringWriter = new StringWriter();
        try {
            StatefulBeanToCsv<Object> beanToCsv = new StatefulBeanToCsvBuilder<>(stringWriter).withQuotechar(com.opencsv.CSVWriter.DEFAULT_QUOTE_CHARACTER).build();
            beanToCsv.write(o);
            // 获取CSV格式的字符串
            String csvString = stringWriter.toString();
            outputStream.write(csvString.getBytes());
            outputStream.flush();
        } catch (Exception e) {
            log.error("执行writeInternal方法出错:", e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                log.error("执行outputStream.close()方法出错:", e);
            }
        }
    }
}
