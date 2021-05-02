package com.sugarbeach.model;

public class PieChartResource {
    public String backgroundColor;
    public String format;
    public int width;
    public int height;
    public double devicePixelRatio;
    public QuickChartResource chart;

    public PieChartResource() {
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getDevicePixelRatio() {
        return devicePixelRatio;
    }

    public void setDevicePixelRatio(double devicePixelRatio) {
        this.devicePixelRatio = devicePixelRatio;
    }

    public QuickChartResource getChart() {
        return chart;
    }

    public void setChart(QuickChartResource chart) {
        this.chart = chart;
    }

    @Override
    public String toString() {
        return "PieChartModel{" +
                "backgroundColor='" + backgroundColor + '\'' +
                ", format='" + format + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", devicePixelRatio=" + devicePixelRatio +
                ", chart=" + chart +
                '}';
    }
}
