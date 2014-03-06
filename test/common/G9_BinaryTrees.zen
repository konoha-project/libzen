// The Great Computer Language Shootout
// http://shootout.alioth.debian.org/

let MINDEPTH : int = 4;
let N        : int =10;

class TreeNode {
    var left  : TreeNode;
    var right : TreeNode;
    var item  : int;
//    var itemCheck : Func<int, TreeNode>;
}

function TreeNode(this : TreeNode, left : TreeNode, right : TreeNode, item : int) {
    this.left  = left;
    this.right = right;
    this.item  = item;
    return this;
}

function itemCheck(this : TreeNode) : int {
    // if necessary deallocate here
    if(this.left == null) {
        return this.item;
    }
    return this.item + this.left.itemCheck() - this.right.itemCheck();
}

function bottomUpTree(item : int, depth : int) : TreeNode {
    if (depth > 0){
        return new TreeNode(bottomUpTree(2*item-1, depth-1),
                            bottomUpTree(2*item,   depth-1), item);
    }
    else {
        return new TreeNode(null, null, item);
    }
}

export function main() {
    var n : int = N;
    println("#BinaryTrees.N: "+N);
    var maxDepth : int = n;
    if(MINDEPTH+2 > n) {
        maxDepth = MINDEPTH + 2;
    }
    var stretchDepth : int = maxDepth + 1;
    var check        : int = bottomUpTree(0, stretchDepth).itemCheck();
    println("#stretch tree of depth: " + stretchDepth + " check: " + check);
    var longLivedTree : TreeNode = bottomUpTree(0, maxDepth);
    var depth : int = MINDEPTH
    while(depth <= maxDepth) {
        var iterations : int = 1 << (maxDepth - depth + MINDEPTH);
        var check : int = 0;
        var i : int = 1;
        while(i <= iterations) {
            check = check + bottomUpTree( i, depth).itemCheck();
            check = check + bottomUpTree(-i, depth).itemCheck();
            i = i + 1;
        }
        println("#"+(iterations*2) + "trees of depth " + depth + " check: " + check);
        depth = depth + 2;
    }
    println("#long lived tree of depth " + maxDepth + " check: "+ longLivedTree.itemCheck());
    assert(longLivedTree.itemCheck() == -1);
}
