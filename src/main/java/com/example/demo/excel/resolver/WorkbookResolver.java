package com.example.demo.excel.resolver;

import com.example.demo.excel.adapter.CellStyleHandlerAdapter;
import com.example.demo.excel.handler.MetaHandler;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface WorkbookResolver<W extends Workbook> {

    <T> W resolverWorkBook(List<T> dataSource, MetaHandler<T> handler, String workbookName, CellStyleHandlerAdapter titleStyleAdapter, CellStyleHandlerAdapter simpleStyleAdapter) throws Exception;

    <T> W resolverWorkBook(List<T> dataSource, MetaHandler<T> handler, CellStyleHandlerAdapter titleStyleAdapter, CellStyleHandlerAdapter simpleStyleAdapter) throws Exception;
}
