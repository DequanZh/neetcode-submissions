class FileSystem {
    class TriNode{
        Map<String, TriNode> directories = new HashMap<>();
        Map<String, String> files = new HashMap<>();
    }
    TriNode head = new TriNode();

    public FileSystem() {
        
    }
    
    public List<String> ls(String path) {
        String[] parts = path.split("/");
        TriNode cur = head;
        List<String> files = new ArrayList<>();
        if(parts.length > 0){
            for(int i = 1; i < parts.length-1; i++){
                cur = cur.directories.get(parts[i]);
            }
            if(cur.files.containsKey(parts[parts.length-1])){
                files.add(parts[parts.length-1]);
                return files;
            }else{
                cur = cur.directories.get(parts[parts.length-1]);
            }
        }
        files.addAll(new ArrayList<>(cur.directories.keySet()));
        files.addAll(new ArrayList<>(cur.files.keySet()));
        Collections.sort(files);
        return files;
    }
    
    public void mkdir(String path) {
        String[] parts = path.split("/");
        TriNode cur = head;
        for(int i = 1; i < parts.length; i++){
            if(!cur.directories.containsKey(parts[i])){
                cur.directories.put(parts[i], new TriNode());
            }
            cur = cur.directories.get(parts[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] parts = filePath.split("/");
        TriNode cur = head;
        for(int i = 1; i < parts.length-1; i++){
            if(!cur.directories.containsKey(parts[i])){
                cur.directories.put(parts[i], new TriNode());
            }
            cur = cur.directories.get(parts[i]);
        }
        cur.files.put(parts[parts.length-1], cur.files.getOrDefault(parts[parts.length-1],"")+content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] parts = filePath.split("/");
        TriNode cur = head;
        for(int i = 1; i < parts.length-1; i++){
            cur = cur.directories.get(parts[i]);
        }
        return cur.files.get(parts[parts.length-1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */