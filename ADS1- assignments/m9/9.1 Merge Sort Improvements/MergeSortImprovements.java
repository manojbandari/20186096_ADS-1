class MergeSortImprovements{
	public String[] sort(String[] a , int low, int high) {
		//System.out.println(" 1");
		/*if(isSorted(a,low,high)) {
			//System.out.println("aaaaaaaaaaaaaaaaaa");
			return a;
		}*/
		if(high<=low+7) {
						System.out.println("Insertion sort method invoked...");
						insertion(a,low,high);

					}
		else {
				if (low < high) {
					int mid = (high+low)/2;
					sort(a,low,mid);
					sort(a,mid+1,high);
					if (isSorted(a,low,high)) {
						System.out.println("Array is already sorted. So, skipped the call to merge...");
						return a;
					}
						//System.out.println(" &&&&&&&&&&");
					merge(a,low,mid,high); 
				}
		}
		return a;
	}
	void merge(String a[], int l, int m, int r) {
		  // Find sizes of two subarrays to be merged 
		//System.out.println(" 2222222222");
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        String left[] = new String [n1]; 
        String right[] = new String [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            left[i] = a[l + i]; 
        for (int j=0; j<n2; ++j) 
            right[j] = a[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (left[i].equals(right[j])) 
            { 
                a[k] = left[i]; 
                i++; 
            } 
            else
            { 
                a[k] = right[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            a[k] = left[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            a[k] = right[j]; 
            j++; 
            k++; 
        } 
    }
	
	void insertion(String[] a,int low,int high) {
		//System.out.println(" **************************" );
		/*for(int i=low;i<high;i++) {
			for(int j=i;j>0;j--) {
				if(a[j-1].compareTo(a[j])>0) {
					swap(a,j-1,j);
				}

			}
		}*/
		
        /*int n = a.length; 
        for (int i=low; i<n; ++i) 
        { 
            //int key = a[i]; 
            int j = i-1; 
  
             Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position 
            while (j>=0 && a[j].compareTo(a[i])>0) 
            { 
                a[j+1] = a[j]; 
                j = j-1; 
            } 
            a[j+1] = a[i]; 
        } */
        for (int i = low; i <high; i++)
			for (int j = i; j > low && a[j].compareTo(a[j-1])>0; j--)
				swap(a, j, j - 1);
    
	}
	boolean isSorted(String[] a, int low ,int high) {
		//System.out.println(" 4");
		while(low< a.length) {
			if(a[low].compareTo(a[high])>0) {
				return false;
			}
			low++;
		}
		return true;
	}
	void swap(String a[], int max,int j) {
		//System.out.println(" 5");
		String temp =a[max];
		a[max]=a[j];
		a[j]=temp; 
	}
}