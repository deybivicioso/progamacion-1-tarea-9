import javax.swing.JFrame;

public class gestorArchivo extends JFrame {
    componentes nuevo=new componentes();
    public gestorArchivo(){
        setTitle("gestor de archivos");
        setVisible(true);
        setSize(650, 460);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(nuevo);
    }
}

