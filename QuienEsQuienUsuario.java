/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.modelo;

/**
 *
 * @author Sara Monzó Bravo
 */
public class QuienEsQuienUsuario 
{
    private String nombre;
    private String dificultad;  //"facil", "medio", "dificil", "personalizado
    
    public QuienEsQuienUsuario(){}
    
    public QuienEsQuienUsuario(String nombre, String dificultad)
    {
        this.nombre = nombre;
        this.dificultad = dificultad;
    }
    
    
    /************************ getNombre ***************************
    * Devuelve el nombre del usuario                              *
    *                                                             *
    * @return nombre                                              *
    ***************************************************************/
    public String getNombre()
    {
        return nombre;
    }
    
    
    /************************ setNombre ***************************
    * Inserta un usuario                                          *
    *                                                             *
    * @param nombre                                               *
    ***************************************************************/
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    
    /************************ getDificultad ***************************
    * Devuelve la dificultad de la partida                            *
    *                                                                 *
    * @return dificultad                                              *
    *******************************************************************/
    public String getDificultad()
    {
        return dificultad;
    }
    
    
    /************************ setDificultad ***************************
    * Inserta una dificultad                                          *
    *                                                                 *
    * @param dificultad                                               *
    *******************************************************************/
    public void setDificultad(String dificultad)
    {
        this.dificultad = dificultad;
    }

    
}
