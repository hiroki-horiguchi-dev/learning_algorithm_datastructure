import java.util.*;

public class Heap {
	int[] data = new int[1000];
	int last = -1;

	// �q�[�v�ւ̗v�f�̒ǉ�
	void insert(int object){
		
		// �Ō���ɗv�f��ǉ� (�������R�[�h)
		last = last + 1;
		data[last] = object;		

		
		// ��ւƒH��Ȃ���t�]���������Ă���
		//
		//	�����ɃR�[�h������
		//
		int i = last;
		while (last > 0) {
			if (data[(i-1)/2] < data[i]) {
				swap(data, (i-1)/2, i);
				i = (i-1)/2;
			}
		}

		
		// �ȉ��A�_�~�[�̃R�[�h�@�e�ƂЂƂ�������ւ���
		if (last >= 1){
			Main.print(this, (last-1)/2, last);	//�@�\��
			swap(data, (last-1)/2, last);	//����ւ�
		}
		
	}
	
	
	// �ŏ��l�̎��o��
	int deletemin(){
		
		//���̗v�f�����o�� (�������R�[�h)
		int object = data[0];
		
		// �Ō�������Ɏ����Ă���  (�������R�[�h)
		data[0] = data[last];
		last = last - 1;	

		
		//���ւƒH��Ȃ���t�]���������Ă��B
		//
		//	�����ɃR�[�h������
		//
		int i = 0;
		// last/2 �Ń��[�v���q�����m�[�h�Ɍ��肷��
		while (i < last/2) {
			// �����ł܂Ƃ߂Ďg���ϐ����`���Ă��܂��ق����ǂ݂₷���Ǝv��
			// �q�[�v���񕪖؂������Ă���揈����.�ƌ����Ӑ}���`��邩��
			int parent = data[i];
			// ���E�O�A�N�Z�X�� ArrayIndexOutOfBoundsException ����������\��������
			// ���A�𓚃R�[�h�ɂ��̎|�̋L�ڂ��Ȃ����߈�U���̂܂܂Ƃ��� 
			int left = data[(i*2) + 1];
			int right = data[(i*2) + 2];
			if (parent > left) {
				if (left > right) {
					swap(data, i, i*2+2);
					i = (2*i) + 2;
				} else {
					swap(data, i, i*2+1);
					i = (2*i) + 1;
				}
			} else if(parent > right) {
				swap(data, i, i*2+2);
				i = (2*i) + 2;
			} else {
				return object;
			}
		}
		return object;
	} 
	
	// A��i�Ԗڂ�j�Ԗڂ̗v�f�����ւ���(�������R�[�h)
	static void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
/*

�����

public class Heap {
	int[] data = new int[1000];
	int last = -1;

	// �q�[�v�ւ̗v�f�̒ǉ�
	void insert(int object){
		
		// �Ō���ɗv�f��ǉ� (�������R�[�h)
		last = last + 1;
		data[last] = object;		

		
		// ��ւƒH��Ȃ���t�]���������Ă���
		//
		//	�����ɃR�[�h������
		//

		
		// �ȉ��A�_�~�[�̃R�[�h�@�e�ƂЂƂ�������ւ���
		if (last >= 1){
			Main.print(this, (last-1)/2, last);	//�@�\��
			swap(data, (last-1)/2, last);	//����ւ�
		}
		
	}
	
	
	// �ŏ��l�̎��o��
	int deletemin(){
		
		//���̗v�f�����o�� (�������R�[�h)
		int object = data[0];
		
		// �Ō�������Ɏ����Ă���  (�������R�[�h)
		data[0] = data[last];
		last = last - 1;	

		
		//���ւƒH��Ȃ���t�]���������Ă��B
		//
		//	�����ɃR�[�h������
		//

		
		// �ȉ��A�_�~�[�̃R�[�h�@�q�ƂЂƂ�������ւ���
		int i = 0;
		Main.print(this, i, i*2+2);	//�@�\��
		swap(data, i, i*2+2);	//�E�̎q�ƌ���

		return object;
	} 
	
	// A��i�Ԗڂ�j�Ԗڂ̗v�f�����ւ���(�������R�[�h)
	static void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
*/