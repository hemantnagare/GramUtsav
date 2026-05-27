package com.gramutsav.controller;

import com.gramutsav.entity.KhatedarMahiti;
import com.gramutsav.entity.ShareHolder;
import com.gramutsav.repository.KhatedarMahitiRepository;
import com.gramutsav.repository.ShareHolderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shareholder")
@CrossOrigin(origins = "http://localhost:5173")
public class ShareHolderController {

    @Autowired
    private KhatedarMahitiRepository khdmRepository;

    @GetMapping("/mobile/{mobile}")
    public ResponseEntity<List<KhatedarMahiti>> getByMobile(@PathVariable String mobile) {
        System.out.println("mobile:"+mobile);
        List<KhatedarMahiti> list =khdmRepository.findByMobileNo(mobile);
        System.out.println("list:"+list);

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }
}