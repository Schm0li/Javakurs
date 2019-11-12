
public class Matrix {
	public static void main(String args[]){  
		
		int a[][]={{5,5,5},{2,2,2},{3,3,3}};    
		int b[][]={{1,1,1},{2,2,2},{3,3,3}};    
		        
		int result[][]=new int[3][3];  
		        
		for(int i=0;i<3;i++){    
			for(int j=0;j<3;j++){    
				result[i][j]=0;      
				
				for(int k=0;k<3;k++){      
					result[i][j]+=a[i][k]*b[k][j];      
				}
				
				System.out.print(result[i][j]+" ");  
			}  
			System.out.println();    
		}    
	}
}
