/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.managesoft.services;

import co.edu.unicauca.managesoft.entities.Usuario;
import co.edu.unicauca.managesoft.infra.MyException;

/**
 *
 * @author jutak
 */
public class LogInValidation {

    private Usuario usuario;

    public LogInValidation(Usuario nuevoUsuario) {
        this.usuario = nuevoUsuario;
    }

    public void camposNoVacios() throws MyException  {
        if (usuario.getNombreUsuario().isBlank()|| usuario.getContrasenaUsuario().isBlank() || usuario.getTipoUsuario().equals(null)) {
            throw new MyException("Todos los campos deben rellenarse");
        }
    }
}
