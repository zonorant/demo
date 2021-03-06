package com.example.demo.excel.client;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.excel.handler.MetaHandler;
import com.example.demo.excel.resolver.WorkbookResolver;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelClient {

    private ExcelManager manager;

    public ExcelClient() {
    }

    public ExcelManager getManager() {
        return this.manager;
    }

    public void setManager(ExcelManager manager) {
        this.manager = manager;
    }

    public void init() {
        if (null == this.manager) {
            this.manager = new ExcelManager();
            this.manager.init();
        }
    }

    private <T> void createWorkbook(String fileName, List<T> datasource, HttpServletResponse response,
        String workbookName) throws Exception {
        WorkbookResolver resolver = this.manager.getResolver();
        MetaHandler<T> metaHandler = new MetaHandler(datasource.get(0).getClass());
        Workbook wb = resolver.resolverWorkBook(datasource, metaHandler, workbookName, this.manager.getTitleStyleAdapter(), this.manager.getSimpleStyleAdapter());
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"),
            "ISO8859-1") + ".xls");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }

    public <T> void export(String fileName, List<T> datasource, HttpServletResponse response, String workbookName) throws Exception {
        createWorkbook(fileName, datasource, response, workbookName);
    }

    public <T> void export(String fileName, List<T> datasource, HttpServletResponse response) throws Exception {
        createWorkbook(fileName, datasource, response, null);
        //WorkbookResolver resolver = this.manager.getResolver();
        //MetaHandler<T> metaHandler = new MetaHandler(datasource.get(0).getClass());
        //HSSFWorkbook wb = resolver.resolverWorkBook(datasource, metaHandler, this.manager.getTitleStyleAdapter(), this.manager.getSimpleStyleAdapter());
        //response.setContentType("application/vnd.ms-excel");
        //response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1") + ".xls");
        //OutputStream ouputStream = response.getOutputStream();
        //wb.write(ouputStream);
        //ouputStream.flush();
        //ouputStream.close();
    }

    public <T> Workbook export(List<T> datasource) throws Exception {
        WorkbookResolver resolver = this.manager.getResolver();
        MetaHandler<T> metaHandler = new MetaHandler(datasource.get(0).getClass());
        Workbook wb = resolver.resolverWorkBook(datasource, metaHandler, this.manager.getTitleStyleAdapter(),
            this.manager.getSimpleStyleAdapter());
        return wb;
    }
}
