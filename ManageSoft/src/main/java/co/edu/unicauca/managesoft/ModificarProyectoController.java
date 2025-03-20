package co.edu.unicauca.managesoft;

import co.edu.unicauca.managesoft.access.INotificacionRepositorio;
import co.edu.unicauca.managesoft.access.IProyectoRepositorio;
import co.edu.unicauca.managesoft.entities.Coordinador;
import co.edu.unicauca.managesoft.entities.EstadoAceptado;
import co.edu.unicauca.managesoft.entities.EstadoCerrado;
import co.edu.unicauca.managesoft.entities.EstadoEnEjecucion;
import co.edu.unicauca.managesoft.entities.EstadoRechazado;
import co.edu.unicauca.managesoft.entities.EstadoRecibido;
import co.edu.unicauca.managesoft.entities.IEstadoProyecto;
import co.edu.unicauca.managesoft.entities.Proyecto;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author juane
 */
public class ModificarProyectoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private IProyectoRepositorio repositorioProyecto;
    private INotificacionRepositorio repositorioCorreo;
    private Coordinador coordinador;
    private Proyecto proyecto;

    public ModificarProyectoController(IProyectoRepositorio repositorioProyecto, INotificacionRepositorio repositorioCorreo, Coordinador coordinador, Proyecto proyecto) {
        this.repositorioProyecto = repositorioProyecto;
        this.repositorioCorreo = repositorioCorreo;
        this.coordinador = coordinador;
        this.proyecto = proyecto;
    }

    @FXML
    private Label lblEstadoActualProyecto;

    @FXML
    private ComboBox<IEstadoProyecto> cboEstadoProyecto;

    @FXML
    private TextArea txtComentario;

    @FXML
    private Button btnModificarDatos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<IEstadoProyecto> estados = Arrays.asList(
                new EstadoRecibido(),
                new EstadoAceptado(),
                new EstadoRechazado(),
                new EstadoEnEjecucion(),
                new EstadoCerrado()
        );

        ObservableList<IEstadoProyecto> listaEstados = FXCollections.observableArrayList();
        listaEstados.addAll(estados);
        cboEstadoProyecto.setItems(listaEstados);

        // Asegurar que se muestre correctamente el nombre del estado en el ComboBox
        cboEstadoProyecto.setCellFactory(param -> new javafx.scene.control.ListCell<IEstadoProyecto>() {
            @Override
            protected void updateItem(IEstadoProyecto estado, boolean empty) {
                super.updateItem(estado, empty);
                setText(empty || estado == null ? "" : estado.obtenerEstado());
            }
        });

        // Configurar el elemento seleccionado para que también muestre correctamente el estado
        cboEstadoProyecto.setButtonCell(new javafx.scene.control.ListCell<IEstadoProyecto>() {
            @Override
            protected void updateItem(IEstadoProyecto estado, boolean empty) {
                super.updateItem(estado, empty);
                setText(empty || estado == null ? "" : estado.obtenerEstado());
            }
        });

        if (proyecto != null) {
            lblEstadoActualProyecto.setText(proyecto.getEstadoProyecto().obtenerEstado());
        }
    }

//    @FXML
//    private void modificarDatos() {
//        IEstadoProyecto nuevoEstado = cboEstadoProyecto.getValue();
//        String comentario = txtComentario.getText();
//
//        if (nuevoEstado == null) {
//            mostrarAlerta("Error", "Seleccione un estado válido", Alert.AlertType.ERROR);
//            return;
//        }
//
//        // Cambiar el estado del proyecto
//        proyecto.setEstadoProyecto(nuevoEstado);
//
//        // Actualizar el estado en la base de datos
//        //boolean actualizado = repositorioProyecto.actualizarEstadoProyecto(proyecto.getIdProyecto(), nuevoEstado.obtenerEstado(), comentario);
//
//        if (actualizado) {
//            mostrarAlerta("Éxito", "Estado actualizado correctamente", Alert.AlertType.INFORMATION);
//
//            // Cerrar la ventana
//            Stage stage = (Stage) btnModificarDatos.getScene().getWindow();
//            stage.close();
//        } else {
//            mostrarAlerta("Error", "No se pudo actualizar el estado", Alert.AlertType.ERROR);
//        }
//    }
//
//    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipoAlerta) {
//        Alert alert = new Alert(tipoAlerta);
//        alert.setTitle(titulo);
//        alert.setHeaderText(null);
//        alert.setContentText(mensaje);
//        alert.showAndWait();
//    }

}
