package com.example.demo.excel.resolver;

import java.util.List;

import com.example.demo.excel.adapter.CellStyleHandlerAdapter;
import com.example.demo.excel.client.SortableField;
import com.example.demo.excel.handler.MetaHandler;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DefaultWorkBookResolver implements WorkbookResolver<HSSFWorkbook> {

    @Override
    public <T> HSSFWorkbook resolverWorkBook(List<T> dataSource, MetaHandler<T> handler, String workbookName,
        CellStyleHandlerAdapter titleStyleAdapter, CellStyleHandlerAdapter simpleStyleAdapter) throws Exception {
        List<SortableField> sortableFieldList = handler.init();
        if (StringUtils.isEmpty(workbookName)) {
            workbookName = "sheet1";
        }

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(workbookName);
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = titleStyleAdapter.styleSettings(wb);

        for (int i = 0; i < sortableFieldList.size(); ++i) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(sortableFieldList.get(i).getMeta().title());
        }

        HSSFCellStyle hssfCellStyle = simpleStyleAdapter.styleSettings(wb);

        for (int i = 0; i < dataSource.size(); ++i) {
            HSSFRow dataRow = sheet.createRow(i + 1);
            T data = dataSource.get(i);

            for (int j = 0; j < sortableFieldList.size(); ++j) {
                SortableField sortableField = sortableFieldList.get(j);
                String property = BeanUtils.getProperty(data, sortableField.getName());
                HSSFCell cell = dataRow.createCell(j);
                cell.setCellStyle(hssfCellStyle);
                cell.setCellValue(property);
            }
        }
        return wb;
    }

    @Override
    public <T> HSSFWorkbook resolverWorkBook(List<T> dataSource, MetaHandler<T> handler,
        CellStyleHandlerAdapter titleStyleAdapter, CellStyleHandlerAdapter simpleStyleAdapter) throws Exception {
        return resolverWorkBook(dataSource, handler, null, titleStyleAdapter, simpleStyleAdapter);
    }
}
