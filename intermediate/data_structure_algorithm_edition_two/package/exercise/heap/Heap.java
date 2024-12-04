import java.util.*;

public class Heap {
	int[] data = new int[1000];
	int last = -1;

	// ヒープへの要素の追加
	void insert(int object){
		
		// 最後尾に要素を追加 (正しいコード)
		last = last + 1;
		data[last] = object;		

		
		// 上へと辿りながら逆転を解消していく
		//
		//	ここにコードを書く
		//
		int i = last;
		while (last > 0) {
			if (data[(i-1)/2] < data[i]) {
				swap(data, (i-1)/2, i);
				i = (i-1)/2;
			}
		}

		
		// 以下、ダミーのコード　親とひとつだけ入れ替える
		if (last >= 1){
			Main.print(this, (last-1)/2, last);	//　表示
			swap(data, (last-1)/2, last);	//入れ替え
		}
		
	}
	
	
	// 最小値の取り出し
	int deletemin(){
		
		//根の要素を取り出す (正しいコード)
		int object = data[0];
		
		// 最後尾を根に持ってくる  (正しいコード)
		data[0] = data[last];
		last = last - 1;	

		
		//下へと辿りながら逆転を解消してく。
		//
		//	ここにコードを書く
		//
		int i = 0;
		// last/2 でループを子を持つノードに限定する
		while (i < last/2) {
			// ここでまとめて使う変数を定義してしまうほうが読みやすいと思う
			// ヒープか二分木を扱っているよ処理だ.と言う意図も伝わるかな
			int parent = data[i];
			// 境界外アクセスで ArrayIndexOutOfBoundsException が発生する可能性がある
			// が、解答コードにその旨の記載がないため一旦そのままとする 
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
	
	// Aのi番目とj番目の要素を入れ替える(正しいコード)
	static void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
/*

正解例

public class Heap {
	int[] data = new int[1000];
	int last = -1;

	// ヒープへの要素の追加
	void insert(int object){
		
		// 最後尾に要素を追加 (正しいコード)
		last = last + 1;
		data[last] = object;		

		
		// 上へと辿りながら逆転を解消していく
		//
		//	ここにコードを書く
		//

		
		// 以下、ダミーのコード　親とひとつだけ入れ替える
		if (last >= 1){
			Main.print(this, (last-1)/2, last);	//　表示
			swap(data, (last-1)/2, last);	//入れ替え
		}
		
	}
	
	
	// 最小値の取り出し
	int deletemin(){
		
		//根の要素を取り出す (正しいコード)
		int object = data[0];
		
		// 最後尾を根に持ってくる  (正しいコード)
		data[0] = data[last];
		last = last - 1;	

		
		//下へと辿りながら逆転を解消してく。
		//
		//	ここにコードを書く
		//

		
		// 以下、ダミーのコード　子とひとつだけ入れ替える
		int i = 0;
		Main.print(this, i, i*2+2);	//　表示
		swap(data, i, i*2+2);	//右の子と交換

		return object;
	} 
	
	// Aのi番目とj番目の要素を入れ替える(正しいコード)
	static void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
*/