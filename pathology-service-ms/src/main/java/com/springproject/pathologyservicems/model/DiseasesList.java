package com.springproject.pathologyservicems.model;

import java.util.List;

public class DiseasesList {

    private List<Disease> diseases;

    public DiseasesList() {
    }

    public DiseasesList(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
}
