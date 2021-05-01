/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sugarbeach.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author lakitha
 */
public class QuickChartClientService {

    public void generateChart() throws UnirestException {
        HttpResponse<String> response = Unirest.post("https://quickchart.io/chart")
                .header("Content-Type", "application/json")
                .body("{\n  \"backgroundColor\": \"#fff\",\n  \"width\": 500,\n  \"height\": 300,\n  \"devicePixelRatio\": 1.0,\n  \"chart\": {\n    \"type\": \"pie\",\n    \"data\": {\n        \"labels\": [\n            \"January\",\n            \"February\",\n            \"March\",\n            \"April\",\n            \"May\"\n        ],\n        \"datasets\": [\n            {\n                \"data\": [\n                    50,\n                    60,\n                    70,\n                    180,\n                    190\n                ]\n            }\n        ]\n    }\n  }\n}")
                .asString();
        System.out.println(response.getStatus());

    }
}
