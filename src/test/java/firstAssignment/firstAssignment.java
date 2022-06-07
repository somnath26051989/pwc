package firstAssignment;


public class firstAssignment {
	
	public void sumOfArrayIndexess(int ary[], int len,int targetedSumOfIndexes) {
		int i,j,temp =0;
		
		for(i = 0; i<len-1;i++) {
			for(j=i+1;j<len;j++) {
				temp = ary[i]+ary[j];
				if(temp == targetedSumOfIndexes) {
					System.out.println("Sum is:"+temp);
					System.out.println("Indexes are:");
					System.out.println(+i);
					System.out.println(+j);
					
				}
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		firstAssignment obj = new firstAssignment();
		int a[] = {1,3,5,8,13};
		int le = a.length;
		int target = 21;
		obj.sumOfArrayIndexess(a,le,target);
		
		

	}

}
