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
		// 4回目 ✅
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

	Node delete(Node node, int object) {
		// 5回目 ✅
		// 考えるケースで重要なのは、削除対象ノードが葉なのか、子を一つ持つ枝なのか、子を二つ持つ枝なのか、だけ
		if (node == null) return null;

		if (object < node.object) {
			// 左辿る、削除なのでnodeの左を更新していく
			node.left = delete(node.left, object);
			return node;
		} else if (object > node.object) {
			// 右辿る、同様に node の右を更新
			node.right = delete(node.right, object);
			return node;
		}
		else {
			// 削除対象ノード
			// 上記で述べた場合わけをここで気にする必要がある
			if (node.left == null && node.right == null) {
				// 削除対象なし、easy
				return null;
			} else if (node.left == null && node.right != null) {
				// 削除対象が右に子を一つ持つ
				return node.right;
			} else if (node.left != null && node.right == null) {
				// 削除対象が左に子を一つ持つ
				return node.left;
			} else {
				// いちばん厄介なパターン
				// 両方に子がいるので最小値を取得して、その最小値の左右を削除対象ののノード左右の子とつげ変えて返却すれば良い
				Node min = deletemin(node.right, node);
				min.left = node.left;
				min.right = node.right;
				return min;
			}
		}
		
	}

	Node deletemin(Node node, Node parent){	// 子孫のうちの最小値を返却する
		// 5回目 ✅
		if (node.left == null) { // 自身が最小値パターン
			if (node == parent.left) {
				parent.left = node.right;
			} else {
				parent.right = node.right;
			}
			return node;
		}

		// 削除対象の右子ノードの左の子ノードが無くなるまで探索して返却
		parent = node;
		node = node.left;
		while (node.left != null) {
			parent = node;
			node = node.left;
		}
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