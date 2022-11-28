import javax.swing.JFrame;

public class gestorArchivo extends JFrame { /*
                                             * la clase "gestorArchivo" es la clase donde
                                             * programamos el jframe. la clase "gestorArchivo" es como un cuaderno donde se vera
                                             * el resultado visual
                                             * del codigo de cada uno de los coponentes de nuestro programa
                                             */
    componentes nuevo = new componentes();

    public gestorArchivo() {
        setTitle("gestor de archivos");
        setVisible(true);
        setSize(650, 660);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(nuevo);
    }
}
