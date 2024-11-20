package controller;

import controller.Nodo;
import controller.ListaP;
public class Ordenamientos{
    
    public int partir(ListaP lista, int low, int high){

        int pivote = lista.get(low).dato;
        while (low < high){
            while (low < high && lista.get(high).dato >= pivote){
                --high;
            }
            swap(lista, low, high);

            while(low < high && lista.get(low).dato <= pivote){
                low++;
            }
            swap(lista,low,high);
        }
        return low;
    }

    public void qSort(ListaP lista, int low, int high){
        int pivote;
        if(low < high){
            pivote = partir(lista, low, high);
            qSort(lista, low, pivote - 1);
            qSort(lista, pivote + 1, high);
        }
    }

    public void quickSort(ListaP lista){
        qSort(lista,0, lista.obtenerTamayo()-1);
    }

    private void swap(ListaP lista, int i, int j){
        Nodo nI = lista.get(i);
        Nodo nJ = lista.get(j);
        int temp = nI.dato;
        nI.dato = nJ.dato;
        nJ.dato = temp;
    }

    public void shellSort(ListaP lista, int size) {
        int j, temp;
        int incrementar = size / 2;
        
        while (incrementar > 0) {
            for (int i = incrementar; i < size; i++) {
                Nodo nI = lista.get(i);
                j = i;
                temp = nI.dato;
                while (j >= incrementar && lista.get(j - incrementar).dato > temp) {
                    Nodo nJ = lista.get(j - incrementar);
                    lista.get(j).dato = nJ.dato;
                    j -= incrementar;
                }
                Nodo nJ = lista.get(j);
                nJ.dato = temp;
            }
            incrementar /= 2;
        }
    }
    

    public static ListaP mergeSort(ListaP lista){

		if (lista.length <= 1) {
            return lista;
        }   

        
        int medio = lista.length / 2;
        ListaP izq = new ListaP();
        ListaP derecha = new ListaP();

       
        for (int i = 0; i < medio; i++) {
            izq.append(lista.get(i).dato);
        }
        for (int i = medio; i < lista.length; i++) {
            derecha.append(lista.get(i).dato);
        }

       
        izq = mergeSort(izq);
        derecha = mergeSort(derecha);

       
        return merge(izq, derecha);

	}

	public static ListaP merge(ListaP izq, ListaP derecha){

		ListaP result = new ListaP();
        int a = 0, b = 0, c = 0;

        
        while (a < izq.length && b < derecha.length) {
            Nodo nA = izq.get(a);
            Nodo nB = derecha.get(b);
            if (nA.dato <= nB.dato) {
                result.append(nA.dato);
                a++;
            } else {
                result.append(nB.dato);
                b++;
            }
        }

      
        while (a < izq.length) {
            result.append(izq.get(a).dato);
            a++;
        }

        
        while (b < derecha.length) {
            result.append(derecha.get(b).dato);
            b++;
        }

        return result;
	}

    public void seleccion(ListaP lista, int tamayo){
		for (int i = 0; i < lista.obtenerTamayo() - 1; i++) {
            Nodo nI = lista.get(i);
            Nodo minIndex = lista.get(i);
            for (int j = i + 1; j < lista.obtenerTamayo(); j++) {
                Nodo nJ = lista.get(j);
                if (nJ.dato < minIndex.dato) {
                    minIndex =  nJ;
                }
            }
            
            int temp = nI.dato;
            nI.dato = minIndex.dato;
            minIndex.dato = temp;
        }
	}

	
    public void burbujaMejorada(ListaP lista) {
	    boolean huboIntercambios;
	    for (int i = 0; i < lista.obtenerTamayo() - 1; i++) {
	        huboIntercambios = false;
	        for (int j = 0; j < lista.obtenerTamayo() - 1 - i; j++) {
	            Nodo nodo1 = lista.get(j);
	            Nodo nodo2 = lista.get(j + 1);
	            if (nodo1.dato > nodo2.dato) {
	                
	                int temp = nodo1.dato;
	                nodo1.dato = nodo2.dato;
	                nodo2.dato = temp;
	                huboIntercambios = true;
	            }
	        }
	        if (!huboIntercambios) break;
	    }
    }

	
    public void insercion(ListaP lista) {
	    for (int i = 1; i < lista.obtenerTamayo(); i++) {
	        Nodo clave = lista.get(i);  
	        int j = i - 1;
	
	        while (j >= 0 && lista.get(j).dato > clave.dato) {
	            Nodo nodoActual = lista.get(j);
	            Nodo siguienteNodo = lista.get(j + 1);
	            nodoActual.dato = siguienteNodo.dato;  
	            j--;
	        }
	        
	        lista.get(j + 1).dato = clave.dato;
	    }
	}

	public static void main(String[]args){
        ListaP lista = new ListaP();
        lista.push(13,0);
        lista.push(143,1);
        lista.push(1,2);
        lista.push(54, 3);
        Ordenamientos ordenamientos = new Ordenamientos();
        ordenamientos.mergeSort(lista);

        for(int i = 0; i < lista.obtenerTamayo(); i++){
        System.out.println("nodo" + i + "  " + lista.get(i).dato);
        }
    }
}
