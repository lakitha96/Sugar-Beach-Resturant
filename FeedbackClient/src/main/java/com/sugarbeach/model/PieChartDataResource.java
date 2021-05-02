package com.sugarbeach.model;

import java.util.List;

public class PieChartDataResource {
    public List<String> labels;
    private List<Datasets> datasets;

    public PieChartDataResource() {
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Datasets> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Datasets> datasets) {
        this.datasets = datasets;
    }

    public static class Datasets {
        private List<Integer> data;

        public Datasets() {
        }

        public List<Integer> getData() {
            return data;
        }

        public void setData(List<Integer> data) {
            this.data = data;
        }
    }
}
