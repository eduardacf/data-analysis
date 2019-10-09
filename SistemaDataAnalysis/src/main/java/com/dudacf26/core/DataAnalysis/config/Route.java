package com.dudacf26.core.DataAnalysis.config;

import com.dudacf26.core.DataAnalysis.processor.FileProcessor;
import com.dudacf26.core.DataAnalysis.processor.ReportProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class Route extends RouteBuilder {

    @Override
    public void configure() {

        from("{{inputDir}}")
                .filter()
                .simple("${file:ext} == 'dat'")
                .convertBodyTo(InputStream.class)
                .process(new FileProcessor())
                .process(new ReportProcessor())
                .convertBodyTo(String.class)
                .to("{{outputDir}}?fileName=${file:onlyname.noext}.done.${file:ext}");
    }
}