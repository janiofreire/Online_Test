package eu.crossover.webquestion.dao.impl;


public class Test {	
	
	public static void main (String[] args){
		Integer[] arrayTest =findIndexs(new Integer[]{2,7,11,15},9 );
		for(Integer i : arrayTest){
			System.out.println(i);
		}
		
	}	
	public static Integer[] findIndexs(Integer[] array, Integer target){
		Integer[] resturn = new Integer[2];
		boolean find = false;
		for(int i =0;i < array.length; i++){
			for(int j =0;j < array.length; j++){
				if(i!=j){
					if(array[i]+array[j]==target){
						resturn[0]=i;
						resturn[1]=j;
						find=true;
						break;
					}
				}
			}
			if(find){
				break;
			}
		}
		
		return resturn;
	}
}
