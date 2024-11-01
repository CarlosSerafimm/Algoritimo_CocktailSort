package cocktailSort;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        
        System.out.println("Array antes da ordenação:");
        printArray(arr, -1, -1);

        
        cocktailShakerSort(arr);

        System.out.println();
        System.out.println("Array depois da ordenação:");
        printArray(arr, -1, -1);
    }

    public static void cocktailShakerSort(int[] arr) {
        boolean swapped;
        int start = 0;
        int end = arr.length - 1;
        int contadorPassos = 0;   
        int contadorTrocas = 0;   

        do {
            swapped = false;

            System.out.println("\nPassagem " + (contadorPassos + 1) + " (Esquerda -> Direita):");

           
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    replacement(arr, i, i + 1);
                    contadorTrocas++;
                    swapped = true;
                    printArray(arr, i, i + 1); 
                }
            }

            if (!swapped) {
                break;
            }

            end--;
            contadorPassos++;

            System.out.println("\nPassagem " + (contadorPassos + 1) + " (Direita -> Esquerda):");

         
            for (int i = end; i > start; i--) {
                if (arr[i] < arr[i - 1]) {
                    replacement(arr, i, i - 1);
                    contadorTrocas++;
                    swapped = true;
                    printArray(arr, i, i - 1); 
                }
            }

            start++;
            contadorPassos++;

        } while (swapped);

    
        System.out.println("\nOrdenação concluída!");
        System.out.println("Total de passos: " + contadorPassos);
        System.out.println("Total de trocas: " + contadorTrocas);
    }

    static void replacement(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    static void printArray(int[] arr, int num1, int num2) {
        for (int i = 0; i < arr.length; i++) {
            if (i == num1 || i == num2) {
                System.out.print("[" + arr[i] + "] ");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
