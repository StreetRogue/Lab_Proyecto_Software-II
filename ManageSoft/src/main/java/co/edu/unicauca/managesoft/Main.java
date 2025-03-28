package co.edu.unicauca.managesoft;

import co.edu.unicauca.managesoft.access.Factory;
import co.edu.unicauca.managesoft.access.ICoordinadorRepositorio;
import co.edu.unicauca.managesoft.access.IEmpresaRepositorio;
import co.edu.unicauca.managesoft.access.IEstudianteRepositorio;
import co.edu.unicauca.managesoft.access.INotificacionRepositorio;
import co.edu.unicauca.managesoft.access.IProyectoRepositorio;
import co.edu.unicauca.managesoft.access.IUsuarioRepositorio;
import co.edu.unicauca.managesoft.access.Repositorio;
import static co.edu.unicauca.managesoft.access.Repositorio.repositorioCorreo;
import co.edu.unicauca.managesoft.services.LogInServices;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX Main
 */

public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
//        IEmpresaRepositorio repositorioEmpresa = Factory.getInstancia().getRepositorioEmpresa("ARRAYS");
//        ICoordinadorRepositorio repositorioCoordinador = Factory.getInstancia().getRepositorioCoordinador("ARRRAYS");
//        IEstudianteRepositorio repositorioEstudiante = Factory.getInstancia().getRepositorioEstudiante("ARRAYS");
//        IUsuarioRepositorio repositorioUsuarios = Factory.getInstancia().getRepositorioUsuario("ARRAYS");
        
        IUsuarioRepositorio repositorioUsuarios = Factory.getInstancia().getRepositorioUsuario("NEONDB");
        IEmpresaRepositorio repositorioEmpresa = Factory.getInstancia().getRepositorioEmpresa("NEONDB");
        ICoordinadorRepositorio repositorioCoordinador = Factory.getInstancia().getRepositorioCoordinador("NEONDB");
        IEstudianteRepositorio repositorioEstudiante = Factory.getInstancia().getRepositorioEstudiante("NEONDB");
        IProyectoRepositorio repositorioProyectos = Factory.getInstancia().getRepositorioProyecto("NEONDB");
        INotificacionRepositorio repositorioCorreo = Factory.getInstancia().getNotificacionRepositorio("NEONDB");
        
        Repositorio repositorio = new Repositorio(repositorioUsuarios, repositorioEmpresa, repositorioCoordinador, repositorioEstudiante, repositorioProyectos, repositorioCorreo);
        
        repositorioUsuarios.setRepositorioEmpresa(repositorioEmpresa);
        repositorioUsuarios.setRepositorioCoordinador(repositorioCoordinador);
        repositorioUsuarios.setRepositorioEstudiante(repositorioEstudiante);
        repositorioUsuarios.setRepositorioProyecto(repositorioProyectos);
        repositorioEmpresa.setRepositorioProyecto(repositorioProyectos);
        repositorioUsuarios.setRepositorioCorreo(repositorioCorreo);
        
        LogInServices loginServices = new LogInServices(repositorioUsuarios);
        
        // Crear una instancia del controlador personalizado
        UserLoginController userLoginController = new UserLoginController(repositorio, loginServices);

        // Cargar la vista con el controlador configurado
        Parent root = loadFXML("UserLoginVista", userLoginController);
        scene = new Scene(root); // Inicializar la escena

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    static void setRoot(String fxml, Object controller) throws IOException {
        Parent root = loadFXML(fxml, controller); // Llamar al método con un controlador
        scene.setRoot(root); // Establecer el nuevo root
    }

    private static Parent loadFXML(String fxml, Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        if (controller != null) {
            fxmlLoader.setController(controller);
        }
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        //DATOS DE PARA INICIAR SESION
        /*
        ESTUDIANTE:
        Usuario: estudiante1
        Contraseña: clave123
        EMPRESA:
        Usuario: empresa1
        Contraseña: contra123
        Coordinador
        Usuario: coord1
        Contraseña: contrasegura1
        */
    }
}
