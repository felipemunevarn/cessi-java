package turismoModel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import turismoDAO.AtraccionDAO;
import turismoDAO.ItinerarioDAO;
import turismoDAO.PromocionDAO;
import turismoDAO.UsuarioDAO;

public class Parque {
	private List<Atraccion> atraccionesList = new ArrayList<Atraccion>();
	private List<Usuario> usuariosList = new ArrayList<Usuario>();
	private List<Promocion> promosList = new ArrayList<Promocion>();
	private List<Ofertable> sugerencias = new ArrayList<Ofertable>();

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

	public void ofertarMientrasHayaOroYtiempo(Usuario usuario) throws IOException, SQLException {
		List<Ofertable> atraccionesAceptadas = new ArrayList<Ofertable>();
		List<Ofertable> itinerario = new ArrayList<Ofertable>();
		List<Atraccion> atraccPreviasAceptadas = new ArrayList<Atraccion>();
		List<Promocion> promoPreviasAceptadas = new ArrayList<Promocion>();
		
		UsuarioDAO udao = new UsuarioDAO();		
		int usuarioId = udao.findIdByName(usuario.getNombre());
		
		ItinerarioDAO idao = new ItinerarioDAO();
		atraccPreviasAceptadas = idao.findAtracByUserId(usuarioId);
		for (Atraccion atraccion : atraccPreviasAceptadas) {
			agregarAtraccionesALista(atraccion, atraccionesAceptadas);
		}
		promoPreviasAceptadas = idao.findPromoByUserId(usuarioId);
		for (Promocion promo : promoPreviasAceptadas) {
			agregarAtraccionesALista(promo, atraccionesAceptadas);
		}
		
		PromocionDAO pdao = new PromocionDAO();
		AtraccionDAO adao = new AtraccionDAO();
				
		for (int i = 0; i < sugerencias.size(); i++) {
			if (usuario.getTiempo() > tiempoMinimoAtraccionOPromocion()
					&& usuario.getPresupuesto() > costoMinimoAtraccionOPromocion()) {			
				if (sugerencias.get(i).esPromocion()) {
					if (!estaAtraccionEnPromocion( sugerencias.get(i), atraccionesAceptadas)
							&& sugerencias.get(i).hayCupo() && sugerencias.get(i).getCosto() <= usuario.getPresupuesto()
							&& sugerencias.get(i).getTiempo() <= usuario.getTiempo()) {
						if (usuario.aceptaOferta(sugerencias.get(i))) {
													
							int promoId = pdao.findIdByName(sugerencias.get(i).getNombre());
							idao.insert(usuarioId, promoId, 0);
							
							ofertaAceptada(usuario, itinerario, i, atraccionesAceptadas);
						}
					}
				} else if (!sugerencias.get(i).esPromocion()) {
					if (!estaAtraccionEnAtracciones(sugerencias.get(i), atraccionesAceptadas)
							&& sugerencias.get(i).hayCupo() && sugerencias.get(i).getCosto() <= usuario.getPresupuesto()
							&& sugerencias.get(i).getTiempo() <= usuario.getTiempo()) {
						if (usuario.aceptaOferta(sugerencias.get(i))) {
							
							int atracId = adao.findIdByName(sugerencias.get(i).getNombre());
							idao.insert(usuarioId, 0, atracId);
							
							ofertaAceptada(usuario, itinerario, i, atraccionesAceptadas);
						}
					}
				}
				usuario.setItinerario(itinerario);
			}
		}
	}

	public void ofertaAceptada(Usuario usuario, List<Ofertable> itinerario, int i, List<Ofertable> atraccionesAceptadas) throws SQLException {
		usuario.restarPresupuesto(sugerencias.get(i).getCosto());
		usuario.restarTiempo(sugerencias.get(i).getTiempo());
		sugerencias.get(i).reservarCupo();
		if (!sugerencias.get(i).esPromocion()) {
			int atracId = AtraccionDAO.findIdByName(sugerencias.get(i).getNombre());
			AtraccionDAO.updateCupo(atracId, sugerencias.get(i).getCupo());
		} else {
//			int promoId = PromocionDAO.findIdByName(sugerencias.get(i).getNombre());
			sugerencias.get(i).reservarCupo();
		}
		
		itinerario.add(sugerencias.get(i));
		
		this.agregarAtraccionesALista(sugerencias.get(i), atraccionesAceptadas);
	}
	
	public void agregarAtraccionesALista(Ofertable ofertable, List<Ofertable> atraccionesAceptadas) {
		if (ofertable.esPromocion()) {
			for (int i = 0; i < ofertable.getAtraccionesList().size(); i++) {
				atraccionesAceptadas.add(this.atraccionesList.get(i));
			}
		} else {
			atraccionesAceptadas.add(ofertable);
		}
	}

	public boolean estaAtraccionEnAtracciones(Ofertable unaAtraccion2, List<Ofertable> atraccionesAceptadas) {

		for (Ofertable unaAtraccion : atraccionesAceptadas) {

			if (unaAtraccion.getNombre().equals(unaAtraccion2.getNombre())) {
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
		System.out.println("Usted ha comprado: ");

		for (int i = 0; i < usuario.getItinerario().size(); i++) {
			costoTotal += usuario.getItinerario().get(i).getCosto();
			tiempoTotal += usuario.getItinerario().get(i).getTiempo();
			System.out.println((i + 1) + ". " + usuario.getItinerario().get(i).getNombre().toUpperCase());
			System.out.println("El costo total de su itinerario es: " + costoTotal + " monedas.");
			System.out.println("El tiempo total de su itinerario es " + tiempoTotal + " horas.");
		}
	}

	public List<Usuario> getUsuariosList() {
		return usuariosList;
	}

	public void ofertarMientrasHayaOroYtiempoAtodosLosUsuarios() throws IOException, SQLException {
		for (int i = 0; i < usuariosList.size(); i++) {
			mensajeBienvenida();
			System.out.println("Bienvenido/a: " + usuariosList.get(i).getNombre());
			ofertarMientrasHayaOroYtiempo(usuariosList.get(i));
			imprimirItinerario(usuariosList.get(i));
			actualizarDatosUserBD(usuariosList.get(i));
			System.out.println("-----------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------");
		}
	}

	private void actualizarDatosUserBD(Usuario usuario) throws SQLException {
		UsuarioDAO udao = new UsuarioDAO();
		int userID = udao.findIdByName(usuario.getNombre());
		udao.updatePresupuestoYTiempo(userID, usuario.getPresupuesto(), usuario.getTiempo());
	}

	public void mensajeBienvenida() {
		System.out.println("Bienvenido/a Turismo en la Tierra Media!");
		System.out.println(
				"A continuación encontrarás nuestras Atracciones y Promociones. Pulsa S para aceptar, o N para rechazar");
		System.out.println("-----------------------------------------------------------------");
	}
}
