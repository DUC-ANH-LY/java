package com.sallyf.sallyf.FreeMarker;

import java.util.HashMap;
import java.util.Map;

public class FreeMarkerResponse
{
    private String template;

    private Map<String, Object> data;

    public FreeMarkerResponse(String template)
    {
        this(template, new HashMap<>());
    }

    public FreeMarkerResponse(String template, Map<String, Object> data)
    {
        this.template = template;
        this.data = data;
    }

    public String getTemplate()
    {
        return template;
    }

    public Map<String, Object> getData()
    {
        return data;
    }
}
