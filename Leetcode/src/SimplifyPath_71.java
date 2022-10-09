import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path){
        /*
        ../ 返回上一级目录
        ./ 当前目录
        // 等价于/
        / 在结尾
         */
        String[] ary = path.split("/");
        Stack<String> stk =new Stack<>();
        for(String str : ary){
            if(str.equals("..") && !stk.isEmpty()) {
                stk.pop();
            }
            if(!str.equals(".") && !str.equals("..") && !str.equals("")) {
                stk.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.insert(0, stk.pop());
            sb.insert(0, "/");
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}
