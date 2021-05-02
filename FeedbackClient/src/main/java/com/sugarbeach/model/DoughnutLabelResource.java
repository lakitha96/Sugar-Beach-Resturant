package com.sugarbeach.model;

import java.util.List;

public class DoughnutLabelResource {
    public List<LabelResource> labels;

    public DoughnutLabelResource() {
    }

    public void setLabels(List<LabelResource> labels) {
        this.labels = labels;
    }

    public List<LabelResource> getLabels() {
        return labels;
    }

    public static class LabelResource{
        private String text;

        public LabelResource() {
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "LabelResource{" +
                    "text='" + text + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DoughnutLabelResource{" +
                "labels=" + labels +
                '}';
    }
}
