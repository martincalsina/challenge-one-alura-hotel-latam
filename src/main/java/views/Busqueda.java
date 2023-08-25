package views;

import com.ar.alura.challene.hotel.alura.controller.HuespedController;
import com.ar.alura.challene.hotel.alura.controller.ReservaController;
import com.ar.alura.challene.hotel.alura.model.Huesped;
import com.ar.alura.challene.hotel.alura.model.Reserva;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
        
        private ReservaController reservaController = new ReservaController();
        private HuespedController huespedController = new HuespedController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
                //inicializacion de la tabla de reservas
                actualizarTodasLasReservas();
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
                
                //inicializacion de la tabla de huespedes
                actualizarTodosLosHuespedes();
                
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
                
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
                
                btnEditar.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int selectedIndex = panel.getSelectedIndex();
                        if (selectedIndex == -1) {
                            //ninguna tabla seleccionada
                            System.out.println("No se ha seleccionado ninguna tabla");
                        }
                        else if (selectedIndex == 0) {
                            //se ha seleccionado la tabla de reservas
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                            Date fechaEntrada = new Date();
                            Date fechaSalida = new Date();
                            
                            int selectedRow = tbReservas.getSelectedRow();
                            Integer reservaId = Integer.valueOf(modelo.getValueAt(selectedRow, 0).toString());
                            try {
                                fechaEntrada = formatter.parse(modelo.getValueAt(selectedRow, 1).toString());
                                fechaSalida = formatter.parse(modelo.getValueAt(selectedRow, 2).toString());
                                
                            } catch (ParseException ex) {
                                System.out.println(ex.getMessage());
                                System.out.println(ex.getStackTrace());
                            }
                            BigDecimal valor = new BigDecimal(modelo.getValueAt(selectedRow, 3).toString());
                            String formaDePago = modelo.getValueAt(selectedRow, 4).toString();
                            
                            Reserva reserva = new Reserva(reservaId, fechaEntrada, fechaSalida, valor, formaDePago);
                            reservaController.modificar(reserva);
                                    
                            actualizarTodasLasReservas();
                            actualizarTodosLosHuespedes();
                            
                            
                        }
                    }
                });
                
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
                
                btnEliminar.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int selectedIndex = panel.getSelectedIndex(); //el indice 0 es la tabla de reservas, el 1 de huespedes
                        if (selectedIndex == -1) {
                            //ninguna tabla seleccionada
                            System.out.println("No se ha seleccionado ninguna tabla");
                        } 
                        else if (selectedIndex == 0) {
                            //caso en que se ha seleccionado una reserva
                            int selectedRow = tbReservas.getSelectedRow();
                            //se selecciona el id
                            Integer reservaId = Integer.valueOf(modelo.getValueAt(selectedRow, 0).toString());
                            System.out.println("Se ha seleccionado la reserva de id: " + reservaId);
                            reservaController.eliminarPorId(reservaId);
                            System.out.println("Se ha eliminado la reserva de id: " + reservaId);
                            actualizarTodasLasReservas();
                            actualizarTodosLosHuespedes();
                        }
                        else if (selectedIndex == 1) {
                            //caso en que se ha seleccionado un huesped
                            int selectedRow = tbHuespedes.getSelectedRow();
                            //se selecciona el id
                            Integer huespedId = Integer.valueOf(modeloHuesped.getValueAt(selectedRow, 0).toString());
                            System.out.println("Se ha seleccionado al huesped de id: " + huespedId);
                            huespedController.eliminarPorId(huespedId);
                            System.out.println("Se ha borrado al huesped de id: " +huespedId+ " y todas sus reservas");
                            actualizarTodasLasReservas();
                            actualizarTodosLosHuespedes();
                                    
                        }
                    }
                }); 
	}
	
    //Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);

    }
    
    private void actualizarTodasLasReservas() {
        borrarTodasLasReservas();     
        List<Reserva> listaReservas = reservaController.traerTodos();
        
        for (Reserva reserva : listaReservas) {
            Integer numeroDeReserva = reserva.getId();
            String fechaEntrada = reserva.getFechaEntrada().toString();
            String fechaSalida = reserva.getFechaSalida().toString();
            BigDecimal valor = reserva.getPrecio();
            String formaDePago = reserva.getFormaDePago();
            modelo.addRow(new Object[] {numeroDeReserva,
                                        fechaEntrada,
                                        fechaSalida,
                                        valor,
                                        formaDePago});
        }
    }
    
    private void borrarTodasLasReservas() {
        int rowCount = modelo.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    
    private void actualizarTodosLosHuespedes() {
        borrarTodosLosHuespedes();
        
        List<Huesped> listaHuespedes = huespedController.traerTodos();
        
        for (Huesped huesped : listaHuespedes) {
            Integer numeroDeHuesped = huesped.getId();
            String nombre = huesped.getNombre();
            String apellido = huesped.getApellido();
            String fechaNacimiento = huesped.getFechaNacimiento().toString();
            String nacionalidad = huesped.getNacionalidad();
            String telefono = huesped.getTelefono();
            List<Reserva> reservas = huesped.getReservas();
            if (reservas.size() == 0) {
                
                Integer numeroDeReserva = 0;
                modeloHuesped.addRow(new Object[] {numeroDeHuesped,
                    nombre, 
                    apellido,
                    fechaNacimiento,
                    nacionalidad,
                    telefono,
                    numeroDeReserva});
                
            } else {
                
                for (Reserva reserva : reservas) {
                    
                    Integer numeroDeReserva = reserva.getId();
                    modeloHuesped.addRow(new Object[] {numeroDeHuesped,
                    nombre, 
                    apellido,
                    fechaNacimiento,
                    nacionalidad,
                    telefono,
                    numeroDeReserva});

                }
                
            }
        }
    }
    
    private void borrarTodosLosHuespedes() {
        int rowCount = modeloHuesped.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modeloHuesped.removeRow(i);
        }
    }
}
