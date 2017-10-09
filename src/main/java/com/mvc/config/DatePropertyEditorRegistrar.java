package com.mvc.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by spencer.hong on 2017/6/19.
 */
public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {
    private String format;

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        CustomDateEditor customDateEditor = new CustomDateEditor(sf, false);
        registry.registerCustomEditor(Date.class, customDateEditor);
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
