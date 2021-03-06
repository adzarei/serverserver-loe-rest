package adzarei.loe.server.api.controllers.v1;


import adzarei.loe.server.api.domain.Acta;
import adzarei.loe.server.api.dtomodel.ActaDto;
import adzarei.loe.server.api.services.ActaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(ActaController.BASE_URL)
public class ActaController {
    public static final String BASE_URL = "/api/v1/actas";
    public ActaService actaService;

    public ActaController(ActaService actaService) {
        this.actaService = actaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ActaDto> getActasByLibroId(@RequestParam Long libroid){
        return actaService.getActasByLibroId(libroid);
    }

    @GetMapping("/next-numHoja")
    @ResponseStatus(HttpStatus.OK)
    public Integer getNextNumHoja(@RequestParam Long libroid){ return actaService.getNextNumHoja(libroid); }


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Long generarActa(@RequestBody Acta acta){
        return actaService.newActa(acta);
    }
}
