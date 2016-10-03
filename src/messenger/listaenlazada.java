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
public class listaenlazada<T> {
   Nodo inicio;
   Nodo fin;
   int size=0;
  
   public listaenlazada(){
    inicio = null;
    fin=null;
   }
   
 public boolean estavacia(){
 return (inicio==null)?true:false;
 }
   
 /**
  * agrega un elemento al inicio de la lista
  * @param dato el valor que va a tener nuestro nodo
  */
 
 public void agregar_inicio(T dato){
  if(inicio == null){
      inicio=new Nodo(dato);
  }
  else{
    Nodo temp = inicio;
   
    Nodo nuevo=new Nodo(dato);
    nuevo.setSiguiente(temp);
    inicio=nuevo;
  }
  size++;
 }
  public int size(){
  return size;
  }
 /**
  * el metodo muestra el elemento que se requiere de la lista
  * @param index posicion del elemento que quiero obtener
  * @return el elemento seleccionado
  */ 
 public T obtener(int index){
  int contador=0;
  Nodo temporal=inicio;
  while(contador<index){
   temporal=temporal.getSiguiente();
   contador++;
  }
  return (T) temporal.getDato();
 }
/**
 * 
 * @return el nodo inicial
 */
 public Nodo<T> inicio() {
        return inicio;
    }
 /**
  * este metodo elimina el primero(ultimo dato ingresado)de la lista
  */
 public void eliminarprimero(){
 inicio=inicio.getSiguiente();
 size--;
 
 }
 /**
  * metodo para agregar al final
  */
 public void agregarfinal(T dato){
 Nodo nuevo=new Nodo(dato,null);
 if(inicio==null){
 fin=nuevo;
 inicio=fin;
 }
 else{
 fin.setSiguiente(nuevo);
 fin=nuevo;
 }
 size++;
 }
 /**
  * metodo solamente creado para la fusion de listas
  * @param dato dato del nodo
  * @param d cadena de nodos
  */
 public void agregarnodo(T dato,Nodo d){
 Nodo nuevo=new Nodo(dato,d);
 if(inicio==null){
 fin=nuevo;
 inicio=fin;
 }
 else{
 fin.setSiguiente(nuevo);
 fin=nuevo;
 }
 size++;
 }
 
 /**
  * este metodo elimina un elemento en la posicion dada
  */
 public void eliminar(int index){
 if(index==0){
   inicio=inicio.getSiguiente();
 }
 else{
    int contador=0;
    Nodo aux=inicio;
    while(contador<index-1){
     aux=aux.getSiguiente();
     contador++;
    }
   aux.setSiguiente(aux.getSiguiente().getSiguiente());
  }
 size--;
 }
 
 /**
  * metodo donde elimina el ultimo elemento de la lista
  */
 public void eliminarultimo(){
 int contador=0;
 Nodo aux=inicio;
 while(contador<size-2){
  aux=aux.getSiguiente();
  contador++;
 }
 aux.setSiguiente(null);
 size--;
 if(size==0){
     inicio=null;
 }
 }

 /**
  * metodo que recorre e imprime todos los elementos de la lista
  */
 public void recorrer(){
 int cont =0;
 Nodo aux=inicio;
   while(cont<size){
     System.out.print(aux.getDato()+"-->");
     aux=aux.getSiguiente();
     cont++;
   }
 }

 public void recorrern(int x){
 int cont =0;
 Nodo aux=inicio;
   while(cont<x){
     System.out.print(aux.getDato()+"-->");
     aux=aux.getSiguiente();
     cont++;
   }
 }
}
