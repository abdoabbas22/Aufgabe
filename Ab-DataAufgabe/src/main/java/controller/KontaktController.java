package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KontaktController {

	@Autowired
	KontService kontServ;

	@GetMapping("/AlleKontakt")
	public Iterable<Kontakt> getAllKontakts() {
		return kontServ.getAllKontakt();

	}

	@GetMapping("/KontaktById")
	public ResponseEntity<Kontakt> getKontaktById(@RequestParam long id) {
		Optional<Kontakt> kontakt = Optional.ofNullable(kontServ.findById(id));

		if (kontakt.isPresent()) {
			return new ResponseEntity<Kontakt>(kontakt.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Kontakt>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/addkontakt")
	public ResponseEntity<Kontakt> addKontakt(@RequestBody Kontakt kontakt) {
		long id = kontakt.getId();
		Optional<Kontakt> kontaktDb = Optional.ofNullable(kontServ.findById(id));

		if (kontaktDb.isEmpty()) {
			kontServ.createKontakt(kontakt);
			return new ResponseEntity<Kontakt>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Kontakt>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/updatekontakt")
	public ResponseEntity<Kontakt> updateKontakt(@RequestBody Kontakt kontakt) {
		long id = kontakt.getId();
		Optional<Kontakt> kontaktDb = Optional.ofNullable(kontServ.findById(id));

		if (kontaktDb.isPresent()) {
			Kontakt kDb = kontaktDb.get();
			kDb.setId(kontakt.getId());
			kDb.setAnrede(kontakt.getAnrede());
			kDb.setVornme(kontakt.getVornme());
			kDb.setNachname(kontakt.getNachname());
			kDb.setStrasse(kontakt.getStrasse());
			kDb.setHausNo(kontakt.getHausNo());
			kDb.setPlz(kontakt.getPlz());
			kDb.setEmail(kontakt.getEmail());

			return new ResponseEntity<Kontakt>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Kontakt>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/deleteKontakt")
	public ResponseEntity<Kontakt> deleteKontaktById(@RequestParam long id) {
		Optional<Kontakt> kontakt = Optional.ofNullable(kontServ.findById(id));

		if (kontakt.isPresent()) {
			kontServ.deleteById(id);
			return new ResponseEntity<Kontakt>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Kontakt>(HttpStatus.NOT_FOUND);
		}

	}
}
