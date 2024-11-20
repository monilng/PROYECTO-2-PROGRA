package view;

import controller.Ordenamientos;
import controller.Nodo;
import controller.ListaP;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*; 

public class GUI implements ActionListener{
    JFrame ventana;
    JTextField txtDatos;
    JLabel lblIngreso, titulo, mensaje, tiempoEjecucion,tiempoEjecucion2, tiempoEjecucion3, tiempoEjecucion4, instrucciones, mergeS, quickS, selS, shellS;
    JList<Integer> listaDatos,listaDatos2, listaDatos3,listaDatos4;
    JList<String> listPodio;
    DefaultListModel<Integer> modelo, modelo2, modelo3, modelo4;
    JScrollPane scrollLista, scrollLista2, scrollLista3, scrollLista4;
    JButton agregar, eliminar, borrar, quickSort, shellSort, mergeSort, seleccion, generarRandom, verPodio;
    Ordenamientos ordenamientos;
    int[] podio = {200, 400, 80, 110}; //nuevo
    int x = 1150;
    int lbWidth = 100, lbHeight = 20;


    public GUI (){
        ventana = new JFrame();
        lblIngreso = new JLabel("Ingresar datos: ");
        lblIngreso.setBounds(435, 4, 100,50);
        instrucciones = new JLabel("Si desea ingresar datos de un solo, escribalo con un espacio de por medio");
        instrucciones.setBounds(500,1, 700, 20);
        titulo = new JLabel("Podio");
        titulo.setBounds(1000, 150, 350, 200);
        //nuevo
        mergeS = new JLabel();
        mergeS.setText("Merge Sort");
        mergeS.setForeground(Color.PINK);
        quickS = new JLabel();
        quickS.setText("Quick Sort");
        quickS.setForeground(Color.BLUE);
        shellS = new JLabel();
        shellS.setText("Shell Sort");
        shellS.setForeground(Color.GREEN);
        selS = new JLabel();
        selS.setText("Seleccion");
        selS.setForeground(Color.RED);



        txtDatos = new JTextField();
        txtDatos.setBounds(525, 20, 250, 40);

        txtDatos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
            agregarDato();
            }
        });

        modelo = new DefaultListModel<>();
        modelo2 = new DefaultListModel<>();
        modelo3 = new DefaultListModel<>();
        modelo4 = new DefaultListModel<>();

        //Jlist datos
        listaDatos = new JList<>(modelo);
        listaDatos2= new JList<>(modelo2);
        listaDatos3 = new JList<>(modelo3);
        listaDatos4 = new JList<>(modelo4);

        scrollLista = new JScrollPane(listaDatos);
        scrollLista.setBounds(120,120,350,220);
        listaDatos.setForeground(Color.BLUE);

        scrollLista2 = new JScrollPane(listaDatos2);
        scrollLista2.setBounds(600, 120, 350,220);
        listaDatos2.setForeground(Color.GREEN);

        scrollLista3 = new JScrollPane(listaDatos3);
        scrollLista3.setBounds(120, 450, 350,220);
        listaDatos3.setForeground(Color.PINK);

        scrollLista4 = new JScrollPane(listaDatos4);
        scrollLista4.setBounds(600, 450, 350,220);
        listaDatos4.setForeground(Color.RED);




        //scrollLista.setViewportView();

        agregar = new JButton("Agregar");
        agregar.setBounds(395, 70, 170, 30);
        agregar.addActionListener(this);

        eliminar = new JButton("Eliminar elemento");
        eliminar.setBounds(620, 70, 170, 30);
        eliminar.addActionListener(this);

        borrar = new JButton("Borrar lista");
        borrar.setBounds(870,70,170,30);
        borrar.addActionListener(this);

        generarRandom = new JButton("Generar lista aleatoria");
        generarRandom.setBounds(810, 23, 200, 30);
        generarRandom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                generarLista();
            }
        });
         
        JButton ordenarTds = new JButton("TODOS");
        ordenarTds.setBounds(1105,140,170,30);
        ordenarTds.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            qsort();
            ssort();
            select();
            msort();
            }

        });
        ventana.add(ordenarTds);
        
        quickSort = new JButton("QuickSort");
        quickSort.setBounds(215, 380, 170, 30);


        ordenamientos = new Ordenamientos(); //MOVER DE LUGAR

        quickSort.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                qsort();
            }
        });
        
        shellSort = new JButton("ShellSort");
        shellSort.setBounds(700, 380, 170, 30);


        shellSort.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ssort();
            }
        });


        mergeSort = new JButton("MergeSort");
        mergeSort.setBounds(215, 700, 170, 30);

        mergeSort.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                msort();
            }
        });
        
        seleccion = new JButton("Seleccion");
        seleccion.setBounds(700, 700, 170, 30);

        seleccion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                select();
            }
        });

        tiempoEjecucion = new JLabel();
        tiempoEjecucion.setBounds(895, 198, 300, 300);

        tiempoEjecucion2 = new JLabel();
        tiempoEjecucion2.setBounds(405,198,300,300);

        tiempoEjecucion3 = new JLabel();
        tiempoEjecucion3.setBounds(405,530,300,300); // definir la posicion

        tiempoEjecucion4 = new JLabel();
        tiempoEjecucion4.setBounds(895,530,300,300); // definir la posicion

        mensaje = new JLabel();
        mensaje.setBounds(670, 90, 220,40);

        ventana.setLayout(null);
        ventana.add(lblIngreso);
        ventana.add(instrucciones);
        ventana.add(titulo);// agregado
        ventana.add(mergeS);//nuevos
        ventana.add(shellS);
        ventana.add(selS);
        ventana.add(quickS);
        ventana.add(txtDatos);
        ventana.add(scrollLista);
        ventana.add(scrollLista2);
        ventana.add(scrollLista3);
        ventana.add(scrollLista4);
        ventana.add(agregar);
        ventana.add(eliminar);
        ventana.add(borrar);
        ventana.add(generarRandom);
        ventana.add(quickSort);
        ventana.add(shellSort);
        ventana.add(mergeSort);
        ventana.add(seleccion);
        ventana.add(mensaje);
        ventana.add(tiempoEjecucion);
        ventana.add(tiempoEjecucion2);
        ventana.add(tiempoEjecucion3);
        ventana.add(tiempoEjecucion4);

        ventana.setSize(1600, 800);
        ventana.setVisible(true);  
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == agregar) {
                agregarDato();
                mensaje.setText("Se agregó un nuevo elemento");
            } else if ( evento.getSource() == eliminar){
                eliminarDato(listaDatos.getSelectedIndex());
                eliminarDato(listaDatos2.getSelectedIndex());
                eliminarDato(listaDatos3.getSelectedIndex());
                eliminarDato(listaDatos4.getSelectedIndex());
            } else if (evento.getSource() == borrar) {
                borrarLista();
                mensaje.setText("Se borró la lista");
            }
        }

        private void agregarDato(){
            try {
                String Datos = txtDatos.getText();  // Suponiendo que txtDatos es un campo de texto
                String[] partes = Datos.split(" ");  // Dividir la cadena en subcadenas por espacios
                
                // Crear un arreglo de enteros con el mismo tamaño que el arreglo de cadenas
                Integer[] numeros = new Integer[partes.length];
                
                // Convertir cada subcadena en un número entero
                for (int i = 0; i < partes.length; i++) {
                    numeros[i] = Integer.parseInt(partes[i]);
                }
                for (Integer Dato : numeros){
                    modelo.addElement(Dato);
                    modelo2.addElement(Dato);
                    modelo3.addElement(Dato);
                    modelo4.addElement(Dato);

                }
                txtDatos.setText("");
            } catch(NumberFormatException e) {
                mensaje.setText("Error: Ingrese un numero valido");
            }
        }

        private void eliminarDato(int indice){
            if (indice >=0){
                modelo.removeElementAt(indice);
                modelo2.removeElementAt(indice);
                modelo3.removeElementAt(indice);
                modelo4.removeElementAt(indice);
            }else{
                mensaje.setText("NO se seleccionó ningún elemento");
            }
        }

        private void borrarLista(){
            modelo.clear();
            modelo2.clear();
            modelo3.clear();
            modelo4.clear();
            tiempoEjecucion.setText(null);
            tiempoEjecucion2.setText(null);
            tiempoEjecucion3.setText(null);
            tiempoEjecucion4.setText(null);
        }


        //metodos para convertir las JListas a arreglo tipo INTEGER (Paramentro en Ordenamientos)
        private long tiempoQsort;
        private long tiempoSsort;
        private long tiempoMsort;
        private long tiempoSelect;

        private void qsort(){
            ListaP lista = new ListaP();
            for (int i = 0; i< modelo2.getSize(); i++){
                lista.push(modelo2.getElementAt(i), i);
            }
            
            long init = System.currentTimeMillis();

            ordenamientos.quickSort(lista);

            long end = System.currentTimeMillis();
            modelo.clear();
            
            //ahora que la lista ya esta ordenada, lo devuelve a JLista
            for (int numero = 0; numero < lista.obtenerTamayo(); numero++) { //ESTO PUEDE SER LO QUE ESTA FALLANDO
                modelo4.addElement(lista.get(numero).dato);
            }

            tiempoQsort = end - init;
            tiempoEjecucion.setText("Quick Sort: " + tiempoQsort + "ms");

            generarPodio();
        }

        private void ssort(){
            ListaP lista = new ListaP();
            for (int i = 0; i< modelo2.getSize(); i++){
                lista.push(modelo2.getElementAt(i), i);
            }

            long init = System.currentTimeMillis();

            ordenamientos.shellSort(lista, lista.obtenerTamayo());

            long end = System.currentTimeMillis();
            modelo2.clear();

            for (int numero = 0; numero < lista.obtenerTamayo(); numero++) { //ESTO PUEDE SER LO QUE ESTA FALLANDO
                modelo4.addElement(lista.get(numero).dato);
            }

            tiempoSsort = end - init;
            tiempoEjecucion2.setText("Shell Sort: " + tiempoSsort +  "ms");

            generarPodio();
        }

        private void msort(){
            ListaP lista = new ListaP();
            for (int i = 0; i< modelo2.getSize(); i++){
                lista.push(modelo2.getElementAt(i), i);
            }

            long init = System.currentTimeMillis();

            ordenamientos.mergeSort(lista);

            long end = System.currentTimeMillis();
            modelo3.clear();

            for (int numero = 0; numero < lista.obtenerTamayo(); numero++) { //ESTO PUEDE SER LO QUE ESTA FALLANDO
                modelo4.addElement(lista.get(numero).dato);
            }

            tiempoMsort = end - init;
            tiempoEjecucion3.setText("Merge Sort: " + tiempoMsort +  "ms");

            generarPodio(); 
        }
        
        private void select(){
            ListaP lista = new ListaP();
            for (int i = 0; i< modelo2.getSize(); i++){
                lista.push(modelo2.getElementAt(i), i);
            }

            long init = System.currentTimeMillis();

            ordenamientos.seleccion(lista, lista.obtenerTamayo());

            long end = System.currentTimeMillis();
            modelo4.clear();

            for (int numero = 0; numero < lista.obtenerTamayo(); numero++) { //ESTO PUEDE SER LO QUE ESTA FALLANDO
                modelo4.addElement(lista.get(numero).dato);
            }

            tiempoSelect = end - init;
            tiempoEjecucion4.setText("Seleccion: " + tiempoSelect +  "ms");

            generarPodio();
        }

        //nuevo
        private void generarPodio(){ 
            JLabel[] metodos = {mergeS, quickS, shellS, selS};
            long[] tiempos = {tiempoQsort,tiempoSsort, tiempoMsort, tiempoSelect};
            for(int i = 0; i < tiempos.length - 1; i++){
                for(int j = i + 1; j < tiempos.length; j++){
                    if(tiempos[i] > tiempos[j]){
                        long temp = tiempos[i];
                        tiempos[i] = tiempos[j];
                        tiempos[j] = temp;

                        JLabel tempM = metodos[i];
                        metodos[i] = metodos[j];
                        metodos[j] = tempM;

                    }
                }
            }
            for(int i = 0; i < podio.length; i++){
                metodos[i].setBounds(x, podio[i], lbWidth, lbHeight);
            }
            
        }

        private void generarLista(){
            String cantidadNmr = JOptionPane.showInputDialog(ventana,"Ingrese la cantidad de numeros que desea generar");
            if (cantidadNmr != null && ! cantidadNmr.isEmpty()){
                try {
                    int cantidad = Integer.parseInt(cantidadNmr);
                    if (cantidad > 0){
                        int [] lista = new int[cantidad];

                        for (int i = 0; i < cantidad; i++) {
                            lista[i] = (int) (Math.random() * cantidad);
                        }

                        for (int Dato : lista){
                            modelo.addElement(Dato);
                            modelo2.addElement(Dato);
                            modelo3.addElement(Dato);
                            modelo4.addElement(Dato);
                    }

                    JOptionPane.showMessageDialog(ventana, "Se generaron correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(ventana, "Por favor ingrese un número mayor a 0.");
                    }
            
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(ventana, "Por favor ingrese un número válido.");
                }
            }
        }
     
}