# 疑問

- deletemin の `if (parent.left == node)`って不要な処理では？
```Java 
	Node deletemin(Node node, Node parent){	// 子孫のうちの最小値を返却する
		// 4回目 🔺
		// 理解し、memo.md にまとめた
		if (node.left == null) { // 自身が最小値
			if (parent.left == node) { // ⚠️ 疑問: この判定が必要なのかなぞい、なぜなら、deletemin を読んでいる段階で node.right を渡しているから。そして、deletemin を再起的に呼ぶことはないから
				parent.left = node.right; // 完全な理解ではない
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
```
- 結論: 不要、ただし deletemin が private function であるならという条件がつく