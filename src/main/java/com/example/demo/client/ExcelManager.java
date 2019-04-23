package com.example.demo.client;

import com.example.demo.excel.adapter.CellSimpleStyleHandlerAdapter;
import com.example.demo.excel.adapter.CellStyleHandlerAdapter;
import com.example.demo.excel.adapter.CellTitleStyleHandlerAdapter;
import com.example.demo.excel.resolver.DefaultWorkBookResolver;
import com.example.demo.excel.resolver.WorkbookResolver;

public class ExcelManager {
    private WorkbookResolver resolver;
    private CellStyleHandlerAdapter titleStyleAdapter;
    private CellStyleHandlerAdapter simpleStyleAdapter;

    public ExcelManager() {
    }

    public WorkbookResolver getResolver() {
        return this.resolver;
    }

    public void setResolver(WorkbookResolver resolver) {
        this.resolver = resolver;
    }

    public CellStyleHandlerAdapter getTitleStyleAdapter() {
        return this.titleStyleAdapter;
    }

    public void setTitleStyleAdapter(CellStyleHandlerAdapter titleStyleAdapter) {
        this.titleStyleAdapter = titleStyleAdapter;
    }

    public CellStyleHandlerAdapter getSimpleStyleAdapter() {
        return this.simpleStyleAdapter;
    }

    public void setSimpleStyleAdapter(CellStyleHandlerAdapter simpleStyleAdapter) {
        this.simpleStyleAdapter = simpleStyleAdapter;
    }

    public void init() {
        this.resolver = new DefaultWorkBookResolver();
        this.titleStyleAdapter = new CellTitleStyleHandlerAdapter();
        this.simpleStyleAdapter = new CellSimpleStyleHandlerAdapter();
    }
}
