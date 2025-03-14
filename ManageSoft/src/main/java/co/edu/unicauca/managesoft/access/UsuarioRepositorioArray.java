/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.managesoft.access;

import co.edu.unicauca.managesoft.entities.Usuario;
import co.edu.unicauca.managesoft.entities.enumTipoUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jutak
 */
public class UsuarioRepositorioArray implements IUsuarioRepositorio {
    public static List<Usuario> usuariosArray;
    
    public UsuarioRepositorioArray() {
        usuariosArray = new ArrayList();
        usuariosArray.add(new Usuario("coordinador1", "pass123", enumTipoUsuario.COORDINADOR));
        usuariosArray.add(new Usuario("estudiante1", "pass456", enumTipoUsuario.ESTUDIANTE));
        usuariosArray.add(new Usuario("empresa1", "pass789", enumTipoUsuario.EMPRESA));
        usuariosArray.add(new Usuario("estudiante2", "pass101", enumTipoUsuario.ESTUDIANTE));
        usuariosArray.add(new Usuario("empresa2", "pass202", enumTipoUsuario.EMPRESA));
    }
    
    @Override
    public boolean guardar(Usuario nuevoUsuario) {
        if (!existeUsuario(nuevoUsuario.getNombreUsuario())){
            usuariosArray.add(nuevoUsuario);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean autenticarInicioSesion(String nombreUsuario, String contrasenaUsuario) {
        for (Usuario usuario: usuariosArray){
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasenaUsuario().equals(contrasenaUsuario)){
                return true;
            }
        }
        return false;
    }
    
    // Al iniciar sesion se obtiene una instancia del usuario que ingreso

    /*@Override
    public List<Empresa> listarEmpresas() {
        return empresasArray;
    }*/
    
    private boolean existeUsuario(String nombreUsuario) {
        for (Usuario usuario: usuariosArray){
            if (usuario.getNombreUsuario().equals(nombreUsuario)){
                return true;
            }
        }
        return false;
    }
}
