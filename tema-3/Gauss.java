public class Gauss {
    private int[][] matriz;
public Gauss(int filas, int columnas){
    matriz = new int [filas][columnas];
}
public void llenar(){
    for (int i=0; i<matriz[i].length; i++){
        for (int j=0; j<matriz[i].length; j++){
        matriz[i][j]=(int)(Math.random()*100)+1;
    }
}
}
public void imprimir(){
   for (int i=0; i<matriz.length; i++){
         for (int j=0; j<matriz[i].length; j++){
        System.out.print(matriz[i][j]); 
   }     
}
}