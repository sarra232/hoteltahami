package com.hoteltahami.analisis.api.controlador;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteltahami.analisis.api.dto.EmployedDTO;
import com.hoteltahami.analisis.api.mapping.EmployedMapper;
import com.hoteltahami.analisis.api.modelo.Employed;
import com.hoteltahami.analisis.api.modelo.Person;
import com.hoteltahami.analisis.api.service.EmployedService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/empleado")
public class EmployedController {
private static Logger log = LoggerFactory.getLogger(EmployedController.class);
	
	private EmployedService employedService;
	
	public EmployedController(EmployedService employedService) {
		this.employedService = employedService;
	}
	

	@GetMapping("listar")
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los personas fueron buscadas", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<Employed>> getEmployed(){
		log.debug("REST request listar todos las personas");
		return ResponseEntity.ok(employedService.getEmployed());		
	}
	
	@GetMapping(value = "buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar empleado", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personas registradas", response = Person.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<EmployedDTO>> getEmployed( @PathVariable("rol") String rol){
		 log.debug("REST request getProyecto estado : {}", rol);
		return ResponseEntity.ok(EmployedMapper.ListAsEmployedDTO(employedService.searchEmployedByRol(rol)));
	}
	
	@PostMapping(value = "crearPersona", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "crea una persona", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Proyecto creado", response = Person.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Employed> addEmployed( @RequestBody Employed data){
		Employed employed = new Employed(data.getRol(), data.getStatus());
		employedService.addEmployed(employed);
		return new ResponseEntity<Employed>(employed, HttpStatus.OK);
	}
	@PutMapping(value = "actualizarPersona", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "actualizar persona", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Datos actualizados", response = Employed.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no actualizado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Employed> getEmployedUpdate(@RequestBody Employed data ){
		Employed persona=new Employed(data.getRol(), data.getStatus());
		employedService.updateEmployed(persona);
		return new ResponseEntity<Employed>(persona, HttpStatus.OK);
	}
	
	@GetMapping(value = "consultar/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar proyecto por nombre", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "proyecto encontrado", response = Person.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<Employed>> searchPersonByEmail( @PathVariable("name") String name){
		 log.debug("REST request getEmployed name : {}", name);
		return ResponseEntity.ok(employedService.searchEmployedByName(name));
		
	}public void createEmployed() {
		 
	}
}
