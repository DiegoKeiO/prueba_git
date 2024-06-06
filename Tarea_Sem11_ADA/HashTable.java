import javax.swing.JOptionPane;

class Nodo {
    String dato;
    Nodo izquierda, derecha;

    public Nodo(String dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

class HashTable {
    private Nodo[] datosEncadenamiento;
    private String[] datosLineal;
    private int nElementos;
    private boolean esEncadenamiento;

    public HashTable(int tamaño, boolean esEncadenamiento) {
        if (esEncadenamiento) {
            this.datosEncadenamiento = new Nodo[tamaño];
        } else {
            this.datosLineal = new String[tamaño];
        }
        this.nElementos = tamaño;
        this.esEncadenamiento = esEncadenamiento;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % nElementos);
    }

    private Nodo insertarEnArbol(Nodo nodo, String k) {
        if (nodo == null) {
            return new Nodo(k);
        }
        if (k.compareTo(nodo.dato) < 0) {
            nodo.izquierda = insertarEnArbol(nodo.izquierda, k);
        } else if (k.compareTo(nodo.dato) > 0) {
            nodo.derecha = insertarEnArbol(nodo.derecha, k);
        }
        return nodo;
    }

    private boolean buscarEnArbol(Nodo nodo, String k) {
        if (nodo == null) {
            return false;
        }
        if (k.equals(nodo.dato)) {
            return true;
        }
        if (k.compareTo(nodo.dato) < 0) {
            return buscarEnArbol(nodo.izquierda, k);
        } else {
            return buscarEnArbol(nodo.derecha, k);
        }
    }

    public void insertar(String k) {
        int d = hash(k);

        if (esEncadenamiento) {
            if (datosEncadenamiento[d] == null) {
                datosEncadenamiento[d] = new Nodo(k);
                JOptionPane.showMessageDialog(null, "Elemento insertado en la posición " + d);
            } else {
                if (buscarEnArbol(datosEncadenamiento[d], k)) {
                    JOptionPane.showMessageDialog(null, "El elemento ya está en la posición " + d);
                } else {
                    datosEncadenamiento[d] = insertarEnArbol(datosEncadenamiento[d], k);
                    JOptionPane.showMessageDialog(null, "Elemento insertado en la posición " + d + " en el árbol");
                }
            }
        } else {
            if (k.equals(datosLineal[d])) {
                JOptionPane.showMessageDialog(null, "El elemento ya está en la posición " + d);
            } else {
                if (datosLineal[d] == null) {
                    datosLineal[d] = k;
                    JOptionPane.showMessageDialog(null, "Elemento insertado en la posición " + d);
                } else {
                    int dx = (d + 1) % nElementos;
                    while (dx != d && datosLineal[dx] != null && !k.equals(datosLineal[dx])) {
                        dx = (dx + 1) % nElementos;
                    }
                    if (k.equals(datosLineal[dx])) {
                        JOptionPane.showMessageDialog(null, "El elemento ya está en la posición " + dx);
                    } else if (datosLineal[dx] == null) {
                        datosLineal[dx] = k;
                        JOptionPane.showMessageDialog(null, "Elemento insertado en la posición " + dx);
                    } else {
                        JOptionPane.showMessageDialog(null, "El arreglo no tiene casillas vacías");
                    }
                }
            }
        }
    }

    public void buscar(String k) {
        int d = hash(k);

        if (esEncadenamiento) {
            if (datosEncadenamiento[d] == null) {
                JOptionPane.showMessageDialog(null, "El elemento no está en el arreglo");
            } else {
                if (buscarEnArbol(datosEncadenamiento[d], k)) {
                    JOptionPane.showMessageDialog(null, "El elemento está en la posición " + d);
                } else {
                    JOptionPane.showMessageDialog(null, "El elemento no está en el arreglo");
                }
            }
        } else {
            if (k.equals(datosLineal[d])) {
                JOptionPane.showMessageDialog(null, "El elemento está en la posición " + d);
            } else {
                if (datosLineal[d] == null) {
                    JOptionPane.showMessageDialog(null, "El elemento no está");
                } else {
                    int dx = (d + 1) % nElementos;
                    while (dx != d && datosLineal[dx] != null && !k.equals(datosLineal[dx])) {
                        dx = (dx + 1) % nElementos;
                    }
                    if (k.equals(datosLineal[dx])) {
                        JOptionPane.showMessageDialog(null, "El elemento está en la posición " + dx);
                    } else {
                        JOptionPane.showMessageDialog(null, "El elemento no está en el arreglo");
                    }
                }
            }
        }
    }
}




