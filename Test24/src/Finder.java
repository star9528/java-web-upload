import java.util.Scanner;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        int beg = 0;
        int end = n - 1;
        quickSort(a,beg,end);
        return a[K - 1];
    }
    public void quickSort(int[] a,int beg,int end) {
        if (beg >= end) {
            return;
        }
        int i = beg;
        int h = end;
        while (i < h) {
            while(i < h  && a[i] <= a[h - 1]) {
                i++;
            }
            while(i < h && a[i] >= a[h - 1]) {
                h--;
            }
            int temp = a[i];
            a[i] = a[h];
            a[h] = a[i];
        }
        int tem = a[i];
        a[i] = a[a.length - 1];
        a[a.length - 1] = a[i];
        quickSort(a,beg,i - 1);
        quickSort(a,i + 1,end);
    }

    public static void main(String[] args) {
        Finder f = new Finder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String a = scanner.next();
            String[] array = a.split(",");
            int[] array1 = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                array1[i] = Integer.parseInt(array[i]);
            }
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(f.findKth(array1,n,k));
        }

    }
}
