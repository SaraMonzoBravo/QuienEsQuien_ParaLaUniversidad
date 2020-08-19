/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Sara Monzó Bravo
 */

public class QuienEsQuienView extends JFrame 
{
    private PanelPortada portadaPanel;
    private QuienEsQuienGame game;
    
    private JButton jugar;
    private JButton opciones;
    private JButton ayuda;
    private JPanel seleccion;
    
    public QuienEsQuienView ()
    {
        this.setLayout(new BorderLayout());
        this.setSize(1150, 750);
        this.setBackground(Color.DARK_GRAY);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("¿Quién es quién? - Inicio");
        
        ImageIcon tituloJuego = new ImageIcon(getClass().getResource("/recursos/imagenes/portada.png"));
        portadaPanel = new PanelPortada(tituloJuego.getImage());
        this.getContentPane().add(portadaPanel);
        
        seleccion = new JPanel();
        seleccion.setLayout(new GridLayout(3, 1));
        seleccion.setSize(50, 30);
        
        jugar = new JButton("¡A JUGAR!");
        jugar.setActionCommand("aJugarPortada");
        
        opciones = new JButton("Opciones");
        opciones.setActionCommand("opcionesPortada");
        
        ayuda = new JButton("Ayuda");
        ayuda.setActionCommand("ayudaPortada");
        
        this.add(seleccion, BorderLayout.SOUTH);
        seleccion.add(jugar);
        seleccion.add(opciones);
        seleccion.add(ayuda);
    } 
    
    public void setActionListener(ActionListener al)
    {
        jugar.addActionListener(al);
        opciones.addActionListener(al);
        ayuda.addActionListener(al);
    }
}
