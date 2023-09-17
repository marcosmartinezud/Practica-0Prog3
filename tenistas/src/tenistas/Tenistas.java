package tenistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tenistas extends JPanel {

	protected static JTable table;
	protected DefaultTableModel tableModel;

	Tenistas() {
		this.setBackground(Color.black);
		this.setLayout(new BorderLayout());

		tableModel = new DefaultTableModel();
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Nacionalidad");
		tableModel.addColumn("Num. victorias GS");

		table = new JTable(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane, BorderLayout.CENTER);

		HashMap<String, Integer> mapaTenistas = new HashMap<String, Integer>();

		for (int i = 0; i < GrandSlam.CargarDatos().size(); i++) {

			if (mapaTenistas.containsKey(GrandSlam.CargarDatos().get(i)[2])) {
				mapaTenistas.put(GrandSlam.CargarDatos().get(i)[2],
						mapaTenistas.get(GrandSlam.CargarDatos().get(i)[2]) + 1);
			} else {
				mapaTenistas.put(GrandSlam.CargarDatos().get(i)[2], 1);
			}

		}

		System.out.println(mapaTenistas);

//		for (int i = 0; i < mapaTenistas.keySet().size(); i++) {
//			
//			String keySet = mapaTenistas.keySet().toString();
//			String[] listaKeySet = keySet.split(", ");
//			
//			String[] campos = listaKeySet[i].split(":");
//			
//			int valor = mapaTenistas.get(campos[0] + ":" + campos[1]);
//				
//			String[] listaTenistas = {
//					campos[0],
//					campos[1],
//					valor + ""			
//			};
//			
//			
//			tableModel.addRow(listaTenistas);
//		}

		for (String clave : mapaTenistas.keySet()) {
			int valor = mapaTenistas.get(clave);

			String paisTenista = null;

			for (int i = 0; i < GrandSlam.CargarDatos().size(); i++) {
				if (clave.equals(GrandSlam.CargarDatos().get(i)[2])) {
					paisTenista = GrandSlam.CargarDatos().get(i)[4];
					break;
				}

			}

			String[] listaTenistas = { clave, paisTenista, valor + "" };

			tableModel.addRow(listaTenistas);

		}

	}

}
