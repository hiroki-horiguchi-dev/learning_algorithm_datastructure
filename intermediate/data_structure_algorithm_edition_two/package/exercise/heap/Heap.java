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
		// 1回目?
		// 2回目?
		int i = last;
		while (i > 0) {
			if (data[i] < data[i-1/2]) {
				swap(data, (i-1)/2, i);
				i = (i-1)/2;
			} else {
				return;
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
		// 1回目❌
		// 2回目✅
		// テストケースとして考えられるのは以下の配列(元々の宣言から考えなくて良いケースもあるが、コードテスト上であれば必須なので書いた)
		// []: 空配列
		// [1]: 根のみの配列
		// [1,2]: 根と1つの葉を持つ配列
		// [1,2,3]: 根と2つの葉を持つ配列
		// [1,2,3,4,5,6,7,8,9]: 1つの根と2つの葉を持つ構造が複数個ある.全体の要素数が奇数個
		// [1,2,3,4,5,6,7,8,9,10]: 1つの根と2つの葉を持つ構造が複数個ある.全体の要素数が偶数個
		// [1,1,1,1,1]: 要素が全て同じ数の配列
		int i = 0;
		while (i < last/2) {
			if (data[i] > data[i*2 + 1]) {
				if (data[i*2 + 1] > data[i*2 + 2]) {
					swap(data, i, i*2 + 2);
					i = i*2 + 2;
				} 
				else {
					swap(data, i, i*2 + 1);
					i = i*2 + 1;
				}
			} else if (data[i] > data[i*2 + 2]) {
				swap(data, i, i*2 + 2);	
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