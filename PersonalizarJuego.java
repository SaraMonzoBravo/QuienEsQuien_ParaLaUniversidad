/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Sara Monzó Bravo
 */
public class PersonalizarJuego extends JFrame 
{
    private JLabel sexo, pelo, ojos, nariz, boca, gafas, sombrero, bigote, puntosTotales;
    private JTextField tSexo, tPelo, tOjos, tNariz, tBoca, tGafas, tSombrero, tBigote, tPuntosTotales;
    private JButton aceptar, cancelar;
    
    public PersonalizarJuego()
    {
        this.setLayout(new GridLayout(10, 2));
        this.setVisible(true);
        this.setSize(600, 600);
        this.setTitle("¿Quién es quién? - Personalizando partida");
        
        sexo = new JLabel("Puntos que restan las preguntas sobre el sexo: ");
        pelo = new JLabel("Puntos que restan las preguntas sobre el pelo: ");
        ojos = new JLabel("Puntos que restan las preguntas sobre los ojos: ");
        nariz = new JLabel("Puntos que restan las preguntas sobre la nariz: ");
        boca = new JLabel("Puntos que restan las preguntas sobre la boca: ");
        gafas = new JLabel("Puntos que resta la pregunta sobre las gafas: ");
        sombrero = new JLabel("Puntos que resta la pregunta sobre el sombrero: ");
        bigote = new JLabel("Puntos que resta la pregunta sobre el bigote: ");
        puntosTotales = new JLabel("Total de puntos de la partida: ");
        
        tSexo = new JTextField(10);
        tSexo.setEditable(true);
        tPelo = new JTextField(10);
        tPelo.setEditable(true);
        tOjos = new JTextField(10);
        tOjos.setEditable(true);
        tNariz = new JTextField(10);
        tNariz.setEditable(true);
        tBoca = new JTextField(10);
        tBoca.setEditable(true);
        tGafas = new JTextField(10);
        tGafas.setEditable(true);
        tSombrero = new JTextField(10);
        tSombrero.setEditable(true);
        tBigote = new JTextField(10);
        tBigote.setEditable(true);
        tPuntosTotales = new JTextField(10);
        tPuntosTotales.setEditable(true);
        
        aceptar = new JButton("Aceptar");
        aceptar.setActionCommand("personalizadoAceptar");
        cancelar = new JButton("Cancelar");
        cancelar.setActionCommand("personalizadoCancelar");
        
        add(sexo);
        add(tSexo);
        add(pelo);
        add(tPelo);
        add(ojos);
        add(tOjos);
        add(nariz);
        add(tNariz);
        add(boca);
        add(tBoca);
        add(gafas);
        add(tGafas);
        add(sombrero);
        add(tSombrero);
        add(bigote);
        add(tBigote);
        add(puntosTotales);
        add(tPuntosTotales);
        add(cancelar);
        add(aceptar);
        
    }
    
    public void setActionListener(ActionListener al)
    {
        aceptar.addActionListener(al);
        cancelar.addActionListener(al);
    }
    
    
    /************************ getSexo ***************************
    * Devuelve la puntuacion asignada al sexo                   *
    *                                                           *
    * @return String                                            *
    *************************************************************/
    public String getSexo()
    {
        return tSexo.getText();
    }
    
    
    /************************ getPelo ***************************
    * Devuelve la puntuacion asignada al pelo                   *
    *                                                           *
    * @return String                                            *
    *************************************************************/
    public String getPelo()
    {
        return tPelo.getText();
    }
    
    
    /************************ getOjos ***************************
    * Devuelve la puntuacion asignada a los ojos                *
    *                                                           *
    * @return String                                            *
    *************************************************************/
    public String getOjos()
    {
        return tOjos.getText();
    }
    
    
    /************************ getNariz ***************************
    * Devuelve la puntuacion asignada a la nariz                 *
    *                                                            *
    * @return String                                             *
    **************************************************************/
    public String getNariz()
    {
        return tNariz.getText();
    }
    
    
    /************************ getBoca ***************************
    * Devuelve la puntuacion asignada a la boca                 *
    *                                                           *
    * @return String                                            *
    *************************************************************/
    public String getBoca()
    {
        return tBoca.getText();
    }
    
    
    /************************ getGafas ***************************
    * Devuelve la puntuacion asignada a las gafas                *
    *                                                            *
    * @return String                                             *
    **************************************************************/
    public String getGafas()
    {
        return tGafas.getText();
    }
    
    
    /************************ getSombrero ***************************
    * Devuelve la puntuacion asignada al sombrero                   *
    *                                                               *
    * @return String                                                *
    *****************************************************************/
    public String getSombrero()
    {
        return tSombrero.getText();
    }
    
    
    /************************ getBigote ***************************
    * Devuelve la puntuacion asignada al bigote                   *
    *                                                             *
    * @return String                                              *
    ***************************************************************/
    public String getBigote()
    {
        return tBigote.getText();
    }
    
    
    /************************ getPuntosTotales ***************************
    * Devuelve los puntos totales introducidos por el usuario            *
    *                                                                    *
    * @return String                                                     *
    **********************************************************************/
    public String getPuntosTotales()
    {
        return tPuntosTotales.getText();
    }
    
    
    
}
