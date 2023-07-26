package controlador;

import java.util.ArrayList;

import dao.EditorialesDAO;
import dao.LibrosDAO;
import excepciones.BBDDException;
import modelo.Editorial;
import modelo.Libro;
import vistas.NuevaEditorialDialog;
import vistas.NuevoLibroDialog;
import vistas.VentanaPpal;

public class Controlador {
	
	// Lista de Libros
	private ArrayList<Libro> listaLibros;
	
	// Referencias a las ventanas de la aplicación
	private VentanaPpal vPrincipal;
	private NuevoLibroDialog dNuevoLibro;
	private NuevaEditorialDialog dNuevaEditorial;
	
	// Definimos los objetos de acceso a datos (DAO)
	LibrosDAO daoLibro;
	EditorialesDAO daoEditoriales;
	
	public Controlador() {
		
		// Instanciamos las ventanas/cuadro de diálogo
		this.vPrincipal = new VentanaPpal();
		this.dNuevoLibro = new NuevoLibroDialog();
		this.dNuevaEditorial = new NuevaEditorialDialog();
		
		// Pasamos una copia del controlador a las vistas.
		this.vPrincipal.setControlador(this);
		this.dNuevoLibro.setControlador(this);
		this.dNuevaEditorial.setControlador(this);
		
		// Instanciamos el DAO del Libro
		this.daoLibro = new LibrosDAO();
		this.daoEditoriales = new EditorialesDAO();
	}
	
	public void iniciarPrograma() {
		this.vPrincipal.setVisible(true);
	}

	public void mostrarInsertarLibro() {
		this.dNuevoLibro.setModal(true);
		this.dNuevoLibro.setVisible(true);
	}

	public void insertaLibro(Libro l) throws BBDDException {
		this.daoLibro.insertarLibro(l);
		this.dNuevoLibro.setVisible(false);
		
	}

	public void mostrarInsertarEditorial() {
		this.dNuevaEditorial.setModal(true);
		this.dNuevaEditorial.setVisible(true);
		
	}

	public void insertarEditorial(Editorial ed) throws BBDDException {
		this.daoEditoriales.insertarEditorial(ed);
		this.dNuevaEditorial.setVisible(false);
		
	}

	
	
	
	
	
	

}
