package easyexcel.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * EasyExcel 导出工具类
 */

@Slf4j
public class EasyExcelExportUtil {

    /**
     * 导出单个sheet
     * @param response
     * @param fileName
     * @param sheetName
     * @param data
     * @param tClass
     * @param <T>
     */
    public static<T> void exportExcel(HttpServletResponse response, String fileName, String sheetName, List<T> data, Class<T> tClass, ExcelTypeEnum type){
        ServletOutputStream out = null;
        ExcelWriter writer = null;
        try {
            defaultResponse(response, fileName, type);
            out = response.getOutputStream();

            writer = EasyExcelFactory.write(out, tClass).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();
            WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).build();

            writer.write(Lists.newArrayList(data),writeSheet);

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                writer.finish();
            }
        }
    }


    /**
     * 导出多个sheet
     * @param response
     * @param fileName
     * @param map
     * @param tClass
     * @param type
     * @param <T>
     */
    public static<T> void exportExcelManySheet(HttpServletResponse response, String fileName, Map<String, List<T>> map, Class<T> tClass, ExcelTypeEnum type){
        ServletOutputStream out = null;
        ExcelWriter writer = null;
        try {
            defaultResponse(response, fileName, type);
            out = response.getOutputStream();
            writer = EasyExcelFactory.write(out, tClass).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();
            ExcelWriter finalWriter = writer;
            map.forEach((k, v)->{
                WriteSheet writeSheet = EasyExcel.writerSheet(k).build();
                finalWriter.write(v,writeSheet);
            });

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                writer.finish();
            }
        }
    }

    public static<T> void exportExcelManySheet(HttpServletResponse response, String fileName, List<List<String>> head, Map<String, List<List<String>>> map, ExcelTypeEnum type){
        ServletOutputStream out = null;
        ExcelWriter writer = null;
        try {
            defaultResponse(response, fileName, type);
            out = response.getOutputStream();
            writer = EasyExcelFactory.write(out).head(head).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();
            ExcelWriter finalWriter = writer;
            map.forEach((k, v)->{
                WriteSheet writeSheet = EasyExcel.writerSheet(k).build();
                finalWriter.write(v,writeSheet);
            });
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                writer.finish();
            }
        }
    }

    public static void exportExcelDifferentSheet(HttpServletResponse response, String fileName, List<ExportModel> exportModels, ExcelTypeEnum type){
        ServletOutputStream out = null;
        ExcelWriter writer = null;
        try {
            defaultResponse(response, fileName, type);
            out = response.getOutputStream();
            writer = EasyExcelFactory.write(out).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();
            ExcelWriter finalWriter = writer;
            exportModels.forEach(o->{
                WriteSheet writeSheet = EasyExcel.writerSheet(o.getSheetName()).head(o.getAClass()).build();
                finalWriter.write(o.getList() ,writeSheet);
            });
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                writer.finish();
            }
        }
    }


    /**
     * 设置response
     * @param response
     * @param fileName
     * @param type
     */
    public static void defaultResponse(HttpServletResponse response, String fileName, ExcelTypeEnum type){
        try {
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + type.getValue());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("response设置编码异常！");
        }
    }

    @Data
    public static class ExportModel<T> {
        private String sheetName;
        private Class<T> aClass;
        private List<T> list;
    }

    /**
     * 多sheet不同类导出时，辅助类
     * @param sheetName
     * @param aClass
     * @param list
     * @param <T>
     * @return
     */
    public static<T> ExportModel getExportModel(String sheetName, Class<T> aClass, List<T> list){
        ExportModel model = new ExportModel();
        model.setSheetName(sheetName);
        model.setAClass(aClass);
        model.setList(list);
        return model;
    }


    /**
     * 自定义头辅助
     * @param list
     * @param str
     * @param size
     * @return
     */
    public static List<String> repeatHead(List<List<String>> list,String str, Integer size){
        List<String> result = Lists.newArrayList();
        for(int i = 0;i<size;i++){
            list.add(Lists.newArrayList(str));
        }
        return result;
    }


}
