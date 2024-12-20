# BST を理解する
- どうすれば理解できるか
    - 全てのパターンを書き出して理解すれば良い


# パターン集

## パターン1　（テキストのサンプル例）

```Java
           5
         /   \
       3       9
      / \     /  \
     2   4   8    11
                   /  \
                 10    13

```

```Java
削除対象と置換対象
           5
         /   \
       3       9 <-- 削除
      / \     /  \
     2   4   8    11
                   /  \
       繰り上げ --> 10  13
```

```Java
完成形態
           5
         /   \
       3       10
      / \     /   \
     2   4   8     11
                     \
                     13
```

```Java
・deletemin 関数内での初期状態
           5
         /   \
       3       9 <-- parent
      / \     /  \
     2   4   8    11 <-- node
                   /  \
                 10    13

・削除する parent ノードが2つの葉ノードを持つ枝ノードであるため、parent から見て右に存在するノードの最小値を置き換える 
    ・BST の定義を守るためにこの操作を行う
・node から見て、左の子の最小値を取得する
・node から見て左の子に対し node.left == null になるまでループを回す
・11(parent), 10(node)になり、parent.left = node.right つまり parent.left = null
・削除後の部分木は以下になる

        11
          \
          13

・この状態で、delete関数へ min = 10 として返却する
・min.left = node.left, min.right = node.right により、ノード9の左右の子が min の左右に配置される
     10
    /   \
   8     11
           \
            13

・上記の部分木が node(今回の例で言えば root).right = delete() に戻るので以下のようになる
           5
         /   \
       3       10
      / \     /   \
     2   4   8     11
                     \
                     13
```
```Java
完成形態
           5
         /   \
       3       10
      / \     /   \
     2   4   8     11
                     \
                     13
```

## パターン2 (deletemin で自身が最小値パターン)

```Java
           5
         /   \
       3       9
      / \     /  \
     2   4   8    11
                    \
                     13
```

```Java
削除対象と置換対象
           5
         /   \
       3       9 <-- 削除
      / \     /  \
     2   4   8    11 <-- 繰り上げ対象
                     \
                      13
```

```Java
完成形態
           5
         /   \
       3       11
      / \     /   \
     2   4   8     13
```

```Java
・deletemin 関数内での初期状態
・初期状態：node = 11、parent = 9
           5
         /   \
       3       9 <-- parent
      / \     /  \
     2   4   8    11 <-- node
                    \
                     13
・パターン1と同様
・削除する parent ノードが2つの葉ノードを持つ枝ノードであるため、parent から見て右に存在するノードの最小値を置き換える 
・node.left が存在しないため、必然的に node が最小値となる
・if (node == parent.left) else で parent に対する node の位置を確認
・今回は else の処理に入る
・parent.right = node.right で 9 (parent) の右の子を 11(node) の右の子 (node.right)に更新するため、以下の部分木が作成される
        9
          \
          13
・自身が最小値のため 11 が min として返却される
・呼び出し元の delete 関数で min.right = node.right としているため以下になる
           5
         /   \
       3       11
      / \     /   \
     2   4   8     13
```
