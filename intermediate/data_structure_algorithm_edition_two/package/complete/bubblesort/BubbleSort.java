public class BubbleSort {
	
	public static void sort(int[] array){
		int n = array.length;
		for(int i=0; i<=n-2; i++){				// �ォ�珇�Ɉ�ԏ����������߂Ă����B
			Main.print(array, i, n-1);			//�@�\��
			for(int j=n-1; j>=i+1; j--){		// �������֑������Ă���
				Main.print(array, i, j, n-1);	//�@�\��
				if ( array[j] < array[j-1])
					swap(array, j, j-1); 		//array��j�Ԗڂ�j-1�Ԗڂ̗v�f������
			}
		}
	}
	
	// A��i�Ԗڂ�j�Ԗڂ̗v�f�����ւ���
	static void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}    

}
