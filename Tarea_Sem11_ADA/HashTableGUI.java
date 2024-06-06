import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HashTableGUI extends JFrame {
    private HashTable hashTable;

    public HashTableGUI(int tamaño, boolean esEncadenamiento) {
        this.hashTable = new HashTable(tamaño, esEncadenamiento);
        setTitle("Hash Table GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton insertarButton = new JButton("Insertar nombre");
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre a insertar:");
                if (nombre != null) {
                    hashTable.insertar(nombre);
                }
            }
        });

        JButton buscarButton = new JButton("Buscar nombre");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre a buscar:");
                if (nombre != null) {
                    hashTable.buscar(nombre);
                }
            }
        });

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(insertarButton);
        panel.add(buscarButton);
        panel.add(salirButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Seleccione Forma de Resolución de Colisiones");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 150);

                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 1));

                JButton linealButton = new JButton("Resolución Lineal");
                linealButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo:"));
                        new HashTableGUI(tamaño, false);
                        frame.dispose();
                    }
                });

                JButton encadenamientoButton = new JButton("Encadenamiento con Árboles");
                encadenamientoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo:"));
                        new HashTableGUI(tamaño, true);
                        frame.dispose();
                    }
                });

                panel.add(linealButton);
                panel.add(encadenamientoButton);

                frame.add(panel);
                frame.setVisible(true);
            }
        });
    }
}


