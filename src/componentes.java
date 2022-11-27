import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class componentes extends JPanel implements ActionListener {
    JPanel lamina1 = new JPanel();
    JTextField busqueda = new JTextField();
    JButton btnSelecionar = new JButton();
    JPanel lamina2=new JPanel();
    JTextArea vista=new JTextArea();
    JScrollPane vistaScroll=new JScrollPane();
    
    public componentes() {
        setLayout(null);
        laminaA();
        laminaB();
        cuadroTexto();
        boton(); 
        areavista();       
    }

    public void cuadroTexto() {
        busqueda.setBounds(5, 5, 400, 20);
        busqueda.setToolTipText("inserte ruta del elemento");
        busqueda.setText("ingrese directorio de busqueda");
    }

    public void boton() {
        btnSelecionar.setText("selecionar...");
        btnSelecionar.setBounds(450, 5, 115, 25);
        btnSelecionar.setBorder(BorderFactory.createLoweredBevelBorder());
        btnSelecionar.addActionListener(this);
    }

    public void areavista(){
        vista.setBounds(0, 0, 570, 345);
        vista.setLineWrap(true);
        vista.setWrapStyleWord(true);
        //vistaScroll=new JScrollPane(vista);
        vistaScroll.setBounds(0, 0, 570, 345);
        

    }

    public void laminaA() {
        lamina1.setLayout(null);
        lamina1.setBounds(5, 5, 570, 40);
        lamina1.setBorder(BorderFactory.createEtchedBorder());
        add(lamina1);
        lamina1.add(busqueda);
        lamina1.add(btnSelecionar);
    }
    public void laminaB(){
        lamina2.setLayout(null);
        lamina2.setBounds(5, 65, 570, 345);
        lamina2.setBorder(BorderFactory.createEtchedBorder());
        add(lamina2);
        lamina2.add(vistaScroll=new JScrollPane(vista));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int seleccion=fc.showOpenDialog(lamina2);
        if (seleccion==JFileChooser.APPROVE_OPTION){
            File fichero=fc.getSelectedFile();
            busqueda.setText(fichero.getAbsolutePath());
            try(FileReader fr=new FileReader(fichero)){
                String cadena="";
                int valor=fr.read();
                while(valor!=-1){
                    cadena=cadena+(char)valor;
                    valor=fr.read();
                }
                vista.setText(cadena);
            }catch(IOException e1){
                e1.printStackTrace();
                System.out.println("error de tipo"+e1);
            }
            
        }
        
    }
}
