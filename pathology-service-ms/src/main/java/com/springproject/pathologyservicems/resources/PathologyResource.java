package com.springproject.pathologyservicems.resources;

import com.springproject.pathologyservicems.model.Disease;
import com.springproject.pathologyservicems.model.DiseasesList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
    List<Disease> diseases = Arrays.asList(
            new Disease("d1", "Ashma", "warm water bath"),
            new Disease("d2", "Thyphoid", "Ampicilin capsule!")
    );

    @RequestMapping("/diseases")
    public DiseasesList getDiseases(){
        DiseasesList diseasesList = new DiseasesList();

        diseasesList.setDiseases(diseases);
        return diseasesList;
    }

    @RequestMapping("/diseases/{Id}")
    public Disease getDiseasesById(@PathVariable("Id") String Id){
        Disease d = diseases.stream()
                .filter(disease -> Id.equals(disease.getId()))
                .findAny()
                .orElse(null);

        return d;
    }

}
