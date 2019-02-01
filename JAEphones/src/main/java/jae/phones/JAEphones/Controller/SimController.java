package jae.phones.JAEphones.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jae.phones.JAEphones.Repository.SimRepository;
import jae.phones.JAEphones.Exception.ResourceNotFoundException;
import jae.phones.JAEphones.Model.Sim;

@RestController
@RequestMapping("/api/business")
public class SimController {

    @Autowired
    private SimRepository simRepository;

    @GetMapping("/sims")
    public List<Sim> findAll() {
        return simRepository.findAll();
    }

    @GetMapping("/sims/{id}")
    public Sim findById(@PathVariable(value = "id") Long id) {
        return simRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sim", "id", id));
    }

    @PostMapping("/sims")
    public Sim add(@Valid @RequestBody Sim sim) {
        return simRepository.save(sim);
    }

    @PutMapping("/sims/{id}")
    public Sim update(@PathVariable(value = "id") Long id, @Valid @RequestBody Sim sim) {
        Sim dbSim = simRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sim", "id", id));
        dbSim.setPhoneNumber(sim.getPhoneNumber());

        return simRepository.save(dbSim);
    }

    @DeleteMapping("/sims/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Sim sim = simRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sim", "id", id));
        simRepository.delete(sim);

        return ResponseEntity.ok().build();
    }
}
