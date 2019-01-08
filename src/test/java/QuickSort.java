/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-11-28 10:29
 **/
public class QuickSort {
    private QuickSort(){}
     static void sort(int[] a){
        operation(a,0,a.length-1);
    }
    private static void operation(int[] a,int low,int high){
        int start=low;
        int end=high;
        int key=a[low];
        int temp;

        while(start<end){
            while (start<end&&a[end]>=key) end--;
            if (a[end]<=key){
                temp=a[end];
                a[end]=a[start];
                a[start]=temp;
            }
            while (start<end&&a[start]<=key) start++;
            if (a[start]>=key){
                temp=a[end];
                a[end]=a[start];
                a[start]=temp;
            }
        }
        if (start>low) operation(a,low,start-1);
        if (end<high) operation(a,end+1,high);
    }
}
