package com.controller;

import com.model.District;
import com.model.Province;
import com.model.Ward;
import com.service.DistrictService;
import com.service.ProvinceService;
import com.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json")
public class AddressController {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private WardService wardService;

    @GetMapping("/province")
    public ResponseEntity<List<Province>> listProvince() {
        List<Province> provinces = provinceService.findAll();
        if (provinces.isEmpty()) {
            return new ResponseEntity<List<Province>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Province>>(provinces, HttpStatus.OK);
    }

    @GetMapping("/district")
    public ResponseEntity<List<District>> listDistrict() {
        List<District> districts = districtService.findAll();
        if (districts.isEmpty()) {
            return new ResponseEntity<List<District>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<District>>(districts, HttpStatus.OK);
    }

    @GetMapping("/ward")
    public ResponseEntity<List<Ward>> listWard() {
        List<Ward> wards = wardService.findAll();
        if (wards.isEmpty()) {
            return new ResponseEntity<List<Ward>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Ward>>(wards, HttpStatus.OK);
    }
}
