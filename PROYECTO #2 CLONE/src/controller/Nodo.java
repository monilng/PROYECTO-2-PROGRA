package controller;

public class Nodo{
    public int dato;
    Nodo siguiente;
    Nodo(int dato){
        this.dato = dato;
        this.siguiente = null;
    }

    public void swap(Nodo otro) {
        // Intercambiar los datos entre los nodos
        int temp = this.dato;
        this.dato = otro.dato;
        otro.dato = temp;
    }
    
}