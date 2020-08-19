/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.vista;

import javax.swing.*;

/**
 *
 * @author Sara Monzó Bravo
 */
public class PartidasJugadas extends JFrame
{
    private JTextArea area;
    private JScrollPane scroll;
    
    public PartidasJugadas()
    {
        area = new JTextArea(10, 3);
        area.setEditable(false);
        scroll = new JScrollPane(); 
        scroll.setViewportView(area);
        
        this.add(area);
        this.add(scroll);
    }
    
    
    /************************ anyadirResultado ***************************
    * Añade una nueva linea de texto al JTextArea                        *
    *                                                                    *
    * @param usuario                                                     *
    * @param dificultad                                                  *
    * @param resultado                                                   *
    * @param puntosFinales                                               *
    **********************************************************************/
    public void anyadirResultado(String usuario, String dificultad, String resultado, String puntosFinales)
    {
        area.setText("Usuario: " + usuario + " Dificultad: " + dificultad + " Resultado: " + resultado + " Puntos finales: " + puntosFinales + "\n");
    }
    
}
