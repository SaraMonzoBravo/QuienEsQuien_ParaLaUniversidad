/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.vista;

import quienesquien.modelo.QuienEsQuienUsuario;
import quienesquien.modelo.PuntosPorPregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;



/**
 *
 * @author Sara Monzó Bravo
 */
public class QuienEsQuienGame extends JFrame
{
    private QuienEsQuienUsuario user;
    private PuntosPorPregunta puntosPorPregunta;
    private QuienEsQuienMenu menu;
    private JPanel preguntas, respuestas, estado, cartas;
    
    // ATRIBUTOS DEL PANEL RESPUESTAS
    private JLabel respuesta;
    
    // ATRIBUTOS DEL PANEL ESTADO
    private JLabel usuario, puntuacion, asesino;
    private JTextField tUsuario, tPuntuacion;
    private JButton bAsesino;
    
    // ATRIBUTOS DEL PANEL PREGUNTAS
    private JButton bPreguntar;
    private JComboBox jPreguntas;
    private final String[] Questions = {"Sexo: ¿El asesino es hombre?", "Sexo: ¿El asesino es mujer?", "Pelo: ¿El asesino es rubio?", "Pelo: ¿El asesino es moreno?", "Pelo: ¿El asesino es castaño?", "Pelo: ¿El asesino es pelirrojo?", "Pelo: ¿El asesino es canoso?", "Pelo: ¿El asesino es calvo?", "Ojos: ¿El asesino tiene ojos azules?", "Ojos: ¿El asesino tiene ojos verdes?", "Ojos: ¿El asesino tiene ojos marrones?", "Nariz: ¿El asesino tiene nariz grande?", "Nariz: ¿El asesino tiene nariz pequeña?", "Nariz: ¿El asesino tiene nariz mediana?", "Boca: ¿El asesino tiene boca grande?", "Boca: ¿El asesino tiene boca pequeña?", "Boca: ¿El asesino tiene boca mediana?", "Gafas: ¿El asesino tiene gafas?", "Sombrero: ¿El asesino tiene sombrero?", "Bigote: ¿El asesino tiene bigote?"};
    
    // ATRIBUTOS DEL PANEL CARTAS
    private JButton[] botones ;
    
    public QuienEsQuienGame(){}
    
    public QuienEsQuienGame(QuienEsQuienUsuario user, PuntosPorPregunta puntosPorPregunta)
    {
        this.user = user;
        this.puntosPorPregunta = puntosPorPregunta;
        this.setVisible(true);
        this.setSize(1300, 950);
        this.setLayout(new BorderLayout());
        this.setTitle("¿Quién es quién? - EL JUEGO");
        
        // MENU DE LA APLICACION
        menu = new QuienEsQuienMenu();
        this.setJMenuBar(menu);
        
        
        //PANEL PREGUNTAS
        preguntas = new JPanel();
        preguntas.setLayout(new FlowLayout());
        bPreguntar = new JButton("¡Pregunta!");
        bPreguntar.setActionCommand("preguntar");
        jPreguntas = new JComboBox(Questions);
        jPreguntas.setPreferredSize (new Dimension (300, 50));
        jPreguntas.setMinimumSize(preguntas.getPreferredSize());
        jPreguntas.setMaximumSize(preguntas.getPreferredSize());
        preguntas.add(jPreguntas);
        preguntas.add(bPreguntar);
        this.add(preguntas, BorderLayout.NORTH);
        
        //PANEL RESPUESTAS
        respuesta = new JLabel(" ");
        respuesta.setSize(100, 100);
        this.add(respuesta, BorderLayout.CENTER);
        
        //PANEL ESTADO
        estado = new JPanel();
        estado.setLayout(new GridLayout(3,2));
        usuario = new JLabel("Usuario: ");
        tUsuario = new JTextField(10);
        tUsuario.setEditable(false);
        tUsuario.setText(user.getNombre());
        puntuacion = new JLabel("Punatuación: ");
        tPuntuacion = new JTextField(" ", 10);
        tPuntuacion.setEditable(false);
        asesino = new JLabel("Asesino: ");
        bAsesino = new JButton(new ImageIcon(getClass().getResource("/recursos/cartas/reversoR.gif")));
        bAsesino.setBorder(new BevelBorder(BevelBorder.RAISED));
        estado.add(usuario);
        estado.add(tUsuario);
        estado.add(puntuacion);
        estado.add(tPuntuacion);
        estado.add(asesino);
        estado.add(bAsesino);
        this.add(estado, BorderLayout.EAST);
        
        //PANEL CARTAS
        cartas = new JPanel();
        cartas.setLayout(new GridLayout(3, 8));
        botones = new JButton[24];
        for (int i = 0; i < 24; i++)
        {
            botones[i] = new JButton(new ImageIcon ("src/recursos/cartas/cara" + String.valueOf(i + 1) + ".gif"));
            botones[i].setName("cara" + String.valueOf(i)); 
            cartas.add(botones[i]);
            botones[i].setActionCommand("cara"+(i+1));
            botones[i].setBorder(new BevelBorder(BevelBorder.RAISED));
        }
        this.add(cartas, BorderLayout.SOUTH);
    }
    
    public void setActionListener(ActionListener al)
    {
        // ActionListener para el boton Preguntar
        bPreguntar.addActionListener(al);
        
        // ActionListener para los botones cartas
        for (int i = 0; i < 24; i++)
        {            
            botones[i].addActionListener(al);            
        }
        
        //ActionListener para el menu
        menu.setActionListener(al);
    }
    
    
    /************************ getPregunta ***************************
    * Devuelve la pregunta seleccionada por el usuaio               *
    *                                                               *
    * @return String                                                *
    *****************************************************************/
    public String getPregunta()
    {
        return (String)jPreguntas.getSelectedItem();
    }
    
    
    /************************ ponReverso ***************************
    * Da la vuelta a la carta indicada                             *
    *                                                              *
    * @param posicion                                              *
    ****************************************************************/
    public void ponReverso(int posicion)
    {
        botones[posicion].setIcon(new ImageIcon("src/recursos/cartas/reversoR.gif"));
        botones[posicion].setEnabled(false);
        System.out.println("Le doy la vuelta a: " + posicion);
    }
    
    /************************ setAsesino ***************************
    * Da la vuelta a la carta del asesino                          *
    *                                                              *
    * @param nombreAsesino                                         *
    ****************************************************************/
    public void setAsesino(String nombreAsesino)
    {
        bAsesino.setIcon(new ImageIcon("src/recursos/cartas/" + nombreAsesino + ".gif"));
    }
    
    /************************ actualizaPuntos ***************************
    * Actualiza los untos del jugador                                   *
    *                                                                   *
    * @param puntos                                                     *
    *********************************************************************/
    public void actualizaPuntos(int puntos)
    {
        tPuntuacion.setText(String.valueOf(puntos));
    }
    
    /************************ respuestaSi ***************************
    * Pone la respuesta "Si" en el panel respuesta                  *
    *                                                               *
    *****************************************************************/
    public void respuestaSi()
    {
        respuesta.setText("                                ¡Si! ^_^");
        respuesta.setForeground(Color.GREEN);
        respuesta.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
    }
    
    /************************ respuestaNo ***************************
    * Pone la respuesta "No" en el panel respuesta                  *
    *                                                               *
    *****************************************************************/
    public void respuestaNo()
    {
        respuesta.setText("                                ¡No! =(");
        respuesta.setForeground(Color.RED);
        respuesta.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
    }
    
    /************************ respuestaVictoria ***************************
    * Pone la respuesta "Victoria" en el panel respuesta                  *
    *                                                                     *
    ***********************************************************************/
    public void respuestaVictoria()
    {
        respuesta.setText("                         ¡Viva! ¡HAS GANADO!");
        respuesta.setForeground(Color.GREEN);
        respuesta.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
    }
    
    
    /************************ respuestaDerrota ***************************
    * Pone la respuesta "Derrota" en el panel respuesta                  *
    *                                                                    *
    **********************************************************************/
    public void respuestaDerrota()
    {
        respuesta.setText("                         ¡Vaya! ¡HAS PERDIDO!");
        respuesta.setForeground(Color.RED);
        respuesta.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
    }
}
