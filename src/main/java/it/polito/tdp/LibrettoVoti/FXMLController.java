package it.polito.tdp.LibrettoVoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.LibrettoVoti.model.Libretto;
import it.polito.tdp.LibrettoVoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Libretto model;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtEsame;

	@FXML
	private TextField txtVoto;

	@FXML
	private TextField txtData;

	@FXML
	private TextArea txtResult;

	@FXML
	void HandleInserisci(ActionEvent event) {
		// controlla e gestisci i dati inseriti

		String nomeEsame = txtEsame.getText();
		if (nomeEsame.length() == 0) {
			txtResult.setText("Errore - inserire il nome dell'esame !");
			return;
		}
		String votoEsame = txtVoto.getText();
		int votoInt = Integer.parseInt(votoEsame);
		String dataEsame = txtData.getText();
		LocalDate data = LocalDate.parse(dataEsame);
		

		// esegui l'azione
		Voto voto = new Voto(nomeEsame, votoInt, data);
		model.add(voto);

		// aggiorna i dati nella view
		txtResult.setText(model.toString());

	}

	public void setModel(Libretto model) {
		this.model = model;
	}

	@FXML
	void initialize() {
		assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

	}
}
