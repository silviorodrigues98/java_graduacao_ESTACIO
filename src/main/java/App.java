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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

public class App {

    private static final String USERNAME = "a";
    private static final String PASSWORD = "a";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("APP ACADEMIA COMUNITÁRIA");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);

            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridBagLayout());

            JLabel userFieldLabel = new JLabel("USUARIO: ");
            JTextField userField = new JTextField();
            userField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            userField.setPreferredSize(new Dimension(200, 30));

            JLabel passwordFieldLabel = new JLabel("SENHA: ");
            JPasswordField passwordField = new JPasswordField();
            passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            passwordField.setPreferredSize(new Dimension(200, 30));

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

            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String usernameInput = userField.getText();
                    String passwordInput = new String(passwordField.getPassword());

                    if (usernameInput.equals(USERNAME) && passwordInput.equals(PASSWORD)) {
                        System.out.println("Login successful");
                        frame.dispose();

                        JFrame fullscreenFrame = new JFrame("APP ACADEMIA COMUNITÁRIA");
                        fullscreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        fullscreenFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        fullscreenFrame.setVisible(true);

                        JPanel buttonPanel = new JPanel();
                        buttonPanel.setLayout(new GridBagLayout());

                        JButton botaoAgendar = new JButton("CADASTRAR HORÁRIO");
                        botaoAgendar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                fullscreenFrame.getContentPane().removeAll();
                                fullscreenFrame.revalidate();
                                fullscreenFrame.repaint();
                                JPanel datePanel = new JPanel();
                                datePanel.setLayout(new GridBagLayout());

                                JLabel dateLabel = new JLabel("DATA: ");
                                JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
                                JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
                                dateSpinner.setEditor(dateEditor);
                                dateSpinner.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                                dateSpinner.setPreferredSize(new Dimension(100, 50));

                                GridBagConstraints gbcDate = new GridBagConstraints();
                                gbcDate.gridx = 0;
                                gbcDate.gridy = 0;
                                gbcDate.anchor = GridBagConstraints.WEST;
                                gbcDate.insets = new Insets(5, 5, 5, 5);
                                datePanel.add(dateLabel, gbcDate);

                                gbcDate.gridx = 1;
                                gbcDate.gridy = 0;
                                gbcDate.fill = GridBagConstraints.HORIZONTAL;
                                datePanel.add(dateSpinner, gbcDate);

                                JButton confirmButton = new JButton("Confirmar");
                                confirmButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        Date selectedDate = (Date) dateSpinner.getValue();
                                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                        String formattedDate = dateFormat.format(selectedDate);
                                        System.out.println("Selected date: " + formattedDate);

                                        fullscreenFrame.getContentPane().removeAll();
                                        fullscreenFrame.revalidate();
                                        fullscreenFrame.repaint();

                                        Calendar calendar = Calendar.getInstance();
                                        calendar.setTime(selectedDate);
                                        calendar.set(Calendar.HOUR_OF_DAY, 7);
                                        calendar.set(Calendar.MINUTE, 0);
                                        calendar.set(Calendar.SECOND, 0);

                                        JPanel contentWrapper = new JPanel();
                                        contentWrapper.setLayout(new BorderLayout());
                                        contentWrapper.setPreferredSize(new Dimension(500, 300));

                                        JPanel timePanel = new JPanel();
                                        timePanel.setLayout(new GridLayout(0, 8, 50, 50));
                                        JLabel selectedDateLabel = new JLabel("DATA SELECIONADA: " + formattedDate);
                                        selectedDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
                                        selectedDateLabel.setPreferredSize(new Dimension(500, 30));
                                        JPanel panelWrapper = new JPanel();
                                        panelWrapper.setLayout(new BorderLayout());
                                        panelWrapper.add(selectedDateLabel, BorderLayout.NORTH);
                                        panelWrapper.add(timePanel, BorderLayout.CENTER);
                                        panelWrapper.setPreferredSize(new Dimension(500, 300));
                                        while (calendar.get(Calendar.HOUR_OF_DAY) < 23) {
                                            JButton timeButton = new JButton(String.format("%02d:%02d",
                                                    calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)));
                                            timeButton.setPreferredSize(new Dimension(100, 100));
                                            timeButton.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {

                                                    System.out.println(
                                                            "Button pressed: " + ((JButton) e.getSource()).getText());
                                                }
                                            });
                                            timePanel.add(timeButton);
                                            calendar.add(Calendar.MINUTE, 30);
                                        }
                                        panelWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
                                        panelWrapper.setAlignmentY(Component.CENTER_ALIGNMENT);
                                        fullscreenFrame.getContentPane().setLayout(new BorderLayout());
                                        fullscreenFrame.getContentPane().add(panelWrapper, BorderLayout.CENTER);
                                        fullscreenFrame.getContentPane().revalidate();
                                        fullscreenFrame.getContentPane().repaint();
                                    }
                                });

                                gbcDate.gridx = 0;
                                gbcDate.gridy = 1;
                                gbcDate.gridwidth = 2;
                                gbcDate.anchor = GridBagConstraints.CENTER;
                                datePanel.add(confirmButton, gbcDate);

                                fullscreenFrame.getContentPane().setLayout(new BorderLayout());
                                fullscreenFrame.getContentPane().add(datePanel, BorderLayout.CENTER);
                                fullscreenFrame.revalidate();
                                fullscreenFrame.repaint();
                            }
                        });
                        buttonPanel.add(botaoAgendar);

                        JButton botaoVerAgenda = new JButton("VER MEUS HORÁRIOS");
                        buttonPanel.add(botaoVerAgenda);

                        fullscreenFrame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

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

            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            inputPanel.add(loginButton, gbc);

            frame.getContentPane().add(inputPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
