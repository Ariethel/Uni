package model;

import java.util.List;

public class HeaderBean {
    public HeaderBean(List<String> headerNames, List<String> headerValues) {
        this.headerNames = headerNames;
        this.headerValues = headerValues;
    }

    public List<String> getHeaderNames() {
        return headerNames;
    }

    public List<String> getHeaderValues() {
        return headerValues;
    }

    private List<String> headerNames;
    private List<String> headerValues;

}
