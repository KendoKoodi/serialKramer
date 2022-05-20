package fi.uef.sarjaliikennekramer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import com.fazecast.jSerialComm.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.ObservableList;


public class PrimaryController implements Initializable{

    @FXML
    private ComboBox<?> cmbBaud;
    @FXML
    private ComboBox<?> cmbPort;
    @FXML
    private ComboBox<?> cmbDataBits;
    @FXML
    private ComboBox<?> cmbStopBits;
    @FXML
    private ComboBox<?> cmbParityBits;
    @FXML
    private ComboBox<?> cmbEndLine;
    @FXML
    private Label lblComStatus;
    @FXML
    private TextArea txtAreaMessage;
    @FXML
    private Button btnSend;
    @FXML
    private TextArea txtAreaResponse;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void btnOpen(ActionEvent event) {
    }

    @FXML
    private void btnClose(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // serial port list
        SerialPort []portList = SerialPort.getCommPorts();
        ArrayList<String> porttiArray = new ArrayList<>();
        for (SerialPort port: portList){
            porttiArray.add(port.getSystemPortName());
        }
        ObservableList oPorttiLista = FXCollections.observableArrayList(porttiArray);
        cmbPort.setItems(oPorttiLista);
        
        
        // baud list
        ObservableList baudiLista = FXCollections.observableArrayList(
                "4800",
                "9600",
                "38400",
                "57600",
                "115200"
        );
        cmbBaud.setItems(baudiLista);
        cmbBaud.getSelectionModel().select(1);
        
        
        // databits
        ObservableList databitsLista = FXCollections.observableArrayList(
                "6",
                "7",
                "8"
        );
        cmbDataBits.setItems(databitsLista);
        cmbDataBits.getSelectionModel().select(2);
        
        
        // stop bits list
        ObservableList stopBitsLista = FXCollections.observableArrayList(
                "1",
                "1.5",
                "2"
        );
        cmbStopBits.setItems(stopBitsLista);
        cmbStopBits.getSelectionModel().select(0);
        
        
        // parity bits list
        ObservableList parityBitsLista = FXCollections.observableArrayList(
                "NO_PARITY",
                "EVEN_PARITY",
                "ODD_PARITY",
                "MARK_PARITY",
                "SPACE_PARITY"
        );
        cmbParityBits.setItems(parityBitsLista);
        cmbParityBits.getSelectionModel().select(0);
        
        
        // end of line list
        ObservableList endLineLista = FXCollections.observableArrayList(
                "None",
                "New Line (\\n)",
                "Carriage Return (\\r)",
                "Both (\\r\\n)"
        );
        cmbEndLine.setItems(endLineLista);
        cmbEndLine.getSelectionModel().select(0);
    }
}
