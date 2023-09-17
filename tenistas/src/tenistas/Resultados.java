package tenistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class Resultados extends JPanel {

	protected static JTable table;
	protected DefaultTableModel tableModel;
	protected JPanel panelInferior;
	protected JButton botonGuardar;
	protected JButton botonAnyadir;
	protected static ArrayList<String> nuevosResultados = new ArrayList<String>();

	Resultados() {

		this.setBackground(Color.black);
		this.setLayout(new BorderLayout());

		tableModel = new DefaultTableModel();
		tableModel.addColumn("Año");
		tableModel.addColumn("Torneo");
		tableModel.addColumn("Campeón");
		tableModel.addColumn("Ranking del campeón");
		tableModel.addColumn("Nacionalidad del campeón");
		tableModel.addColumn("Subcampeón");
		tableModel.addColumn("Ranking del subcampeón");
		tableModel.addColumn("Nacionalidad del subcampeón");
		tableModel.addColumn("Resultado");

		table = new JTable(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane, BorderLayout.CENTER);

		for (int i = 0; i < GrandSlam.CargarDatos().size(); i++) {
			tableModel.addRow(GrandSlam.CargarDatos().get(i));
		}

		panelInferior = new JPanel();
		panelInferior.setPreferredSize(new Dimension(0, 45));
		panelInferior.setLayout(new FlowLayout(FlowLayout.TRAILING));
		this.add(panelInferior, BorderLayout.SOUTH);

		botonGuardar = new JButton("Guardar");
		panelInferior.add(botonGuardar);
		botonAnyadir = new JButton("Añadir");
		panelInferior.add(botonAnyadir);

		botonAnyadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String respuestaAnyo = JOptionPane.showInputDialog("Año");

				String[] listaTorenos = { "Open Australia", "Roland Garros", "Wimbeldon", "Open USA" };
				String respuestaTorneo1 = (JOptionPane.showInputDialog(null, "Torneo", "Input", 3, null, listaTorenos,
						0)).toString();

				String respuestaTorneo2;

				if (respuestaTorneo1.equals("Open Australia")) {
					respuestaTorneo2 = "1";
				} else if (respuestaTorneo1.equals("Roland Garros")) {
					respuestaTorneo2 = "2";

				} else if (respuestaTorneo1.equals("Wimbeldon")) {
					respuestaTorneo2 = "3";
				} else {
					respuestaTorneo2 = "4";
				}

				String respuestaCampeon = JOptionPane.showInputDialog("Ganador");

				String respuestaRankingCampeon = JOptionPane.showInputDialog("Ranking del ganador");

				String respuestaPaisCampeon = JOptionPane.showInputDialog("Pais del ganador");

				String respuestaSubcampeon = JOptionPane.showInputDialog("Subcampeon");

				String respuestaRankingSubcampeon = JOptionPane.showInputDialog("Ranking del subcampeon");

				String respuestaPaisSubampeon = JOptionPane.showInputDialog("Pais del subcampeon");

				String respuestaResultado = JOptionPane.showInputDialog("Resultado").replace(" ", ", ");

				String[] nuevoResultado = { respuestaAnyo, respuestaTorneo2, respuestaCampeon, respuestaRankingCampeon,
						respuestaPaisCampeon, respuestaSubcampeon, respuestaRankingSubcampeon, respuestaPaisSubampeon,
						respuestaResultado };

				tableModel.addRow(nuevoResultado);

				String nuevoResultadoArr = "";

				nuevoResultadoArr = nuevoResultadoArr + respuestaAnyo + ',' + respuestaTorneo2 + ',' + '\"'
						+ respuestaCampeon + '\"' + ',' + respuestaRankingCampeon + ',' + '\"' + respuestaPaisCampeon
						+ '\"' + ',' + '\"' + respuestaSubcampeon + '\"' + ',' + respuestaRankingSubcampeon + ',' + '\"'
						+ respuestaPaisSubampeon + '\"' + ',' + '\"' + respuestaResultado + '\"';

				nuevosResultados.add(nuevoResultadoArr);

				System.out.println(nuevosResultados);

			}
		});

		botonGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				File f = new File("ExcelGrandSlams.csv");
				
				
				try {
					FileWriter fw = new FileWriter(f);
					
					for (int i = 0; i < table.getRowCount(); i++) {
						fw.write(table.getValueAt(i, 0).toString() + ",");
						fw.write(table.getValueAt(i, 1).toString() + ",");
						fw.write("\"" + table.getValueAt(i, 2).toString() + "\"" + ",");
						fw.write(table.getValueAt(i, 3).toString() + ",");
						fw.write("\"" + table.getValueAt(i, 4).toString() + "\"" + ",");
						fw.write("\"" + table.getValueAt(i, 5).toString() + "\"" + ",");
						fw.write(table.getValueAt(i, 6).toString().toString() + ",");
						fw.write("\"" + table.getValueAt(i, 7).toString() + "\"" + ",");
						fw.write("\"" + table.getValueAt(i, 8).toString().replace(" ", ", ") + "\"" + "\n");
					}
					
					fw.close();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	public static ArrayList<String> getNuevosResultados() {
		return nuevosResultados;
	}

	public static JTable getTable() {
		return table;
	}

	
}
