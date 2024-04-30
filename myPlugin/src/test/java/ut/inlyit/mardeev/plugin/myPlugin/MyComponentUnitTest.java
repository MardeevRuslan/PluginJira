package ut.inlyit.mardeev.plugin.myPlugin;

import org.junit.Test;
import inlyit.mardeev.plugin.myPlugin.api.MyPluginComponent;
import inlyit.mardeev.plugin.myPlugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest {
    @Test
    public void testMyName() {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent", component.getName());
    }
}