package turismo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
	private List<Atraccion> atraccionesList = new ArrayList<Atraccion>();
	private List<Usuario> usuariosList = new ArrayList<Usuario>();
	
	public void crearAtracciones() {
		try {
			File file = new File("/home/pipemun/Documents/cessi/TP001-TurismoTierraMedia/atraccionesTexto.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String[] temp = sc.nextLine().strip().split(" ");
				String nombre = temp[0];
				int costo = Integer.parseInt(temp[1]);
				double tiempo = Double.parseDouble(temp[2]);
				int cupo = Integer.parseInt(temp[3]);
				Atraccion a1 = new Atraccion(nombre, costo, tiempo, cupo);
				System.out.println(a1);
				atraccionesList.add(a1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearPromociones() {
		try {
			File file = new File("/home/pipemun/Documents/cessi/TP001-TurismoTierraMedia/promocionesTexto.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String[] temp = sc.nextLine().strip().split(" ");
				if (temp[0].equalsIgnoreCase("ConDescuento")) {
					ConDescuento c1 = new ConDescuento();
				}
				String nombre = temp[0];
				int costo = Integer.parseInt(temp[1]);
				double tiempo = Double.parseDouble(temp[2]);
				int cupo = Integer.parseInt(temp[3]);
				Atraccion a1 = new Atraccion(nombre, costo, tiempo, cupo);
				System.out.println(a1);
				atraccionesList.add(a1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearUsuarios() {
		try {
			File file = new File("/home/pipemun/Documents/cessi/TP001-TurismoTierraMedia/usuariosTexto.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String[] temp = sc.nextLine().strip().split(" ");
				String nombre = temp[0];
				int presupuesto = Integer.parseInt(temp[1]);
				double tiempo = Double.parseDouble(temp[2]);
				Usuario u1 = new Usuario(nombre, presupuesto, tiempo);
				System.out.println(u1);
				usuariosList.add(u1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
