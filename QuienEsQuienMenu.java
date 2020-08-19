/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.vista;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Sara Monzó Bravo
 */
public class QuienEsQuienMenu extends JMenuBar
{
    private JMenu partida, resultados;
    private JMenuItem avandonarPartida, nuevaPartida, cerrar;
    
    public QuienEsQuienMenu()
    {
        partida = new JMenu("Partida");
        resultados = new JMenu("Resultados");
        resultados.setActionCommand("menuResultados");
        avandonarPartida = new JMenuItem("Abandonar partida");
        avandonarPartida.setActionCommand("menuAvandonar");
        nuevaPartida = new JMenuItem("Nueva partida");
        nuevaPartida.setActionCommand("menuNuevaPartida");
        cerrar = new JMenuItem("Cerrar");
        cerrar.setActionCommand("menuCerrar");
        
        partida.add(nuevaPartida);
        partida.add(avandonarPartida);
        partida.add(cerrar);
        add(partida);
        add(resultados);
    }
    
    public void setActionListener(ActionListener al)
    {
        nuevaPartida.addActionListener(al);
        avandonarPartida.addActionListener(al);
        cerrar.addActionListener(al);
        resultados.addActionListener(al);
    }
    
}
