package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MasSaldo extends JPanel
{
	private JTextField addSaldoText;
	private JLabel lblSaldoAnadido;
	private Usuario usuario;
	private JLabel saldoActual;
	private BigDecimal bigd;






	/**
	 * 
	 * @author Jose Luis Gallardo
	 * @author Balint Salamon Mark
	 */
	public MasSaldo(VentanaPrincipal v, Usuario usuario)
	{
		this.usuario = usuario;
		bigd = new BigDecimal(v.getUsu().getSaldo());
		setBackground(new Color(65, 105, 225));
		setLayout(null);

		JLabel labelSueldo = new JLabel("A\u00F1adir Saldo :");
		labelSueldo.setForeground(new Color(255, 165, 0));
		labelSueldo.setHorizontalAlignment(SwingConstants.CENTER);
		labelSueldo.setBounds(65, 83, 89, 17);
		add(labelSueldo);
		JButton atrasBoton = new JButton("Atras");

		atrasBoton.setBackground(new Color(139, 0, 0));
		atrasBoton.setForeground(new Color(178, 34, 34));
		atrasBoton.setBounds(12, 264, 89, 23);
		add(atrasBoton);
		JButton addSaldo = new JButton("A\u00F1adir");

		addSaldo.setForeground(new Color(50, 205, 50));
		addSaldo.setBackground(new Color(0, 128, 0));
		addSaldo.setBounds(166, 133, 89, 23);
		add(addSaldo);
		addSaldoText = new JTextField();
		addSaldoText.setBounds(166, 81, 96, 20);
		add(addSaldoText);
		addSaldoText.setColumns(10);

		lblSaldoAnadido = new JLabel("");
		lblSaldoAnadido.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldoAnadido.setForeground(new Color(255, 165, 0));
		lblSaldoAnadido.setBounds(10, 167, 430, 86);
		add(lblSaldoAnadido);

		saldoActual = new JLabel("Saldo actual: " + bigd.toPlainString() + "€");
		saldoActual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saldoActual.setHorizontalAlignment(SwingConstants.LEFT);
		saldoActual.setForeground(new Color(255, 165, 0));
		saldoActual.setBounds(12, 11, 387, 28);
		add(saldoActual);

		// Funcion que vuelve al menu
		atrasBoton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				v.irAMenu();
			}
		});

		// Funcion que añade saldo
		addSaldo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// Comprueba que el dato introducido sea un numero
				try
				{
					float saldoAAnadir = Float.parseFloat(getAddSaldoText().getText());
					// Comprueba que el numero no sea mayor al numero permitido por la base de datos
					if (saldoAAnadir + v.getUsu().getSaldo() < 2000000000L)
					{
						// Comprueba que el numero no sea negativo ni mayor al numero permitido por java
						if (saldoAAnadir >= 0.01f && saldoAAnadir <= Integer.MAX_VALUE)
						{
							// Si todo ha ido bien hasta este punto se le añade el saldo al usuario y se
							// actualiza la ventana
							float newBal = (float) (saldoAAnadir + getUsuario().getSaldo());
							v.getUsu().setSaldo(newBal);
							getLblSaldoAnadido().setText("Saldo añadido correctamente");
							addSaldoText.setText("");
							bigd = new BigDecimal(v.getUsu().getSaldo());
							getSaldoActual().setText("Saldo actual: " + bigd.toPlainString() + "€");

						} else
						{
							getLblSaldoAnadido().setText(
									"<html>No se admite una cantidad menor a un centimo <br>ni mayor a un billon</html>");
							addSaldoText.setText("");
						}
					} else
					{
						getLblSaldoAnadido().setText("Su saldo no puede exceder los 2 billones");
					}
				} catch (NumberFormatException e)
				{
					getLblSaldoAnadido().setText("Solo se admiten numeros");
					addSaldoText.setText("");
				}
			}
		});
	}






	public JLabel getSaldoActual()
	{
		return saldoActual;
	}






	public JLabel getLblSaldoAnadido()
	{
		return lblSaldoAnadido;
	}






	public JTextField getAddSaldoText()
	{
		return addSaldoText;
	}






	public Usuario getUsuario()
	{
		return usuario;
	}






	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
}
