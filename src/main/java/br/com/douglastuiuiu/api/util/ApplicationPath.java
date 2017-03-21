package br.com.douglastuiuiu.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author douglasg
 * @since 20/03/2017
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationPath {

    @Value("${app.terrain.maxColumns}")
    private Integer maxColumns;
    @Value("${app.terrain.minColumns}")
    private Integer minColumns;
    @Value("${app.terrain.maxColumns}")
    private Integer maxlines;
    @Value("${app.terrain.minColumns}")
    private Integer minlines;

    public Integer getMaxColumns() {
        return maxColumns;
    }

    public void setMaxColumns(Integer maxColumns) {
        this.maxColumns = maxColumns;
    }

    public Integer getMinColumns() {
        return minColumns;
    }

    public void setMinColumns(Integer minColumns) {
        this.minColumns = minColumns;
    }

    public Integer getMaxlines() {
        return maxlines;
    }

    public void setMaxlines(Integer maxlines) {
        this.maxlines = maxlines;
    }

    public Integer getMinlines() {
        return minlines;
    }

    public void setMinlines(Integer minlines) {
        this.minlines = minlines;
    }

}
