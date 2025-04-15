import java.util.*;

public class KnapSack {
    private int maxVal = 0;
    
    public void solve(int []w,int []v,int cap){
        findMax(0,0,0,w,v,cap);
        System.out.println("Maximum Profit : " + maxVal);
    }
    public void findMax(int idx,int curW,int curV,int []w,int []v,int cap){
        if (curW > cap){
            return;
        }
        if (idx == w.length){
            maxVal = Math.max(maxVal,curV);
            return;
        }
        findMax(idx+1,curW+w[idx], curV+v[idx],w,v,cap);
        findMax(idx+1,curW, curV,w,v,cap);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of weights and profit ; ");
        int n = sc.nextInt();
        
        int []w = new int[n];
        int []v = new int[n];
        
        System.out.print("Enter the weights : ");
        for (int i=0;i<n;i++){
            w[i] = sc.nextInt();
        }
        System.out.print("Enter the profits : ");
        for (int i=0;i<n;i++){
            v[i] = sc.nextInt();
        }
        System.out.print("Enter the capacity : ");
        int cap = sc.nextInt();
        
        KnapSack ks = new KnapSack();
        ks.solve(w,v,cap);
    }
}
