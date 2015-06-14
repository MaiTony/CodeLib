package PatternSearching;

public class Trie {
	static class trie_node{
		int value;
		trie_node[] children;
	}
	static class trie{
		trie_node root;
		int count;
	}
	public static void main(String[] args) {
		char[][] key={"the".toCharArray(),"a".toCharArray(),"there".toCharArray(),"answer".toCharArray(),"any".toCharArray(),"by".toCharArray(),"bye".toCharArray(),"their".toCharArray()};
		char[][] output={"Not present in trie".toCharArray(),"Present in trie".toCharArray()};
		trie trie_t=new trie();
		initialize(trie_t);
		for(int i=0;i<key.length;i++){
			insert(trie_t,key[i]);
		}
		System.out.println(output[search(trie_t,"the".toCharArray())]);
		System.out.println(output[search(trie_t,"these".toCharArray())]);
		System.out.println(output[search(trie_t,"their".toCharArray())]);
		System.out.println(output[search(trie_t,"thaw".toCharArray())]);
	}
	static void initialize(trie pTrie){
		pTrie.root=getNode();
		pTrie.count=0;
	}
	static trie_node getNode(){
		trie_node pNode=new trie_node();
		pNode.value=0;
		pNode.children=new trie_node[26];
		return pNode;
	}
	static void insert(trie pTrie,char[] key){
		int level,index,length=key.length;
		trie_node pCrawl;
		pTrie.count++;
		pCrawl=pTrie.root;
		for(level=0;level<length;level++){
			index=key[level]-'a';
			if(pCrawl.children[index]==null){
				pCrawl.children[index]=getNode();
			}
			pCrawl=pCrawl.children[index];
		}
		pCrawl.value=pTrie.count;;
	}
	static int search(trie pTrie,char[] key){
		int level,index,length=key.length;
		trie_node pCrawl;
		pCrawl=pTrie.root;
		for(level=0;level<length;level++){
			index=key[level]-'a';
			if(pCrawl.children[index]==null)
				return 0;
			pCrawl=pCrawl.children[index];
		}
		return pCrawl!=null&&pCrawl.value>0?1:0;
	}
}
