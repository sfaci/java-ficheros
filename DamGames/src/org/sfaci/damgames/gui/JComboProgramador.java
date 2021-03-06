package org.sfaci.damgames.gui;

import org.sfaci.damgames.base.Programador;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santi on 29/10/15.
 */
public class JComboProgramador extends JComboBox {

    private List<Programador> datos;

    public JComboProgramador(List<Programador> datos) {
        super();
        this.datos = datos;
        listar();
    }

    public void listar() {

        removeAllItems();

        if (datos.size() == 0) {
            addItem("<Sin datos>");
            return;
        }

        addItem("<Selecciona Programador>");
        for (Programador programador : datos)
            addItem(programador);
    }

    public void listar(String filtro) {

        removeAllItems();

        if (datos.size() == 0) {
            addItem("<Sin datos>");
            return;
        }

        addItem("<Selecciona Programador>");
        for (Programador programador : datos) {
            if ((programador.getNombre().contains(filtro)) || (programador.getApellidos().contains(filtro)))
                addItem(programador);
        }
    }

    public String getNombreProgramadorSeleccionado() {

        Programador programador = getProgramadorSeleccionado();
        if (programador == null)
            return null;

        return programador.getNombre();
    }

    public Programador getProgramadorSeleccionado() {

        int itemSeleccionado = getSelectedIndex();
        if (itemSeleccionado == 0)
            return null;

        return datos.get(itemSeleccionado - 1);
    }
}
