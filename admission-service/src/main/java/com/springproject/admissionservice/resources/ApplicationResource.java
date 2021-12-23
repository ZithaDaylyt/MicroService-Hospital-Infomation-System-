package com.springproject.admissionservice.resources;

import com.springproject.admissionservice.model.DiseasesList;
import com.springproject.admissionservice.model.EmployeeList;
import com.springproject.admissionservice.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admissions")
public class ApplicationResource {

    @Autowired
    private RestTemplate restTemplate;

    List<Patient> patients = Arrays.asList(
            new Patient("p1", "Zingah", "Bots"),
            new Patient("p2", "Daylyt", "USA"),
            new Patient("p3", "SnowWhite", "UK")
    );

    @RequestMapping("/physicians")
    public EmployeeList getPhysicians(){

       EmployeeList employeeList = restTemplate.getForObject("http://hr-service/hr/employees", EmployeeList.class);
        return employeeList;
    }

    @RequestMapping("/diseases")
    public DiseasesList getDiseases(){

        DiseasesList diseasesList = restTemplate.getForObject("http://pathology-service-ms/pathology/diseases",DiseasesList.class);
        return diseasesList;
    }

    @RequestMapping("/patients")
    public List<Patient> getPatients(){


        return patients;
    }
    @RequestMapping("/patients/{Id}")
    public  Patient getPatientById(@PathVariable("Id") String Id){
        //
        Patient p = patients.stream()
                .filter(patient -> Id.equals(patient.getId()))
                .findAny()
                .orElse(null);
        return p;
    }
}
