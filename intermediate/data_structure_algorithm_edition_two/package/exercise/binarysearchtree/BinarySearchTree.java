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
		// 5回目 
	}

	Node deletemin(Node node, Node parent){	// 子孫のうちの最小値を返却する
		// 5回目 
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