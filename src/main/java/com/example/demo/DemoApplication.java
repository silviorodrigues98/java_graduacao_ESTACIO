import javax.swing.JFrame;
import javax.swing.JLabel;
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
						frame.getContentPane().removeAll(); // Clear the frame's content pane
						frame.revalidate(); // Revalidate the frame to update the changes
						frame.repaint(); // Repaint the frame to reflect the changes

						// Expand the JFrame
						frame.setSize(800, 600);
					} else {
						System.out.println("Login failed");
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
