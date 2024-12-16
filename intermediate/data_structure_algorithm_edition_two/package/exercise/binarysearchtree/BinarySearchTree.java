import java.util.*;

public class BinarySearchTree {
	void insert(int object){
		if (root == null)
			root = new Node(object);
		else
			insert(root, object);
	}
	void delete(int object){
		root = delete(root, object);
	}
	Node root = null;
	
	
	
	void insert(Node node, int object){
		// 3回目 ✅
		if (object < node.object) {
			if (node.left == null) {
				node.left = new Node(object);
			} else {
				insert(node.left, object);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(object);
			} else {
				insert(node.right, object);
			}
		}
	}

	Node delete(Node node, int object){

		// 2回目
		// 読んで理解は余裕
		// deletemin のロジック、右の子孫の最小値を取るコードを書くのがちょいむず
		// [5,3,9,2,4,8,11,null*6,10,13, null*15, 16] という二分木で考える
		if (node == null) {
			// ✅
			return null;
		}
		if (object < node.object) {
			// 左を辿らせる ✅
			node.left = delete(node.left, object);
			return node;
		}
		else if (object > node.object) {
			// 右を辿らせる ✅
			node.right = delete(node.right, object);
			return node;
		} else {
			// 🙅
			// 一致する object がツリーの中に存在する時、このノードを削除する
			// 削除ロジックは分かりづらいが、再起的にnode.left, node.right に delete 関数を呼んでいる処理で実現できる

			// 削除ロジックは、その object ノードが枝なのか？葉なのか？で処理が分かれる
			if (node.left == null && node.right == null) {
				// 削除対象が葉ノードの場合 ✅
				// 元のノードリストに対し、object == 2 を削除するコードをイメージする
				// 一つ前の node, つまり、 3から見て left のノード 2 は、削除対象の object と一致
				// かつ、葉ノードであるため 3 から見て left ノードを null に変更して node 全体を返却したい
				return null;
			} else if (node.left == null && node.right != null) {
				// 削除対象が枝ノード(右に子がいる場合) ✅
				// 少しイレギュラーケース、前提で書いたケースではなく以下のケースについて考えると分かりやすい
				// [5,3,9,2,4,null,11,null*5,11,null*11,13]
				// このケースについて、9の削除を考える
				// 5 の right を 11 に差し替えれば良いだけなので、右を辿って object と合致した 9 のノードの right を返却し、元のノード5の right に繋げば良い
				return node.right;
			} else if (node.left != null && node.right == null) {
				// 削除対象が枝ノード(左に子がいる場合) ✅
				// 右に子がいる場合の逆を考えればよい
				// 同様に
				return node.left;
			} else {
				// 削除対象が枝ノードの場合 🙅
				// 元のノードリストに対して 9 を削除するコードをイメージする
				// 右の子孫の中の最小値
				Node min = deletemin(node.right, node)
				// 10.left = 8, 10.right = node.right をやりたいはず
				min.right = node.right;
				min.left = node.left;
				return min;
			}
		}


	}

	// 全体的に解釈が違いそう。。3回目で気づけるといい	
	Node deletemin(Node node, Node parent){	// 子孫のうちの最小値を返却する
		// 2回目
		// node   (= node.right) 11
		// parent (= node 	   ) 9

		// 右にしか子がいない (ん？どゆこと？と思ったけど、line 63 と同じ)
		// このケースは別途サンプルを作って理解する
		if (node.left == null) { // 自分自身のいた場所に右の子を配置する
			// ここの == ロジックがわからん、これはなんの判定？？？ 🙅
			if (parent.left == node) {
				parent.left = node.right;
			} else {
				parent.right = node.right;
			}
			return node; // 自分自身が最小値
		}

		// 9 を削除した場合に 10 を返却する挙動をイメージ
		// ここの更新処理と
		// (引数への再代入のせいで結構分かりづらい。。viva kotlin)
		parent = node; // [11] --> [10]
		node = node.left; // [10] --> [null]

		// ここのループで次へ次へイテレートして
		while (node.left != null) {
			parent = node;
			node = node.left;
		}

		// ?? これまでの進め方だとここでおかしくなるので、どこかしらの理解が違うか
		parent.left = node.right;
		return node;
	}	
}


class Node {
	Node left;
	Node right;
	int object;
	Node(int _object){
		object = _object;
	}
}


/*
 * ???
 
public class BinarySearchTree {
	void insert(int object){
		if (root == null)
			root = new Node(object);
		else
			insert(root, object);
	}
	void delete(int object){
		root = delete(root, object);
	}
	Node root = null;
	
	
	void insert(Node node, int object){
		if (object < node.object){
			if (node.left == null)
				node.left = new Node(object); //?V?????m?[?h????
			else
				insert(node.left, object);	//????q??H??
		}
		else {
			if (node.right == null)
			   node.right = new Node(object);  //?V?????m?[?h????
			else
			  insert(node.right, object); 	//?E??q??H??
		}
	}

	// ????R?[?h?B??A?I??~?????????I????????????m?[?h????????B?????????? deletemin??????????B
	Node delete(Node node, int object){
		if (node == null)
			return null;
		if (object < node.object){
			node.left = delete(node.left, object);  //????q??H??
			return node;
		}
		else if (object > node.object){
			node.right =  delete(node.right, object); //?E??q??H??
			return node;
		}
		else {	// ????node????????
			if (node.left == null && node.right == null)	//?@?q???????
				return null;
			else if (node.left == null && node.right != null)  // ?E??q???
				return node.right;
			else if (node.left != null && node.right == null)  // ?E??q???
				return node.left;
			else { 					//?q???Q??
				Node min = deletemin(node.right, node);	//?E??q???????l
				min.right = node.right;
				min.left = node.left;
				return min;
			}
		}
	}
	Node deletemin(Node node, Node parent){	//?q????????????l??????????
		if (node.left == null){	// ?E??????q?????
			if (parent.left == node)	// ???????g?????????E??q??z?u????
				parent.left = node.right;
			else 
				parent.right = node.right;
			return node;	//???????g??????l
		}
		parent = node;
		node = node.left;
		while(node.left != null){	//????q??H??
			parent =node;
			node = node.left;
		}
		parent.left = node.right;
		return node;
	}	
}
*/