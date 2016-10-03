
package messenger;
import java.net.*;
import java.io.*;
import messenger.VServidor;

public class Conector extends Thread {
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 8180;
    chat k=new chat();
    
    
    public Conector(String nombre)
    {
        super(nombre);
    }
    public void enviarMSG(String msg)
    {
        VServidor.jTextArea1.setText(VServidor.jTextArea1.getText()+"\n Tu:   "+msg);
        msg=k.espacio(msg);
        try{
            this.salida.writeUTF(msg+"\n");
            
        }catch (IOException e){};
    }
    
    public void run()
    {
     String text="test";
     try{
         this.ss = new ServerSocket(puerto);
         this.s = ss.accept();
         
         this.entradaSocket = new InputStreamReader(s.getInputStream());
         this.entrada = new BufferedReader(entradaSocket);
         
         this.salida = new DataOutputStream(s.getOutputStream());
         
         while(true)
         {
             text = this.entrada.readLine();
             //System.out.println(text);
             text=k.desencriptar(text);
             
             //text="binario 2";
             VServidor.jTextArea1.setText(VServidor.jTextArea1.getText()+"\n El:   "+text);
             
         }
         }catch (IOException e){
         System.out.println("Algun Tipo de error");
         };
    }
   
    public void desconectar()
    {
        try{
            s.close();
        }catch(IOException e){};
        try{
            ss.close();
        }catch(IOException e){};
    }
}
