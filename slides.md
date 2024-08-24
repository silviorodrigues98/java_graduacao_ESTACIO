---
marp: true
theme: default
paginate: true
footer: 'Aplicativo Java Swing'
---

# Aplicativo Java Swing

## Visão Geral

- Aplicativo básico em Swing
- Funcionalidades de login, agendamento e manipulação de arquivos

---

# Importações Essenciais

```java
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.*;
import java.util.*;
```

- Importa bibliotecas para GUI, eventos e arquivos.

---

# Configuração Principal

```java
public class App {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("APP ACADEMIA COMUNITÁRIA");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
```

- Inicializa a janela principal do aplicativo.

---

# Painel de Login

```java
JPanel inputPanel = new JPanel(new GridBagLayout());
JLabel userFieldLabel = new JLabel("USUARIO: ");
JTextField userField = new JTextField();
JLabel passwordFieldLabel = new JLabel("SENHA: ");
JPasswordField passwordField = new JPasswordField();
```

- Criação do painel de login com campos de texto e senha.

---

# Botão de Login

```java
JButton loginButton = new JButton("Login");
loginButton.addActionListener(e -> {
    String usernameInput = userField.getText();
    String passwordInput = new String(passwordField.getPassword());
    if (usernameInput.equals(USERNAME) && passwordInput.equals(PASSWORD)) {
        frame.dispose();
        mostrarJanelaPrincipal();
    } else {
        JOptionPane.showMessageDialog(frame, "Login incorreto", "Erro", JOptionPane.ERROR_MESSAGE);
    }
});
```

- Verifica credenciais e exibe a janela principal ao sucesso.

---

# Janela Principal

```java
JFrame fullscreenFrame = new JFrame("APP ACADEMIA COMUNITÁRIA");
fullscreenFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
fullscreenFrame.setVisible(true);
```

- Configura a janela principal em tela cheia.

---

# Seleção de Data

```java
JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
JButton confirmButton = new JButton("Confirmar");
confirmButton.addActionListener(e -> {
    mostrarHorariosDisponiveis(fullscreenFrame, dateSpinner);
});
```

- Permite ao usuário selecionar uma data para agendamento.

---

# Visualizando Agendamentos

```java
JButton botaoVerAgenda = new JButton("VER MEUS HORÁRIOS");
botaoVerAgenda.addActionListener(e -> mostrarAgendamentosSalvos(fullscreenFrame));
```

- Exibe os horários agendados previamente.

---

# Conclusão

- Aplicativo com interface amigável para login e agendamentos.