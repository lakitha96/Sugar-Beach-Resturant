package com.sugarbeach.model;

import java.util.List;

public class QuickChartResource {
    public String type;
    public PieChartDataResource data;
    public PieChartOptionsResource options;

    public QuickChartResource() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PieChartDataResource getData() {
        return data;
    }

    public void setData(PieChartDataResource data) {
        this.data = data;
    }

    public PieChartOptionsResource getOptions() {
        return options;
    }

    public void setOptions(PieChartOptionsResource options) {
        this.options = options;
    }
}
