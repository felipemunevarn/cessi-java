package turismo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sistema {
	private static List<Atraccion> atraccionesList = new ArrayList<Atraccion>();
	private List<Usuario> usuariosList = new ArrayList<Usuario>();
	private List<Promocion> promosList = new ArrayList<Promocion>();
	
	public void crearAtracciones() {
		try {
			File file = new File("/home/pipemun/Documents/cessi/TP001-TurismoTierraMedia/atraccionesTexto.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String[] temp = sc.nextLine().strip().split("/");
				String nombre = temp[0];
				int costo = Integer.parseInt(temp[1]);
				double tiempo = Double.parseDouble(temp[2]);
				int cupo = Integer.parseInt(temp[3]);
				Atraccion a1 = new Atraccion(nombre, costo, tiempo, cupo);
//				System.out.println(a1);
				atraccionesList.add(a1);
				sc.close();
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
				String[] temp = sc.nextLine().strip().split("/");
				if (temp[0].equalsIgnoreCase("ConDescuento")) {
					String nombre = temp[1];
					int costo = Integer.parseInt(temp[2]);
					String[] arrTemp = Arrays.copyOfRange(temp, 3, temp.length);
					ConDescuento p1 = new ConDescuento(nombre, costo, arrTemp);
//					System.out.println(p1);
					promosList.add(p1);
				}
				if (temp[0].equalsIgnoreCase("Porcentual")) {
					String nombre = temp[1];
					int dcto = Integer.parseInt(temp[2]);
					String[] arrTemp = Arrays.copyOfRange(temp, 3, temp.length);
					Porcentual p1 = new Porcentual(nombre, dcto, arrTemp);
//					System.out.println(p1);
					promosList.add(p1);
				}
				if (temp[0].equalsIgnoreCase("AxB")) {
					String nombre = temp[1];
					String[] arrTemp1 = Arrays.copyOfRange(temp, 2, temp.length);
					String[] arrTemp2 = sc.nextLine().strip().split("/");
					AxB p1 = new AxB(nombre, arrTemp1, arrTemp2);
//					System.out.println(p1);
					promosList.add(p1);
				}
			}
			sc.close();
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
//				System.out.println(u1);
				usuariosList.add(u1);
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Atraccion> getAtraccionesList() {
		return atraccionesList;
	}

	public List<Usuario> getUsuariosList() {
		return usuariosList;
	}

	public List<Promocion> getPromosList() {
		return promosList;
	}	
	
	public void saludar(Usuario user) {
		System.out.println("Hola " + user.getNombre() + "!!!");
	}
	
	public List<Producto> filtrarProdPosibles(Usuario user) {
		List<Producto> p1 = new ArrayList<Producto>(), p2 = new ArrayList<Producto>();
		p1.addAll(atraccionesList);
		p1.addAll(promosList);
		List<Producto> productosPosiblesList = new ArrayList<Producto>();
		for (int i = 0; i < p1.size(); i++) {
			if (user.getPresupuesto() >= p1.get(i).costo) {
				productosPosiblesList.add(p1.get(i));
			}			
		}
		return productosPosiblesList;
	}
	
	public boolean preguntar(Producto producto) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quiere: " + producto);
		String respuesta = sc.nextLine();
//		sc.close();
		return respuesta.equalsIgnoreCase("s");
	}
}
