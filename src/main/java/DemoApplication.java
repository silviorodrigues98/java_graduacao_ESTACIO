import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.*;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoApplication {

	// Pre-configured username and password
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "password";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("APP ACADEMIA COMUNITÁRIA");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500, 500);
			frame.setLocationRelativeTo(null); // Set the frame to open at the center of the screen

			// Create a panel to hold the input fields and button
			JPanel inputPanel = new JPanel();
			inputPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for center alignment

			// Create label and text field for "USUÁRIO"
			JLabel userFieldLabel = new JLabel("USUARIO: ");
			JTextField userField = new JTextField();
			userField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			userField.setPreferredSize(new Dimension(200, 30)); // Set preferred size for the text field

			// Create label and password field for "SENHA"
			JLabel passwordFieldLabel = new JLabel("SENHA: ");
			JPasswordField passwordField = new JPasswordField();
			passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			passwordField.setPreferredSize(new Dimension(200, 30)); // Set preferred size for the password field

			// Add components to the panel using GridBagConstraints
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.WEST;
			gbc.insets = new Insets(5, 5, 5, 5);
			inputPanel.add(userFieldLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			inputPanel.add(userField, gbc);

			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.WEST;
			inputPanel.add(passwordFieldLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			inputPanel.add(passwordField, gbc);

			// Create a button for "LOGIN"
			JButton loginButton = new JButton("Login");
			loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String usernameInput = userField.getText();
					String passwordInput = new String(passwordField.getPassword());

					if (usernameInput.equals(USERNAME) && passwordInput.equals(PASSWORD)) {
						System.out.println("Login successful");
						frame.dispose(); // Close the current frame

						// Create a new full-screen frame
						JFrame fullscreenFrame = new JFrame("APP ACADEMIA COMUNITÁRIA");
						fullscreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						fullscreenFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the frame to full screen
						fullscreenFrame.setVisible(true);

						// Add two buttons side by side in the middle of the jframe
						JPanel buttonPanel = new JPanel();
						buttonPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for center alignment

						JButton button1 = new JButton("CADASTRAR HORÁRIO");
						buttonPanel.add(button1);

						JButton button2 = new JButton("VER MEUS HORÁRIOS");
						buttonPanel.add(button2);

						// Add the button panel to the fullscreen frame's content pane
						fullscreenFrame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

						// Center the buttons vertically and horizontally
						buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
						buttonPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
					} else {
						System.out.println("Login failed");
						JOptionPane.showMessageDialog(frame, "Senha ou usuário incorretos, tente novamente.",
								"LOGIN INVALIDO",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			// Add the button to the panel
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 2;
			gbc.anchor = GridBagConstraints.CENTER;
			inputPanel.add(loginButton, gbc);

			// Add the panel to the frame's content pane
			frame.getContentPane().add(inputPanel, BorderLayout.CENTER);

			frame.setVisible(true);
		});
	}
}