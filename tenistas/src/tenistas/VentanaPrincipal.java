package tenistas;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
	
	VentanaPrincipal() {
		
		this.setTitle("Grand Slams");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720, 500);

        JTabbedPane tabbedPane = new JTabbedPane();
        
        Resultados panelResultados = new Resultados();
        Tenistas panelTenistas = new Tenistas();
        Torneos panelTorneos = new Torneos();
        
        tabbedPane.addTab("Resultados", panelResultados);
        tabbedPane.addTab("Tenistas", panelTenistas);
        tabbedPane.addTab("Torenos", panelTorneos);
        
        this.add(tabbedPane);
	}

}
