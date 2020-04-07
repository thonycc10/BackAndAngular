package com.thony.spring.boot.backend.apirest.springbootbackendapirest.controller;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.service.IUploadFileService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ReporteController {

    public static final String REPORT_1 = "report1.jasper";

    @Autowired
    private IUploadFileService iUploadFileService;

    @GetMapping("/repo/{typeReport}")
    @ResponseStatus(HttpStatus.OK)
    public String getRepo(@PathVariable String typeReport) throws FileNotFoundException, JRException {
        return iUploadFileService.getRepo(typeReport);
    }

}
