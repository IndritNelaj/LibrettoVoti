package it.polito.tdp.LibrettoVoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.LibrettoVoti.model.Libretto;
import it.polito.tdp.LibrettoVoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
    private DatePicker pickerEsame;
	//private TextField txtData;

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
		int votoInt = 0;
		try {
		votoInt = Integer.parseInt(votoEsame);
		}
		catch (NumberFormatException ex){
			txtResult.setText("Errore - il voto deve essere numerico !");
			return ;
		}
		if(votoInt<18 || votoInt>30) {
			txtResult.setText("Errore - il voto deve essere compreso tra 18 e 30 !");
			return ;
		}
		//String dataEsame = txtData.getText();
		//LocalDate data ;
		//try {
		// data = LocalDate.parse(dataEsame);
		//}
		//catch(DateTimeParseException ex) {
		//	txtResult.setText("Errore - il formato della data è errato");
		//	return ;
		//}
		LocalDate data = pickerEsame.getValue();
		if(data == null) {
			txtResult.setText("Errore - la data è errata o mancante!");
			return ;
		}

		// esegui l'azione
		Voto voto = new Voto(nomeEsame, votoInt, data);
		model.add(voto);

		// aggiorna i dati nella view
		txtResult.setText(model.toString());
		txtEsame.clear();
		txtVoto.clear();
		//txtData.clear();

	}

	public void setModel(Libretto model) {
		this.model = model;
	}

	@FXML
	void initialize() {
		assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

	}
}
