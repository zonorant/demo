package com.example.demo.excel.handler;

import com.example.demo.client.SortableField;
import com.example.demo.excel.annotation.FieldMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MetaHandler<T> {
    private Class<T> entity;

    public MetaHandler(Class<T> entity) {
        this.entity = entity;
        this.init();
    }

    public List<SortableField> init() {
        if (null != this.entity) {
            Field[] fields = this.entity.getDeclaredFields();
            List<SortableField> list = Stream.of(fields)
                    .map(field -> {
                        FieldMeta fieldMeta = field.getAnnotation(FieldMeta.class);
                        if (null != fieldMeta) {
                            SortableField sf = new SortableField(fieldMeta, field);
                            return sf;
                        }
                        return null;
                    })
                    .filter(field -> null != field)
                    .sorted(Comparator.comparing(f -> f.getMeta().order()))
                    .collect(Collectors.toList());
            return list;
        }
        return new ArrayList<>();
    }
}