package br.com.foursys.vendas;

import br.com.foursys.vendas.view.LoginPrincipal;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import javax.swing.UIManager;

/*
 *@author's: Equipe 4 "Diego, we have a problem!"
 */
public class Main {

    public static void main(String[] args) {

        try {
            UIManager
                    .setLookAndFeel(new McWinLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new LoginPrincipal();

    }

}
