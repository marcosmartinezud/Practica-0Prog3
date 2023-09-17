package tenistas;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTable;

import java.io.*;

public class GrandSlam {

	protected String anyo;
	protected String torneo;
	protected String campeon;
	protected String rankingCampeon;
	protected String paisCampeon;
	protected String Subcampeon;
	protected String rankingSubcampeon;
	protected String paisSubampeon;
	protected String resultado;

	public GrandSlam() {
		super();
		this.anyo = "";
		this.torneo = "";
		this.campeon = "";
		this.rankingCampeon = "";
		this.paisCampeon = "";
		this.Subcampeon = "";
		this.rankingSubcampeon = "";
		this.paisSubampeon = "";
		this.resultado = "";
	}

	public GrandSlam(String anyo, String torneo, String campeon, String rankingCampeon, String paisCampeon,
			String Subcampeon, String rankingSubcampeon, String paisSubampeon, String resultado) {
		super();
		this.anyo = anyo;
		this.torneo = torneo;
		this.campeon = campeon;
		this.rankingCampeon = rankingCampeon;
		this.paisCampeon = paisCampeon;
		this.Subcampeon = Subcampeon;
		this.rankingSubcampeon = rankingSubcampeon;
		this.paisSubampeon = paisSubampeon;
		this.resultado = resultado;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public String getCampeon() {
		return campeon;
	}

	public void setCampeon(String campeon) {
		this.campeon = campeon;
	}

	public String getRankingCampeon() {
		return rankingCampeon;
	}

	public void setRankingCampeon(String rankingCampeon) {
		this.rankingCampeon = rankingCampeon;
	}

	public String getPaisCampeon() {
		return paisCampeon;
	}

	public void setPaisCampeon(String paisCampeon) {
		this.paisCampeon = paisCampeon;
	}

	public String getSubcampeon() {
		return Subcampeon;
	}

	public void setSubcampeon(String Subcampeon) {
		this.Subcampeon = Subcampeon;
	}

	public String getRankingSubcampeon() {
		return rankingSubcampeon;
	}

	public void setRankingSubcampeon(String rankingSubampeon) {
		this.rankingSubcampeon = rankingSubampeon;
	}

	public String getPaisSubcampeon() {
		return paisSubampeon;
	}

	public void setPaisSubcampeon(String paisSubampeon) {
		this.paisSubampeon = paisSubampeon;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "GrandSlam [anyo=" + anyo + ", torneo=" + torneo + ", campeon=" + campeon + ", rankingCampeon="
				+ rankingCampeon + ", paisCampeon=" + paisCampeon + ", Subcampeon=" + Subcampeon
				+ ", rankingSubcampeon=" + rankingSubcampeon + ", paisSubampeon=" + paisSubampeon + ", resultado="
				+ resultado + "]";
	}

	public static ArrayList<String[]> CargarDatos() {

		ArrayList<GrandSlam> listaGrandSlams = new ArrayList<GrandSlam>();
		ArrayList<String[]> listaDefinitiva = new ArrayList<String[]>();

		try {
			Scanner sc = new Scanner(new File("ExcelGrandSlams.csv"));

			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				if (campos.length == 13) {
					GrandSlam nuevo = new GrandSlam(campos[0], campos[1], campos[2].replace("\"", ""), campos[3],
							campos[4].replace("\"", ""), campos[5].replace("\"", ""), campos[6],
							campos[7].replace("\"", ""),
							(campos[8] + campos[9] + campos[10] + campos[11] + campos[12]).replace("\"", ""));
					String[] listaProvisional = { nuevo.getAnyo(), nuevo.getTorneo(), nuevo.getCampeon(),
							nuevo.getRankingCampeon(), nuevo.getPaisCampeon(), nuevo.getSubcampeon(),
							nuevo.getRankingSubcampeon(), nuevo.getPaisSubcampeon(), nuevo.getResultado() };
					listaDefinitiva.add(listaProvisional);
				} else if (campos.length == 12) {
					GrandSlam nuevo = new GrandSlam(campos[0], campos[1], campos[2].replace("\"", ""), campos[3],
							campos[4].replace("\"", ""), campos[5].replace("\"", ""), campos[6],
							campos[7].replace("\"", ""),
							(campos[8] + campos[9] + campos[10] + campos[11]).replace("\"", ""));
					String[] listaProvisional = { nuevo.getAnyo(), nuevo.getTorneo(), nuevo.getCampeon(),
							nuevo.getRankingCampeon(), nuevo.getPaisCampeon(), nuevo.getSubcampeon(),
							nuevo.getRankingSubcampeon(), nuevo.getPaisSubcampeon(), nuevo.getResultado() };
					listaDefinitiva.add(listaProvisional);
				} else if (campos.length == 11) {
					GrandSlam nuevo = new GrandSlam(campos[0], campos[1], campos[2].replace("\"", ""), campos[3],
							campos[4].replace("\"", ""), campos[5].replace("\"", ""), campos[6],
							campos[7].replace("\"", ""), (campos[8] + campos[9] + campos[10]).replace("\"", ""));
					String[] listaProvisional = { nuevo.getAnyo(), nuevo.getTorneo(), nuevo.getCampeon(),
							nuevo.getRankingCampeon(), nuevo.getPaisCampeon(), nuevo.getSubcampeon(),
							nuevo.getRankingSubcampeon(), nuevo.getPaisSubcampeon(), nuevo.getResultado() };
					listaDefinitiva.add(listaProvisional);
				} else if (campos.length == 17) {
					GrandSlam nuevo = new GrandSlam(campos[0], campos[1], campos[2].replace("\"", ""), campos[3],
							campos[4].replace("\"", ""), campos[5].replace("\"", ""), campos[6],
							campos[7].replace("\"", ""),
							(campos[8] + campos[10] + campos[12] + campos[14] + campos[16]).replace("\"", ""));
					String[] listaProvisional = { nuevo.getAnyo(), nuevo.getTorneo(), nuevo.getCampeon(),
							nuevo.getRankingCampeon(), nuevo.getPaisCampeon(), nuevo.getSubcampeon(),
							nuevo.getRankingSubcampeon(), nuevo.getPaisSubcampeon(), nuevo.getResultado() };
					listaDefinitiva.add(listaProvisional);
				} else if (campos.length == 15) {
					GrandSlam nuevo = new GrandSlam(campos[0], campos[1], campos[2].replace("\"", ""), campos[3],
							campos[4].replace("\"", ""), campos[5].replace("\"", ""), campos[6],
							campos[7].replace("\"", ""),
							(campos[8] + campos[10] + campos[12] + campos[14]).replace("\"", ""));
					String[] listaProvisional = { nuevo.getAnyo(), nuevo.getTorneo(), nuevo.getCampeon(),
							nuevo.getRankingCampeon(), nuevo.getPaisCampeon(), nuevo.getSubcampeon(),
							nuevo.getRankingSubcampeon(), nuevo.getPaisSubcampeon(), nuevo.getResultado() };
					listaDefinitiva.add(listaProvisional);
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaDefinitiva;

	}

}
