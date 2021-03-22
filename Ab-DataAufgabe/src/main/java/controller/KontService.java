package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KontService {

	@Autowired
	KontaktRepo repo;

	public Iterable<Kontakt> getAllKontakt() {
		return repo.findAll();

	}

	public Kontakt findById(long id) {
		Optional<Kontakt> kontakt = repo.findById(id);

		if (kontakt.isPresent()) {
			return kontakt.get();
		} else {
			return null;
		}
	}

	public void createKontakt(Kontakt kontakt) {
		repo.save(kontakt);

	}

	public void deleteById(long id) {
		repo.deleteById(id);

	}
}
