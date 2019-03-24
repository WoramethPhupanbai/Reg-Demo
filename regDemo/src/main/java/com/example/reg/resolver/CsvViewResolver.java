package com.example.reg.resolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.example.reg.view.CsvView;

public class CsvViewResolver implements ViewResolver {
	
    @Override
    public View resolveViewName(String s, Locale locale) {
        CsvView view = new CsvView();
        return view;
    }

}
