package com.sugarbeach.model;

public class PluginsResource {
    private DoughnutLabelResource doughnutlabel;

    public PluginsResource() {
    }

    public DoughnutLabelResource getDoughnutlabel() {
        return doughnutlabel;
    }

    public void setDoughnutlabel(DoughnutLabelResource doughnutlabel) {
        this.doughnutlabel = doughnutlabel;
    }

    @Override
    public String toString() {
        return "PluginsResource{" +
                "doughnutLabelResource=" + doughnutlabel +
                '}';
    }
}
