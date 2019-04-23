package com.example.demo.excel.adapter;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public interface CellStyleHandlerAdapter<W extends Workbook> {
    HSSFCellStyle styleSettings(W workbook);
}
