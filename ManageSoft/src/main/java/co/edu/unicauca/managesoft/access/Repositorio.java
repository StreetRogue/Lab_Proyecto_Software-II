/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.managesoft.access;

import co.edu.unicauca.managesoft.entities.Usuario;
import java.util.List;

/**
 *
 * @author jutak
 */
public class Repositorio {
    public static IUsuarioRepositorio repositorioUsuario;
    public static IEmpresaRepositorio repositorioEmpresa;
    public static ICoordinadorRepositorio repositorioCoordinador;
    public static IEstudianteRepositorio repositorioEstudiante;
    public static IProyectoRepositorio repositorioProyecto;

    public Repositorio(IUsuarioRepositorio repositorioUsuario, IEmpresaRepositorio repositorioEmpresa, ICoordinadorRepositorio repositorioCoordinador, 
            IEstudianteRepositorio repositorioEstudiante, IProyectoRepositorio repositorioProyecto) {
            this.repositorioUsuario = repositorioUsuario;
            this.repositorioEmpresa = repositorioEmpresa;
            this.repositorioCoordinador = repositorioCoordinador;
            this.repositorioEstudiante = repositorioEstudiante;
            this.repositorioProyecto = repositorioProyecto;
    }

    public static IUsuarioRepositorio getRepositorioUsuario() {
        return repositorioUsuario;
    }

    public static void setRepositorioUsuario(IUsuarioRepositorio repositorioUsuario) {
        Repositorio.repositorioUsuario = repositorioUsuario;
    }

    public static IEmpresaRepositorio getRepositorioEmpresa() {
        return repositorioEmpresa;
    }

    public static void setRepositorioEmpresa(IEmpresaRepositorio repositorioEmpresa) {
        Repositorio.repositorioEmpresa = repositorioEmpresa;
    }

    public static ICoordinadorRepositorio getRepositorioCoordinador() {
        return repositorioCoordinador;
    }

    public static void setRepositorioCoordinador(ICoordinadorRepositorio repositorioCoordinador) {
        Repositorio.repositorioCoordinador = repositorioCoordinador;
    }

    public static IEstudianteRepositorio getRepositorioEstudiante() {
        return repositorioEstudiante;
    }

    public static void setRepositorioEstudiante(IEstudianteRepositorio repositorioEstudiante) {
        Repositorio.repositorioEstudiante = repositorioEstudiante;
    }

    public static IProyectoRepositorio getRepositorioProyecto() {
        return repositorioProyecto;
    }

    public static void setRepositorioProyecto(IProyectoRepositorio repositorioProyecto) {
        Repositorio.repositorioProyecto = repositorioProyecto;
    }

    
    
    
}
