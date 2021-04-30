package com.platform3.demoproject.controller;

import com.platform3.demoproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/v1/demo/upload-data")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity uploadData(@RequestParam("file") MultipartFile file) throws Exception{
        String resp = fileService.uploadFile(file);
        if(resp.equalsIgnoreCase("badRequest")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
