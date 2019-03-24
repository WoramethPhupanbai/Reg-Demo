package com.example.reg.resolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.example.reg.view.Excelview;

public class ExcelViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) {
        Excelview view = new Excelview();
        return view;
    }
}
