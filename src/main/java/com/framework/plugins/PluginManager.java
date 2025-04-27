package com.framework.plugins;

import com.framework.exceptions.DIException;
import java.util.*;

public class PluginManager {
    private final Map<Class<?>, List<Object>> pluginsByType = new HashMap<>();

    public void registerPlugin(Object plugin) {
        if (!plugin.getClass().isAnnotationPresent(Plugin.class)) {
            throw new DIException("Class must be annotated with @Plugin");
        }

        // Registra o plugin para cada interface que ele implementa
        for (Class<?> iface : plugin.getClass().getInterfaces()) {
            pluginsByType
                .computeIfAbsent(iface, k -> new ArrayList<>())
                .add(plugin);
        }
    }

    public <T> List<T> getPlugins(Class<T> type) {
        List<Object> plugins = pluginsByType.getOrDefault(type, Collections.emptyList());
        List<T> typedPlugins = new ArrayList<>();
        
        for (Object plugin : plugins) {
            typedPlugins.add(type.cast(plugin));
        }
        
        return typedPlugins;
    }
}