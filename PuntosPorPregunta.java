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
public class PuntosPorPregunta 
{
    int preguntaSexo;
    int preguntaPelo;
    int preguntaOjos;
    int preguntaNariz;
    int preguntaBoca;
    int preguntaGafas;
    int preguntaSombrero;
    int preguntaBigote;
    int puntosTotales;
    int puntosActuales;
    
    public PuntosPorPregunta(int sexo, int pelo, int ojos, int nariz, int boca, int gafas, int sombrero, int bigote, int totales)
    {
        this.preguntaSexo = sexo;
        this.preguntaPelo = pelo;
        this.preguntaOjos = ojos;
        this.preguntaNariz = nariz;
        this.preguntaBoca = boca;
        this.preguntaGafas = gafas;
        this.preguntaSombrero = sombrero;
        this.preguntaBigote = bigote;
        this.puntosTotales = totales;
        this.puntosActuales = totales;
    }
    
    /************************** getPreguntaSexo ***************************
    * Devuelve los puntos que cuesta preguntar por el Sexo del asesino    *
    *                                                                     *
    * @return preguntaSexo                                                *
    ***********************************************************************/
    public int getPreguntaSexo()
    {
        return preguntaSexo;
    }
    
    /************************** getPreguntaPelo ***************************
    * Devuelve los puntos que cuesta preguntar por el Pelo del asesino    *
    *                                                                     *
    * @return preguntaPelo                                                *
    ***********************************************************************/
    public int getPreguntaPelo()
    {
        return preguntaPelo;
    }
    
    /************************** getPreguntaOjos ***************************
    * Devuelve los puntos que cuesta preguntar por los Ojos del asesino   *
    *                                                                     *
    * @return preguntaOjos                                                *
    ***********************************************************************/
    public int getPreguntaOjos()
    {
        return preguntaOjos;
    }
    
    /************************* getPreguntaNariz ***************************
    * Devuelve los puntos que cuesta preguntar por la Nariz del asesino   *
    *                                                                     *
    * @return preguntaNariz                                               *
    ***********************************************************************/
    public int getPreguntaNariz()
    {
        return preguntaNariz;
    }
    
    /************************* getPreguntaBoca ***************************
    * Devuelve los puntos que cuesta preguntar por la Boca del asesino   *
    *                                                                    *
    * @return preguntaBoca                                               *
    **********************************************************************/
    public int getPreguntaBoca()
    {
        return preguntaBoca;
    }
    
    /************************* getPreguntaGafas ***************************
    * Devuelve los puntos que cuesta preguntar por las Gafas del asesino  *
    *                                                                     *
    * @return preguntaGafas                                               *
    ***********************************************************************/
    public int getPreguntaGafas()
    {
        return preguntaGafas;
    }
    
    /************************ getPreguntaSombrero ***************************
    * Devuelve los puntos que cuesta preguntar por el Sombrero del asesino  *
    *                                                                       *
    * @return preguntaSombrero                                              *
    *************************************************************************/
    public int getPreguntaSombrero()
    {
        return preguntaSombrero;
    }
    
    /************************ getPreguntaBigote ***************************
    * Devuelve los puntos que cuesta preguntar por el Bigote del asesino  *
    *                                                                     *
    * @return preguntaBigote                                              *
    ***********************************************************************/
    public int getPreguntaBigote()
    {
        return preguntaBigote;
    }
    
    /************************ getTotalPuntos ***************************
    * Devuelve el total de puntos de la partida                        *
    *                                                                  *
    * @return totalPuntos                                              *
    ********************************************************************/
    public int getPuntosTotales()
    {
        return puntosTotales;
    }
    
    /************************ getPuntosActuales ***************************
    * Devuelve el total de puntos actuales de la partida                  *
    *                                                                     *
    * @return puntosActuales                                              *
    ***********************************************************************/
    public int getPuntosActuales()
    {
        return puntosActuales;
    }
    
    /************************ setPuntosActuales ***************************
    * Introduce el total de puntos actuales de la partida                 *
    *                                                                     *
    * @param puntosActuales                                               *
    ***********************************************************************/
    public void setPuntosActuales(int puntosActuales)
    {
        this.puntosActuales = puntosActuales;
    }
            
    
}
