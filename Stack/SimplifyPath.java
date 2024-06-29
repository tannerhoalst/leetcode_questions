package Stack;

import java.util.Stack;

public class SimplifyPath {
        public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if(component.equals("") || component.equals(".")) {
                continue;
            } else if (component.equals("..")){
                if (!stack.isEmpty()) {
                        stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        
        String newPath = "";
        for (String dir : stack) {
            newPath += "/";
            newPath += dir;
        }

        if(newPath.length() > 0) {
            return newPath;
        } else {
            return "/";
        }
    }

    public static void main(String[] args) {
        String[] testCases = {
            "/home/",
            "/../",
            "/home//foo/",
            "/a/./b/../../c/",
            "/a/../../b/../c//.//",
            "/a//b////c/d//././/..",
            "/..."
        };

        SimplifyPath sp = new SimplifyPath();
        for (String testCase : testCases) {
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Simplified: \"" + sp.simplifyPath(testCase) + "\"");
            System.out.println();
        }
    }
}
