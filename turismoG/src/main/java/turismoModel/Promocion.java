package turismoModel;

import java.sql.SQLException;
import java.util.List;

import turismoDAO.AtraccionDAO;

public class Promocion implements Ofertable {
	protected List<Atraccion> atraccionesList;
	protected String nombre;

	public Promocion(String nombre, List<Atraccion> atraccionesList) {
		this.nombre = nombre;
		this.atraccionesList = atraccionesList;
	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + nombre + ", atraccionesList=" + atraccionesList + "]";
	}

	@Override
	public boolean hayCupo() {
		int i = 0;
		boolean estaDisponible = true;
		while (i < atraccionesList.size() && estaDisponible) {
			if (!atraccionesList.get(i).hayCupo()) {
				return false;
			}
			i++;
		}
		return estaDisponible;
	}

	@Override
	public Integer getCosto() {
		int costoTotal = 0;
		for (int i = 0; i < atraccionesList.size(); i++) {
			costoTotal += atraccionesList.get(i).getCosto();
		}
		return costoTotal;
	}

	public Integer getCostoSinDescuento() {
		int costoTotal = 0;
		for (int i = 0; i < atraccionesList.size(); i++) {
			costoTotal += atraccionesList.get(i).getCosto();
		}
		return costoTotal;
	}

	@Override
	public Double getTiempo() {
		double tiempoHastaAhora = 0;
		for (int i = 0; i < atraccionesList.size(); i++) {
			tiempoHastaAhora += atraccionesList.get(i).getTiempo();
		}
		return tiempoHastaAhora;
	}

	@Override
	public void reservarCupo() throws SQLException {
		for (int i = 0; i < atraccionesList.size(); i++) {
			atraccionesList.get(i).reservarCupo();
			int atracId = AtraccionDAO.findIdByName(atraccionesList.get(i).getNombre());
			AtraccionDAO.updateCupo(atracId, atraccionesList.get(i).getCupo());
		}
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public boolean esPromocion() {
		// TODO Auto-generated method stub
		return true;
	}

	public List<Atraccion> getAtraccionesList() {
		return atraccionesList;
	}

	@Override
	public void imprimirOferta() {
		// TODO Auto-generated method stub
	}

//	@Override
//	public void agregarAtraccionesALista(Ofertable ofertable, List<Atraccion> listaAtracciones) {
//		for (int i = 0; i < getAtraccionesList().size(); i++) {
//			listaAtracciones.add(this.atraccionesList.get(i));
//		}
//	}

}
