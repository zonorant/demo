package com.example.demo.excel.adapter;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface CellStyleHandlerAdapter {
    HSSFCellStyle styleSettings(HSSFWorkbook workbook);
}
