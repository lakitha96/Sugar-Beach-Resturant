/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sugarbeach.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sugarbeach.model.*;
import com.sugarbeach.resource.FeedbackReportResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author lakitha
 */
public class QuickChartController {
    public static final int DEFAULT_BUFFER_SIZE = 8192;

    /**
     * This method will bind all data as per needed to create PieChart
     *
     * @param feedbackReportResource {@link FeedbackReportResource}
     * @return File
     */
    public File bindData(FeedbackReportResource feedbackReportResource) throws UnirestException, IOException {
        PieChartResource pieChartResource = new PieChartResource();
        pieChartResource.setBackgroundColor("#fff");
        pieChartResource.setWidth(900);
        pieChartResource.setHeight(500);
        pieChartResource.setDevicePixelRatio(1.0);
        pieChartResource.setFormat("png");

        QuickChartResource quickChartResource = new QuickChartResource();
        quickChartResource.setType("doughnut");

        PieChartDataResource dataResource = new PieChartDataResource();
        List<String> labelList = feedbackReportResource.getAnswerReportResources().stream().map(FeedbackReportResource.FeedbackAnswerReportResource::getAnswer).collect(Collectors.toList());
        dataResource.setLabels(labelList);

        PieChartDataResource.Datasets datasets = new PieChartDataResource.Datasets();
        List<Integer> countList = feedbackReportResource.getAnswerReportResources().stream().map(FeedbackReportResource.FeedbackAnswerReportResource::getAnswerCount).collect(Collectors.toList());
        datasets.setData(countList);

        List<PieChartDataResource.Datasets> datasetsList = new ArrayList<>();
        datasetsList.add(datasets);

        dataResource.setDatasets(datasetsList);

        quickChartResource.setData(dataResource);

        PieChartOptionsResource optionsResource = new PieChartOptionsResource();
        PluginsResource pluginsResource = new PluginsResource();

        DoughnutLabelResource labelResource = new DoughnutLabelResource();

        DoughnutLabelResource.LabelResource dLabel = new DoughnutLabelResource.LabelResource();
        dLabel.setText(feedbackReportResource.getQuestion());

        List<DoughnutLabelResource.LabelResource> doughnutLabelList = new ArrayList<>();
        doughnutLabelList.add(dLabel);

        labelResource.setLabels(doughnutLabelList);
        pluginsResource.setDoughnutlabel(labelResource);

        optionsResource.setPlugins(pluginsResource);
        quickChartResource.setOptions(optionsResource);
        pieChartResource.setChart(quickChartResource);
        return generateChart(pieChartResource);
    }

    /**
     * This method will convert any object to json string
     *
     * @param object
     * @return json string
     */
    private String getJsonString(Object object) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(object);
    }

    /**
     * This method used to generate chart using external api.
     * https://quickchart.io
     * <p>
     * QuickChart is a web service that generates chart images on-the-fly.
     * Once report is generated it will be open with report viewer form.
     *
     * @param pieChartResource {@link PieChartResource}
     * @return File
     */
    public File generateChart(PieChartResource pieChartResource) throws UnirestException, IOException {
        HttpResponse<String> response = Unirest.post("https://quickchart.io/chart")
                .header("Content-Type", "application/json")
                .body(getJsonString(pieChartResource))
                .asString();
        InputStream input = response.getRawBody();

        //create file on system
        Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/reports"));
        File file = new File(System.getProperty("user.dir") + "/reports/" + UUID.randomUUID() + ".png");
        copyInputStreamToFile(input, file);
        return file;
    }

    /**
     * This method will convert input stream to a file.
     *
     * @param inputStream {@link InputStream}
     * @param file        {@link File}
     */
    private static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }
}
