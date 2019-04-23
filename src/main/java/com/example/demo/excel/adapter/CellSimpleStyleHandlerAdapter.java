package com.example.demo.excel.adapter;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CellSimpleStyleHandlerAdapter implements CellStyleHandlerAdapter<HSSFWorkbook> {

    @Override
    public HSSFCellStyle styleSettings(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        return style;
    }
}
