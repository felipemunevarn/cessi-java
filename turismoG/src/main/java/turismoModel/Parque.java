package turismoModel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import turismoDAO.AtraccionDAO;
import turismoDAO.PromocionDAO;
import turismoDAO.UsuarioDAO;

public class Parque {
	private List<Atraccion> atraccionesList = new ArrayList<Atraccion>();
	private List<Usuario> usuariosList = new ArrayList<Usuario>();
	private List<Promocion> promosList = new ArrayList<Promocion>();
	private List<Ofertable> sugerencias = new ArrayList<Ofertable>();

	public void agregarAtraccionesALista(Ofertable ofertable, List<Ofertable> listaAtracciones) {
		if (ofertable.esPromocion()) {
			for (int i = 0; i < ofertable.getAtraccionesList().size(); i++) {
				listaAtracciones.add(this.atraccionesList.get(i));
			}
		} else {
			listaAtracciones.add(ofertable);
		}
	}

	public void crearAtracciones() throws SQLException {
		AtraccionDAO adao = new AtraccionDAO();
		atraccionesList = adao.findAll();	
	}

	public void crearPromociones() throws SQLException {
		PromocionDAO pdao = new PromocionDAO();
		List<AxB> promoAxB = pdao.findAllAxB();
		List<Absoluto> promoAbsolut = pdao.findAllAbsoluto();
		List<Descuento> promoDcto = pdao.findAllDescuento();
		promosList.addAll(promoAxB);
		promosList.addAll(promoAbsolut);
		promosList.addAll(promoDcto);
	}

	public void crearUsuarios() throws SQLException {
		UsuarioDAO udao = new UsuarioDAO();
		usuariosList = udao.findAll();
	}

	public void listaSugerencias() {
		this.sugerencias.addAll(promosList);
		this.sugerencias.addAll(atraccionesList);
	}

	public void ordenarSugerencias() {
		Collections.sort(promosList, new Ordenador());
		Collections.sort(atraccionesList, new Ordenador());
	}

	public int costoMinimoAtraccionOPromocion() {
		int costoMinimo = sugerencias.get(0).getCosto();
		for (int i = 0; i < sugerencias.size(); i++) {
			if (sugerencias.get(i).getCosto() < costoMinimo) {
				costoMinimo = sugerencias.get(i).getCosto();
			}
		}
		return costoMinimo;
	}

	public double tiempoMinimoAtraccionOPromocion() {
		Double tiempoMinimo = sugerencias.get(0).getTiempo();
		for (int i = 0; i < sugerencias.size(); i++) {
			if (sugerencias.get(i).getCosto() < tiempoMinimo) {
				tiempoMinimo = sugerencias.get(i).getTiempo();
			}
		}
		return tiempoMinimo;
	}

	public void ofertarMientrasHayaOroYtiempo(Usuario usuario) throws IOException {

		List<Ofertable> atraccionesAceptadas = new ArrayList<Ofertable>();
		List<Ofertable> itinerario = new ArrayList<Ofertable>();
		int i = 0;
		this.ordenarSugerencias();
		this.listaSugerencias();

		while (usuario.getTiempo() > tiempoMinimoAtraccionOPromocion()
				&& usuario.getPresupuesto() > costoMinimoAtraccionOPromocion()) {
			if (i == sugerencias.size()) {
				i = 0;
			}
			if (sugerencias.get(i).esPromocion()) {
				if (!estaAtraccionEnPromocion( sugerencias.get(i), atraccionesAceptadas)
						&& sugerencias.get(i).hayCupo() && sugerencias.get(i).getCosto() < usuario.getPresupuesto()
						&& sugerencias.get(i).getTiempo() < usuario.getTiempo()) {
					if (usuario.aceptaOferta(sugerencias.get(i))) {
						ofertaAceptada(usuario, itinerario, i, atraccionesAceptadas);
					}
				}
			} else if (!sugerencias.get(i).esPromocion()) {
				if (!estaAtraccionEnAtracciones(sugerencias.get(i), atraccionesAceptadas)
						&& sugerencias.get(i).hayCupo() && sugerencias.get(i).getCosto() < usuario.getPresupuesto()
						&& sugerencias.get(i).getTiempo() < usuario.getTiempo()) {
					if (usuario.aceptaOferta(sugerencias.get(i))) {
						ofertaAceptada(usuario, itinerario, i, atraccionesAceptadas);
					}
				}
			}
			if (i < sugerencias.size()) {
				i++;
			}
			usuario.setItinerario(itinerario);
		}
	}

	public void ofertaAceptada(Usuario usuario, List<Ofertable> itinerario, int i, List<Ofertable> atraccionesAceptadas) {
		usuario.restarPresupuesto(sugerencias.get(i).getCosto());
		usuario.restarTiempo(sugerencias.get(i).getTiempo());
		sugerencias.get(i).reservarCupo();
		itinerario.add(sugerencias.get(i));
		this.agregarAtraccionesALista(sugerencias.get(i), atraccionesAceptadas);
	}

	public boolean estaAtraccionEnAtracciones(Ofertable unaAtraccion2, List<Ofertable> atraccionesAceptadas) {

		for (Ofertable unaAtraccion : atraccionesAceptadas) {

			if (unaAtraccion.equals(unaAtraccion2)) {
				return true;
			}
		}
		return false;
	}

	public boolean estaAtraccionEnPromocion(Ofertable ofertable, List<Ofertable> atraccionesAceptadas) {

		for (Ofertable unaAtraccion : ofertable.getAtraccionesList()) { // atracciones inclu�das.

			if (estaAtraccionEnAtracciones(unaAtraccion, atraccionesAceptadas)) {
				return true;
			}
		}
		return false;
	}

	public void imprimirItinerario(Usuario usuario) throws IOException {
		int costoTotal = 0;
		double tiempoTotal = 0.0;
		PrintWriter salida = new PrintWriter(new FileWriter(usuario.getNombre() + " Itinerario.out"));

		salida.println("Usted ha comprado: ");
		System.out.println("Usted ha comprado: ");

		for (int i = 0; i < usuario.getItinerario().size(); i++) {
			costoTotal += usuario.getItinerario().get(i).getCosto();
			tiempoTotal += usuario.getItinerario().get(i).getTiempo();
			salida.println((i + 1) + ". " + usuario.getItinerario().get(i).getNombre().toUpperCase());
			System.out.println((i + 1) + ". " + usuario.getItinerario().get(i).getNombre().toUpperCase());
			salida.println("El costo total de su itinerario es: " + costoTotal + " monedas.");
			salida.println("El tiempo total de su itinerario es: " + tiempoTotal + " horas.");
			System.out.println("El costo total de su itinerario es: " + costoTotal + " monedas.");
			System.out.println("El tiempo total de su itinerario es " + tiempoTotal + " horas.");
		}
		salida.close();
	}

	public List<Usuario> getUsuariosList() {
		return usuariosList;
	}

	public void ofertarMientrasHayaOroYtiempoAtodosLosUsuarios() throws IOException {
		for (int i = 0; i < usuariosList.size(); i++) {
			mensajeBienvenida();
			System.out.println("Bienvenido/a: " + usuariosList.get(i).getNombre());
			ofertarMientrasHayaOroYtiempo(usuariosList.get(i));
			imprimirItinerario(usuariosList.get(i));
			System.out.println("-----------------------------------------------------------------");
		}
	}

	public void mensajeBienvenida() {
		System.out.println("Bienvenido/a Turismo en la Tierra Media!");
		System.out.println(
				"A continuaci�n encontrar�s nuestras Atracciones y Promociones. Pulsa S para aceptar, o N para rechazar");
		System.out.println("-----------------------------------------------------------------");
	}

	public static void main(String[] args) throws IOException, SQLException {

		Parque sistema = new Parque();

		sistema.crearUsuarios();
		sistema.crearAtracciones();
		sistema.crearPromociones();

		sistema.ordenarSugerencias();
		sistema.listaSugerencias();

		sistema.ofertarMientrasHayaOroYtiempoAtodosLosUsuarios();
	}
}
