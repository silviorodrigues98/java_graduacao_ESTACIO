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
			inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Set flow layout with left alignment

			// Create label and text field for "USUÁRIO"
			JLabel userFieldLabel = new JLabel("USUARIO: ");
			JTextField userField = new JTextField();
			userField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			// Create label and password field for "SENHA"
			JLabel passwordFieldLabel = new JLabel("SENHA: ");
			JPasswordField passwordField = new JPasswordField();
			passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			// Add components to the panel
			inputPanel.add(userFieldLabel);
			inputPanel.add(userField);
			inputPanel.add(passwordFieldLabel);
			inputPanel.add(passwordField);

			// Add the panel to the frame's content pane
			frame.getContentPane().add(inputPanel, BorderLayout.CENTER);

			// Calculate the width of the input area
			int inputAreaWidth = (int) (frame.getWidth() * 0.8);

			// Set the preferred size of the text fields
			userField.setPreferredSize(new Dimension(inputAreaWidth, userField.getPreferredSize().height));
			passwordField.setPreferredSize(new Dimension(inputAreaWidth, passwordField.getPreferredSize().height));

			// Create a button for "LOGIN"
			JButton loginButton = new JButton("Login");
			loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String usernameInput = userField.getText();
					String passwordInput = new String(passwordField.getPassword());

					if (usernameInput.equals(USERNAME) && passwordInput.equals(PASSWORD)) {
						System.out.println("Login successful");
					} else {
						System.out.println("Login failed");
					}
				}
			});

			// Add the button to the panel
			inputPanel.add(loginButton);

			frame.setVisible(true);
		});
	}
}
