package array;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		employee[] array=new employee[5];
		array[0]=new employee("harsh",1,5000);
		array[1]=new employee("harsh",1,57000);
		array[2]=new employee("harsh",1,5000);
		array[3]=new employee("harsh",1,5000);
		array[4]=new employee("harsh",1,5000);
		
		
		System.out.println(array[0].name+ " "+array[0].id+" "+array[0].sal);
		System.out.println(array[1].name+ " "+array[1].id+" "+array[1].sal);
		
		
	}
	
	

}
