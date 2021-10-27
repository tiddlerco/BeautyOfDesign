package easyexcel.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import easyexcel.listener.ExcelListener;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EasyExcelImportUtil {

    /**
     * 读取文件(默认读取sheet1)
     * @param excel
     * @param readListener
     * @return
     * @throws IOException
     */
    public static ReadListener readExcel(MultipartFile excel, ReadListener readListener,Integer num ) throws IOException {
        ExcelReader reader = getReader(excel, readListener);
        return getExcelListener(readListener, reader,num);
    }

    /**
     * 读取文件(默认读取sheet1)
     * @param excel
     * @param tClass
     * @param <T>
     * @return
     * @throws IOException
     */
    public static<T> ExcelListener<T> readExcel(MultipartFile excel, Class<T> tClass, Integer num ) throws IOException {
        ExcelListener<T> readListener = new ExcelListener<>();
        ExcelReader reader = getReader(excel, readListener, tClass);
        getExcelListener(readListener, reader,num);
        return readListener;
    }

    /**
     * 读取文件,自选listener(默认读取sheet1)
     * @param excel
     * @param readListener
     * @param tClass
     * @param <T>
     * @return
     * @throws IOException
     */
    public static<T> ReadListener readExcel(MultipartFile excel, ReadListener<T> readListener, Class<T> tClass,Integer num) throws IOException {
        ExcelReader reader = getReader(excel, readListener, tClass);
        return getExcelListener(readListener, reader,num);
    }

    public static void readExcelSheet(MultipartFile excel, Map<ReadListener,Class> map) throws IOException{
        InputStream is = new BufferedInputStream(excel.getInputStream());
        ExcelReader reader = EasyExcel.read(is).build();

        List<ReadSheet> sheets = Lists.newArrayList();
        final int[] i = {0};
        map.forEach((listener,c)->{
            ReadSheet readSheet = EasyExcel.readSheet(i[0]).head(c).registerReadListener(listener).build();
            sheets.add(readSheet);
            i[0]++;
        });

        reader.read(sheets);
    }

    /**
     * 读取多个sheet
     * @param excel
     * @param start 起始sheet
     * @param end   终止sheet
     * @param tClass
     * @param <T>
     * @return
     * @throws IOException
     */
    public static<T> List<ExcelListener<T>> readExcelSheet(MultipartFile excel, Integer start, Integer end, Class<T> tClass) throws IOException{
        InputStream is = new BufferedInputStream(excel.getInputStream());
        ExcelReader reader = EasyExcel.read(is).build();
        List<ReadSheet> readSheets = Lists.newArrayList();
        List<ExcelListener<T>> excelListeners = Lists.newArrayList();
        for(int i = start; i <= end; i++){
            ExcelListener<T> excelListener = new ExcelListener();
            ReadSheet readSheet = EasyExcel.readSheet(i).head(tClass).registerReadListener(excelListener).build();
            excelListeners.add(excelListener);
            readSheets.add(readSheet);
        }
        ExcelReader read = reader.read(readSheets);
        return excelListeners;
    }

    public static<T> LinkedHashMap<String, ExcelListener<T>> readExcelSheet(MultipartFile excel, Class<T> tClass) throws IOException{
        InputStream is = new BufferedInputStream(excel.getInputStream());
        ExcelReader reader = EasyExcel.read(is).build();
        List<Sheet> sheets = reader.getSheets();
        List<ReadSheet> readSheets = Lists.newArrayList();
        LinkedHashMap<String,ExcelListener<T>> result = Maps.newLinkedHashMap();
        sheets.forEach(o->{
            ExcelListener<T> excelListener = new ExcelListener();
            ReadSheet readSheet = EasyExcel.readSheet(o.getSheetNo()-1).head(tClass).registerReadListener(excelListener).build();
            result.putIfAbsent(o.getSheetName(),excelListener);
            readSheets.add(readSheet);
        });
        ExcelReader read = reader.read(readSheets);
        return result;
    }

    /**
     * 获取 ReadListener
     * @param readListener
     * @param reader
     * @return
     */
    private static ReadListener getExcelListener(ReadListener readListener, ExcelReader reader,Integer num) {
        if (reader == null) {
            return null;
        }
        ReadSheet sheet = EasyExcel.readSheet(0).headRowNumber(num).build();
        reader.read(sheet);
        return readListener;
    }

    /**
     * 获取 ExcelReader
     * @param excel
     * @param readListener
     * @param tClass
     * @param <T>
     * @return
     * @throws IOException
     */
    private static<T> ExcelReader getReader(MultipartFile excel, ReadListener readListener, Class<T> tClass) throws IOException {
        InputStream is = new BufferedInputStream(excel.getInputStream());
        ExcelReader reader = EasyExcel.read(is,tClass,readListener).build();
        return reader;
    }


    private static ExcelReader getReader(MultipartFile excel, ReadListener readListener) throws IOException {
        InputStream is = new BufferedInputStream(excel.getInputStream());
        ExcelReader reader = EasyExcel.read(is,readListener).build();
        return reader;
    }
}
