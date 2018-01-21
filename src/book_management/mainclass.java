package book_management;

import javax.swing.SwingUtilities;

public class mainclass 
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() 
            {   
               // new line().setVisible(true);
                new homepage().setVisible(true);
            }
        });
    }
}

