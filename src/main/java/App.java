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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

public class App {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

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
                                        timePanel.setLayout(new GridLayout(0, 8, 10, 10));

                                        JLabel selectedDateLabel = new JLabel("DATA SELECIONADA: " + formattedDate);
                                        selectedDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
                                        selectedDateLabel.setPreferredSize(new Dimension(500, 30));
                                        JPanel panelWrapper = new JPanel();
                                        panelWrapper.setLayout(new BorderLayout());
                                        panelWrapper.add(selectedDateLabel, BorderLayout.NORTH);
                                        panelWrapper.add(timePanel, BorderLayout.CENTER);
                                        panelWrapper.setPreferredSize(new Dimension(500, 300));
                                        ArrayList<Date> array = new ArrayList<>();

                                        while (calendar.get(Calendar.HOUR_OF_DAY) < 23) {
                                            JButton timeButton = new JButton(String.format("%02d:%02d",
                                                    calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)));
                                            timeButton.setPreferredSize(new Dimension(60, 60));

                                            timeButton.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    JButton clickedButton = (JButton) e.getSource();
                                                    clickedButton.setBackground(Color.GREEN);

                                                    clickedButton.setEnabled(false);

                                                    System.out.println("Button pressed: " + clickedButton.getText());
                                                    String selectedTime = clickedButton.getText();
                                                    String selectedDateTime = formattedDate + " " + selectedTime;
                                                    SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
                                                            "dd/MM/yyyy HH:mm");
                                                    try {
                                                        Date parsedDateTime = dateTimeFormat.parse(selectedDateTime);
                                                        System.out.println("Selected date and time: " + parsedDateTime);
                                                        array.add(parsedDateTime);
                                                        System.out.println("Array: " + array);

                                                    } catch (ParseException ex) {
                                                        System.out.println("Error parsing selected date and time");
                                                        ex.printStackTrace();
                                                    }
                                                }
                                            });
                                            timePanel.add(timeButton);
                                            calendar.add(Calendar.MINUTE, 30);
                                        }

                                        JButton saveButton = new JButton("SALVAR");
                                        saveButton.setBackground(Color.RED);
                                        saveButton.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                fullscreenFrame.getContentPane().removeAll();
                                                fullscreenFrame.revalidate();
                                                fullscreenFrame.repaint();

                                                JPanel resultPanel = new JPanel();
                                                resultPanel.setLayout(new GridLayout(array.size() + 1, 1, 0, 0));

                                                JLabel resultLabel = new JLabel("MEUS AGENDAMENTOS SALVOS:");
                                                resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD, 40));

                                                resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
                                                resultPanel.add(resultLabel);

                                                SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
                                                        "dd/MM/yyyy HH:mm");

                                                for (Date date : array) {
                                                    JLabel dateLabel = new JLabel(dateTimeFormat.format(date));
                                                    dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
                                                    resultPanel.add(dateLabel);
                                                }

                                                fullscreenFrame.getContentPane().add(resultPanel, BorderLayout.CENTER);
                                                fullscreenFrame.revalidate();
                                                fullscreenFrame.repaint();

                                                try {
                                                    File file = new File("agendamentos.txt");
                                                    FileWriter writer = new FileWriter(file, true); // append mode
                                                    for (Date date : array) {
                                                        writer.write(dateTimeFormat.format(date) + ",");
                                                    }
                                                    writer.close();
                                                } catch (IOException ex) {
                                                    ex.printStackTrace();
                                                }
                                            }
                                        });
                                        panelWrapper.add(saveButton, BorderLayout.SOUTH);
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
                        botaoVerAgenda.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                fullscreenFrame.getContentPane().removeAll();
                                fullscreenFrame.revalidate();
                                fullscreenFrame.repaint();

                                JPanel agendaPanel = new JPanel();
                                agendaPanel.setLayout(new GridLayout(4, 4, 1, 1));
                                try {
                                    File file = new File("agendamentos.txt");
                                    Scanner scanner = new Scanner(file);
                                    scanner.useDelimiter(",");
                                    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                    System.out.println("Reading file...");
                                    while (scanner.hasNext()) {
                                        String dateTimeString = scanner.next();
                                        Date dateTime = dateTimeFormat.parse(dateTimeString);
                                        JLabel dateLabel = new JLabel(dateTimeFormat.format(dateTime));
                                        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
                                        dateLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border
                                        agendaPanel.add(dateLabel);
                                        System.out.println("Read date and time: " + dateTime);
                                    }
                                } catch (FileNotFoundException ex) {
                                    System.out.println("File not found");
                                    ex.printStackTrace();
                                } catch (ParseException ex) {
                                    System.out.println("Error parsing date and time");
                                    ex.printStackTrace();
                                }

                                fullscreenFrame.getContentPane().add(agendaPanel, BorderLayout.CENTER);
                                fullscreenFrame.revalidate();
                                fullscreenFrame.repaint();
                            }
                        });
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
