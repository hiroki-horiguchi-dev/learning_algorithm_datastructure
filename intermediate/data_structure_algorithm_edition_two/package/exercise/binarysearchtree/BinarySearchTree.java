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
		// 4回目 🔺
		if (node == null) {
			return null;
		}

		if (object < node.object) {
			// 左を探索
			node.left = delete(node.left, object);
			return node;
		} eles if (object > node.object) {
			// 右を探索
			node.right = delete(node.right, object);
			return node;
		} eles {
			// 一致しているので削除対象ノードの形態によって処理を変える
			if (node.left == null && node.right == null) { // 葉ノードの場合
				return null;
			} else if (node.left == null && node.right != null) { // 枝ノードの場合、ただし右の子のみ存在する
				return node.right;
			} else if (node.left != null && node.right == null) { // 枝ノードの場合、ただし左の好み存在する
				return node.left;
			} else {
				// 一致するノードが存在し、削除する処理
				Node min = deletemin(node, node.right);
				min.right = node.right;
				min.left = node.left;
				return min;
			}
		}
	}

	Node deletemin(Node node, Node parent){	// 子孫のうちの最小値を返却する
		// 4回目 🔺
		if (node.left == null) { // 自身が最小値
			if (parent.left == node) { // 汎用的な分岐
				parent.left = node.right; 
			} else {
				parent.right = node.right;
			}
			// 自身が最小値であり、それを返却していること
			// その最小値に対して、parent に自信を飛ばしてくっつけた right および left ノードを
			// 呼び出し元の min.right, min.left の処理で繋ぎ直して削除していること
			// これが理解できれば問題ない
			return node;
		}

		parent = node;
		node = node.left;
		while (node.left != null) {
			parent = node;
			node = node.left;
		}
		parent.left = node.right; // node.right を代入する意図がわからん.nullじゃダメか？
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