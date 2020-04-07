package com.thony.spring.boot.backend.apirest.springbootbackendapirest.service;

import net.sf.jasperreports.engine.JRException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileService {
    public Resource cargar(String nombreFoto) throws MalformedURLException;
    public String copiar(MultipartFile archivo) throws IOException;
    public boolean eliminar(String nombreFoto);
    public Path getPath(String nombreFoto);
    public String getRepo(String typeReport) throws FileNotFoundException, JRException;
}
