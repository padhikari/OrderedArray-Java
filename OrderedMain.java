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
        
    }
}
