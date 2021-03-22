package controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.persistence.Id;

@Entity
public class Kontakt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String anrede;
	@NotBlank
	@Size(min = 3, max = 25, message = "Vorname müssen zwichen  3 und 25 Charakter.")
	private String vornme;
	@NotBlank
	@Size(min = 3, max = 25, message = "Nachname müssen zwichen  3 und 25 Charakter.")
	private String nachname;
	@NotBlank
	private String strasse;
	@NotBlank
	private String hausNo;
	@Size(min = 5, max = 5, message = "PostleitZahl müssen 5 Nummer.")
	private int plz;
	@Email(message = "E-Mail muss eine gültige E-Mail-Adresse haben.")
	private String email;

	public Kontakt(long id, String anrede, String vornme, String nachname, String strasse, String hausNo, int plz,
			String email) {
		super();
		this.id = id;
		this.anrede = anrede;
		this.vornme = vornme;
		this.nachname = nachname;
		this.strasse = strasse;
		this.hausNo = hausNo;
		this.plz = plz;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getVornme() {
		return vornme;
	}

	public void setVornme(String vornme) {
		this.vornme = vornme;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausNo() {
		return hausNo;
	}

	public void setHausNo(String hausNo) {
		this.hausNo = hausNo;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
