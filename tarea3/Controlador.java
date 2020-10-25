package tarea3;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;

 class Controlador implements ActionListener {

	 Modelo  modelo;
	 Vista  vista;
	 
	 public Controlador (Modelo m, Vista v) {
		 modelo = m;
		 vista = v;
		 
		 vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 vista.setSize(250,250);
		 vista.setLocationRelativeTo(null);
		 vista.setVisible(true);
		 
		 vista.setControlodor(this); //agregado
		//*  
		 //vista.entrar.addActionListener(this);
		// vista.usuario.addActionListener(this);
		 
		// vista.Registrar.addActionListener(this);
		// *
	 }
	
	public void actionPerformed(ActionEvent e) {
	
		//agregado
		//@Override
		switch(e.getActionCommand()) {
		
		case interfazVista1.Ingresar:
			
			//inicia lectura de archivo
			File file = new File("archivoLogin.txt");
			//"C:/Users/osval/OneDrive/Escritorio/Trabajos JAVA/Topicos Avanzados de Programacion/src/tarea3/niu.txt"
			ArrayList lista = new ArrayList<>();
			
			//vista.usuario.setText(null);
			//vista.contrasena.setText(null);
			int x=0;
			
			try {
				Scanner scanner = new Scanner(file);
				
				
				
				
					String linea = scanner.nextLine();
					Scanner delimitar = new Scanner (linea);
					delimitar.useDelimiter("\\s*,\\s*");
					//String nC, nU;
					

					if( vista.usuario.getText().equals(delimitar.next()) && modelo.convertirSHA256(vista.contrasena.getText()).equals(delimitar.next())  ) {
						
						JOptionPane.showMessageDialog(null, "Bienvenido ;v","Ingresando" ,JOptionPane.INFORMATION_MESSAGE);
						VistaP p = new VistaP (this, true);
						p.setVisible(true);
						p.setSize(300,200);
						p.setLocationRelativeTo(null);
						x=1;
						
						
					}else {
						
				
						JOptionPane.showMessageDialog(null, "SAQUESE >:v", "ERROR", JOptionPane.ERROR_MESSAGE);
					vista.usuario.setText("");
					vista.contrasena.setText("");
					vista.usuario.requestFocus();
					;
			}
					
				
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.print("ERROR: " + e1.getMessage());
			}
			
			//Termina... por ahora
			
			
			//codigo alterno
			
			
			break;
			
		case interfazVista1.RegistrarU:
			
			try {
				FileWriter esc = new FileWriter ("archivoLogin.txt", true);
				//"C:/Users/osval/OneDrive/Escritorio/Trabajos JAVA/Topicos Avanzados de Programacion/src/tarea3/niu.txt"
				BufferedWriter bw = new BufferedWriter(esc);
				bw.write(vista.usuario.getText() + " , " + modelo.convertirSHA256(vista.contrasena.getText()) + "\n");
				
				bw.close();
				esc.close();
			
			
				
			} catch (IOException ecsdi) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "ERROR INESPERADO");
			}
			
			vista.usuario.setText("");
			vista.contrasena.setText("");
			vista.usuario.requestFocus();
			break;
		
		}
		//finagregado
		
	
		
		
	
		
	}
	
	
	
	
	 
}
