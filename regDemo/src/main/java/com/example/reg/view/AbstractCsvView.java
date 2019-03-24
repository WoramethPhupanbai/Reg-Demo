package com.example.reg.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public abstract class AbstractCsvView extends AbstractView {

    private static final String CONTENT_TYPE = "text/csv";


    private String url;


    public AbstractCsvView() {
        setContentType(CONTENT_TYPE);
    }


    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }


    @Override
    protected final void renderMergedOutputModel(
            Map<String, Object> req, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        buildCsvDocument(req, request, response);
    }


    protected abstract void buildCsvDocument(
            Map<String, Object> req, HttpServletRequest request, HttpServletResponse response)
            throws Exception;

}
