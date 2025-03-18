/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.managesoft.access;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jutak
 */
public class Factory {

    private static Factory instancia;

    private Map<String, IEmpresaRepositorio> repositoriosEmpresa;
    private Map<String, IUsuarioRepositorio> repositoriosUsuario;
    private Map<String, ICoordinadorRepositorio> repositoriosCoordinador;

    private Factory() {
        repositoriosEmpresa = new HashMap<>();
        repositoriosCoordinador = new HashMap<>();
        repositoriosUsuario = new HashMap<>();

        repositoriosEmpresa.put("ARRAYS", new EmpresaRepositorioArray());
        repositoriosEmpresa.put("POSTGRES", new EmpresaRepositorioPG());
        repositoriosEmpresa.put("NEONDB", new EmpresaRepositorioNeonDB());
        repositoriosCoordinador.put("NEONDB", new CoordinadorRepositorioNeonDB());

        repositoriosUsuario.put("ARRAYS", new UsuarioRepositorioArray());
        repositoriosUsuario.put("POSTGRES", new UsuarioRepositorioPG());
        repositoriosUsuario.put("NEONDB", new UsuarioRepositorioNeonDB());


    }

    /**
     * Clase singleton
     *  
     * @return
     */
    public static Factory getInstancia() {

        if (instancia == null) {
            instancia = new Factory();
        }
        return instancia;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia ICompanyRepository
     *
     * @param repository cadena que indica qué tipo de clase hija debe
     * instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public IEmpresaRepositorio getRepositorioEmpresa(String repositorio) {

        IEmpresaRepositorio resultado = null;

        if (repositoriosEmpresa.containsKey(repositorio)) {
            resultado = repositoriosEmpresa.get(repositorio);
        }

        return resultado;

    }
    

    public ICoordinadorRepositorio getRepositorioCoordinador(String repositorio) {

        ICoordinadorRepositorio resultado = null;

        if (repositoriosCoordinador.containsKey(repositorio)) {
            resultado = repositoriosCoordinador.get(repositorio);
        }

        return resultado;

    }

    public IUsuarioRepositorio getRepositorioUsuario(String repositorio) {

        IUsuarioRepositorio resultado = null;

        if (repositoriosUsuario.containsKey(repositorio)) {
            resultado = repositoriosUsuario.get(repositorio);
        }

        return resultado;
    }
}
