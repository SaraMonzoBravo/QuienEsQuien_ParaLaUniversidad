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
public class IntroUsuario extends JFrame
{
    private JLabel lUsuario, lDificultad;
    private JTextField tUsuario;
    private final String[] Dificultades = {"Facil", "Medio", "Dificil", "Personalizado"};
    private JButton aceptar, cancelar;
    private JComboBox dificultades;
    
    private JPanel datos;
    private JPanel comboBox;
    private JPanel botones;
    
    public IntroUsuario()
    {
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setVisible(true);
        this.setSize(400, 200);
        this.setTitle("¿Quién es quien? - Creación de partida");
        
        datos = new JPanel();
        datos.setLayout(new FlowLayout());
        comboBox = new JPanel();
        comboBox.setLayout(new FlowLayout());
        botones = new JPanel();
        botones.setLayout(new FlowLayout());
        
        lUsuario = new JLabel("Introduce tu nombre de usuario: ");
        tUsuario = new JTextField(10);
        lDificultad = new JLabel("Selecciona una dificultad: ");
        dificultades = new JComboBox(Dificultades);
        aceptar = new JButton("Aceptar");
        aceptar.setActionCommand("introAceptar");
        cancelar = new JButton("Cancelar");
        cancelar.setActionCommand("introCancelar");
        
        datos.add(lUsuario);
        datos.add(tUsuario);
        comboBox.add(lDificultad);
        comboBox.add(dificultades);
        botones.add(cancelar);
        botones.add(aceptar);
        this.add(datos);
        this.add(comboBox);
        this.add(botones); 
    }

    public void setActionListener(ActionListener al)
    {
        aceptar.addActionListener(al);
        cancelar.addActionListener(al);
        tUsuario.addActionListener(al);
    }
    
    
    /************************ getUsuario ***************************
    * Devuelve el texto que hay en el campo tUsuario               *
    *                                                              *
    * @return String                                               *
    ****************************************************************/
    public String getUsuario()
    {
        return tUsuario.getText();
    }
    
    
    /************************ getDificultad ***************************
    * Devuelve la dificultad elegida en el JComboBox                  *
    *                                                                 *
    * @return String                                                  *
    *******************************************************************/
    public String getDificultad()
    {
        return (String)dificultades.getSelectedItem();
    }
}
