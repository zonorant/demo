package com.example.demo.excel.resolver;

import com.example.demo.excel.adapter.CellStyleHandlerAdapter;
import com.example.demo.excel.handler.MetaHandler;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

public interface WorkbookResolver {

    <T> HSSFWorkbook resolverWorkBook(List<T> data, MetaHandler<T> handler, String workbookName, CellStyleHandlerAdapter titleStyleAdapter, CellStyleHandlerAdapter simpleStyleAdapter) throws Exception;

    <T> HSSFWorkbook resolverWorkBook(List<T> data, MetaHandler<T> handler, CellStyleHandlerAdapter titleStyleAdapter, CellStyleHandlerAdapter simpleStyleAdapter) throws Exception;
}
