/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.vista;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Sara Monzó Bravo
 */

public class PanelPortada extends JPanel 
{
    private Image img;
    private Dimension dim;
    
    public PanelPortada(Image img)
    {
        this.img = img;
        dim = new Dimension(img.getWidth(null), img.getHeight(null));
        this.setPreferredSize(dim);
        this.setMaximumSize(dim);
        this.setMinimumSize(dim);
        this.setSize(dim);
        this.setLayout(null);
    }
    
    /************************ getDimension ***************************
    * Devuelve la dimension de la imagen de inicio                   *
    *                                                                *
    * @return Dimension                                              *
    ******************************************************************/
    public Dimension getDimension()
    {
        return dim;
    }
    
    
    /************************ paintComponent ***************************
    * Metodo que sobrescribe paintComponent y pinta la imagen          *
    *                                                                  *
    * @param g                                                         *
    ********************************************************************/
    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, null);
    }
}
