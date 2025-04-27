package com.netrunner.reflectionexplorer.visualization;

public class HierarchyVisualizer {
    public String generateDotGraph(Class<?> rootClass) {
        StringBuilder dot = new StringBuilder();
        dot.append("digraph Hierarchy {\n");
        
        addClassNode(dot, rootClass);
        addRelationships(dot, rootClass);
        
        dot.append("}");
        return dot.toString();
    }
    
    private void addClassNode(StringBuilder dot, Class<?> clazz) {
        dot.append(String.format(
            "  %s [label=\"%s\"];\n",
            clazz.getSimpleName(),
            clazz.getName()
        ));
        
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null && !superclass.equals(Object.class)) {
            addClassNode(dot, superclass);
            dot.append(String.format(
                "  %s -> %s;\n",
                clazz.getSimpleName(),
                superclass.getSimpleName()
            ));
        }
    }
    
    private void addRelationships(StringBuilder dot, Class<?> clazz) {
        for (Class<?> iface : clazz.getInterfaces()) {
            addClassNode(dot, iface);
            dot.append(String.format(
                "  %s -> %s [style=dashed];\n",
                clazz.getSimpleName(),
                iface.getSimpleName()
            ));
        }
    }
}