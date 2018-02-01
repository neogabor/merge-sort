package MergeSort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		List<String> lines = Files.readAllLines(Paths.get(".\\data\\IntegerArray.txt"));
		int ar[]=new int[lines.size()];
		for (int i = 0; i < ar.length; i++) {
			ar[i]=Integer.parseInt(lines.get(i));
		}
//	    for (String line : lines) {
//        System.out.println(line);
//      }	
	    System.out.println(Arrays.toString(ar));
	    
//	    ///ha front es back t[] meretu
//	    int a[],b[];
//	    a=new int[ar.length];
//	    b=new int[ar.length];
//	    for (int i = 0; i < ar.length/2; i++) {
//			a[i]=ar[i];
//			System.out.println(Arrays.toString(a));
//		}
//		for (int i = ar.length/2; i < ar.length; i++) {
//			b[i]=ar[i];
//			System.out.println(Arrays.toString(b));
//		}

	    long inversions[]=new long[1];
	    inversions[0]=0;
	    mergeSort(ar,0,ar.length,inversions);
		System.out.println(Arrays.toString(ar));
		System.out.println(inversions[0]);

    }
	
	public static int[] merge(int a[],int b[],int start, int end, int length, long[] inv){
		int c[]=new int[length];
		int j=0;
		int k=0;
		for (int i = start; i <= end; i++) {
				if ((j<a.length) && (k<b.length) && (a[j]<=b[k])) {
					c[i]=a[j];
					j++;
				}
				else if ((j<a.length) && (k<b.length) && (a[j]>b[k])) {
					c[i]=b[k];
					inv[0]+=a.length-j;
					k++;
				}
				else if (j==a.length) {
					c[i]=b[k];
					k++;
				}
				else if (k==b.length){
					c[i]=a[j];
					j++;
				}
		}
		return c;
	}
	
	
	public static void mergeSort(int t[],int left, int right, long[] inv){
		int front[],back[],holder[];
		int middle=(left+right)/2;
		holder=new int[t.length];
		front=new int[middle-left];
		
		back=new int[right-middle];
		
		
		if (front.length>1) {
			
			mergeSort(t,left,middle, inv);
		}
		
		if (back.length>1) {
			
			mergeSort(t,middle,right,inv);
		}
		copy2(front,t,left,middle-1);
		copy2(back,t,middle,right-1);
		holder=merge(front, back, left, right-1, t.length, inv);

		copy(t,holder,left,right-1);
		
		return;
	}
	static int[] copy(int ab[],int t[],int l, int r){
		for (int i = l; i <= r; i++) {
			ab[i]=t[i];
		}
		return ab;
	}
	
	static int[] copy2(int ab[],int t[],int l, int r){
		int j=0;
		for (int i = l; i <= r; i++) {
			ab[j]=t[i];
			j++;
		}
		return ab;
	}
	
	}
		
