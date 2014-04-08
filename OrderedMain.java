class OrderedArray {
	
	private int[] array; //array definition
	private int numOfElem; //total num of elements
	
	public OrderedArray(int max){ //constructor
		array= new int[max];
	}
    
    //insert an element in array
	public void insert(int value) {
		int j;
		for(j=0; j<numOfElem; j++){
			if(array[j] > value){
				break;
			}
		}
		for(int k=numOfElem; k>j; k--){
			array[k] = array[k-1];
		}
		array[j] = value; numOfElem++;
	}
    
    //search the element in array
	public int search(long searchKey){
		int lowerBound=0;
		int upperBound=numOfElem-1;
		int current;
		
		while(true){
			current =(lowerBound+upperBound)/2;
			if(array[current]==searchKey){  //found the element
				return current;
			}
			else if(lowerBound>upperBound){
				return numOfElem;
			}
			else{							 // can not find, divide it
				if(array[current]<searchKey){ // it is in upper half
					lowerBound=current+1;
				}
				else{						// it is in lower half
					upperBound=current-1;
				}
			}
		} //end of while
	} //end of search
    
    //delete an element from an array
	public boolean delete(int value){
		int j= search(value);
		if(j==numOfElem){ //can not find element
			return false;
		}
		else{					//find
			for(int k=j;k<numOfElem;k++){ // move bigger ones down
				array[k]=array[k+1];
			}
			numOfElem--;
			return true;
		}
	}
	
    // display array data
	public void display(){
		for(int i=0;i<numOfElem;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}
    
}

class OrderedMain {
	public static void main(String[] args) {
        int size =10;
		OrderedArray array;
		array = new OrderedArray(size);
		array.insert(20);
		array.insert(38);
		array.insert(5);
		array.insert(2);
		array.insert(45);
		array.insert(10);
        
        array.display();
        
        int searchKey = 2;
		if(array.search(searchKey)!=array.size()){
			System.out.println("Found " + searchKey);
		}
		else{
			System.out.println("can not find " + searchKey);
		}
        
        array.delete(38);
		
		array.display();
        
    }
}
