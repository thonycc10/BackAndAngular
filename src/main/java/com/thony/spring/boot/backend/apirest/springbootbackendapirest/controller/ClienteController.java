package com.thony.spring.boot.backend.apirest.springbootbackendapirest.controller;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Cliente;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Region;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.service.ClienteService;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.service.IUploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteController  {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private IUploadFileService iUploadFileService;

    private final Logger log = LoggerFactory.getLogger(ClienteController.class);

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }


    @GetMapping("/clientes/page/{page}")
    public Page<Cliente> index(@PathVariable Integer page){
        Pageable pageable = PageRequest.of(page, 4);
        return clienteService.findAll(pageable);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> getFindById(@PathVariable Long id){
        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();
        try {
            cliente = clienteService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cliente == null) {
            response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> save(@Valid @RequestBody Cliente cliente, BindingResult result) {
        Cliente cliente1 = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            /* List<String> errors = new ArrayList<>();

            for (FieldError err: result.getFieldErrors()) {
                    errors.add("El campo '" + err.getField() + "' " + err.getDefaultMessage());
            } version jdk8*/
            // manejo de errores lamda
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("Errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            cliente1 = clienteService.save(cliente);
        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido creado con exito");
        response.put("cliente", cliente1);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    public  ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result,
                           @PathVariable Long id) {
        Cliente cliente1 = null;
        Cliente clienteActual = clienteService.findById(id);

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            // manejo de errores lamda
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("Errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (clienteActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.NOT_FOUND);
        }

        try {
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setName(cliente.getName());
            clienteActual.setEmail(cliente.getEmail());
            clienteActual.setCreateAt(cliente.getCreateAt());
            clienteActual.setRegion(cliente.getRegion());
            cliente1 = clienteService.save(clienteActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el cliente en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido modificado con exito");
        response.put("cliente", cliente1);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @DeleteMapping("/clientes/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cliente cliente = clienteService.findById(id);
            String nombreFotoAnterior = cliente.getFoto();

            iUploadFileService.eliminar(nombreFotoAnterior);

            clienteService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/clientes/upload")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo,
                                    @RequestParam("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Cliente cliente = clienteService.findById(id);
        if (!archivo.isEmpty()) {
            String nombreArchivo = null;
            try {
                nombreArchivo = iUploadFileService.copiar(archivo);
            } catch (IOException e) {
                response.put("mensaje", "Error al subir imagen del cliente ");
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreFotoAnterior = cliente.getFoto();

            iUploadFileService.eliminar(nombreFotoAnterior);

//            cliente.setFoto(nombreArchivo);
            clienteService.save(cliente);

            response.put("cliente", cliente);
//            response.put("mensaje", "Has subido correctemente la imagen: " + nombreArchivo);

        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/img/{nombreFoto:.+}") // :.+ para añadir un formato al string
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {

        Resource recurso = null;
        try {
            recurso =  iUploadFileService.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders cabecera = new HttpHeaders();
        // para mostrar la descarga de la imagen
       cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
        return new ResponseEntity<Resource>(cabecera, HttpStatus.OK);
    }

    @GetMapping("/clientes/regiones")
    public List<Region> listarRegiones() {
        return clienteService.findAllRegiones();
    }
}
