package controller;
import controller.Nodo;
public class ListaP{
    Nodo inicio;
    Nodo fin;
    int length;
    
    public ListaP(){
        inicio = null;
        fin = inicio;
        length = 0;
    }
    
    public Nodo push(int dato, int indice){
        if(indice < 0){
            return null;
        }
        Nodo nuevoNodo = new Nodo(dato);
        if(inicio == null){
            if(indice == 0){
                inicio = nuevoNodo;
                fin = inicio;
            }
            else{
                return null; // mal
            }
        }
        else{
            if(indice == 0){
                nuevoNodo.siguiente = inicio;
                inicio = nuevoNodo;
            }
            else if(indice == length){
                fin.siguiente = nuevoNodo;
                fin = nuevoNodo;
            }
            else if(indice > length){
                return null;
            }
            else{
                Nodo it = inicio;
                int contador = 0;
                while(it != null){
                    
                    if(contador == indice - 1){
                        nuevoNodo.siguiente = it.siguiente;
                        it.siguiente = nuevoNodo;
                        break;
                    }
                    
                    contador++;
                    it = it.siguiente;
                }
            }
        }
        
        length++;
        return nuevoNodo;
    }
    
    public Nodo prepend(int dato){ // insertar nodos al frente
        Nodo nuevoNodo = new Nodo(dato);
        if(inicio == null){
            inicio = nuevoNodo;
            fin = inicio;
        }
        else{
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        }
        
        length++;
        return nuevoNodo;
    }
    
    public Nodo append(int dato){ // insertar nodos al final
        Nodo nuevoNodo = new Nodo(dato);
        if(inicio == null){
            inicio = nuevoNodo;
            fin = inicio;
        }
        else{
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
        
        length++;
        return nuevoNodo;
    }
    
    public Nodo pop(int indice){
        Nodo sacar = null;
        if(inicio == null || indice < 0 || indice >= length){
            return null;
        }
        else if(indice == 0){
            sacar = inicio;
            inicio = inicio.siguiente;
            sacar.siguiente = null;
        }
        else if(indice == length - 1){
            Nodo it = inicio;
            while(it.siguiente != fin){
                it = it.siguiente;
            }
            sacar = fin;
            fin = it;
            fin.siguiente = null;
            sacar.siguiente = null;
        }
        else{
            Nodo it = inicio;
            int contador = 0;
            while(it != null){
                
                if(contador == indice - 1){
                    sacar = it.siguiente;
                    it.siguiente = it.siguiente.siguiente;
                    sacar.siguiente = null;
                    break;
                }
                
                contador++;
                it = it.siguiente;
            }
        }
        
        length--;
        
        return sacar;
    }
    
    public Nodo shift(){ // eliminar nodos al inicio
        Nodo sacar = inicio;
        inicio = inicio.siguiente;
        sacar.siguiente = null;
        
        length--;
        return sacar;
    }

    
    
    public Nodo pop(){ // eliminar nodos al final
        Nodo it = inicio;
        while(it.siguiente != fin){
            it = it.siguiente;
        }

        Nodo sacar = fin;
        fin = it;
        fin.siguiente = null;
        sacar.siguiente = null;
        
        length--;
        return sacar;
    }
    
    public String toString() {
        String resultado = ""; // Inicializa una cadena vacía
        Nodo iterador = inicio; // Comienza desde el nodo inicial
    
        while (iterador != null) {
            resultado += iterador.dato; // Agrega el dato del nodo actual
    
            if (iterador.siguiente != null) {
                resultado += " "; // Solo agrega un espacio si hay un siguiente nodo
            }
            
            iterador = iterador.siguiente; // Avanza al siguiente nodo
        }
        
        return resultado; // Devuelve la cadena resultante
    }
    

    public Nodo getInicio(){
        return inicio;
    }

    public Nodo getFin(){
        return fin;
    }
	
    public int obtenerTamayo() {
        return length;
    }    

    public Nodo get(int index) {
        if (index < 0 || index >= length) {
            return null;  // Return null if the index is out of bounds
        }

        Nodo current = inicio;
        int counter = 0;
        while (counter < index) {
            current = current.siguiente;  // Move to the next node
            counter++;
        }

        return current;  // Return the Nodo at the specified index
    }
}
