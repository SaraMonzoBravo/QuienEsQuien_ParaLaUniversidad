/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.controlador;



import quienesquien.modelo.QuienEsQuienModel;
import quienesquien.modelo.QuienEsQuienUsuario;
import quienesquien.vista.QuienEsQuienView;
import quienesquien.vista.QuienEsQuienGame;
import quienesquien.vista.IntroUsuario;
import quienesquien.modelo.PuntosPorPregunta;
import quienesquien.modelo.QuienEsQuienCartas;
import quienesquien.vista.PersonalizarJuego;
import quienesquien.vista.PartidasJugadas;
import quienesquien.vista.QuienEsQuienMenu;
        
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Sara Monzó Bravo
 */
public class QuienEsQuienController 
{
    private QuienEsQuienModel model;
    private QuienEsQuienView view;
    private IntroUsuario intro;
    private QuienEsQuienUsuario user;
    private QuienEsQuienGame game;
    private String dificultadElegida;
    private PuntosPorPregunta puntosPorPregunta;
    private PersonalizarJuego persJuego;
    private QuienEsQuienCartas[] Cartas;
    private PartidasJugadas partidasJugadas;
    private QuienEsQuienMenu menu;
    
    public QuienEsQuienController(QuienEsQuienModel model, QuienEsQuienView view)
    {
        this.model = model;
        this.view = view;
        
        view.setActionListener(new QuienEsQuienControllerActionListener());
    }
    
    //CLASES EMPOTRADAS
    class QuienEsQuienControllerActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            String command = actionEvent.getActionCommand();   
            
            switch(command)
            {
                case "aJugarPortada":
                    intro = new IntroUsuario();
                    intro.setActionListener(new QuienEsQuienControllerActionListener());
                    intro.setVisible(true);
                    view.setVisible(false);
                    break;
                case "introAceptar":
                    //compruebo que no este el campo vacio
                    if(intro.getUsuario().length()== 0)
                    {
                        JOptionPane.showMessageDialog(null,"El campo de usuario no puede estar vacío", "Error en el nombre", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        user = new QuienEsQuienUsuario(intro.getUsuario(), intro.getDificultad());
                        dificultadElegida = intro.getDificultad();
                        
                        if(dificultadElegida == "Facil")
                        {
                            /************* PUNTUACION JUEGO MODO FACIL **************
                            * Puntos que resta la pregunta sobre el Sexo = 5        *
                            * Puntos que resta la pregunta sobre el Pelo = 5        *
                            * Puntos que resta la pregunta sobre los Ojos = 5       *
                            * Puntos que resta la pregunta sobre la Nariz = 5       *
                            * Puntos que resta la pregunta sobre la Boca = 5        *
                            * Puntos que resta la pregunta sobre las Gafas = 5      *
                            * Puntos que resta la pregunta sobre el Sombrero = 5    *
                            * Puntos que resta la pregunta sobre el Bigote = 5      *
                            * PUNTOS TOTALES DE LA PARTIDA = 100                    *
                            *********************************************************/
                            
                            puntosPorPregunta = new PuntosPorPregunta(5, 5, 5, 5, 5, 5, 5, 5, 100);
                            model.comienzaJuego();
                            game = new QuienEsQuienGame(user, puntosPorPregunta);
                            game.setActionListener(new QuienEsQuienControllerActionListener());
                            System.out.println("Has elegido juego facil");
                            game.setVisible(true);
                            game.repaint();
                            intro.setVisible(false);
                        }
                        else if(dificultadElegida == "Medio")
                        {
                            /************* PUNTUACION JUEGO MODO MEDIO **************
                            * Puntos que resta la pregunta sobre el Sexo = 10       *
                            * Puntos que resta la pregunta sobre el Pelo = 5        *
                            * Puntos que resta la pregunta sobre los Ojos = 5       *
                            * Puntos que resta la pregunta sobre la Nariz = 5       *
                            * Puntos que resta la pregunta sobre la Boca = 5        *
                            * Puntos que resta la pregunta sobre las Gafas = 10     *
                            * Puntos que resta la pregunta sobre el Sombrero = 10   *
                            * Puntos que resta la pregunta sobre el Bigote = 10     *
                            * PUNTOS TOTALES DE LA PARTIDA = 100                    *
                            *********************************************************/
                            
                            puntosPorPregunta = new PuntosPorPregunta(10, 5, 5, 5, 5, 10, 10, 10, 100);
                            model.comienzaJuego();
                            game = new QuienEsQuienGame(user, puntosPorPregunta);
                            game.setActionListener(new QuienEsQuienControllerActionListener());
                            System.out.println("Has elegido juego medio");
                            game.repaint();
                            game.setVisible(true);
                            intro.setVisible(false);
                        }
                        else if(dificultadElegida == "Dificil")
                        {
                            /************* PUNTUACION JUEGO MODO DIFICIL *************
                            * Puntos que resta la pregunta sobre el Sexo = 30       *
                            * Puntos que resta la pregunta sobre el Pelo = 5        *
                            * Puntos que resta la pregunta sobre los Ojos = 5       *
                            * Puntos que resta la pregunta sobre la Nariz = 5       *
                            * Puntos que resta la pregunta sobre la Boca = 5        *
                            * Puntos que resta la pregunta sobre las Gafas = 30     *
                            * Puntos que resta la pregunta sobre el Sombrero = 30   *
                            * Puntos que resta la pregunta sobre el Bigote = 30     *
                            * PUNTOS TOTALES DE LA PARTIDA = 100                    *
                            *********************************************************/
                            
                            puntosPorPregunta = new PuntosPorPregunta(30, 5, 5, 5, 5, 30, 30, 30, 100);
                            model.comienzaJuego();
                            game = new QuienEsQuienGame(user, puntosPorPregunta);
                            game.setActionListener(new QuienEsQuienControllerActionListener());
                            System.out.println("Has elegido juego dificil");
                            game.repaint();
                            game.setVisible(true);
                            intro.setVisible(false);
                        }
                        else if(dificultadElegida == "Personalizado")
                        {
                            persJuego = new PersonalizarJuego();
                            persJuego.setActionListener(new QuienEsQuienControllerActionListener());
                            System.out.println("Has elegido juego personalizar");
                            persJuego.setVisible(true);
                            intro.setVisible(false);
                        }
                        game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                        menu = new QuienEsQuienMenu();
                        menu.setActionListener(new QuienEsQuienControllerActionListener());
                    }
                    break;
                case "introCancelar":
                    view.setVisible(true);
                    intro.setVisible(false);
                    break;
                case "personalizadoAceptar":
                    //Compruebo que ningun campo este vacio
                    if( (persJuego.getSexo().length() == 0) || (persJuego.getPelo().length() == 0) || (persJuego.getOjos().length() == 0) || (persJuego.getNariz().length() == 0) || (persJuego.getBoca().length() == 0) || (persJuego.getGafas().length() == 0) || (persJuego.getSombrero().length() == 0 || persJuego.getBigote().length() == 0) || (persJuego.getPuntosTotales().length() == 0) )
                    {
                        JOptionPane.showMessageDialog(null,"No puede haber ningun campo vacío", "Error en los campos", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        /********* PUNTUACION JUEGO MODO PERSONALIZADO **********
                        * Puntos que resta la pregunta sobre el Sexo = ?        *
                        * Puntos que resta la pregunta sobre el Pelo = ?        *
                        * Puntos que resta la pregunta sobre los Ojos = ?       *
                        * Puntos que resta la pregunta sobre la Nariz = ?       *
                        * Puntos que resta la pregunta sobre la Boca = ?        *
                        * Puntos que resta la pregunta sobre las Gafas = ?      *
                        * Puntos que resta la pregunta sobre el Sombrero = ?    *
                        * Puntos que resta la pregunta sobre el Bigote = ?      *
                        * PUNTOS TOTALES DE LA PARTIDA = ?                      *
                        *********************************************************/
                        puntosPorPregunta = new PuntosPorPregunta(Integer.parseInt(persJuego.getSexo()), Integer.parseInt(persJuego.getPelo()), Integer.parseInt(persJuego.getOjos()), Integer.parseInt(persJuego.getNariz()), Integer.parseInt(persJuego.getBoca()), Integer.parseInt(persJuego.getGafas()), Integer.parseInt(persJuego.getSombrero()), Integer.parseInt(persJuego.getBigote()), Integer.parseInt(persJuego.getPuntosTotales()));
                        model.comienzaJuego();
                        game = new QuienEsQuienGame(user, puntosPorPregunta);
                        game.repaint();
                        game.setVisible(true);
                        intro.setVisible(false);
                        persJuego.setVisible(false);
                    }
                    break;
                case "personalizadoCancelar":
                    persJuego.setVisible(false);
                    intro.setVisible(true);
                    break;
                case "preguntar":
                    Cartas = model.getVectorCartas();
                    
                    //SI EL JUGADOR NO TIENE PUNTOS, HA PERDIDO
                    if(puntosPorPregunta.getPuntosActuales() <= 0)
                    {
                        System.out.println("El jugador ha perdido");
                        game.setAsesino(model.getNombreAsesino());
                        game.respuestaDerrota();
                        //partidasJugadas.anyadirResultado(intro.getName(), intro.getDificultad(), "Derrota", String.valueOf(puntosPorPregunta.getPuntosActuales()));
                    }
                    
                    // LOGICA Y FUNCIONAMIENTO DEL JUEGO
                    switch(game.getPregunta())
                    {
                        case "Sexo: ¿El asesino es hombre?":
                            System.out.println("has preguntado si es hombre");
                            if(model.compruebaSexo("hombre")) //Mi asesino ES HOMBRE
                            {
                                //Le doy la vuelta a las cartas que son mujer
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getSexo().equals("mujer"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else // MI ASESINO NO ES HOMBRE
                            {
                                //Le doy la vuelta a las cartas que son hombre
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getSexo().equals("hombre"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                } 
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaSexo());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Sexo: ¿El asesino es mujer?":
                            System.out.println("has preguntado si es mujer");
                            if(model.compruebaSexo("mujer")) //Mi asesino ES MUJER
                            {
                                //Le doy la vuelta a las cartas que son hombre
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getSexo().equals("hombre"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else // MI ASESINO NO ES MUJER
                            {
                                //Le doy la vuelta a las cartas que son mujer
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getSexo().equals("mujer"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaSexo());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Pelo: ¿El asesino es rubio?":
                            System.out.println("has preguntado si es rubio");
                            if(model.compruebaPelo("rubio")) //Mi asesino ES RUBIO
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "moreno", "castaño", "pelirrojo", "canoso", "calvo"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("moreno") || Cartas[i].getPelo().equals("castaño") || Cartas[i].getPelo().equals("pelirrojo") || Cartas[i].getPelo().equals("canoso") || Cartas[i].getPelo().equals("calvo"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "rubio"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("rubio"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaPelo());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Pelo: ¿El asesino es moreno?":
                            System.out.println("has preguntado si es moreno");
                            if(model.compruebaPelo("moreno")) //Mi asesino ES MORENO
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "rubio", "castaño", "pelirrojo", "canoso", "calvo"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("rubio") || Cartas[i].getPelo().equals("castaño") || Cartas[i].getPelo().equals("pelirrojo") || Cartas[i].getPelo().equals("canoso") || Cartas[i].getPelo().equals("calvo"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "moreno"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("moreno"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaPelo());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Pelo: ¿El asesino es castaño?": 
                            System.out.println("has preguntado si es castaño");
                            if(model.compruebaPelo("castaño")) //Mi asesino ES CASTAÑO
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "rubio", "moreno", "pelirrojo", "canoso", "calvo"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("rubio") || Cartas[i].getPelo().equals("moreno") || Cartas[i].getPelo().equals("pelirrojo") || Cartas[i].getPelo().equals("canoso") || Cartas[i].getPelo().equals("calvo"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "castaño"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("castaño"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaPelo());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Pelo: ¿El asesino es pelirrojo?":
                            System.out.println("has preguntado si es pelirrojo");
                            if(model.compruebaPelo("pelirrojo")) //Mi asesino ES PELIRROJO
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "rubio", "moreno", "castaño", "canoso", "calvo"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("rubio") || Cartas[i].getPelo().equals("moreno") || Cartas[i].getPelo().equals("castaño") || Cartas[i].getPelo().equals("canoso") || Cartas[i].getPelo().equals("calvo"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "pelirrojo"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("pelirrojo"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaPelo());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Pelo: ¿El asesino es canoso?":
                            System.out.println("has preguntado si es canoso");
                            if(model.compruebaPelo("canoso")) //Mi asesino ES CANOSO
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "rubio", "moreno", "castaño", "pelirrojo", "calvo"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("rubio") || Cartas[i].getPelo().equals("moreno") || Cartas[i].getPelo().equals("castaño") || Cartas[i].getPelo().equals("pelirrojo") || Cartas[i].getPelo().equals("calvo"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "canoso"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("canoso"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaPelo());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Pelo: ¿El asesino es calvo?":
                            System.out.println("has preguntado si es calvo");
                            if(model.compruebaPelo("calvo")) //Mi asesino ES CALVO
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "rubio", "moreno", "castaño", "pelirrojo", "canoso"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("rubio") || Cartas[i].getPelo().equals("moreno") || Cartas[i].getPelo().equals("castaño") || Cartas[i].getPelo().equals("pelirrojo") || Cartas[i].getPelo().equals("canoso"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen pelo "calvo"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getPelo().equals("calvo"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaPelo());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Ojos: ¿El asesino tiene ojos azules?":
                            System.out.println("has preguntado si tiene ojos azules");
                            if(model.compruebaOjos("azules")) //Mi asesino tiene ojos azules
                            {
                                //Le doy la vuelta a las cartas que tienen ojos "verdes", "marrones"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getOjos().equals("verdes") || Cartas[i].getOjos().equals("marrones"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen los ojos "azules"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getOjos().equals("azules"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaOjos());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Ojos: ¿El asesino tiene ojos verdes?":
                            System.out.println("has preguntado si tiene ojos verdes");
                            if(model.compruebaOjos("verdes")) //Mi asesino tiene ojos verdes
                            {
                                //Le doy la vuelta a las cartas que tienen ojos "azules", "marrones"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getOjos().equals("azules") || Cartas[i].getOjos().equals("marrones"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen los ojos "verdes"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getOjos().equals("verdes"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaOjos());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Ojos: ¿El asesino tiene ojos marrones?":
                            System.out.println("has preguntado si tiene ojos marrones");
                            if(model.compruebaOjos("marrones")) //Mi asesino tiene ojos marrones
                            {
                                //Le doy la vuelta a las cartas que tienen ojos "azules", "verdes"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getOjos().equals("azules") || Cartas[i].getOjos().equals("verdes"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen los ojos "marrones"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getOjos().equals("marrones"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaOjos());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Nariz: ¿El asesino tiene nariz grande?":
                            System.out.println("has preguntado si tiene la nariz grande");
                            if(model.compruebaNariz("grande")) //Mi asesino tiene nariz grande
                            {
                                //Le doy la vuelta a las cartas que tienen nariz "mediana", "pequeña"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getNariz().equals("mediana") || Cartas[i].getNariz().equals("pequeña"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen la nariz "grande"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getNariz().equals("grande"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaNariz());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Nariz: ¿El asesino tiene nariz pequeña?":
                            System.out.println("has preguntado si tiene la nariz pequeña");
                            if(model.compruebaNariz("pequeña")) //Mi asesino tiene nariz pequeña
                            {
                                //Le doy la vuelta a las cartas que tienen nariz "mediana", "grande"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getNariz().equals("mediana") || Cartas[i].getNariz().equals("grande"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen la nariz "pequeña"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getNariz().equals("pequeña"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaNariz());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Nariz: ¿El asesino tiene nariz mediana?":
                            System.out.println("has preguntado si tiene la nariz mediana");
                            if(model.compruebaNariz("mediana")) //Mi asesino tiene nariz mediana
                            {
                                //Le doy la vuelta a las cartas que tienen nariz "pequeña", "grande"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getNariz().equals("pequeña") || Cartas[i].getNariz().equals("grande"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen la nariz "mediana"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getNariz().equals("mediana"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaNariz());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Boca: ¿El asesino tiene boca grande?":
                            System.out.println("has preguntado si tiene la boca grande");
                            if(model.compruebaBoca("grande")) //Mi asesino tiene boca grande
                            {
                                //Le doy la vuelta a las cartas que tienen boca "mediana", "pequeña"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getBoca().equals("mediana") || Cartas[i].getBoca().equals("pequeña"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen la boca "grande"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getBoca().equals("grande"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaBoca());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Boca: ¿El asesino tiene boca pequeña?":
                            System.out.println("has preguntado si tiene la boca pequeña");
                            if(model.compruebaBoca("pequeña")) //Mi asesino tiene boca pequeña
                            {
                                //Le doy la vuelta a las cartas que tienen boca "mediana", "grande"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getBoca().equals("mediana") || Cartas[i].getBoca().equals("grande"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen la boca "pequeña"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getBoca().equals("pequeña"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaBoca());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Boca: ¿El asesino tiene boca mediana?":
                            System.out.println("has preguntado si tiene la boca mediana");
                            if(model.compruebaBoca("mediana")) //Mi asesino tiene boca mediana
                            {
                                //Le doy la vuelta a las cartas que tienen boca "pequeña", "grande"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getBoca().equals("pequeña") || Cartas[i].getBoca().equals("grande"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else 
                            {
                                //Le doy la vuelta a las cartas que tienen la boca "mediana"
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getBoca().equals("mediana"))
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaBoca());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Gafas: ¿El asesino tiene gafas?":
                            System.out.println("has preguntado si lleva ganas");
                            if(model.compruebaGafas(true)) //Mi asesino lleva gafas
                            {
                                //Le doy la vuelta a las cartas que no llevan gafas
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getGafas() == false)
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else // MI ASESINO NO LLEVA GAFAS
                            {
                                //Le doy la vuelta a las cartas que llevan gafas
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getGafas() == true)
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaGafas());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Sombrero: ¿El asesino tiene sombrero?":
                            System.out.println("has preguntado si lleva sombrero");
                            if(model.compruebaSombrero(true)) //Mi asesino lleva sombrero
                            {
                                //Le doy la vuelta a las cartas que no llevan sombrero
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getSombrero() == false)
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else // MI ASESINO NO LLEVA SOMBRERO
                            {
                                //Le doy la vuelta a las cartas que llevan sombrero
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getSombrero() == true)
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaSombrero());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        case "Bigote: ¿El asesino tiene bigote?":
                            System.out.println("has preguntado si lleva bigote");
                            if(model.compruebaBigote(true)) //Mi asesino lleva bigote
                            {
                                //Le doy la vuelta a las cartas que no llevan bigote
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getBigote() == false)
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaSi();
                            }
                            else // MI ASESINO NO LLEVA BIGOTE
                            {
                                //Le doy la vuelta a las cartas que llevan bigote
                                for(int i = 0; i < 24; i++)
                                {
                                    if(Cartas[i].getBigote() == true)
                                    {
                                        game.ponReverso(i);
                                    }  
                                }
                                game.respuestaNo();
                                puntosPorPregunta.setPuntosActuales(puntosPorPregunta.getPuntosActuales() - puntosPorPregunta.getPreguntaBigote());
                            }
                            game.actualizaPuntos(puntosPorPregunta.getPuntosActuales());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Ha ocurrido un error inesperado en las preguntas", "Error inesperado", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    break;
                case "cara1":
                case "cara2":
                case "cara3":
                case "cara4":
                case "cara5":
                case "cara6":
                case "cara7":
                case "cara8":
                case "cara9":
                case "cara10":
                case "cara11":
                case "cara12":
                case "cara13":
                case "cara14":
                case "cara15":
                case "cara16":
                case "cara17":
                case "cara18":
                case "cara19":
                case "cara20":
                case "cara21":
                case "cara22":
                case "cara23":
                case "cara24":
                    if(model.getNombreAsesino().equals(command))
                    {
                        System.out.println("El usuario ha ganado");
                        game.setAsesino(command);
                        game.respuestaVictoria();
                        //partidasJugadas.anyadirResultado(intro.getName(), intro.getDificultad(), "Victoria", String.valueOf(puntosPorPregunta.getPuntosActuales()));
                    }
                    else
                    {
                        System.out.println("El jugador ha perdido");
                        game.setAsesino(model.getNombreAsesino());
                        game.respuestaDerrota();
                        //partidasJugadas.anyadirResultado(intro.getName(), intro.getDificultad(), "Derrota", String.valueOf(puntosPorPregunta.getPuntosActuales()));
                    }
                    
                    break;
                case "menuNuevaPartida":
                    game.setVisible(false);
                    view.setVisible(false);
                    intro.setVisible(true);
                    break;
                case "menuAvandonar":
                    //partidasJugadas.anyadirResultado(intro.getName(), intro.getDificultad(), "Derrota", String.valueOf(puntosPorPregunta.getPuntosActuales()));
                    game.setVisible(false);
                    intro.setVisible(false);
                    view.setVisible(true);
                    break;
                case "menuCerrar":
                    System.exit(0);
                    break;
                case "ayudaPortada":
                    try 
                    {
                        File path = new File ("src/recursos/documentos/Ayuda.pdf");
                        Desktop.getDesktop().open(path);
                    }
                    catch (IOException ex) 
                    {
                        ex.printStackTrace();
                    }
                    break;
                case "menuResultados":
                    partidasJugadas.setVisible(true);
                    break;
                case "opcionesPortada":
                    Color color = JColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
                    break;  
                default:
                    JOptionPane.showMessageDialog(null,"Ha ocurrido un error inesperado", "Error inesperado", JOptionPane.ERROR_MESSAGE);
                    break;
                    
            }
        }
    }
}
