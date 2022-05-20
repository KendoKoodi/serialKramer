module fi.uef.sarjaliikennekramer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires com.fazecast.jSerialComm;

    opens fi.uef.sarjaliikennekramer to javafx.fxml;
    exports fi.uef.sarjaliikennekramer;
}
