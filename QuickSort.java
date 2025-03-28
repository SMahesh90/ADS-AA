// Java program for implementation of QuickSort
import java.util.*;
class QuickSort
{
    int partition(int a[], int low, int high)
    {
        int pivot = a[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (a[j] <= pivot)
            {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }
    void sort(int a[], int l, int h)
    {
        if (l < h)
        {
            int pi = partition(a, l, h);
            sort(a, l, pi-1);
            sort(a, pi+1, h);
        }
    }

    // Driver program
    public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements in array");
        for (int i=0;i<n;i++){
            System.out.printf("Enter the %d element : ",i);
            a[i] = sc.nextInt();
        }
        System.out.print("Elements before Sorting : ");
        for (int i=0;i<n;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        QuickSort ob = new QuickSort();
        ob.sort(a, 0, n-1);
        
        System.out.print("Elements after sorting : ");
        for (int i=0; i<n; ++i){
            System.out.print(a[i]+" ");
        }
            
    }
}
