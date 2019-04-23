package com.example.demo.excel.adapter;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class CellTitleStyleHandlerAdapter implements CellStyleHandlerAdapter<HSSFWorkbook> {

    @Override
    public HSSFCellStyle styleSettings(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }
}
