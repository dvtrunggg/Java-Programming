package com.myclass.app;

import com.myclass.views.DangNhapJFrame;
import javax.swing.SwingUtilities;
import java.util.List;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DangNhapJFrame().setVisible(true);
            }
        });
        
    
    }
}
