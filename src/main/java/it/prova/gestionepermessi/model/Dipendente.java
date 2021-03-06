package it.prova.gestionepermessi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "dipendente", uniqueConstraints = @UniqueConstraint(columnNames = { "utente_id" }))
public class Dipendente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Size(min = 16, max = 16)
	@Column(name = "cf")
	private String codFis;
	@Column(name = "email")
	private String email;
	@Column(name = "dataNascita")
	private Date dataNascita;
	@Column(name = "dataAssunzione")
	private Date dataAssunzione;
	@Column(name = "dataDimissione")
	private Date dataDimissione;
	@Column(name = "sesso")
	@Enumerated(EnumType.STRING)
	private Sesso sesso;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "utente_id", referencedColumnName = "id")
	private Utente utente;

	@OneToMany(mappedBy = "dipendente")
	private List<RichiestaPermesso> richiestaPermesso = new ArrayList<RichiestaPermesso>();

	public Dipendente() {
	}

	public Dipendente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public Dipendente(String nome, String cognome, String codFis, String email, Date dataNascita, Date dataAssunzione,
			Date dataDimissione, Sesso sesso) {

		
		this.nome = nome;
		this.cognome = cognome;
		this.codFis = codFis;
		this.email = email;
		this.dataNascita = dataNascita;
		this.dataAssunzione = dataAssunzione;
		this.dataDimissione = dataDimissione;
		this.sesso = sesso;
		this.utente = utente;
		this.richiestaPermesso = richiestaPermesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodFis() {
		return codFis;
	}

	public void setCodFis(String codFis) {
		this.codFis = codFis;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public Date getDataDimissione() {
		return dataDimissione;
	}

	public void setDataDimissione(Date dataDimissione) {
		this.dataDimissione = dataDimissione;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RichiestaPermesso> getRichiestaPermesso() {
		return richiestaPermesso;
	}

	public void setRichiestaPermesso(List<RichiestaPermesso> richiestaPermesso) {
		this.richiestaPermesso = richiestaPermesso;
	}
	
	public String getNominativo() {
		return this.nome + " " + this.cognome;
	}

}
