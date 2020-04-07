package com.thony.spring.boot.backend.apirest.springbootbackendapirest.service;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.dao.ClienteDao;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Cliente;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class IUploadFileServiceImpl implements IUploadFileService {
    private final Logger log = LoggerFactory.getLogger(IUploadFileServiceImpl.class);
    private final static String DIRECTORIO_UPLOAD = "uploads";

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public Resource cargar(String nombreFoto) throws MalformedURLException {
        Path rutaArchivo =  getPath(nombreFoto);
        log.info(rutaArchivo.toString());
        Resource recurso = null;
        recurso = new UrlResource(rutaArchivo.toUri());
        if (!recurso.exists() && !recurso.isReadable()) {
            rutaArchivo = Paths.get("src/main/resources/static/imagen").resolve("notUser.png").toAbsolutePath();
            recurso = new UrlResource(rutaArchivo.toUri());
            log.error("Error no se pudo cargar la imagen: " + nombreFoto);
        }
        return recurso;
    }

    @Override
    public String copiar(MultipartFile archivo) throws IOException {
        String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
        Path rutaArchivo = getPath(nombreArchivo); // se añade un uri C://Temp//uploads
        log.info(rutaArchivo.toString());

        Files.copy(archivo.getInputStream(), rutaArchivo); // aqio añade la imagen y lo posiciona en la ruta

        return nombreArchivo;
    }

    @Override
    public boolean eliminar(String nombreFoto) {
        if (nombreFoto != null && nombreFoto.length() > 0) {
            // verifica la foto similiar y chanca
            Path rutaFotoAnterior = getPath(nombreFoto);
            // lo convertimos en file
            File archivoFotoAnterior = rutaFotoAnterior.toFile();
            // validar que el archivo existe y se pueda leer
            if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
                archivoFotoAnterior.delete();
                return true;
            }
        }
        return false;
    }

    @Override
    public Path getPath(String nombreFoto) {
        return Paths.get(DIRECTORIO_UPLOAD).resolve(nombreFoto).toAbsolutePath(); // se añade un uri C://Temp//uploads
    }

    @Override
    public String getRepo(String typeReport) throws FileNotFoundException, JRException {
        List<Cliente> clientes = clienteDao.findAll();
        File file = ResourceUtils.getFile("classpath:report1.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clientes);
        Map<String, Object> map= new HashMap<>();
        map.put("createBy", "Thony tu papu");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);
        if (typeReport.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:\\codigo\\JasperCurso\\reportGenerados"+"\\clienteRepo.html");
        }
        if (typeReport.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\codigo\\JasperCurso\\reportGenerados"+"\\clienteRepo.pdf");
        }
        return "report generate";
    }


}
