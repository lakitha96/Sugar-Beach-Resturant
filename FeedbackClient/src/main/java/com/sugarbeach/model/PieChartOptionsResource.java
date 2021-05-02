package com.sugarbeach.model;

public class PieChartOptionsResource {
    private PluginsResource plugins;

    public PieChartOptionsResource() {
    }

    public PluginsResource getPlugins() {
        return plugins;
    }

    public void setPlugins(PluginsResource plugins) {
        this.plugins = plugins;
    }

    @Override
    public String toString() {
        return "PieChartOptionsResource{" +
                "plugins=" + plugins +
                '}';
    }
}
