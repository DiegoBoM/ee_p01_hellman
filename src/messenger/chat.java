/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

/**
 *
 * @author alejandro
 */
public class chat<T> {
    listaenlazada lista=new listaenlazada ();
    listaenlazada lista2=new listaenlazada ();
    int t2=1;
    int cifrado=0;
 
    public chat (){
     w();
     llavepublica();
     }
    /**
     * este metodo inicializa mi lista superincrementada
     */
    private void w(){
    lista.agregarfinal(9);
    lista.agregarfinal(18);
    lista.agregarfinal(35);
    lista.agregarfinal(84);
    lista.agregarfinal(178);
    lista.agregarfinal(342);
    lista.agregarfinal(780);
    }
    
    private int q(){
        int q=4340;
        return q;
    }
    private int r(){
     int r=233;
     return r;
    }
    
    private void llavepublica(){
    for(int i=0;i<7;i++){
        int a=(int) lista.obtener(i);
        int b=(r()*a)%q();
        lista2.agregarfinal(b);
      }
    }
    public String espacio(String palabra){
        String espacio="";
        for(int m=0;m<palabra.length();m++){
         if(palabra.charAt(m)==' '){
         espacio=espacio+"_";
         }
         else{
         espacio=espacio+palabra.charAt(m);
         }
        }
        String e=encriptar(espacio);
        return e;
    }
    public String encriptar(String palabra){
    String enviar="";
     for(int p=0;p<palabra.length();p++){
     String n=Integer.toBinaryString(palabra.charAt(p));
     //System.out.println();
     //System.out.print(palabra.charAt(p));
     //System.out.println("numero binario: "+n);
     cifrado=0;
     for(int j=0;j<7;j++){
      if(n.charAt(j)=='1'){
        int m=(int) lista2.obtener(j);
        cifrado=cifrado+m;
      }
     }
     //numeros.agregarfinal(cifrado);
     //System.out.println("paquete a enviar: "+cifrado);
     enviar=enviar+cifrado+" ";
     }
     //System.out.println("paquete a enviar: "+"("+enviar+")");
     return enviar;
     }
    
    public String desencriptar(String enviar){
     listaenlazada numeros=new listaenlazada();
     int longitud=0;
     //va agregando palabra por palabra a una lista llamada numeros
     String n="";
     for(int a=2;a<enviar.length();a++){
     if(enviar.charAt(a)==' '){
        numeros.agregarfinal(n);
        n="";
        longitud=longitud+1;
     }
     else{
      n=n+enviar.charAt(a);
     }
     }
     
    //empieza desencriptacion
    String desencriptado="";
    
    Inverso();
       for(int z=0;z<longitud;z++){
        int numentero = Integer.parseInt((String) numeros.obtener(z));
        int des=(numentero*t2)%q();
        String letra="";
        String letra2="";
        //System.out.println("numero a restar: "+des);
       for(int y=6;y>-1;y--){ 
         if(des>=(int)lista.obtener(y)){
           des = des-(int)lista.obtener(y);
           letra=letra+1;
         }
         else{
          letra=letra+0;
         }
       }
       
       for(int k=6;k>-1;k--){
        letra2=letra2+letra.charAt(k);
       }
       //System.out.println("letra: "+letra2);
         
      char c =(char)Integer.parseInt(letra2,2); 
      if(c=='_'){
       desencriptado=desencriptado+" ";
      }
      else{
      desencriptado=desencriptado+c;
      }
      }
      t2=1;
      System.out.println("la palabra desencriptada es : "+desencriptado);
      return desencriptado;
    
    
    }
   
    
    public void Inverso(){
        int a=r(); 
        int m=q();
       int c1=1,c2=-1*(m/a);//coeficiente de a y b respectivamente
        int t1=0;//coeficientes penultima corrida
        int r=m%a;//residuo, asignamos 1 como condicion de entrada 
        int x=a,y=r,c;
        while(r!=0)
        {
        c= x/y;//cociente
        r= x%y;//residuo
        //guardamos valores temporales de los coeficientes
        //multiplicamos los coeficiente por -1*cociente de la division
        c1*=-1*c;
        c2*=-1*c;
        //sumamos la corrida anterior
        c1+=t1;
        c2+=t2;
        //actualizamos corrida anterior
        t1=-1*(c1-t1)/c;
        t2=-1*(c2-t2)/c;
        x=y;
        y=r;
        }
      
    } 
    
    
    
}