
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Genesis
 */
public class cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("*******CLIENTE*******\n");
        
        try {
            
            DatagramSocket ClienteUDP = new DatagramSocket();
            int puerto = 5001;
            InetAddress host = InetAddress.getByName("localhost");
            String cadena;
            
            do{
                
                
                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
                //System.out.println("Ingrese la cadena de valores: ");
                cadena = JOptionPane.showInputDialog(null,"Ingrese una cadena");
                
                byte [] mensaje= cadena.getBytes();
            
                DatagramPacket peticion = new DatagramPacket(mensaje, cadena.length(), host, puerto);
                ClienteUDP.send(peticion);

                DatagramPacket respuesta = new DatagramPacket(mensaje, cadena.length());
                ClienteUDP.receive(respuesta);

                JOptionPane.showMessageDialog(null,"El mensaje del server dice: " + new String(respuesta.getData(), 0, respuesta.getLength()));
                
            }while(!"".equals(cadena));
            
            //ClienteUDP.close();
            
        } catch (SocketException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
   }
    }
    
}