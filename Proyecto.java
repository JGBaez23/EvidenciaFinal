package Proyecto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Proyecto.Administrador.Doctor;
import Proyecto.Administrador.Paciente;

class GestorCita{
	
	private ArrayList<Cita> citas;
	private GestorDoctor doctores;
	private GestorPacientes pacientes;
	
	public GestorCita (GestorDoctor gestDoc, GestorPacientes gestPaci) {
		citas = new ArrayList<Cita>();
		doctores = gestDoc;
		pacientes = gestPaci;
	}

	public boolean nuevaCita() {
		String id = JOptionPane.showInputDialog(null, "Introduzca identificador:", "Nueva Cita", JOptionPane.QUESTION_MESSAGE);
		String fecha = JOptionPane.showInputDialog(null,"Fecha:", "Nuevo Fecha", JOptionPane.QUESTION_MESSAGE);
		String hora = JOptionPane.showInputDialog(null,"Hora:", "Nuevo Hora", JOptionPane.QUESTION_MESSAGE);
		String motivo = JOptionPane.showInputDialog(null,"Motivo:", "Nuevo Motivo", JOptionPane.QUESTION_MESSAGE);
		String iDdoctor = JOptionPane.showInputDialog(null,"ID del Doctor:", "Nuevo Doctor", JOptionPane.QUESTION_MESSAGE);
		String iDpaciente = JOptionPane.showInputDialog(null, "ID del Paciente", "Nuevo Paciente", JOptionPane.QUESTION_MESSAGE);
		
		GestorDoctor doctor = doctores.getDoctor(iDdoctor);
		Paciente paciente = pacientes.getPaciente(iDpaciente);
		
		Cita nuevoCita = new Cita(id, fecha, hora, motivo, doctor, paciente);
		return citas.add(nuevoCita);
		
	}

	public void mostrarCitas() {
		
	}
}
class GestorDoctor{
	
	private static final String Doctores = null;

	public void crearCSV() {
		
		File archivo = new File("C:\\Users\\jesus\\OneDrive\\Escritorio\\Certificado Java\\Evidencia 1\\EvidenciaFinal\\src\\Proyecto\\Doctores");
		
		try {
			
			boolean primeraVez = false;
			if(!archivo.exists("Doctores")) {
				File carpeta=archivo.getParentFile("C:\\Users\\jesus\\OneDrive\\Escritorio\\Certificado Java\\Evidencia 1\\EvidenciaFinal\\src\\Proyecto\\Doctores");
				carpeta.mkdir("Doctores");
				archivo.createNewFile("Doctores");
				primeraVez = true;
			}
			
			FileWriter escritor = new FileWriter(archivo, true);
			
			if(primeraVez)
				escritor.append("#ID;Nombre;Apellido;Especialidad\n");
			
			int ultimo = Doctor.size(Doctores) - 1;
			escritor.append(Doctores.get(ultimo).generaLineaCSV("C:\\Users\\jesus\\OneDrive\\Escritorio\\Certificado Java\\Evidencia 1\\EvidenciaFinal\\src\\Proyecto\\Doctores"));
			
			escritor.close();
		}catch(IOException e) {
			System.out.println("Error de acceso a:" + archivo.getAbsolutePath());
		}
		}

	public GestorDoctor getDoctor(String iDdoctor) {

		return null;
	}

	public void nuevoDoctor() {
		
	}

	public void modificarDoctor() {
		
	}

	public void mostrarDoctores() {
		
	}
		
		
	}
class GestorPacientes{
	
	private ArrayList<Paciente> pacientes;
public void crearCSV() {
		
		File archivo = new File("C:\\Users\\jesus\\OneDrive\\Escritorio\\Certificado Java\\Evidencia 1\\EvidenciaFinal\\src\\Proyecto\\Pacientes");
		
		try {
			
			boolean primeraVez = false;
			if(!archivo.exist("Pacientes")) {
				File carpeta=archivo.getParentFile("C:\\Users\\jesus\\OneDrive\\Escritorio\\Certificado Java\\Evidencia 1\\EvidenciaFinal\\src\\Proyecto\\Pacientes");
				carpeta.mkdir("Pacientes");
				archivo.createNewFile("Pacientes");
				primeraVez = true;
			}
			
			FileWriter escritor = new FileWriter(archivo, true);
			
			if(primeraVez)
				escritor.append("#ID;Nombre;Apellido\n");
			
			int ultimo = Paciente.size() - 1;
			escritor.append(pacientes.get(ultimo).generaLineaCSV("C:\\Users\\jesus\\OneDrive\\Escritorio\\Certificado Java\\Evidencia 1\\EvidenciaFinal\\src\\Proyecto\\Pacientes"));
			
			escritor.close();
		}catch(IOException e) {
			System.out.println("Error de acceso a:" + archivo.getAbsolutePath());
		}
		}
public Paciente getPaciente(String iDpaciente) {
	
	return null;
}
public void nuevoPaciente() {
	
}
public void mostrarPacientes() {
	
}
public void borrarPaciente() {
	
}
		
		
	}

class Cita{
	
	private String motivo;
	private Object paciente;
	
	public Cita (String id, String fecha, String hora, String motivo, GestorDoctor doctor, Paciente paciente2) {
		
		this.motivo = motivo;
		this.paciente = paciente2;
				
	}
	
	public String getMotivo() {
		return motivo;
	}
	
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public Object getPaciente() {
		return paciente;
		
	}
	
	public void setPaciente (String paciente) {
		this.paciente = paciente;
		
	}
}
class Administrador{
	private static final Doctor[] Doctores = null;
	private String nombre;
	private String password;
	
	public Administrador (String nom, String pass) {
		nombre = nom;
		password = pass;
		
	}

	public boolean equials (Object objeto) {
		if (objeto instanceof Administrador) {
			
			Administrador otroAdmin = (Administrador) objeto;
			
			if(nombre.equals(otroAdmin.nombre) && password.equals(otroAdmin.password))
				return true;
			else
				return false;
		}
		else
			return false;
		
	}
class Paciente{
	
	private String id;
	private String nombre;
	private String apellidos;
	
	public String generaLineaCSV(String string) {
		return String.format("%s;%s;%s;%s;\n", id, nombre, apellidos);
	}
		
	
	
	public static int size() {
		return 0;
	}



	public Paciente(String id, String nombre, String apellidos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
}
class Doctor{
	
	private String id;
	private String nombre;
	private String apellidos;
	private String especialidad;
	
	public Doctor(String id, String nombre, String apellidos, String especialidad) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
	}
	
	public static int size(String doctores) {
		return 0;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;	
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
}

public void mostrar(String especialidad) {
	String id = null;
	String apellidos = null;
	String mensaje = "ID doctor: " + id + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nEspecialidad: " + especialidad;
	JOptionPane.showMessageDialog(null, mensaje, "Mostrar doctor", JOptionPane.INFORMATION_MESSAGE);
}

public Doctor getDoctor(String id) {
	for(Doctor doc: Doctores)
		if(doc.getId().equals(id))
			return doc;
	return null;
}

public class Proyecto {
	private static ArrayList<Administrador> administradores = new ArrayList<Administrador>();
	private static Scanner teclado = new Scanner (System.in);
	static GestorDoctor doctores = new GestorDoctor();
	static GestorPacientes pacientes = new GestorPacientes();
	static GestorCita citas = new GestorCita(doctores, pacientes);
	
	
	public static void main (String[] args) {
		
		crearAdmins();

		
			if(validarAcceso()) {
				System.out.println("\nUsuario autorizado\n");
				doctores.nuevoDoctor();
				doctores.modificarDoctor();
				doctores.mostrarDoctores();
				pacientes.nuevoPaciente();
				pacientes.mostrarPacientes();
				pacientes.borrarPaciente();
				citas.nuevaCita();
				citas.mostrarCitas();
				
			}
			else
				System.out.println("\nUsuario no autorizado.");
						
			System.out.println("\n\t\tFIN DE PROGRAMA");
		}


	private static void crearAdmins() {
		
	}
	}

public static boolean validarAcceso() {
	return false;
}

}
