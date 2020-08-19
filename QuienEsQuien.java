/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien;

import quienesquien.controlador.QuienEsQuienController;
import quienesquien.modelo.QuienEsQuienModel;
import quienesquien.vista.QuienEsQuienView;

/**
 *
 * @author Sara Monzó Bravo
 */
public class QuienEsQuien 
{
    public static void main(String[] args) 
    {
        QuienEsQuienModel model = new QuienEsQuienModel();
        QuienEsQuienView view = new QuienEsQuienView();
        QuienEsQuienController controller = new QuienEsQuienController(model, view);
        
        view.setVisible(true);
        view.repaint();
        
    }
    
}
