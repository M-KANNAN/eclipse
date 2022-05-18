package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSortAlgorithm {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		System.out.println("Enter the size of an Array");
		int sizeOfList=scanner.nextInt();
		System.out.println("Enter the array elements");
		for(int i=0;i<sizeOfList;i++) {
			arrayList.add(scanner.nextInt());
		}
		
		mergerSort(arrayList,0,arrayList.size()-1);
		System.out.println(arrayList);

	}

	private static void mergerSort(ArrayList<Integer> arrayList, int beg, int end) {
		
		if(beg < end) {
			  int mid = (beg + end) / 2;  
		      mergerSort(arrayList, beg, mid);  
		      mergerSort(arrayList, mid + 1, end);  
		      merge(arrayList, beg, mid, end); 
		}
		
	}

	private static void merge(ArrayList<Integer> arrayList, int beg, int mid, int end) {
		


	    int i, j, k;  
	    int n1 = mid - beg + 1;    
	    int n2 = end - mid;    
	      
	   /* temporary Arrays */  
	        int LeftArray[] = new int[n1];  
	        int RightArray[] = new int[n2];  
	      
	    /* copy data to temp arrays */  
	    for (i = 0; i < n1; i++)    
	    LeftArray[i] = arrayList.get(beg+i);    
	    for (j = 0; j < n2; j++)    
	    RightArray[j] = arrayList.get(mid + 1 + j);    
	      
	    i = 0; /* initial index of first sub-array */  
	    j = 0; /* initial index of second sub-array */   
	    k = beg;  /* initial index of merged sub-array */  
	      
	    while (i < n1 && j < n2)    
	    {    
	        if(LeftArray[i] <= RightArray[j])    
	        {    
	            arrayList.set(k, LeftArray[i]);
	            i++;
	        }    
	        else    
	        {    
	        	arrayList.set(k, RightArray[j]);  
	            j++;    
	        }    
	        k++;    
	    }    
	    while (i<n1)    
	    {    
	    	arrayList.set(k, LeftArray[i]);    
	        i++;    
	        k++;    
	    }    
	     
	    while (j<n2)    
	    {    
	    	arrayList.set(k, RightArray[j]);    
	        j++;    
	        k++;    
	    }    
		
	}

}
